/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import electronicwebstore.beans.MobileManager;
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
@WebServlet(name = "MobileServlet", urlPatterns = {"/MobileServlet"})
public class MobileServlet extends HttpServlet {

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
        MobileManager mobile=new MobileManager();
        request.setAttribute("mobile",mobile); 
        //response.sendRedirect("mobile.jsp");
        ServletContext context=getServletContext();
        RequestDispatcher dispatcher=context.getRequestDispatcher("/WEB-INF/views/mobile.jsp");
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
          MobileManager mobile=new MobileManager();
          mobile.setMinPrice(Integer.parseInt(request.getParameter("minPrice")));
          mobile.setMaxPrice(Integer.parseInt(request.getParameter("maxPrice")));
          mobile.setBrand(request.getParameter("brand"));
          mobile.setResolution(request.getParameter("resolution"));
          mobile.setScreenSize(request.getParameter("screenSize"));
          mobile.setIntMem(request.getParameter("intMem"));
          mobile.setExtMem(request.getParameter("extMem"));
          mobile.setCamera(request.getParameter("camera"));
          if(request.getParameterValues("operMem")!=null){
            mobile.setOperMem(request.getParameterValues("operMem"));
          }
          if(request.getParameterValues("simCount")!=null){
            mobile.setSimCount(request.getParameterValues("simCount"));
          }
          if(request.getParameterValues("gps")!=null){
            mobile.setGps(request.getParameterValues("gps"));
          }
          request.setAttribute("mobile",mobile);          
          ServletContext context=getServletContext();
          RequestDispatcher dispatcher=context.getRequestDispatcher("/WEB-INF/views/mobile.jsp");
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
