package gui.panel;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.frame.MainFrame;
import util.CenterPanel;
import util.GUIUtil;

public class MainPanel extends JPanel
{
	
//	Use a system style
	static
	{
		GUIUtil.useLNF();
	}
	
	private static MainPanel instance = new MainPanel();
	
	public static MainPanel getInstance()
	{
		if(instance == null)
			instance = new MainPanel();
		return instance;
	}
	
	public JToolBar tb = new JToolBar();
	
	public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();
    
    public CenterPanel workingPanel;
    
    private MainPanel()
    {
    	GUIUtil.setImageIcon(bSpend, "home.png", "Spend Summary");
        GUIUtil.setImageIcon(bRecord, "record.png", "Record A Purchase");
        GUIUtil.setImageIcon(bCategory, "category2.png", "Purchase Category");
        GUIUtil.setImageIcon(bReport, "report.png", "Monthly Report");
        GUIUtil.setImageIcon(bConfig, "config.png", "Config");
        GUIUtil.setImageIcon(bBackup, "backup.png", "Backup");
        GUIUtil.setImageIcon(bRecover, "restore.png", "Recovery");
        
        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);
        
        workingPanel = new CenterPanel(0.8);
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUIUtil.showPanel(MainPanel.instance, 1);

	}

}
