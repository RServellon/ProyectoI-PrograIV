/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Login;

import Modelo.Cita;
import Modelo.Ciudad;
import Modelo.DAO.AdminHandler;
import Modelo.DAO.GeneralHandler;
import Modelo.DAO.MedicoHandler;
import Modelo.DAO.PacienteHandler;
import Modelo.Especialidad;
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


//jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=CONVERT_TO_NULL [root on Default schema]

/**
 *
 * @author norma
 */
@WebServlet(name = "ControladorLogin", urlPatterns = {"/login/show","/login/login", "/loginError", "/log-out"})
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
            request.setAttribute("model", new Modelo());
            String viewUrl="";
           
            String id = request.getParameter("id");
            String pwd = request.getParameter("password");

            GeneralHandler general = new GeneralHandler();
            AdminHandler admin = new AdminHandler();
            MedicoHandler medico = new MedicoHandler();
            PacienteHandler pac = new PacienteHandler();
            
            
            switch (request.getServletPath()) {
                case "/loginError":
                    viewUrl = "/Components/LoginError.jsp";
                break;
                case "/log-out":
                    viewUrl=this.logout(request);
                break;
                case "/login/show":
                    viewUrl=this.show(request);
                break;
                case "/login/login":
                    viewUrl=this.login(request, general,null);
                break;
            }
            request.getRequestDispatcher(viewUrl).forward(request, response);
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

    private void updateModel(HttpServletRequest request) {
        Modelo modelo = (Modelo) request.getAttribute("model");
        modelo.getCurrent().setClave(request.getParameter("password"));
        modelo.getCurrent().setId(request.getParameter("id"));
        //System.out.println(modelo.getCurrent());
    }

    private String logout(HttpServletRequest request) {
        return this.logoutAction(request);
    }

    private String logoutAction(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.removeAttribute("user");
        session.invalidate();
        return "/index.jsp";
    }

    private String login(HttpServletRequest request, GeneralHandler general, Usuario newUser) {
        this.updateModel(request);
        return this.loginAction(request, general);
    }

    private String show(HttpServletRequest request) {
        return this.showActionRequest(request);
    }

    private String showActionRequest(HttpServletRequest request) {
        Modelo model = (Modelo) request.getAttribute("model");
        request.getSession(true).invalidate();
        model.getCurrent().setId("");
        model.getCurrent().setClave("");
        return "/Login.jsp";
    }


    private String loginAction(HttpServletRequest request, GeneralHandler general) {
        Modelo modelo = (Modelo) request.getAttribute("model");
        Usuario newUser = modelo.getCurrent();
        //abrimos sesion
        HttpSession session = request.getSession(true);
        String confirm = (String) session.getAttribute("confirm"); //si es 0 entonces me debe de llevar al show citas despues de su registro
        System.out.println("CONFIRMACION: "+confirm);
        if (general.validarLogin(newUser)) {
            Usuario user = general.retornaUserPorId(newUser.getId());
            System.out.println(user);
            //System.out.println("METODOLOGINACTION: "+user.toString());
            session.setAttribute("user", user);
           // System.out.println(user);

            switch (user.getTipo()) {
                case "admin":
                    return "/admin-dash-board/administrar/medicos/show";
                case "medico":
                    
                    Medico mm = general.retornaMedicoPorId(newUser.getId());
                    System.out.println(mm);
                    if (mm.getEstado().equals("ESP")) {
                        
                        showActionRequest(request);
                        request.setAttribute("error", "Su solicitud se encuentra en revision");
                        return "/Components/LoginError.jsp";
                    }
                    return "/mavenproject1/medico/gestion/perfil";//todo
                case "paciente":
                    if(confirm != null){
                    if(confirm.equals("0")){
                        return "/VistaCliente/showCita.jsp";
                    }
                    }
                    return "/index.jsp";//todo
            }
        } else {
            return "/Components/LoginError.jsp";
        }
        return "/Components/LoginError.jsp";
    }


}
