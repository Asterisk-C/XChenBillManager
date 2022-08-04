package gui.panel;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import util.ColorUtil;
import util.GUIUtil;

public class ConfigPanel extends JPanel
{
	
	static
	{
        GUIUtil.useLNF();
    }
	
	private static ConfigPanel instance;
	
	public static ConfigPanel getInstance()
	{
		if(instance == null)
			instance = new ConfigPanel();
		return instance;
	}
	
	JLabel lBudget = new JLabel("Budget this month($)");
	public JTextField tfBudget = new JTextField("0");
	JLabel lMysql = new JLabel("Mysql installation path");
    public JTextField tfMysqlPath = new JTextField("");
 
    JButton bSubmit = new JButton("Update");
	
	private ConfigPanel()
	{
		GUIUtil.setColor(ColorUtil.grayColor, lBudget,lMysql);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        
        JPanel pInput = new JPanel();
        JPanel pSubmit = new JPanel();
        int gap = 40;
        pInput.setLayout(new GridLayout(4, 1, gap, gap));
        pInput.add(lBudget);
        pInput.add(tfBudget);
        pInput.add(lMysql);
        pInput.add(tfMysqlPath);
        pSubmit.add(bSubmit);
        
		this.setLayout(new BorderLayout());
		this.add(pInput, BorderLayout.NORTH);
		this.add(pSubmit,BorderLayout.CENTER);
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUIUtil.showPanel(ConfigPanel.getInstance());

	}

}
