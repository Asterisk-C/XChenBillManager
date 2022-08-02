package test;

import javax.swing.JButton;
import javax.swing.JPanel;

import util.GUIUtil;

public class Test 
{

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUIUtil.useLNF();
		JPanel p = new JPanel();
		p.add(new JButton("Button 1"));
		p.add(new JButton("Button 2"));
		GUIUtil.showPanel(p);

	}

}
