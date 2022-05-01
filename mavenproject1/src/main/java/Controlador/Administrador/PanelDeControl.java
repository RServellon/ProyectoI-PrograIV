/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Administrador;

import Modelo.Ciudad;
import Modelo.ClaseServicio;
import Modelo.DAO.AdminHandler;
import Modelo.DAO.GeneralHandler;
import Modelo.DAO.MedicoHandler;
import Modelo.Especialidad;
import Modelo.Medico;
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
 *
 * @author norma
 */
@WebServlet(name = "PanelDeControl", urlPatterns = {"/PanelDeControl", "/mavenproject1/admin-dash-board",
    "/admin-dash-board", "/admin-dash-board/administrar/medicos/show", "/admin-dash-board/administrar/especialidades/show",
    "/admin-dash-board/administrar/ciudades/show", "/admin-dash-board/administrar/especialidades/add", "/admin-dash-board/administrar/ciudades/add",
    "/admin-dash-board/administrar/medicos/restringir", "/admin-dash-board/administrar/medicos/reactivar",
    "/admin-dash-board/administrar/medicos/aceptar","/admin-dash-board/administrar/medicos/rechazar"})
public class PanelDeControl extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            //solicitud de ingreso a la vista
            HttpSession session = request.getSession(true);
            Usuario user = (Usuario) session.getAttribute("user");
            GeneralHandler general = new GeneralHandler();
            MedicoHandler medicoHandler = new MedicoHandler();
            AdminHandler adminHandler = new AdminHandler();
            
            switch (request.getServletPath()) {
                case "/admin-dash-board/administrar/medicos/show":
                    //Listar medicos
                    List<Medico> aprobados = adminHandler.listarMedicosPorEstado("APRO");
                    List<Medico> pendientes = adminHandler.listarMedicosPorEstado("ESP");
                    List<Medico> restringidos = adminHandler.listarMedicosPorEstado("REC");
                    
                    System.out.println(aprobados);
                    System.out.println(pendientes);
                    System.out.println(restringidos);
                    
                    session.setAttribute("aprobados",aprobados);
                    session.setAttribute("pendientes",pendientes);
                    session.setAttribute("restringidos",restringidos);
                    session.setAttribute("adminHandler",adminHandler);
                    
                    
                    
                    request.getRequestDispatcher("/VistaAdmin/PanelDeControl.jsp").forward(request, response);
                    break;
                case "/admin-dash-board/administrar/medicos/restringir":
                    //Restringir un medico
                    String idASuspender = request.getParameter("idASuspender");
                    
                    
                    adminHandler.cambiarEstadoDeMedico(idASuspender, "REC");
                    request.getRequestDispatcher("/admin-dash-board/administrar/medicos/show").forward(request, response);
                    break;
                case "/admin-dash-board/administrar/medicos/reactivar":
                    //Reactivar  un medico bloqueadp
                    String idAReactivar = request.getParameter("idAReactivar");
                    
                    
                    adminHandler.cambiarEstadoDeMedico(idAReactivar, "APRO");
                    request.getRequestDispatcher("/admin-dash-board/administrar/medicos/show").forward(request, response);
                    break;
                case "/admin-dash-board/administrar/medicos/aceptar":
                    //aceptar  un medico nuevo
                    String idAAceptar = request.getParameter("idAAceptar");
                    
                    
                    adminHandler.cambiarEstadoDeMedico(idAAceptar, "APRO");
                    request.getRequestDispatcher("/admin-dash-board/administrar/medicos/show").forward(request, response);
                    break;
                case "/admin-dash-board/administrar/medicos/rechazar":
                    //rechazar un medico nuevo
                    String idARechazar = request.getParameter("idARechazar");
                    
                    
                    adminHandler.borarMedico(idARechazar);
                    
                    request.getRequestDispatcher("/admin-dash-board/administrar/medicos/show").forward(request, response);
                    break;
                case "/admin-dash-board/administrar/especialidades/show":
                    //Listar Especiialidades
                    List<Especialidad> especialidades = general.listarEspecialidades();
                    session.setAttribute("especialidades", especialidades);
                    request.getRequestDispatcher("/VistaAdmin/AdministrarEspecialidades.jsp").forward(request, response);
                    break;
                case "/admin-dash-board/administrar/especialidades/add":
                    //agregar Especiialidad
                    String nombre = (String) request.getParameter("nombreEspecialidad");
                    String id = (String) request.getParameter("idEspecialidad");
                    String descripcion = (String) request.getParameter("descripcion");
                    
                    Especialidad especialidad = new Especialidad(id, nombre, descripcion);
                    Especialidad especialidaddb = adminHandler.retornaEspecialidadPorCodigo(id);
                    if (especialidaddb.getCodigo() == null) {
                        adminHandler.registrarEspecialidad(especialidad);
                    }              
                    request.getRequestDispatcher("/admin-dash-board/administrar/especialidades/show").forward(request, response);
                    break;
                    case "/admin-dash-board/administrar/ciudades/add":
                    ClaseServicio ser = ClaseServicio.instance();
                    String ciudad = (String) request.getParameter("Ciudad");
                    String provincia = (String) request.getParameter("Provincia");
                    String codigo = ser.generarAleatorio();
                    //creamos la ciudad
                    Ciudad city = new Ciudad(codigo,ciudad,provincia);
                    adminHandler.registrarCiudad(city);
                    request.setAttribute("registrado", "1"); //manda 1 si se registro correctamente
                    request.getRequestDispatcher("/admin-dash-board/administrar/ciudades/show").forward(request, response);
                    break; 
                case "/admin-dash-board/administrar/ciudades/show":
                    // Listar ciudades
                    //mandamos las ciudades para listarlas
                    List<Ciudad> ciudades = general.listarCiudades();
                    session.setAttribute("ciudades", ciudades);
                    
                    request.getRequestDispatcher("/VistaAdmin/AdministrarCiudades.jsp").forward(request, response);
                    break;
            }
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

}
