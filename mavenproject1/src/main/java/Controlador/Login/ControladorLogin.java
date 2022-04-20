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
@WebServlet(name = "ControladorLogin", urlPatterns = {"/login", "/loginError"})
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

            request.setAttribute("user", id);
            request.setAttribute("password", pwd); 
            //creamos el usuario
            Usuario newUser = new Usuario();
            newUser.setClave(pwd);
            newUser.setId(id);
            GeneralHandler general = new GeneralHandler();
            AdminHandler admin = new AdminHandler();
            
            
            switch (request.getServletPath()) {
                case "/loginError":
                    //todo: validar en sql @Rebe
                    request.getRequestDispatcher("/Components/LoginError.jsp").forward(request, response);
                break;
                case "/login":
                    //System.out.println("a");
                    //request.getRequestDispatcher("/loginError").forward(request, response);
                    if (general.validarLogin(newUser)) { 
                        System.out.println("Sii");
                        
                        //retorna usuario por id
                        Usuario u = general.retornaUserPorId("100");
                        System.out.println(u.toString());
                        
                        //Retorna lista de medicos
                        System.out.println(admin.retornaMedicoPorId("101").toString());
                        
                        // Listar medicos
                        System.out.println(admin.listarMedicos().toString());
                        
                        // Listar medicos por estado
                        System.out.println(admin.listarMedicosPorEstado("APRO").toString());


                    } else {
                    request.getRequestDispatcher("/Components/LoginError.jsp").forward(request, response);
                    }
                break;
                default:
                    throw new AssertionError();
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
