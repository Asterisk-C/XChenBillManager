package gui.panel;

import java.awt.BorderLayout;
import java.awt.Image;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import entity.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

public class ReportPanel extends WorkingPanel
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
		Image img = ChartUtil.getImage(400, 300);
		Icon icon = new ImageIcon(img);
		l.setIcon(icon);
		this.add(l);
		addListener();
	}
	
	@Override
    public void updateData() {
        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        l.setIcon(icon);
    }
 
    @Override
    public void addListener() {
 
    }
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		GUIUtil.showPanel(ReportPanel.getInstance());

	}

}
