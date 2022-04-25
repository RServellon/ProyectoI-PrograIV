/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Medico;

import Modelo.DAO.GeneralHandler;
import Modelo.Medico;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ControladorMedico", urlPatterns = {"/ControladorMedico", "/mavenproject1/configurar-medico-primera-vez", "/mavenproject1/paciente/gestion/perfil"})
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

//            HttpSession session = request.getSession(true);
//            Usuario user = (Usuario) session.getAttribute("user");
//            System.out.println(user);
//            request.setAttribute("clave", user.getClave());
            switch (request.getServletPath()) {
                case "/mavenproject1/configurar-medico-primera-vez":
                    request.getRequestDispatcher("/login/show").forward(request, response);
                    break;
                case "/mavenproject1/paciente/gestion/perfil":
                    GeneralHandler general = new GeneralHandler();
                    HttpSession session = request.getSession(true);
                    Usuario user = (Usuario) session.getAttribute("user");
                    Medico medico =  general.retornaMedicoPorId(user.getId());
                    System.out.println(medico);
                    
                    if (medico.getEstado()==null) {
                        System.out.println("Primer ingreso, iinigrese a terminar de configurar el perfil");  
                        request.getRequestDispatcher("/VistaMedico/ConfiguraciónInicialDelPerfil.jsp").forward(request, response);
                    }else{
                        System.out.println("Ingresar a configurar los datos de configurar el perfil");  
                        request.getRequestDispatcher("/VistaMedico/GestionarPerfil.jsp").forward(request, response);
                    }
                    
                        
                    
                    
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
