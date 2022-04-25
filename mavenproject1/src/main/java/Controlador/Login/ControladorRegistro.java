/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Login;

import Modelo.Cliente;
import Modelo.DAO.GeneralHandler;
import Modelo.Medico;
import Modelo.Modelo;
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
@WebServlet(name = "ControladorRegistro", urlPatterns = {"/ControladorRegistro", "/mavenproject1/registrar-medico", "/mavenproject1/registrar-paciente","/mavenproject1/registrar-administrador"})
public class ControladorRegistro extends HttpServlet {

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
            request.setAttribute("model", new Modelo());
            String viewUrl = "";
            
            //getting info
            String name = request.getParameter("first-name");
            name+= " "+request.getParameter("last-name");
            String id = request.getParameter("id");
            String pwd = request.getParameter("pwd");
            String tipo = request.getParameter("tipo_usuario");
            
            
            System.out.println("\n");
            System.out.println("Estamos en el Controlador de regiistro");
            Usuario user = new Usuario(id,name,pwd,tipo);
            GeneralHandler general = new GeneralHandler();
            
            switch (tipo) {
                case "medico":
                    System.out.println("Case mediic");
                    viewUrl=this.CrearMedico(request, user, general);
                    
                    break;
                case "paciente":
                    System.out.println("Case paciente");
                    viewUrl=this.CrearPaciente(request, user, general);
                    
                    break;
                case "admin":
                    
                    break;
            }
            request.getRequestDispatcher(viewUrl).forward(request, response);
            

            
           
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


    private String CrearMedico(HttpServletRequest request, Usuario user, GeneralHandler general) {
        HttpSession session = request.getSession(true);

        Medico medico = new Medico(user);
        session.setAttribute("user", user);
        general.registrarUsuario(medico.getNombre(), medico.getId(), medico.getClave(), "medico");
        
        //procedemos a que el medico configure su perfil
        return "/mavenproject1/configurar-medico-primera-vez";
    }

    private String CrearPaciente(HttpServletRequest request, Usuario user, GeneralHandler general) {
        Cliente cliente = new Cliente(user.getId(), user.getNombre(), user.getClave(), user.getTipo());
//        general.registrarUsuario(cliente.getNombre(), cliente.getId(), cliente.getClave(), "paciente");
        general.registrarUsuario(cliente.getNombre(), cliente.getId(), cliente.getClave(), cliente.getTipo());

        //procedemos a que el medico configure su perfil
        System.out.println(cliente.getClave());
        request.setAttribute("id", cliente.getId());
        request.setAttribute("password", cliente.getClave());
        
        return "/VistaCliente/PaginaPrincipal.jsp";
    }

}
