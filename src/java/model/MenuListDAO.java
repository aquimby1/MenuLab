/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import db.accessor.DBAccessor;
import db.accessor.DB_Generic;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aquimby1
 */
public class MenuListDAO implements MenuItemService{
    private HashMap<String, Double> items = new HashMap<String, Double>();
    private ArrayList<ArrayList> info = new ArrayList<ArrayList>();
    private String driverClassName;
    private String url;
    private String userName;
    private String password;
    private DBAccessor db; 

    public MenuListDAO() {
        driverClassName = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/sakila";
        userName = "root";
        password = "admin";
        db = new DB_Generic();
    }
    
    @Override
    public HashMap<String, Double> getMenuOptions(){
        List<Map> rawData = new ArrayList<Map>();
        try {
            
            db.openConnection(driverClassName,url,userName, password);
            
            rawData = db.findRecords("SELECT item,price FROM menu_list", true);
            System.out.println(rawData.toString());;
            
            
        } catch (Exception ex) {
            Logger.getLogger(MenuListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<rawData.size();i++){
            Object[] x = rawData.get(i).entrySet().toArray();
            x[0] = x[0].toString().substring(x[0].toString().indexOf("=")+1);
            x[1] = x[1].toString().substring(x[1].toString().indexOf("=")+1);
            
            items.put(x[1].toString(),Double.parseDouble(x[0].toString()));  
        }
        return items;   
    }
    
    
    public ArrayList<ArrayList> getMenuData(){
        List<Map> rawData = new ArrayList<Map>();
        try {
            
            db.openConnection(driverClassName,url,userName, password);
            
            rawData = db.findRecords("SELECT item_id,item,price FROM menu_list", true);
            
            
            
        } catch (Exception ex) {
            Logger.getLogger(MenuListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i=0;i<rawData.size();i++){
            ArrayList<String> build = new ArrayList<String>();
            Object[] x = rawData.get(i).entrySet().toArray();
            
            build.add(x[1].toString().substring(x[1].toString().indexOf("=")+1));
            build.add(x[2].toString().substring(x[2].toString().indexOf("=")+1));
            build.add(x[0].toString().substring(x[0].toString().indexOf("=")+1));
            
            info.add(build);
        }
        return info;   
    }
    public ArrayList<String> getRecordByID(int id){
        ArrayList<String> data = new ArrayList<String>();
        Map rawData = new HashMap();
        try {
            
            db.openConnection(driverClassName,url,userName, password);
            
            rawData = db.getRecordByID("menu_list", "item_id", id, true);
//            System.out.println(rawData);
            
        } catch (Exception ex) {
            Logger.getLogger(MenuListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Object[] x = rawData.entrySet().toArray();
        data.add(x[1].toString().substring(x[1].toString().indexOf("=")+1));
        data.add(x[2].toString().substring(x[2].toString().indexOf("=")+1));
        data.add(x[0].toString().substring(x[0].toString().indexOf("=")+1));
        
        return data;
        
    }
    @Override
    public void changeItemData(List colDescriptors, List colValues, Object whereValue){
        try {
            
            db.openConnection(driverClassName,url,userName, password);
            
            int z = db.updateRecords("menu_list", colDescriptors, colValues, "item_id", whereValue, true);
            System.out.println(z);
            
        } catch (Exception ex) {
            Logger.getLogger(MenuListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void addItem(List colDescriptors, List colValues){
        try {
            
            db.openConnection(driverClassName,url,userName, password);
            
             boolean z = db.insertRecord("menu_list", colDescriptors, colValues, true);
            System.out.println(z);
            
        } catch (Exception ex) {
            Logger.getLogger(MenuListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    public void deleteRecords(Object whereValue){
        try {
            
            db.openConnection(driverClassName,url,userName, password);
            
            int z = db.deleteRecords("menu_list", "item_id", whereValue, true);
            System.out.println(z);
            
        } catch (Exception ex) {
            Logger.getLogger(MenuListDAO.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
            
    public static void main(String[] args) {
        MenuListDAO x = new MenuListDAO();
        x.getRecordByID(2);
    }
  
}

