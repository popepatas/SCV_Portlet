/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package control.ParametrizacionServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
import modelo.ParametrizacionManagers.*;

/**
 *
 * @author Galatea
 */
@WebServlet(name = "ActualizarActEconomica", urlPatterns = {"/ActualizarActEconomica"})
public class ActualizarActEconomica extends HttpServlet {



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
        doPost(request, response);
    }
    //-----------------------------------------------------------------------------
    
    
    
    
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
            
            JSONObject respError = new JSONObject(); 

        try {
             
            //Obtenemos la informacion del form.
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            int ciiu = Integer.parseInt(request.getParameter("codigoCiiu"));
            String descripcion = request.getParameter("descripcion");

            ActividadEconomica manager = new ActividadEconomica();
            respError = manager.actualizar(codigo, descripcion, ciiu);
            
            //Armamos la respuesta JSON y la enviamos
            response.setContentType("application/json");
            response.getWriter().write(respError.toString());
            
        } catch (Exception ex) {
            //Armamos la respuesta JSON y la enviamos
            response.setContentType("application/json");
            respError.put("error", 0);
            response.getWriter().write(respError.toString());
        }
        
    }
    //-----------------------------------------------------------------------------
    
}