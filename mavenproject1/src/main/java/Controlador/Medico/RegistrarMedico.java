/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Medico;

import java.io.IOException;
import Modelo.DAO.GeneralHandler;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author norma
 */
@WebServlet(name = "RegistrarMedico", urlPatterns = {"/registrarmedico", "/VistaMedico/registrarmedico"})
public class RegistrarMedico extends HttpServlet {

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
            GeneralHandler g = new GeneralHandler();
            String nombre = request.getParameter("first-name");
            String apellido = request.getParameter("last-name");
            String id = request.getParameter("id");
            String password = request.getParameter("pwd");
            String confirmPassword = request.getParameter("pwd-confirmation");
            String userTipe = request.getParameter("tipo_usuario");
            
            System.out.println(nombre);
            System.out.println(apellido);
            System.out.println(id);
            System.out.println(password);
            System.out.println(confirmPassword);
            System.out.println(userTipe);
            
            request.setAttribute("first-name", nombre);
            request.setAttribute("last-name", apellido);
            request.setAttribute("id", id);
            request.setAttribute("tipo_usuario", userTipe);
            
            
            
            if (!(password.equals(confirmPassword))) {
                request.setAttribute("error-code", "Las contrase??as no coinciden");
                request.getRequestDispatcher("/mavenproject1/VistaMedico/RegistroMedicoErrorContrasena.jsp").forward(request, response);
            }
            
            
            if (g.retornaUserPorId(id).getId() == null) {
                switch (PasswordValidator.isValidPassword(password)) {
                    case 1:
                        request.setAttribute("pwd", password);
                        switch (userTipe) {
                            case "medico":
                                request.getRequestDispatcher("/mavenproject1/registrar-medico").forward(request, response);
                                break;
                            case "paciente":
                                request.getRequestDispatcher("/mavenproject1/registrar-paciente").forward(request, response);
                                break;

                            case "administrador":
                                request.getRequestDispatcher("/mavenproject1/registrar-administrador").forward(request, response);
                                break;
                            default:
                                throw new AssertionError();
                        }

                        break;
                    case -1:
                        request.setAttribute("error-code", "La contrase??a debe tener menos de 20 y m??s de 8 caracteres de longitud.");
                        request.getRequestDispatcher("/mavenproject1/VistaMedico/RegistroMedicoErrorContrasena.jsp").forward(request, response);
                        break;

                    case -2:
                        request.setAttribute("error-code", "La contrase??a debe tener al menos un car??cter en may??scula.");
                        request.getRequestDispatcher("/mavenproject1/VistaMedico/RegistroMedicoErrorContrasena.jsp").forward(request, response);

                        break;

                    case -3:
                        request.setAttribute("error-code", "La contrase??a debe tener al menos un car??cter en min??scula");
                        request.getRequestDispatcher("/mavenproject1/VistaMedico/RegistroMedicoErrorContrasena.jsp").forward(request, response);

                        break;
                    default:
                        throw new AssertionError();
                }
            }else{
                request.setAttribute("error-code", "Ya existe un usuario con la identificaci??n "+id);
                request.getRequestDispatcher("/mavenproject1/VistaMedico/RegistroMedicoErrorContrasena.jsp").forward(request, response);   
            }
             
        }catch(Exception e){
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
