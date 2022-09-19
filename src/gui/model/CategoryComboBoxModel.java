package gui.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import entity.Category;
import service.CategoryService;

public class CategoryComboBoxModel implements ComboBoxModel<Category>
{
	
//	public List<String> cs = new ArrayList<>();
	public List<Category> cs = new CategoryService().list();
	
	Category c;
	
	public CategoryComboBoxModel()
	{
//		cs.add("Food");
//		cs.add("Transportation");
//		cs.add("Accommodation");
//		cs.add("Call Charge");
		if(!cs.isEmpty())
			c = cs.get(0);
	}
	
	@Override
    public int getSize() {
        return cs.size();
    }
 
    @Override
    public Category getElementAt(int index) {
        return cs.get(index);
    }
 
    @Override
    public void addListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void removeListDataListener(ListDataListener l) {
        // TODO Auto-generated method stub
         
    }
 
    @Override
    public void setSelectedItem(Object anItem) {
        c = (Category) anItem;
         
    }
 
    @Override
    public Object getSelectedItem() {
        // TODO Auto-generated method stub
        if(!cs.isEmpty())
        	return c;
        else
        	return null;
    }

}
