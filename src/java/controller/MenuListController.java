/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuItemService;
import model.MenuListDAO;

/**
 *
 * @author AJ
 */
public class MenuListController extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String target = "/index.html";
        
        MenuItemService mo = new MenuListDAO();
        request.setAttribute("MenuData", mo.getMenuData());
        
        String action = request.getParameter("action");
        if(action == null){
            target = "/manageMenu.jsp";
        }
        else if(action.equals("addedit")) {
            ArrayList<String> data = new ArrayList<String>();
            String id = request.getParameter("itemIDBox");
            if(id==null){                
                data.add("null");
                data.add("null");
                data.add("null");
            }else{
                int x = Integer.parseInt(id);
                data = mo.getRecordByID(x);
            }
            request.setAttribute("itemData", data);
            
            target = "/addEditPage.jsp";
        }
        else if(action.equals("delete")) {
            String[] x = request.getParameterValues("itemIDBox");
            for(String z : x){
                mo.deleteRecords(z);
            }
            
            target = "/index.html";
        }
        else if(action.equals("change")) {            
            ArrayList<String> col = new ArrayList<String>();
            ArrayList<String> data = new ArrayList<String>();
            
            String id = request.getParameter("id");
            String item = request.getParameter("item");
            String price = request.getParameter("price");
            
            col.add("item");
            col.add("price");
            data.add(item);
            data.add(price);
            
            if(id.equals("null")){
                mo.addItem(col, data);
            }else{
                mo.changeItemData(col, data, Integer.parseInt(id)); 
            }
            
            
            
            target = "/index.html";
        }
     
        
        RequestDispatcher view =
                request.getRequestDispatcher(target);
        view.forward(request, response);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
