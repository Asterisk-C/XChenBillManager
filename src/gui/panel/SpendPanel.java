package gui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUtil;

public class SpendPanel extends JPanel
{
	
	static
	{
		GUIUtil.useLNF();
	}
	
	private SpendPanel()
	{
		this.setLayout(new BorderLayout());
		
		bar = new CircleProgressBar();
		bar.setBackgroundColor(ColorUtil.blueColor);
		GUIUtil.setColor(ColorUtil.grayColor, lMonthSpend, lDaySpend, lAvgDailySpend, lMonthAvailable, lAvgDailyAvailable,
                lMonthLeftDay, vAvgDailySpend, vMonthAvailable, vAvgDailyAvailable, vMonthLeftDay);
        GUIUtil.setColor(ColorUtil.blueColor, vMonthSpend, vDaySpend);
        
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vDaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        
        this.add(center(), BorderLayout.CENTER);
        this.add(south(), BorderLayout.SOUTH);
	}
	
	private static SpendPanel instance;
	
	public static SpendPanel getInstance()
	{
		if(instance == null)
			instance = new SpendPanel();
		return instance;
	}

	public JLabel lMonthSpend = new JLabel("Spend this month");
	public JLabel lDaySpend = new JLabel("Spend today");
	public JLabel lAvgDailySpend = new JLabel("Average daily Spend");
	public JLabel lMonthAvailable = new JLabel("Left this month");
	public JLabel lAvgDailyAvailable = new JLabel("Average daily available");
	public JLabel lMonthLeftDay = new JLabel("Days left in the month");
	
	public JLabel vMonthSpend = new JLabel("$2300");
	public JLabel vDaySpend = new JLabel("$50");
	public JLabel vAvgDailySpend = new JLabel("$30");
	public JLabel vMonthAvailable = new JLabel("$1800");
	public JLabel vAvgDailyAvailable = new JLabel("$200");
	public JLabel vMonthLeftDay = new JLabel("15 days");
	
	CircleProgressBar bar;
	
//	CENTER
	private JPanel center() 
	{
        JPanel p = new JPanel();
        p.setLayout(new BorderLayout());
        p.add(west(), BorderLayout.WEST);
        p.add(center2(),BorderLayout.CENTER);
 
        return p;
    }
 
    private Component center2() 
    {
        return bar;
    }
 
    private Component west() 
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(4, 1));
        p.add(lMonthSpend);
        p.add(vMonthSpend);
        p.add(lDaySpend);
        p.add(vDaySpend);
        return p;
    }
 
//    SOUTH
    private JPanel south() 
    {
        JPanel p = new JPanel();
        p.setLayout(new GridLayout(2, 4));
 
        p.add(lAvgDailySpend);
        p.add(lMonthAvailable);
        p.add(lAvgDailyAvailable);
        p.add(lMonthLeftDay);
        p.add(vAvgDailySpend);
        p.add(vMonthAvailable);
        p.add(vAvgDailyAvailable);
        p.add(vMonthLeftDay);
 
        return p;
    }
}
