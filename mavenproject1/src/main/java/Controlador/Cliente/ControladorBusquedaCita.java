package Controlador.Cliente;

import Modelo.ClaseServicio;
import Modelo.Medico;
import Modelo.Usuario;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]

/**
 *
 * @author norma
 */
@WebServlet(name = "BusquedaCita", urlPatterns = {"/VistaCliente/search"})
public class ControladorBusquedaCita extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        request.setAttribute("model", new ModelBusquedaCita()); //se manda al request
        
        HttpSession session = request.getSession(true);
        Usuario user = (Usuario) session.getAttribute("user");
        
        try{
//            String viewURL = showSearch(request);
            String viewURL = showSearch(request, session);
            request.getRequestDispatcher(viewURL).forward(request, response);
                    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);  
        }
    }
     
    //este metodo es para abrir la ventana de search con los medicos correspondientes segun la busqueda realizada
    public String showSearch(HttpServletRequest request, HttpSession session){
        return this.showActionSearch(request, session);
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
        processRequest(request, response);
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
        processRequest(request, response);
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

    //este metodo extraera la informacion de los campos de especialidad y provincia que se colocaron, posterior a eso
    //hara una busqueda en la lista de medicos registrados y insertara en otra lista distinta los medicos que cumplan
    //con las especificaciones de la busqueda para mandarlo al jsp de search y que me filtre esos medicos encontrados
    public String showActionSearch(HttpServletRequest request, HttpSession session){
        this.updateModel(request, session);
        return "/VistaCliente/search.jsp";
    }
    
     void updateModel(HttpServletRequest request, HttpSession session) {
         //Se llama la sesion para extraer los datos de la busqueda
         session = request.getSession(true);
         //Extraemos la provincia y especialidad para que permanezcan
         String provincia = request.getParameter("Provincia");
         String espec = request.getParameter("Especialidad");
         //se mandan los objetos a la sesion
         session.setAttribute("provincia", provincia);
         session.setAttribute("especialidad", espec);
         //Se crea el modelo
        ModelBusquedaCita model = (ModelBusquedaCita) request.getAttribute("model");
        //se inserta la lista y la fecha enviada por parametro
        model.setEspecialidad(request.getParameter("Especialidad"));
        model.setProvincia(request.getParameter("Provincia"));
    }
}