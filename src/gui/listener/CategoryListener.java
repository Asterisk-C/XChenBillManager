package gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

public class CategoryListener implements ActionListener
{
	@Override
	public void actionPerformed(ActionEvent e)
	{
		CategoryPanel p = CategoryPanel.getInstance();
		
		JButton b = (JButton) e.getSource();
		if(b == p.bAdd) 
		{
            String name = JOptionPane.showInputDialog(null);
            if(name.length() == 0) 
            {
                JOptionPane.showMessageDialog(p, "Category name shouldn't be null");
                return;
            }
 
            new CategoryService().add(name);
        }
        if(b == p.bEdit) 
        {
            Category c = p.getSelectedCategory();
            int id = c.id;
            String name = JOptionPane.showInputDialog("Edit category name", c.name);
            if(name.length() == 0) 
            {
                JOptionPane.showMessageDialog(p, "Category name shouldn't be null");
                return;
            }
 
            new CategoryService().update(id, name);
        }
        if(b == p.bDelete) 
        {
            Category c = p.getSelectedCategory();
            if(c.recordNumber != 0) 
            {
                JOptionPane.showMessageDialog(p, "There are some records under this category, couldn't be deleted");
                return;
            }
            if(JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "Do you confirm the delete?"))
                return;
 
            int id = c.id;
            new CategoryService().delete(id);
        }
        p.updateData();
	}

}
