package service;

import java.util.List;

import dao.RecordDAO;
import entity.Record;
import gui.page.SpendPage;
import util.DateUtil;

public class SpendService 
{
	public SpendPage getSpendPage()
	{
		RecordDAO recordDao = new RecordDAO();
		List<Record> thisMonthRecords = recordDao.listThisMonth();
        List<Record> toDayRecords = recordDao.listToday();
        
        int thisMonthTotalDay = DateUtil.thisMonthTotalDay();
        
        int monthSpend = 0;
        int daySpend = 0;
        float avgDailySpend = 0;
        int monthAvailable = 0;
        int avgDailyAvailable = 0;
        int monthLeftDay = 0;
        int usagePercentage = 0;
        
        int monthBudget = new ConfigService().getIntBudget();
 
        for (Record record : thisMonthRecords) {
            monthSpend += record.getSpend();
        }
 
        for (Record record : toDayRecords) {
            daySpend += record.getSpend();
        }
        
        avgDailySpend = (float)(Math.round(monthSpend * 100 / thisMonthTotalDay)) / 100;

        monthAvailable = monthBudget - monthSpend;
 
        monthLeftDay = DateUtil.thisMonthLeftDay();
 
        avgDailyAvailable = monthAvailable / monthLeftDay;
 
        usagePercentage = monthSpend * 100 / monthBudget;
 
        return new SpendPage(monthSpend, daySpend, avgDailySpend, monthAvailable, avgDailyAvailable, monthLeftDay,
                usagePercentage);
	}

}
