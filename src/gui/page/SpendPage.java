package gui.page;

public class SpendPage 
{
	public String monthSpend;
	public String daySpend;
    public String avgDailySpend;
    public String monthAvailable;
    public String avgDailyAvailable;
    public String monthLeftDay;
    public int usagePercentage;
    public boolean isOverSpend = false;
    
    public SpendPage(int monthSpend, int daySpend, float avgDailySpend, int monthAvailable, int avgDailyAvailable,
            int monthLeftDay, int usagePercentage)
    {
    	this.monthSpend = "€" + monthSpend;
        this.daySpend = "€" + daySpend;
        this.avgDailySpend = "€" + avgDailySpend;
        if (monthAvailable < 0)
            isOverSpend = true;
        
        if (!isOverSpend) 
        {
            this.monthAvailable = "€" + monthAvailable;
            this.avgDailyAvailable = "€" + avgDailyAvailable;
        } else 
        {
            this.monthAvailable = "Overspend" + (0 - monthAvailable);
            this.avgDailyAvailable = "€0";
        }
        
        this.monthLeftDay = monthLeftDay + "days";
        this.usagePercentage = usagePercentage;
    }

}
