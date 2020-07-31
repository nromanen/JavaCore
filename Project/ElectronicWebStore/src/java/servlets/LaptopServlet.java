/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import electronicwebstore.beans.LaptopManager;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dmytr
 */
@WebServlet(name = "LaptopServlet", urlPatterns = {"/LaptopServlet"})
public class LaptopServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {            
        }
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
        //processRequest(request, response);
        LaptopManager laptop=new LaptopManager();
        request.setAttribute("laptop",laptop);        
        ServletContext context=getServletContext();
        RequestDispatcher dispatcher=context.getRequestDispatcher("/WEB-INF/views/laptops.jsp");
        dispatcher.forward(request,response);
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
        //processRequest(request, response);
          LaptopManager laptop=new LaptopManager();
          laptop.setMinPrice(Integer.parseInt(request.getParameter("minPrice")));
          laptop.setMaxPrice(Integer.parseInt(request.getParameter("maxPrice")));
          laptop.setBrand(request.getParameter("brand"));
          laptop.setResolution(request.getParameter("resolution"));
          laptop.setScreenSize(request.getParameter("screenSize"));
          laptop.setIntMem(request.getParameter("intMem"));
          if(request.getParameterValues("operMem")!=null){
            laptop.setOperMem(request.getParameterValues("operMem"));
          }  
          request.setAttribute("laptop",laptop);          
          ServletContext context=getServletContext();
          RequestDispatcher dispatcher=context.getRequestDispatcher("/WEB-INF/views/laptops.jsp");
          dispatcher.forward(request,response);
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
