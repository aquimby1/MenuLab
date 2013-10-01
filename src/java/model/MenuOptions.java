package model;

import java.util.HashMap;


/**
 *
 * @author aquimby1
 */
public class MenuOptions  {
    private HashMap<String, Double> items = new HashMap<String, Double>();

    public MenuOptions() {
        items.put("Steak",15.0);
        items.put("Burger",8.0);
        items.put("Fries",2.0);
        items.put("Soda",1.50);
        items.put("Salad",3.0);
        items.put("Soup",1.0);
        
    }
    

    public HashMap<String, Double> getMenuOptions(){
        return items;
    }
    
}
