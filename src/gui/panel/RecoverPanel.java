package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.ColorUtil;
import util.GUIUtil;

public class RecoverPanel extends JPanel
{
	static
	{
        GUIUtil.useLNF();
    }
	
	private static RecoverPanel instance = new RecoverPanel();
	
	public static RecoverPanel getInstance()
	{
		if(instance == null)
			instance = new RecoverPanel();
		return instance;
	}
	
	JButton bBackup =new JButton("Recovery");
	
	private RecoverPanel() 
	{
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 GUIUtil.showPanel(RecoverPanel.getInstance());

	}

}
