/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis.cs425.project1;

import java.io.*;
import java.sql.SQLException;
import java.util.logging.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 *
 * @author treyb
 */
@WebServlet(name = "Registration", urlPatterns = {"/registration"})
public class Registration extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
 
        Database db = new Database();
        
        try {
            
            out.println( db.getDataAsTable( Integer.parseInt( request.getParameter("session") ) ) );
            
        } 
        catch (SQLException ex) {
            
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        Database db = new Database();
        
        try {
            
            out.println( db.putDataInDB( request.getParameter("firstname"), request.getParameter("lastname"),
                    request.getParameter("displayname"), Integer.parseInt( request.getParameter("session") ) ) );
            
            
        } 
        catch (SQLException ex) {
            
            Logger.getLogger(Registration.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
    }
    
   
    @Override
    public String getServletInfo() {
        return "Servlet to handle registration process.";
    }
}
