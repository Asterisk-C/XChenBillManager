package gui.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import gui.panel.MainPanel;
import gui.panel.RecoverPanel;

public class MainFrame extends JFrame
{
	
	private static MainFrame instance = new MainFrame();
	
	public static MainFrame getInstance()
	{
		if(instance == null)
			instance = new MainFrame();
		return instance;
	}
	
	private MainFrame()
	{
		this.setSize(800, 600);
		this.setTitle("XChen Bill Manager");
		this.setContentPane(MainPanel.getInstance());
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) 
	{
		getInstance().setVisible(true);
		
		// Demo Frame
//		JFrame f = new JFrame();
//		f.setSize(800, 600);
//        f.setTitle("XChen Bill Manager");
//        f.setLocationRelativeTo(null);
//        f.setResizable(true);
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        JToolBar tb = new JToolBar();
//        JButton bCost = new JButton("Spend Summary");
//        JButton bRecord = new JButton("Record A Purchase");
//        JButton bCategory = new JButton("Purchase Category");
//        JButton bReport = new JButton("Monthly Report");
//        JButton bConfig = new JButton("Config");
//        JButton bBackup = new JButton("Backup");
//        JButton bRecovery = new JButton("Recovery");
//        
//        tb.add(bCost);
//        tb.add(bRecord);
//        tb.add(bCategory);
//        tb.add(bReport);
//        tb.add(bConfig);
//        tb.add(bBackup);
//        tb.add(bRecovery);
//        
//        f.setLayout(new BorderLayout());
//        f.add(tb, BorderLayout.NORTH);
//        f.add(new JPanel(), BorderLayout.CENTER);
//        
//        f.setVisible(true);
//        
//        bCost.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 
//            }
//        });
//        bRecord.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 
//            }
//        });
//        bCategory.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 
//            }
//        });
//        bConfig.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 
//            }
//        });
//        bBackup.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 
//            }
//        });
//        bRecovery.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                 
//            }
//        });

	}

}
