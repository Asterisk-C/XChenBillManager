package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.BackupListener;
import util.ColorUtil;
import util.GUIUtil;

public class BackupPanel extends WorkingPanel
{
	static
	{
        GUIUtil.useLNF();
    }
	
	private static BackupPanel instance = new BackupPanel();
	
	public static BackupPanel getInstance()
	{
		if(instance == null)
			instance = new BackupPanel();
		return instance;
	}
	
	JButton bBackup =new JButton("Backup");
	
	private BackupPanel() 
	{
        GUIUtil.setColor(ColorUtil.blueColor, bBackup);
        this.add(bBackup);
        addListener();
    }
	
	@Override
    public void updateData() {
 
    }
 
    @Override
    public void addListener() {
        BackupListener listener = new BackupListener();
        bBackup.addActionListener(listener);
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 GUIUtil.showPanel(BackupPanel.getInstance());

	}

}
