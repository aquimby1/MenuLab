/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AJ
 */
public class recieptController extends HttpServlet {

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
            
            int s = Integer.parseInt(request.getParameter("size"));
            ArrayList<String> order = new ArrayList<String>();
            
            for(int i=0;i<s;i++){
            String r = request.getParameter("menu"+i);   
            if(r != null){
                order.add(r); 
            }
            
            }
            String out = "";
            double subTotal=0;
            for(int i=0;i<order.size();i++){
                String[] p = order.get(i).split("=");
                out+=p[0]+" $"+p[1]+"\n";
                
                subTotal+=Double.parseDouble(p[1]);
            }
            out+="\n";
            out+="Subtotal: $"+subTotal+"\n";
            out+="Tax: $"+(subTotal*.05)+"\n";
            out+= "Grand Total: $"+(subTotal+(subTotal*.05));
            
//            System.out.println(order.toString());
            
            request.setAttribute("output", out);
            
            
            RequestDispatcher view =
                request.getRequestDispatcher("/reciept.jsp");
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
