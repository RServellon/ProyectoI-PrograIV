/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Cliente;

import Modelo.ClaseServicio;
import Modelo.DAO.MedicoHandler;
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
 *Me cargara los datos en el jsp showCita.jsp
 */
@WebServlet(name = "ControladorShowCita", urlPatterns = {"/VistaCliente/showCita"})
public class ControladorShowCita extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
         request.setAttribute("model", new ModelShowCita()); //se manda al request
         //se extrae la sesion
         HttpSession session = request.getSession(true);
         Usuario user = (Usuario) session.getAttribute("user");
         
         String viewUrl = "";
        switch (request.getServletPath()) {
            //si me llega el path de login/show entonces ejecuto una logica para mostrar la vista de show
            case "/VistaCliente/showCita":
                viewUrl = showCita(request, session);
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
    private String showCita(HttpServletRequest request, HttpSession session) {
       return showActionCita(request, session);
    }

    private String showActionCita(HttpServletRequest request, HttpSession session) {
        this.updateModel(request, session);
        this.updateSesion(request, session);
        return "/VistaCliente/showCita.jsp";
    }
        
    //actualizara el modelo y la sesion
    void updateModel(HttpServletRequest request, HttpSession session) {
        ModelShowCita model = (ModelShowCita) request.getAttribute("model");
        
        MedicoHandler medH = new MedicoHandler();
        Medico med = medH.retornaMedicoPorId(request.getParameter("idMed"));
        model.setMedico(med);
        model.setFecha(request.getParameter("fechaCita"));
        model.setHoraCita(request.getParameter("horaCita"));
        System.out.println(model.toString());
    }

    private void updateSesion(HttpServletRequest request, HttpSession session) {
        String idMedico = request.getParameter("idMed");
        String horaCita = request.getParameter("horaCita");
        String fechaCita = request.getParameter("fechaCita");
        //mandamos a la sesion los datos
        session.setAttribute("horaCita", horaCita);
        session.setAttribute("fechaCita", fechaCita);
        session.setAttribute("idMedico", idMedico);
    }

}
