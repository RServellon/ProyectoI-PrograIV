/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Cliente;

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
 *Este servlet se activara a la hora de dar click al boton de confirmar cita, verificara primero que haya una sesion iniciada y si no es asi
 * entonces lo manda a hacer login, cuando hace login me devuelve a la pagina de confirmar cita para ya poder confirmarla y registrar esa cita 
 * Me debe de mostrar el showCitasMedicas.jsp del usuario  cuando se confirme y registre esa cita
 */
@WebServlet(name = "ControladorConfirmarCita", urlPatterns = {"/VistaCliente/confirmarCita"})
public class ControladorConfirmarCita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("ENTREEEEEEEE0");
        HttpSession session = request.getSession(true);
        Usuario user = (Usuario) session.getAttribute("user");
        session.setAttribute("user", user);
        request.setAttribute("model", new ModelConfirmarCita()); //se manda al request

        String viewUrl = "";
        switch (request.getServletPath()) {
            //si me llega el path de login/show entonces ejecuto una logica para mostrar la vista de show
            case "/VistaCliente/confirmarCita":
                System.out.println("ENTREEEEEE1");
                viewUrl = "/VistaCliente/showCitasMedicas.jsp";
                break;
        }
        //en base a lo que retorno el switch en la variable viewUrl realiza el foward respectivo
        request.getRequestDispatcher(viewUrl).forward(request, response);
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
