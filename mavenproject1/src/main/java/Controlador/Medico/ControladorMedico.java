/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Medico;

import Modelo.Ciudad;
import Modelo.DAO.GeneralHandler;
import Modelo.DAO.MedicoHandler;
import Modelo.Especialidad;
import Modelo.Fecha;
import Modelo.Medico;
import Modelo.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
@WebServlet(name = "ControladorMedico", urlPatterns = {"/ControladorMedico", "/mavenproject1/configurar-medico-primera-vez", "/mavenproject1/paciente/gestion/perfil", "/configurar/medico/actualizar/datos"})
public class ControladorMedico extends HttpServlet {

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

            HttpSession session = request.getSession(true);
            GeneralHandler general = new GeneralHandler();
//            Usuario user = (Usuario) session.getAttribute("user");
//            System.out.println(user);
//            request.setAttribute("clave", user.getClave());
            switch (request.getServletPath()) {
                case "/mavenproject1/configurar-medico-primera-vez":
                    request.getRequestDispatcher("/login/show").forward(request, response);
                    break;
                case "/mavenproject1/paciente/gestion/perfil":
                    
                    Usuario user = (Usuario) session.getAttribute("user");
                    Medico medico =  general.retornaMedicoPorId(user.getId());
                    System.out.println(medico);
                    //medico.getClinica() == null || medico.getCiudad() == null || medico.getEspecialidad() == null 
                    if (true) {
                        List<Ciudad> ciudades = general.listarCiudades();
                        session.setAttribute("ciudades", ciudades);
                        List<Especialidad> esp =  general.listarEspecialidades();
                        session.setAttribute("especialidades", esp);
                        
                        DateTimeFormatter dtf;
                        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                        Fecha fecha = new Fecha(dtf.format(LocalDateTime.now()));
                        session.setAttribute("fecha", fecha);
                        
                        System.out.println(fecha.toString());
                        
                        
                        request.getRequestDispatcher("/VistaMedico/ConfiguraciónInicialDelPerfil.jsp").forward(request, response);
                    }else{
                        request.getRequestDispatcher("/VistaMedico/GestionarPerfil.jsp").forward(request, response);
                    }
                    
                        
                    
                    
                    break;
                case "/configurar/medico/actualizar/datos":
                    
                    Usuario usuario = (Usuario) session.getAttribute("user");
                    String especialidad = (String) request.getParameter("especialidad");
                    String codeCiudad = (String) request.getParameter("ciudad");
                    String costoConsulta = (String)request.getParameter("costoConsulta");
                    String clinica = (String) request.getParameter("clinica");
                    String foto = (String) request.getParameter("foto");
                    
                    
                    
                    
                    
                    
                    
                    System.out.println(especialidad);
                    System.out.println(codeCiudad);
                    System.out.println(costoConsulta);
                    System.out.println(clinica);
                    System.out.println(foto);
                    System.out.println(usuario.getId());
                    
                    MedicoHandler medicoHandler = new MedicoHandler();
                    System.out.println(medicoHandler.modificarDatos(usuario.getId(), especialidad, costoConsulta, codeCiudad, clinica));
                    Medico m = general.retornaMedicoPorId(usuario.getId());
                    System.out.println("Medico actualizado");
                    System.out.println(m);
                    
                    Map<String, List<String>> citasSemanal = this.buidCitas(request, medicoHandler);
                    this.configurarCitas(citasSemanal, request, medicoHandler, m);
                    
                    request.getRequestDispatcher("/login/show").forward(request, response);//TODO: cambiar a que mande a la parte de confit perfil
                    
                    
                    break;
                default:
                    request.getRequestDispatcher("/Components/Error.jsp").forward(request, response);
            }
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

    private Map<String, List<String>> buidCitas(HttpServletRequest request, MedicoHandler medicoHandler) {
        HttpSession session = request.getSession(true);
        Fecha fechaReferencia = (Fecha) session.getAttribute("fecha");
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (int i = 0; i < 7; i++) {
            List<String> list = new ArrayList<String>();
            String _inicio = (String) request.getParameter("horaInicio"+i);
            String _final = (String) request.getParameter("horaFinal"+i);
            String _frecuencia = (String) request.getParameter("frecuencia"+i);
            String _annio =String.valueOf(fechaReferencia.getFechaHora().getYear());
            int mes = fechaReferencia.getFechaHora().getMonthValue();
            int dia = fechaReferencia.getDiaDelMes();
            String _mes = mes >= 10? String.valueOf(mes): "0"+String.valueOf(mes);
            String _dia = dia >= 10? String.valueOf(dia): "0"+String.valueOf(dia);
            fechaReferencia = fechaReferencia.creearFechaMasDias(1);
            
            if ((! _inicio.equals("null")) && (!_final.equals("null")) && (!_frecuencia.equals("null"))) {
                list.add(_inicio);
                list.add(_final);
                list.add(_frecuencia);
                list.add(_annio);
                list.add(_mes);
                list.add(_dia);

                map.put(String.valueOf(i), list);
            }
        }
        return map;
    }

    private void configurarCitas(Map<String, List<String>> citasSemanal, HttpServletRequest request, MedicoHandler medicoHandler, Medico m) {
        

        
        for (Map.Entry<String, List<String>> entry : citasSemanal.entrySet()) {
            String horaInicio=entry.getValue().get(0);
            String horaFinal=entry.getValue().get(1);
            String frecuencia=entry.getValue().get(2);
            String annio=entry.getValue().get(3);
            String mes=entry.getValue().get(4);
            String dia=entry.getValue().get(5);
            
            if ( (Integer.parseInt(horaFinal) - Integer.parseInt(horaInicio)) > 0 ) {
              
                String strFechaInicio = annio + "-" + mes + "-" + dia + "T" + horaInicio + ":00:00";
                String strFechaFinal = annio + "-" + mes + "-" + dia + "T" + horaFinal + ":00:00";
                
                System.out.println("Fecha Inicial");
                System.out.println(strFechaInicio);
                System.out.println("Fecha Final");
                System.out.println(strFechaFinal);
                String strFrecuencia = frecuencia.equals("00") ? "01:00:00" :"00:30:00";
                System.out.println(medicoHandler.registrarHorario(m.getId(), strFechaInicio, strFechaFinal, strFrecuencia));

   
                
            }

            
            
        }
    }

  

    

    

   

}
