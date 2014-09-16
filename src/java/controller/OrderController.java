/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.MenuItem;
import model.MenuService;

/**
 *
 * @author Lizzy
 */
@WebServlet(name = "OrderController", urlPatterns = {"/OrderController"})
public class OrderController extends HttpServlet {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Retrieve parameters from form and convert to double
        String action = request.getParameter("action");
        String destination = "";
        if(action.equals("getMenuItems")){
            //return menu items
            MenuService menu = new MenuService();
            List<MenuItem> menuItems = menu.getMenuItems();
            request.setAttribute("menuItems", menuItems);
            destination = "order.jsp";
        } else if(action.equals("processOrder")){
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String orderType = request.getParameter("type");

            Map<String, String> items = getOrderItems();

            //Pass parameters to Model
            String subtotal = "";
            String tax = "";
            String total = "";
            String gratuity = "";

            //return the data to the view
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("phone", phone);
            request.setAttribute("orderType", orderType);
            request.setAttribute("subtotal", subtotal);
            request.setAttribute("tax", tax);
            request.setAttribute("total", total);
            request.setAttribute("gratuity", gratuity);
            
            destination = "confirmation.jsp";
        }
        
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
        
        
    }
    
    /**
     * Returns a map of items and quantity ordered from the Order page. 
     * The results are stored as string pairs: <item name, quantity>
     * 
     * @return - a map of items and quantity ordered from the Order page.
     */
    private Map<String, String> getOrderItems(){
        // grabs the names and quantities of items ordered
        return new HashMap<String, String>();
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
