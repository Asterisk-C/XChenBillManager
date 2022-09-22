package util;

import java.awt.Color;
import java.awt.Dimension;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIUtil 
{
	
	private static String imageFolder = "E:/Java Projects/XChenBillManager/img";
	
	public static boolean checkEmpty(JTextField tf, String input)
	{
		String text = tf.getText().trim();
		if(text.length() == 0)
		{
			JOptionPane.showMessageDialog(null, input + "Input can't be null");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public static boolean checkNumber(JTextField tf, String input)
	{
		if(!checkEmpty(tf, input))
			return false;
		
		String text = tf.getText().trim();
		try {
			Float.parseFloat(text);
			return true;
		}catch(NumberFormatException e1){
			JOptionPane.showMessageDialog(null, input + "Input should be number");
			tf.grabFocus();
			return false;
		}
	}
	
	public static boolean checkZero(JTextField tf, String input)
	{
		if(!checkEmpty(tf, input))
			return false;
		
		String text = tf.getText().trim();
		if(Float.parseFloat(text) == 0)
		{
			JOptionPane.showMessageDialog(null, input + "Input can't be 0");
			tf.grabFocus();
			return false;
		}
		return true;
	}
	
	public static void setColor(Color color, JComponent... cs) 
	{
	    for (JComponent c : cs) 
	    {
	        c.setForeground(color);
	    }
	}
	
	public static void setImageIcon(JButton b, String fileName, String tip) 
	{
	    ImageIcon i = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
	    b.setIcon(i);
	    b.setPreferredSize(new Dimension(61, 81));
	    b.setToolTipText(tip);
	    b.setVerticalTextPosition(JButton.BOTTOM);
	    b.setHorizontalTextPosition(JButton.CENTER);
	    b.setText(tip);
	}
	
	public static void useLNF() 
	{
	    try {
	        javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	    } catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	public static void showPanel(JPanel p, double strech) 
	{
	    GUIUtil.useLNF();
	    JFrame f = new JFrame();
	    f.setSize(750, 750);
	    f.setLocationRelativeTo(null);
	    CenterPanel cp = new CenterPanel(strech);
	    f.setContentPane(cp);
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setVisible(true);
	    cp.show(p);
	}
	 
	public static void showPanel(JPanel p) 
	{
	    showPanel(p, 0.85);
	} 

}
