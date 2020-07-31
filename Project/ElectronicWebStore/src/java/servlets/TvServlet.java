package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import electronicwebstore.beans.TvManager;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
/**
 *
 * @author dmytr
 */
@WebServlet(urlPatterns = {"/TvServlet"})
public class TvServlet extends HttpServlet {

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
            throws ServletException, IOException{
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
        TvManager tv=new TvManager();
        request.setAttribute("tv",tv);        
        ServletContext context=getServletContext();
        RequestDispatcher dispatcher=context.getRequestDispatcher("/WEB-INF/views/tv.jsp");
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
          TvManager tv=new TvManager();
          tv.setMinPrice(Integer.parseInt(request.getParameter("minPrice")));
          tv.setMaxPrice(Integer.parseInt(request.getParameter("maxPrice")));
          tv.setBrand(request.getParameter("brand"));
          tv.setResolution(request.getParameter("resolution"));
          if(request.getParameter("screenSizeRange")!=null){
            tv.setScreenSizeRange(request.getParameter("screenSizeRange"));
          }       
          if(request.getParameterValues("smartTv")!=null){
            tv.setSmartTv(request.getParameterValues("smartTv"));
          }
          if(request.getParameterValues("threeD")!=null){
            tv.setThreeD(request.getParameterValues("threeD"));
          }
            request.setAttribute("tv",tv);
            //response.sendRedirect("tv.jsp");
            ServletContext context=getServletContext();
            RequestDispatcher dispatcher=context.getRequestDispatcher("/WEB-INF/views/tv.jsp");
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
