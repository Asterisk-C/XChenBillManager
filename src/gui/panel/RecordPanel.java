package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import entity.Category;
import gui.listener.RecordListener;
import gui.model.CategoryComboBoxModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class RecordPanel extends WorkingPanel
{
	
	static
	{
        GUIUtil.useLNF();
    }
	
	private static RecordPanel instance;
	
	public static RecordPanel getInstance()
	{
		if(instance == null)
			instance = new RecordPanel();
		return instance;
	}
	
	JLabel lSpend = new JLabel("Spend(€)");
    JLabel lCategory = new JLabel("Category");
    JLabel lComment = new JLabel("Comment");
    JLabel lDate = new JLabel("Date");
 
    public JTextField tfSpend = new JTextField("0");
    public CategoryComboBoxModel cbModel = new CategoryComboBoxModel();
    public JComboBox<Category> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());
    
    JButton bSubmit = new JButton("Record A Purchase");
    
    private RecordPanel()
    {
    	GUIUtil.setColor(ColorUtil.grayColor, lSpend,lCategory,lComment,lDate);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        JPanel pInput =new JPanel();
        JPanel pSubmit = new JPanel();
        
        int gap = 40;
        pInput.setLayout(new GridLayout(4,2,gap,gap));
        pInput.add(lSpend);
        pInput.add(tfSpend);
        pInput.add(lCategory);
        pInput.add(cbCategory);
        pInput.add(lComment);
        pInput.add(tfComment);
        pInput.add(lDate);
        pInput.add(datepick);
        
        pSubmit.add(bSubmit);
        
        this.setLayout(new BorderLayout());
        this.add(pInput,BorderLayout.NORTH);
        this.add(pSubmit,BorderLayout.CENTER);
        
        addListener();
    }
    
    public Category getSelectedCategory()
    {
    	return (Category) cbCategory.getSelectedItem();
    }
    
    @Override
    public void updateData()
    {
    	cbModel.cs = new CategoryService().list();
    	cbCategory.updateUI();
    	resetInput();
    	tfSpend.grabFocus();
    }
    
    public void resetInput()
    {
    	tfSpend.setText("0");
    	tfComment.setText("");
    	if(cbModel.cs.size() != 0)
    		cbCategory.setSelectedIndex(0);
    	datepick.setDate(new Date());
    }
    
    @Override
    public void addListener()
    {
    	RecordListener listener = new RecordListener();
    	bSubmit.addActionListener(listener);
    }
	
	public static void main(String[] args) 
	{
        GUIUtil.showPanel(RecordPanel.getInstance());
    }

}
