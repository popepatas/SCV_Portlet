/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.ProcesoVertimientosServlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ProcesoVertimientosManagers.VerificacionInfoCaracterizacion;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 *
 * @author illustrato
 */
@WebServlet(name = "InsertarDevolucionCaracterizacion", urlPatterns = {"/InsertarDevolucionCaracterizacion"})
public class InsertarDevolucionCaracterizacion extends HttpServlet {

 

    
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
        doPost(request, response);
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
          try {
            
            String fechaDevolCaracterizacion = request.getParameter("fechaDevolCaracterizacion");
            String observacionDevolCaracterizacion = request.getParameter("observacionDevolCaracterizacion");
            String fechaEntDevolCaracterizacion = request.getParameter("fechaEntDevolCaracterizacion");
            String tipoDevolCaracterizacion = request.getParameter("tipoDevolCaracterizacion");
            String codigoProceso = request.getParameter("codigoProceso");
            
            VerificacionInfoCaracterizacion manager = new VerificacionInfoCaracterizacion();
            manager.insertarDevlucion(tipoDevolCaracterizacion, fechaEntDevolCaracterizacion, observacionDevolCaracterizacion, codigoProceso, fechaDevolCaracterizacion);
              
            
        } catch (Exception ex) {
            //Logger.getLogger(InsertarActEconomica.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    
    }


}
