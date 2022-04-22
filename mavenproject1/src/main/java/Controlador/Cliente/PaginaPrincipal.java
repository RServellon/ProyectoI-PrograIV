/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Cliente;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PaginaPrincipal", urlPatterns = {"/VistaCliente/PaginaPrincipal", "/mavenproject1"})

public class PaginaPrincipal extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//          String viewUrl="/VistaAdmin/borar.jsp";
        //en base a lo que retorno el switch en la variable viewUrl realiza el foward respectivo 
          response.setContentType("text/html;charset=UTF-8");
        try{
            request.getRequestDispatcher("VistaCliente/search.jsp").forward( request, response); //cuando el forward se ejecuta el jsp tendra acceso al objeto request y response
        }catch(Exception e){
            //si en el registro del prestamo me da un error entonces mando una ventana de error (getRequestDispatcher)
            request.getRequestDispatcher("/PaginaPrincipal.jsp").forward( request, response); 
        }
    }
       
}
