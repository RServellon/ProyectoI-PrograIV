/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Medico;

import Modelo.Ciudad;
import Modelo.DAO.GeneralHandler;
import Modelo.DAO.MedicoHandler;
import Modelo.Especialidad;
import Modelo.Fecha;
import Modelo.Medico;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
@WebServlet(name = "ControladorMedico", urlPatterns = {"/ControladorMedico", "/mavenproject1/configurar-medico-primera-vez", "/mavenproject1/paciente/gestion/perfil", "/configurar/medico/actualizar/datos"})
public class ControladorMedico extends HttpServlet {

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

            HttpSession session = request.getSession(true);
            GeneralHandler general = new GeneralHandler();
//            Usuario user = (Usuario) session.getAttribute("user");
//            System.out.println(user);
//            request.setAttribute("clave", user.getClave());
            switch (request.getServletPath()) {
                case "/mavenproject1/configurar-medico-primera-vez":
                    request.getRequestDispatcher("/login/show").forward(request, response);
                    break;
                case "/mavenproject1/paciente/gestion/perfil":
                    
                    Usuario user = (Usuario) session.getAttribute("user");
                    Medico medico =  general.retornaMedicoPorId(user.getId());
                    System.out.println(medico);
                    //medico.getClinica() == null || medico.getCiudad() == null || medico.getEspecialidad() == null 
                    if (true) {
                        List<Ciudad> ciudades = general.listarCiudades();
                        session.setAttribute("ciudades", ciudades);
                        List<Especialidad> esp =  general.listarEspecialidades();
                        session.setAttribute("especialidades", esp);
                        
                        DateTimeFormatter dtf;
                        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                        Fecha fecha = new Fecha(dtf.format(LocalDateTime.now()));
                        session.setAttribute("fecha", fecha);
                        
                        System.out.println(fecha.toString());
                        request.getRequestDispatcher("/VistaMedico/ConfiguraciónInicialDelPerfil.jsp").forward(request, response);
                    }else{
                        request.getRequestDispatcher("/VistaMedico/GestionarPerfil.jsp").forward(request, response);
                    }
                    
                        
                    
                    
                    break;
                case "/configurar/medico/actualizar/datos":
                    
                    Usuario usuario = (Usuario) session.getAttribute("user");
                    String especialidad = (String) request.getParameter("especialidad");
                    String codeCiudad = (String) request.getParameter("ciudad");
                    String costoConsulta = (String)request.getParameter("costoConsulta");
                    String clinica = (String) request.getParameter("clinica");
                    String foto = (String) request.getParameter("foto");
                    
                    System.out.println(especialidad);
                    System.out.println(codeCiudad);
                    System.out.println(costoConsulta);
                    System.out.println(clinica);
                    System.out.println(foto);
                    System.out.println(usuario.getId());
                    
                    MedicoHandler medicoHandler = new MedicoHandler();
                    System.out.println(medicoHandler.modificarDatos(usuario.getId(), especialidad, costoConsulta, codeCiudad, clinica));
                    Medico m = general.retornaMedicoPorId(usuario.getId());
                    System.out.println("Medico actualizado");
                    System.out.println(m);
                    
                    request.getRequestDispatcher("/login/show").forward(request, response);
                    
                    
                    break;
                default:
                    request.getRequestDispatcher("/Components/Error.jsp").forward(request, response);
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
