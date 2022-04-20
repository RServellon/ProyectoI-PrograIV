/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Login;

import Modelo.Ciudad;
import Modelo.DAO.AdminHandler;
import Modelo.DAO.GeneralHandler;
import Modelo.DAO.MedicoHandler;
import Modelo.Especialidad;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]

/**
 *
 * @author norma
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/login"})
public class ControladorLogin extends HttpServlet {

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
            
           
            String id = request.getParameter("user");
            String pwd = request.getParameter("password");
            String userTipe = request.getParameter("tipo_usuario");

            System.out.println(id);
            System.out.println(pwd);
            System.out.println(userTipe);

            request.setAttribute("user", id);
            request.setAttribute("password", pwd);
            request.setAttribute("tipo_usuario", userTipe);  
            
            
            GeneralHandler general = new GeneralHandler();
            AdminHandler admin = new AdminHandler();
            MedicoHandler medico = new MedicoHandler();
            
            boolean aceptarMedico = false;
            boolean ingresarCiudad = false;
            boolean ingresarEsp = false;
            boolean ingresarMedico = false;
            boolean ingresarUsuario = false;

            Usuario newUser = new Usuario("100", "Lucia Hernandez", "Password100", "ADMIN");
            Ciudad newCiudad = new Ciudad("1003", "Barva", "Heredia");
            Especialidad newEsp = new Especialidad("6", "Anestecia General", null);
            
            aceptarMedico = admin.aceptarMedico("101");
            ingresarCiudad = admin.registrarCiudad(newCiudad);
            ingresarEsp = admin.registrarEspecialidad(newEsp);
            ingresarUsuario = admin.registrarUsuarioGeneral("Felicia Ramirez", "105", "Password105", "MEDICO");
            ingresarMedico = medico.registrarMedico("105", "1", "1000000000", "1003", "Salud", "APRO");
            

            if (aceptarMedico && ingresarCiudad && ingresarEsp && ingresarUsuario && ingresarMedico) {
                System.out.println("Sii");
            } else {
                System.out.println("NOOOOOOOO");
               
            }
        } catch (Exception e) {
            System.out.println(e);
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
