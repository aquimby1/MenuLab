/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author aquimby1
 */
public interface MenuItemService {

    public abstract HashMap<String, Double> getMenuOptions();
    
    public abstract ArrayList<ArrayList> getMenuData();
    
    public abstract ArrayList<String> getRecordByID(int id);
    
    public abstract void changeItemData(List colDescriptors, List colValues, Object whereValue);
    
    public abstract void addItem(List colDescriptors, List colValues);
    
}
