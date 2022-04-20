/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Cliente;

import java.io.IOException;
import Controlador.Medico.PasswordValidator;
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
@WebServlet(name = "RegistrarCliente", urlPatterns = {"/registrarcliente"})
public class RegistrarCliente {
    
     protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String nombre = request.getParameter("first-name");
            String apellido = request.getParameter("last-name");
            String id = request.getParameter("id");
            String password = request.getParameter("pwd");
            String confirmPassword = request.getParameter("pwd-confirmation");
            
            System.out.println(nombre);
            System.out.println(apellido);
            System.out.println(id);
            System.out.println(password);
            System.out.println(confirmPassword);
            
            request.setAttribute("first-name", nombre);
            request.setAttribute("last-name", apellido);
            request.setAttribute("id", id);
             switch (PasswordValidator.isValidPassword(password)) {
                case 1:
//                    request.getRequestDispatcher("/RegistroMedicoErrorContrasena.jsp").forward(request, response);
                    
                    break;
                case -1:
                    request.setAttribute("error-code", "La contraseña debe tener menos de 20 y más de 8 caracteres de longitud.");
                    request.getRequestDispatcher("/RegistroClienteErrorContrasena.jsp").forward(request, response);
                    break;
                    
                case -2:
                    request.setAttribute("error-code", "La contraseña debe tener al menos un carácter en mayúscula.");
                    request.getRequestDispatcher("/RegistroClienteErrorContrasena.jsp").forward(request, response);
                    
                    break;
                
                case -3:
                    request.setAttribute("error-code", "La contraseña debe tener al menos un carácter en minúscula");
                    request.getRequestDispatcher("/RegistroClienteErrorContrasena.jsp").forward(request, response);
                    
                    break;
                
                case -4:
                    request.setAttribute("error-code", "La contraseña debe tener al menos un carácter especial");
                    request.getRequestDispatcher("/RegistroClienteErrorContrasena.jsp").forward(request, response);
                    
                    break;
                default:
                    throw new AssertionError();
            }
            
            
            if (!(password.equals(confirmPassword))) {
                request.setAttribute("error-code", "Las contraseñas no coinciden");
                request.getRequestDispatcher("/RegistroClienteErrorContrasena.jsp").forward(request, response);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

}
