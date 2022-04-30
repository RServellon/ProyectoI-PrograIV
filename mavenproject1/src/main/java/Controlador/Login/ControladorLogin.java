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
//            System.out.println("path ->>>>>>" + request.getServletPath());
            
            
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
//                    System.out.println("Case login");
                    viewUrl=this.login(request, general,null);
                    // Retorna citas por id paciente
                    //System.out.println(pac.listarCitasPorIdPaciente("103"));
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
                     // System.out.println(medico.listarHorarios("102").toString());
//                        
//                        // falta verificar registro cliente, registro usuario, registro cita
//                        // registro horario, eliminar cita, eliminar horario, eliminar usuario
//                        
//                        // Listar especialidades
//                        System.out.println(general.listarEspecialidades().toString());
//
//                        // Listar ciudades
//                        System.out.println(general.listarCiudades().toString());

                        // Registrar ciudad
                        //admin.registrarCiudad(new Ciudad("1100", "Mercedes", "Heredia"));
                        //System.out.println(admin.retornaCiudadPorCodigo("1100").toString());
                        //admin.borrarCiudad("1100");
                    
                        // Registrar especialidad
                        //admin.registrarEspecialidad(new Especialidad("1004", "Dermatologia", "Encargado del cuidado de la piel"));
                        //System.out.println(admin.retornaEspecialidadPorCodigo("1004").toString());
                        //admin.borrarEspecialidad("1004");

                        // Agregar y eliminar usuarios, medicos, admins, pacientes
                        //System.out.println("PRUEBA: " + general.registrarUsuario("Rebe4", "109", "Password109", "medico"));
                        //System.out.println("PRUEBA: " + general.registrarUsuario("Rebe4", "110", "Password109", "paciente"));
                        //System.out.println("PRUEBA: " + general.registrarUsuario("Rebe4", "111", "Password109", "admin"));
                        //System.out.println("PRUEBA: " + general.registrarUsuario("Rebe4", "112", "Password109", "admin"));

                        //System.out.println("prueba" + general.retornaUserPorId("112").toString());
                        //System.out.println("PRUEBA: " + general.borrarUsuario("109", "medico"));
                        //System.out.println("PRUEBA: " + general.borrarUsuario("110", "paciente"));
                        //System.out.println("PRUEBA: " + general.borrarUsuario("111", "admin"));
                        //System.out.println("PRUEBA: " + general.borrarUsuario("112", "admin"));
                        
                        // Registrar y eliminar horario -> para eliminar es con el id y la fechayhora de inicio
                        //System.out.println("PRUEBA: " + medico.registrarHorario("101", "2022-05-10 13:00:00", "2022-05-10 15:00:00", "00:30:00"));
                        //System.out.println("PRUEBA: " + medico.registrarHorario("102", "2022-05-10 13:00:00", "2022-05-10 15:00:00", "00:30:00"));
                        
                        //System.out.println("PRUEBA: " + medico.borrarHorario("101", "2022-05-10 13:00:00"));
                        //System.out.println("PRUEBA: " + medico.borrarHorario("102", "2022-05-10 13:00:00"));

                    // Registrar y eliminar cita
                    //System.out.println("PRUEBA: " + pac.registrarCita("2005", "101", "103", "2022-04-10 15:00:00", "anotacion"));
                    //System.out.println("PRUEBA: " + pac.registrarCita("2006", "101", "104", "2022-04-10 14:00:00", "anotacion"));

                    //System.out.println("PRUEBA: " + pac.borrarCita("2005"));
                    //System.out.println("PRUEBA: " + pac.borrarCita("2006"));
                    
                    // Cambiar estado de cita -> FINALIZADO, REGISTRADO, CANCELADO
                    //System.out.println("PRUEBA: " + pac.cambiarEstadoCita("2003", "FINALIZADO"));
                    //System.out.println("PRUEBA: " + pac.cambiarEstadoCita("2000", "FINALIZADO"));
                    
                    
                    // Registrar y eliminar calificaciones ACEPTABLE, EXCELENTE, DEFICIENTE
                    //System.out.println("PRUEBA: " +  pac.registrarCalificacion("102", "104", "EXCELENTE"));
                    //System.out.println("PRUEBA: " +  pac.registrarCalificacion("105", "104", "DEFICIENTE"));
                    //System.out.println("PRUEBA retorna calif: " +  general.retornaCalificacion("105", "104"));
                    
                    //System.out.println("PRUEBA: " +  pac.cambiarCalificacion("105", "104", "EXCELENTE"));                  
                    //System.out.println("PRUEBA retorna calif: " +  general.retornaCalificacion("105", "104"));

                    //System.out.println("PRUEBA: " +  pac.borrarCalificacion("102", "104"));
                    //System.out.println("PRUEBA: " +  pac.borrarCalificacion("105", "104"));

                    
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
        if (general.validarLogin(newUser)) {
            Usuario user = general.retornaUserPorId(newUser.getId());
            //System.out.println("METODOLOGINACTION: "+user.toString());
            HttpSession session = request.getSession(true);
            session.setAttribute("user", user);
           // System.out.println(user);

            switch (user.getTipo()) {
                case "admin":
                    return "/mavenproject1/admin-dash-board";
                case "medico":
                    
//                    Medico mm = general.retornaMedicoPorId(newUser.getId());
//                    if (mm.getEstado().equals("ESP") ) {
//                        
//                        showActionRequest(request);
//                        request.setAttribute("error", "Su solicitud se encuentra en revision");
//                        return "/Components/LoginError.jsp";
//                    }
                    return "/mavenproject1/paciente/gestion/perfil";//todo
                case "paciente":
                  //  System.out.println("ENTRE A PACIENTE");
                    return "/index.jsp";//todo
            }
        } else {
            return "/Components/LoginError.jsp";
        }
        return "/Components/LoginError.jsp";
    }


}
