package gui.panel;

import javax.swing.JLabel;
import javax.swing.JPanel;

import util.CircleProgressBar;
import util.GUIUtil;

public class SpendPanel extends JPanel
{
	
	static
	{
		GUIUtil.useLNF();
	}
	
	private SpendPanel()
	{
		
	}
	
	private static SpendPanel instance;
	
	public static SpendPanel getInstance()
	{
		if(instance == null)
			instance = new SpendPanel();
		return instance;
	}

	JLabel lMonthSpend = new JLabel("Spend this month");
	JLabel lDaySpend = new JLabel("Spend today");
	JLabel lAvgDailySpend = new JLabel("Average daily Spend");
	JLabel lMonthLeft = new JLabel("Left this month");
	JLabel lAvgDailyAvailable = new JLabel("Average daily available");
	JLabel lMonthDayLeft = new JLabel("Days left in the month");
	
	JLabel vMonthSpend = new JLabel("$2300");
	JLabel vDaySpend = new JLabel("$50");
	JLabel vAvgDailySpend = new JLabel("$30");
	JLabel vMonthLeft = new JLabel("$1800");
	JLabel vAvgDailyAvailable = new JLabel("$200");
	JLabel vMonthDayLeft = new JLabel("15 days");
	
	CircleProgressBar bar;
}
