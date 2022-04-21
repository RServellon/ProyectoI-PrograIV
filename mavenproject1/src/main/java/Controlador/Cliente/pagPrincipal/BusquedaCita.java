/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Cliente.pagPrincipal;

import Modelo.ClaseServicio;
import Modelo.Medico;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dell
 */
@WebServlet(name = "BusquedaCita", urlPatterns = {"/inicio/busquedaCita"})
public class BusquedaCita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String viewUrl="";
        switch(request.getServletPath()){
             //si me llega el path de login/login entonces ejecuto una logica para mostrar la vista de login
            case "/inicio/busquedaCita":
//                viewUrl=this.busquedaCita(request);
                viewUrl = "/VistaCliente/search.jsp";
                break;            
        }
        //en base a lo que retorno el switch en la variable viewUrl realiza el foward respectivo
        request.getRequestDispatcher(viewUrl).forward( request, response); 
    }

    
public String busquedaCita(HttpServletRequest request){
        return this.showActionCita(request);
    }

 public String showActionCita(HttpServletRequest request){
     ClaseServicio service = ClaseServicio.instance(); //se crea la instancia unica con los objetos por defecto (solo medicos por ahora)
     //extrae lo que hay en los campos de busqueda
       String especialidad = request.getParameter("Especialidad ");
       String provincia = request.getParameter("Provincia");
      //retornamos en un objeto medico el que tenga esos requisitos
       Medico med = service.retornarMedico(especialidad, provincia);
       request.setAttribute("medico", med);
       out.print("A");
       return "/VistaCliente/search.jsp";
 }
 
}
