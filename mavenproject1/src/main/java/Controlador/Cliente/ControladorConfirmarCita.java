/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Cliente;

import Modelo.Cita;
import Modelo.DAO.GeneralHandler;
import Modelo.DAO.PacienteHandler;
import Modelo.Modelo;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *Este servlet se activara a la hora de dar click al boton de confirmar cita, verificara primero que haya una sesion iniciada y si no es asi
 * entonces lo manda a hacer login, cuando hace login me devuelve a la pagina de confirmar cita para ya poder confirmarla y registrar esa cita 
 * Me debe de mostrar el showCitasMedicas.jsp del usuario  cuando se confirme y registre esa cita
 */
@WebServlet(name = "ControladorConfirmarCita", urlPatterns = {"/VistaCliente/confirmarCita"})
public class ControladorConfirmarCita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
            request.setAttribute("model", new ModelConfirmarCita()); //se manda al request
           HttpSession session = request.getSession(true);
           Usuario user = (Usuario) session.getAttribute("user");
           
          // request.setAttribute("model", new ModelConfirmarCita()); //se manda al request
          
        String viewUrl = "";
        switch (request.getServletPath()) {
            //si me llega el path de login/show entonces ejecuto una logica para mostrar la vista de show
            case "/VistaCliente/confirmarCita":
                viewUrl = showConfirmarCita(request, session);
                break;
        }
        //en base a lo que retorno el switch en la variable viewUrl realiza el foward respectivo
        request.getRequestDispatcher(viewUrl).forward(request, response);
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

    private String showConfirmarCita(HttpServletRequest request, HttpSession http) {
       return actionConfirmarCita(request, http);
    }

    private String actionConfirmarCita(HttpServletRequest request, HttpSession http) {
        this.updateModel(request, http);
        //me verifica que el usuario este registrado , si no lo esta me manda al login (un nuevo servlet)
         ModelConfirmarCita model = (ModelConfirmarCita) request.getAttribute("model");
         if(!model.confirmarSesion()){
             return "";
         }
        
        return "/VistaCliente/showCitasMedicas.jsp";
    }
    
    void updateModel(HttpServletRequest request,HttpSession http ) {
        ModelConfirmarCita model = (ModelConfirmarCita) request.getAttribute("model");
        //se extrae el user de la sesion
        Usuario user =(Usuario)http.getAttribute("user");
        System.out.println("USUARIO SESIOOOON: " + user.toString());
        //se inserta en el modelo
        model.setUser(user);
        //Se llama al handler de Pacientes
        PacienteHandler pacHandler = new PacienteHandler();
        //Se extrae la lista de citas de ese usuario
        List<Cita> list = null;
        if(model.confirmarSesion()){
        list = pacHandler.listarCitasPorIdPaciente(model.getUser().getId());
        }
        //se inserta la lista de citas al modelo
        model.setListCitas(list);
    }

    
}