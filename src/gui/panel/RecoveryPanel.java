package gui.panel;

import javax.swing.JButton;
import javax.swing.JPanel;

import gui.listener.RecoveryListener;
import util.ColorUtil;
import util.GUIUtil;

public class RecoveryPanel extends WorkingPanel
{
	static
	{
        GUIUtil.useLNF();
    }
	
	private static RecoveryPanel instance = new RecoveryPanel();
	
	public static RecoveryPanel getInstance()
	{
		if(instance == null)
			instance = new RecoveryPanel();
		return instance;
	}
	
	JButton bRecovery =new JButton("Recovery");
	
	private RecoveryPanel() 
	{
        GUIUtil.setColor(ColorUtil.blueColor, bRecovery);
        this.add(bRecovery);
        
        addListener();
    }
	
	@Override
    public void updateData() 
	{
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void addListener() 
    {
        RecoveryListener listener = new RecoveryListener();
        bRecovery.addActionListener(listener);
    }

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		 GUIUtil.showPanel(RecoveryPanel.getInstance());

	}

}
