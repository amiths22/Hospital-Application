/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.City;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author amith
 */
@WebServlet(name = "CityServlet", urlPatterns = {"/city"})
public class CityServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(CityServlet.class.getName());

    
    
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
        LOG.info("Inside CityServlet.doGet");
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
                LOG.info("Inside CityServlet.doPost");
                Integer cityId=parseInt(request.getParameter("cityId"));
                String cit=request.getParameter("city");
                Integer countryId=parseInt(request.getParameter("countryId"));

                City city=new City();
                city.setCityId(cityId);
                city.setCity(cit);
                city.setCountryId(countryId);
                LOG.info(city.toString());

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
