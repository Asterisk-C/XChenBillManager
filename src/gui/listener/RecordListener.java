package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import gui.panel.MainPanel;
import gui.panel.RecordPanel;
import gui.panel.SpendPanel;
import service.RecordService;
import util.GUIUtil;

public class RecordListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		RecordPanel p = RecordPanel.getInstance();
		if(p.cbModel.cs.size() == 0)
		{
			JOptionPane.showMessageDialog(p, "Don't have Category at the moment, couldn't add record, please add category first");
			MainPanel.getInstance().workingPanel.show(CategoryPanel.getInstance());
			return;
		}
		
		if(!GUIUtil.checkZero(p.tfSpend, "Spend($)"))
            return;
		float spend = Float.parseFloat(p.tfSpend.getText());
		Category c = p.getSelectedCategory();
		String comment = p.tfComment.getText();
		Date d = p.datepick.getDate();
		new RecordService().add(spend, c, comment, d);
		JOptionPane.showMessageDialog(p, "Added successfully");
		
		MainPanel.getInstance().workingPanel.show(SpendPanel.getInstance());
	}

}
