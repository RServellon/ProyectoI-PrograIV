/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Cliente;

import java.io.IOException;
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
@WebServlet(name = "BusquedaCita", urlPatterns = {"/VistaCliente/search"})
public class BusquedaCita extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        try{
            String viewURL = showSearch(request);
        request.getRequestDispatcher("/VistaCliente/search.jsp").forward(request, response);
                    
        }catch(Exception e){
            System.out.println("Ha ocurrido un error: "+ e);
                   
        }
    }
     
    //este metodo es para abrir la ventana de search con los medicos correspondientes segun la busqueda realizada
    public String showSearch(HttpServletRequest request){
        return this.showActionSearch(request);
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

    //este metodo extraera la informacion de los campos de especialidad y provincia que se colocaron, posterior a eso
    //hara una busqueda en la lista de medicos registrados y insertara en otra lista distinta los medicos que cumplan
    //con las especificaciones de la busqueda para mandarlo al jsp de search y que me filtre esos medicos encontrados
    public String showActionSearch(HttpServletRequest request){
        String especialidad = "a";
        return especialidad;
    }
}