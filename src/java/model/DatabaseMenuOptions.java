/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author aquimby1
 */
public class DatabaseMenuOptions {
    private HashMap<String, Double> items = new HashMap<String, Double>();
    private Connection conn;
    private String driverClassName;
    private String url;
    private String userName;
    private String password;

    
    public HashMap<String, Double> getMenuOptions() {
        
        
            driverClassName = "com.mysql.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/sakila";
            userName = "root";
            password = "admin";

            try {
                      Class.forName (driverClassName);
                      conn = DriverManager.getConnection(url, userName, password);
            }
            catch ( ClassNotFoundException cnfex ) {
               System.err.println(
                      "Error: Failed to load JDBC driver!" );
               cnfex.printStackTrace();
               System.exit( 1 );  // terminate program
            }
            catch ( SQLException sqlex ) {
               System.err.println( "Error: Unable to connect to database!" );
               sqlex.printStackTrace();
               System.exit( 1 );  // terminate program
            }

            Statement stmt = null;
            ResultSet rs = null;

    ///////////////////////////////////////////
            String sql = "SELECT item,price FROM menu_list";

            try {
                    stmt = conn.createStatement();
                    rs = stmt.executeQuery(sql);


                    while( rs.next() ) {     
                        items.put(rs.getString("item"),rs.getDouble("price"));

                    }



            } catch (SQLException sqle) {
                    System.out.println(sqle);
            } catch (Exception e) {
                    System.out.println(e);
            } finally {
                    try {
                            stmt.close();
                            conn.close();
                    } catch(Exception e) {
                            System.out.println(e);
                    }
            }
        
    return items;
    }

    



}
