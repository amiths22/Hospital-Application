/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package edu.iit.sat.itmd4515.asatyanarayan1.web;

import edu.iit.sat.itmd4515.asatyanarayan1.domain.City;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author amith
 */
@WebServlet(name = "CityServlet", urlPatterns = {"/city"})
public class CityServlet extends HttpServlet {

    @Resource
    Validator validator;
    
    @Resource(lookup="java:app/jdbc/itmd4515DS")
    DataSource ds;
    
    
     City city=new City();
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
        
        request.setAttribute("city", city);
                   RequestDispatcher requestDispatcher= request.getRequestDispatcher("/WEB-INF/views/city.jsp");
                   requestDispatcher.forward(request, response);
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
                String cityIdparam=request.getParameter("cityId");
                String cityparam=request.getParameter("city");
                String countryIdparam=request.getParameter("countryId");

                Integer cityId=null;
                if(cityIdparam !=null && !cityIdparam.isBlank()){
                    cityId=Integer.valueOf(cityIdparam);
                }
                 Integer countryId=null;
                if(countryIdparam !=null && !countryIdparam.isBlank()){
                    countryId=Integer.parseInt(countryIdparam);
                }
                
                
               
                city.setCityId(cityId);
                city.setCity(cityparam);
                city.setCountryId(countryId);
                LOG.info(city.toString());
                
                Set<ConstraintViolation<City>> violations= validator.validate(city);
                //if it is greater than 0 then we have problems
                if(violations.size()>0){
                    for(ConstraintViolation<City> violation: violations){
                        LOG.info(violation.toString());
                      
                    }
                   request.setAttribute("errors", violations);
                   request.setAttribute("city", city);
                   RequestDispatcher requestDispatcher= request.getRequestDispatcher("/WEB-INF/views/city.jsp");
                   requestDispatcher.forward(request, response);
                    
                }else{
                     
                    //To add the city to db
                    LOG.info(ds.toString());
                    createACity(city);
                    request.setAttribute("city", city);
                   RequestDispatcher requestDispatcher= request.getRequestDispatcher("/WEB-INF/views/confirmation.jsp");
                   requestDispatcher.forward(request, response);
                }

    }
   
    
    private void createACity(City c){
        String query="Insert into city "
                    + "(city_id,city,country_id) "
                    + "values (?,?,?)";
        
                    
            try(    Connection con =ds.getConnection();
                    PreparedStatement ps=con.prepareStatement(query)){

                ps.setInt(1, c.getCityId());
                ps.setString(2, c.getCity());
                ps.setInt(3,c.getCountryId());
                
                ps.executeUpdate();
            
            } catch (SQLException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
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
