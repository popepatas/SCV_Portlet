package control.DashboardServlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.DashboardManagers.DashboardManager;
import org.json.simple.JSONArray;

/**
 *
 * @author jmrincon
 */
@WebServlet(name = "ConsultarDashboard3", urlPatterns = {"/ConsultarDashboard3"})
public class ConsultarDashboard3 extends HttpServlet {

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
            //Obtenemos los parametros
            String codigoCliente = request.getParameter("codigoCliente");
            String paramFisicoQuimico = request.getParameter("paramFisicoQuimico");
            String fechaInicio = "01/01/" + request.getParameter("rangoInicial");
            String fechaFin = "01/01/" + request.getParameter("rangoFinal");
            //Obtenemos La informacion del manager
            DashboardManager manager = new DashboardManager();
            JSONArray jsonArray = manager.getDashboard3(codigoCliente, paramFisicoQuimico, fechaInicio, fechaFin);
            String json = null;
            //Armamos la respuesta JSON y la enviamos
            response.setContentType("application/json");
            for(Object jsonObject : jsonArray){
                json = jsonObject.toString();
                response.getWriter().write(jsonObject.toString());
            }
        } catch (Exception ex) {
            Logger.getLogger(ConsultarDashboard3.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}