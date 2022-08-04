package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CharUtil;
import util.GUIUtil;

public class ReportPanel extends JPanel
{
	
	static
	{
		GUIUtil.useLNF();
	}

	private static ReportPanel instance;
	
	public static ReportPanel getInstance()
	{
		if(instance == null)
			instance = new ReportPanel();
		return instance;
	}
	
	public JLabel l = new JLabel();
	
	private ReportPanel()
	{
		this.setLayout(new BorderLayout());
		Image img = CharUtil.getImage(400, 300);
		Icon icon = new ImageIcon(img);
		l.setIcon(icon);
		this.add(l);
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUIUtil.showPanel(ReportPanel.getInstance());

	}

}
