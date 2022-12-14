package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUtil;

public class CategoryPanel extends WorkingPanel
{
	
	static
	{
        GUIUtil.useLNF();
    }
	
	private static CategoryPanel instance;
	
	public static CategoryPanel getInstance()
	{
		if(instance == null)
			instance = new CategoryPanel();
		return instance;
	}
	
	public JButton bAdd = new JButton("Add");
    public JButton bEdit = new JButton("Edit");
    public JButton bDelete = new JButton("Delete");
    
    String[] columNames = new String[]{"Category Name","Paid Times"};
    
    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable(ctm);
    
    private CategoryPanel()
    {
    	GUIUtil.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);
        JScrollPane sp = new JScrollPane(t);
        JPanel pSubmit = new JPanel();
        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);
        
        this.setLayout(new BorderLayout());
        this.add(sp, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);
        
        addListener();
    }
    
    public Category getSelectedCategory()
    {
    	int index = t.getSelectedRow();
    	return ctm.cs.get(index);
    }
    
    public void updateData()
    {
    	ctm.cs = new CategoryService().list();
    	t.updateUI();
    	t.getSelectionModel().setSelectionInterval(0, 0);
    	
    	if(ctm.cs.size() == 0)
    	{
			bEdit.setEnabled(false);
			bDelete.setEnabled(false);
		}
    	else
    	{
    		bEdit.setEnabled(true);
			bDelete.setEnabled(true);
    	}
    }
    
    public void addListener()
    {
    	CategoryListener listener = new CategoryListener();
    	bAdd.addActionListener(listener);
    	bEdit.addActionListener(listener);
    	bDelete.addActionListener(listener);
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUIUtil.showPanel(CategoryPanel.getInstance());

	}

}
