package control.ReportesServlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.ApiManager;
import modelo.ReportesManagers.ReportesManager;
import org.json.simple.JSONArray;

/**
 *
 * @author Marcos
 */
@WebServlet(name = "ConsultarReporte1", urlPatterns = {"/ConsultarReporte1"})
public class ConsultarReporte1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //Obtenemos los parametros
            String fechaInicial = request.getParameter("fechaInicial");
            String fechaFinal = request.getParameter("fechaFinal");
            String estadoProceso = request.getParameter("estadoProceso");
            String numeroContrato = request.getParameter("numeroContrato");
            String nit = request.getParameter("nit");
            String actividadProductiva = request.getParameter("actividadProductiva");
            String razonSocial = request.getParameter("razonSocial");
            String comuna = request.getParameter("comuna");
            String laboratorio = request.getParameter("laboratorio");
            String usoServicio = request.getParameter("usoServicio");
            String tipoInforme = request.getParameter("tipoInforme");
            int take = ApiManager.numeroNull(request.getParameter("take"));
            int skip = ApiManager.numeroNull(request.getParameter("skip"));
            Integer filaInicio = skip + 1;
            Integer filaFin= take + skip;
            
            //Obtenemos La informacion del manager
            ReportesManager manager = new ReportesManager();
            JSONArray jsonArray = manager.getReporte1(fechaInicial, fechaFinal, estadoProceso
                    , numeroContrato, nit, actividadProductiva, razonSocial, comuna, laboratorio
                    , usoServicio, tipoInforme, filaInicio.toString(), filaFin.toString());
            String json = null;
            //Armamos la respuesta JSON y la enviamos
            response.setContentType("application/json");
            for(Object jsonObject : jsonArray){
                json = jsonObject.toString();
                response.getWriter().write(jsonObject.toString());
            }
        } catch (Exception ex) {
            //Logger.getLogger(Reporte1Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}