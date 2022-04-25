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
import Modelo.Especialidad;
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
            System.out.println("path ->>>>>>" + request.getServletPath());
            
            
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
                    System.out.println("Case login");
                    viewUrl=this.login(request, general,null);
//                        System.out.println("Sii");
//                        
//                        //retorna usuario por id
//                        Usuario u = general.retornaUserPorId("100");
//                        System.out.println(u.toString());
//                        
//                        //Retorna lista de medicos
//                        System.out.println(admin.retornaMedicoPorId("101").toString());
//                        
//                        // Listar medicos
//                        System.out.println(admin.listarMedicos().toString());
//                        
//                        //Cambiar estado del medico
//                        admin.cambiarEstadoDeMedico("101", "REC");
//                        
//                        // Listar medicos por estado
//                        System.out.println("Sii");
//                        System.out.println(admin.listarMedicosPorEstado("REC").toString());
//
//                        // Listar medicos aprobados por prov
//                        System.out.println(general.listarMedicoPorProvinciaYEspecialidad("HEREDIA", null).toString());
//
//                        // Listar medicos aprobados por especialidad
//                        System.out.println(general.listarMedicoPorProvinciaYEspecialidad(null,"Anestecia General").toString());
//
//                        // Listar medicos aprobados por provincia y especialidad
//                        System.out.println(general.listarMedicoPorProvinciaYEspecialidad("HEREDIA","Anestecia General").toString());
//
//                        // Listar citas por estado y id del medico
//                        System.out.println(medico.listarCitasPorEstado("FINALIZADO", "101").toString());
//                        
//                        // Prueba formato de fecha en cita
//                        Cita cita = new Cita("102", "104", "2022-04-10 16:00:00.0", "FINALIZADO", "abc-abc-abc");
//                        System.out.println(cita.getFechaString());
//
//                                                
//                        // Mostrar datos de fecha
//                        System.out.println(cita.getFecha());
//                        System.out.println(cita.getFecha().getFecha());
//                        System.out.println(cita.getFecha().getHora());
//                        
//                        // Listar calificaciones
//                        System.out.println(medico.listarCalificaciones("101").toString());
//                        
//                        // Listar horarios
//                        System.out.println(medico.listarHorarios("102").toString());
//                        
//                        // falta verificar registro cliente, registro usuario, registro cita
//                        // registro horario, eliminar cita, eliminar horario, eliminar usuario
//                        
//                        // Listar especialidades
//                        System.out.println(general.listarEspecialidades().toString());
//
//                        // Listar ciudades
//                        System.out.println(general.listarCiudades().toString());

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
        System.out.println(modelo.getCurrent());
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
        model.getCurrent().setId("");
        model.getCurrent().setClave("");
        return "/Login.jsp";
    }


    private String loginAction(HttpServletRequest request, GeneralHandler general) {
        Modelo modelo = (Modelo) request.getAttribute("model");
        Usuario newUser = modelo.getCurrent();
        if (general.validarLogin(newUser)) {
            Usuario user = general.retornaUserPorId(newUser.getId());
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
            System.out.println("\n Usuario<<<<<<<<<<<<<<<<>>>>>>>>>>>>>");
            System.out.println(user);
            System.out.println("Usuario<<<<<<<<<<<<<<<<>>>>>>>>>>>>>");

            switch (user.getTipo()) {
                case "admin":
                    return "/mavenproject1/admin-dash-board";
                case "medico":
                    return "/mavenproject1/paciente/gestion/perfil";//todo
                case "paciente":
                    return "/index.jsp";//todo
            }
        } else {
            System.out.println("entra al error");
            return "/Components/LoginError.jsp";
        }
            System.out.println("entra al error");
        return "/Components/LoginError.jsp";
    }


}
