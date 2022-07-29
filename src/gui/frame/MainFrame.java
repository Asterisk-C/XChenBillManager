package gui.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class MainFrame 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		JFrame f = new JFrame();
		f.setSize(800, 600);
        f.setTitle("XChen Bill Manager");
        f.setLocationRelativeTo(null);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JToolBar tb = new JToolBar();
        JButton bCost = new JButton("Cost Summary");
        JButton bRecord = new JButton("Record A Purchase");
        JButton bCategory = new JButton("Purchase Category");
        JButton bReport = new JButton("Monthly Report");
        JButton bConfig = new JButton("Settings");
        JButton bBackup = new JButton("Backup");
        JButton bRecovery = new JButton("Recovery");
        
        tb.add(bCost);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecovery);
        
        f.setLayout(new BorderLayout());
        f.add(tb, BorderLayout.NORTH);
        f.add(new JPanel(), BorderLayout.CENTER);
        
        f.setVisible(true);
        
        bCost.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bRecord.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bCategory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bConfig.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bBackup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });
        bRecovery.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
            }
        });

	}

}
