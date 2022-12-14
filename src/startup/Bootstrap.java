package startup;

import javax.swing.SwingUtilities;

import gui.frame.MainFrame;
import gui.panel.MainPanel;
import gui.panel.SpendPanel;
import util.GUIUtil;

public class Bootstrap 
{
	public static void main(String[] args) throws Exception
	{
		GUIUtil.useLNF();
		
		SwingUtilities.invokeAndWait(new Runnable() 
		{
			@Override
			public void run()
			{
				MainFrame.getInstance().setVisible(true);
				MainPanel.getInstance().workingPanel.show(SpendPanel.getInstance());
			}
		});
	}

}
