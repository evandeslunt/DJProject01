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
import javax.servlet.http.HttpSession;
import model.InMemoryMenuAccessStrategy;
import model.MenuItem;
import model.MenuService;
import model.OrderItem;
import model.OrderService;

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
            //get data from request to send to the model
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String phone = request.getParameter("phone");
            String orderType = request.getParameter("orderType");
            List<OrderItem> itemsOrdered = getOrderItems(request);

            //send data to model
            OrderService orderServ = new OrderService(itemsOrdered);
            
            //Pass parameters to Model
            Double subtotal = orderServ.getFoodTotal();
            Double tax = orderServ.getTaxRate();
            Double total = subtotal + tax;
            Double gratuity = orderServ.getGratuityRate();

            //return the data to the view
            /*
            request.setAttribute("firstName", firstName);
            request.setAttribute("lastName", lastName);
            request.setAttribute("phone", phone);
            request.setAttribute("orderType", orderType);
            request.setAttribute("subtotal", subtotal);
            request.setAttribute("tax", tax);
            request.setAttribute("total", total);
            request.setAttribute("gratuity", gratuity);
            request.setAttribute("itemsOrdered", itemsOrdered);
            */
            
            HttpSession session = request.getSession();
            session.setAttribute("firstName", firstName);
            session.setAttribute("lastName", lastName);
            session.setAttribute("phone", phone);
            session.setAttribute("orderType", orderType);
            session.setAttribute("subtotal", subtotal);
            session.setAttribute("tax", tax);
            session.setAttribute("total", total);
            session.setAttribute("gratuity", gratuity);
            session.setAttribute("itemsOrdered", itemsOrdered);
            
            destination = "confirmation.jsp";
        }
        
        RequestDispatcher view = request.getRequestDispatcher(destination);
        view.forward(request, response);
        
        
    }
    
    /**
     * Returns a list of MenuItems ordered from the Order page. 
     * 
     * @return - a list of MenuItems ordered from the Order page.
     */
    private List<OrderItem> getOrderItems(HttpServletRequest request){
        // grabs the names and quantities of items ordered and 
        // creates MenuItem objects to hold them
        
        //I am not sure what the best way to do this is, so I am going to do something that feels hacky.
        List<MenuItem> itemsOnPage = new InMemoryMenuAccessStrategy().getMenuItems();
        List<OrderItem> itemsOrdered = new ArrayList<OrderItem>();
        for(int i = 0; i < itemsOnPage.size(); i++){
            MenuItem curr = itemsOnPage.get(i);
            String selected = request.getParameter(curr.gethtmlDesc());
            
            if(selected != null && selected.equals("on")){
                Double quantity = 0.0;
                
                try{
                    quantity = new Double(request.getParameter(curr.gethtmlDesc() + "_qty"));
                } catch(Exception e){
                    quantity = 0.0;
                }
                
                itemsOrdered.add(new OrderItem(curr.getName(), curr.getDescription()
                 , curr.getPrice(), quantity));
            }
        }
        return itemsOrdered;
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
