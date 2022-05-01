/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controlador.Medico;

import Modelo.Cita;
import Modelo.Ciudad;
import Modelo.DAO.GeneralHandler;
import Modelo.DAO.MedicoHandler;
import Modelo.DAO.PacienteHandler;
import Modelo.Especialidad;
import Modelo.Fecha;
import Modelo.Horario;
import Modelo.Medico;
import Modelo.Usuario;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.ws.rs.Path;

/**
 *
 * @author norma
 */
@WebServlet(name = "ControladorMedico", urlPatterns = {"/ControladorMedico", "/mavenproject1/configurar-medico-primera-vez",
    "/mavenproject1/paciente/gestion/perfil", "/configurar/medico/actualizar/datos", "/configurar/medico/image", 
    "/medico/gestion/perfil", "/medico/actualizar/informacion", "/medico/gestionar/horario",
    "/medico/gestionar/horario/procesar", "/administrar/citas", "/mavenproject1/medico/gestion/perfil",
    "/medico/gestion/inicial", "/medico/gestionar/citas/aceptar","/medico/gestionar/citas/descartar",
    "/medico/gestionar/citas/concluir", "/medico/gestionar/citas/concluir/update" })
@MultipartConfig(location="C:/Users/rebec/OneDrive/Escritorio/img")
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
        try {

            HttpSession session = request.getSession(true);
            GeneralHandler general = new GeneralHandler();
            
//            Usuario user = (Usuario) session.getAttribute("user");
//            System.out.println(user);
//            request.setAttribute("clave", user.getClave());

            MedicoHandler medicoHandler = new MedicoHandler();
            PacienteHandler pacienteHandler = new PacienteHandler();
            Usuario usuario = (Usuario) session.getAttribute("user");
            String especialidad = (String) request.getParameter("especialidad");
            String codeCiudad = (String) request.getParameter("ciudad");
            String costoConsulta = (String)request.getParameter("costoConsulta");
            String clinica = (String) request.getParameter("clinica");
          
            System.out.println(request.getServletPath());
            switch (request.getServletPath()) {
                case "/mavenproject1/configurar-medico-primera-vez":
                    request.getRequestDispatcher("/login/show").forward(request, response);
                    break;
                case "/medico/gestionar/citas/aceptar":
                    //aceptar la cita de un paciente
                    String citaAceptada = request.getParameter("citaAceptada");
                    System.out.println(citaAceptada);
                    pacienteHandler.cambiarEstadoCita(citaAceptada, "REGISTRADO");
                    
                    
                    request.getRequestDispatcher("/administrar/citas").forward(request, response);
                    break;
                case "/medico/gestionar/citas/descartar":
                    //descartar la cita de un paciente
                    String citaDescartada = request.getParameter("citaDescartada");
                    System.out.println(citaDescartada);
                    pacienteHandler.cambiarEstadoCita(citaDescartada, "CANCELADO");
                    
                    
                    request.getRequestDispatcher("/administrar/citas").forward(request, response);
                    break;
                case "/medico/gestionar/citas/concluir":
                    //finalizar la cita de un paciente
                    String citaConcluida = request.getParameter("citaConcluida");
                    System.out.println(citaConcluida);
                    Cita citaObj = general.retornaCitaPorCodigo(citaConcluida);
                    Usuario pacienteObj = general.retornaUserPorId(citaObj.getId_paciente());
                    session.setAttribute("citaConcluida", citaConcluida);
                    session.setAttribute("citaObj", citaObj);
                    session.setAttribute("pacienteObj", pacienteObj);
                    request.getRequestDispatcher("/VistaMedico/CouncluirCita.jsp").forward(request, response);   
                    break;
                case "/medico/gestionar/citas/concluir/update":
                    //mandar datos por backend y relistar la info nueva
                    String anotaciones = request.getParameter("anotaciones");
                    String citaConcluidap = (String) session.getAttribute("citaConcluida");
                    System.out.println(anotaciones);
                    System.out.println(citaConcluidap);
                    pacienteHandler.concluirCita(citaConcluidap, anotaciones);
                    
                    
                    request.getRequestDispatcher("/administrar/citas").forward(request, response);
                    break;
                case "/administrar/citas":
                    String estado = request.getParameter("estado");
                    String idCliente = request.getParameter("idCliente");
                    
                    if (estado == null) {
                        estado = "";
                    }
                    if (idCliente == null) {
                        idCliente = "";
                    }
                    
                    List<Cita> citas = medicoHandler.listarCitasPorEstadoYNombrePaciente(estado, usuario.getId() , idCliente);
                  

                    
                    request.setAttribute("estado", estado);
                    request.setAttribute("idCliente", idCliente);
                    session.setAttribute("citas", citas);
                    
                    //TODO hacer lo de gestión de ciitas de x medico
                    request.getRequestDispatcher("/VistaMedico/GestionarCitas.jsp").forward(request, response);
                    break;
                case "/medico/gestionar/horario":
                    {
                        //aqui se deben cargar los datos de la base y cargar la fecha actual
                        DateTimeFormatter dtf;
                        dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                        Fecha fecha = new Fecha(dtf.format(LocalDateTime.now()));
                        session.setAttribute("fecha", fecha);
                        Usuario user = (Usuario) session.getAttribute("user");
                        System.out.println(user);
                        
                       
                       
                        
                        
                        request.getRequestDispatcher("/VistaMedico/ConfiguracionHorario.jsp").forward(request, response);
                    }
                    break;
                case "/medico/gestionar/horario/procesar":
                    {
                        //aqui se deben cargar los datos de la base y cargar la fecha actual

                        Usuario user = (Usuario) session.getAttribute("user");
//                        MedicoHandler medicoHandler = new MedicoHandler();
                       String horaInicio = (String) request.getParameter("horaInicio");
                       String horaFinal = (String) request.getParameter("horaFinal");
                       String frecuencia = (String) request.getParameter("frecuencia");
                       String calendario = (String) request.getParameter("calendario");
                       String strFrecuencia = frecuencia.equals("00") ? "01:00:00" : "00:30:00";
                       
                       String strFechaInicio = calendario+"T"+horaInicio+":00:00";
                       String strFechaFinal= calendario + "T" + horaFinal + ":00:00";
                       
                        System.out.println(calendario);
                        System.out.println(frecuencia);
                        System.out.println(horaFinal);
                        System.out.println(horaInicio);
                        System.out.println(strFechaInicio);
                        System.out.println(strFechaFinal);
                        System.out.println(user);
                        
                        
                        if (Integer.parseInt(horaFinal) - Integer.parseInt(horaInicio) > 0) {
                            medicoHandler.registrarHorario(user.getId(), strFechaInicio, strFechaFinal, strFrecuencia);
                            Horario h = medicoHandler.retornaHorario(user.getId(), strFechaInicio);
                            System.out.println(h);
                            if (h.getId_medico() != null ) {
                                System.out.println("Entra y borra user");
                                medicoHandler.borrarHorario(user.getId(), strFechaInicio);
                                medicoHandler.registrarHorario(user.getId(), strFechaInicio, strFechaFinal, strFrecuencia);
                            }else{
                                System.out.println("Entra y borra user");
                                System.out.println(user);
                              medicoHandler.registrarHorario(user.getId(), strFechaInicio, strFechaFinal, strFrecuencia);
                            }
                            
                            request.getRequestDispatcher("/VistaMedico/ConfiguracionHorario.jsp").forward(request, response);
                        }else{
                            //todo error
                        }
                       
                        
                        
                    }
                    break;
                case "/medico/actualizar/informacion":
                    {
                        Usuario usuario1 = (Usuario) session.getAttribute("user");
                        String codeEspecialidad = (String) request.getParameter("especialidad");
                        String codeCiudad1 = (String) request.getParameter("ciudad");
                        String costoConsulta1 = (String) request.getParameter("costoConsulta");
                        String clinica1 = (String) request.getParameter("clinica");
                        String foto = (String) request.getParameter("foto");
                        String descipcion = (String) request.getParameter("descipcion");
                        
                        System.out.println(usuario1);
                        System.out.println(codeEspecialidad);
                        System.out.println(codeCiudad1);
                        System.out.println(costoConsulta1);
                        System.out.println(clinica1);
                        
                        ///TODO: -> poner que actualize la foto y descripción
                        System.out.println(foto);
                        System.out.println(descipcion);
                        
//                        MedicoHandler medicoHandler = new MedicoHandler();
                        System.out.println(medicoHandler.modificarDatos(usuario1.getId(), codeEspecialidad, costoConsulta1, codeCiudad1, clinica1));
                        request.getRequestDispatcher("/medico/gestion/perfil").forward(request, response);
                    }
                    break;
                case "/medico/gestion/perfil":{
                    
                    
                    Usuario user = (Usuario) session.getAttribute("user");
                    Medico medico = general.retornaMedicoPorId(user.getId());
                    List<Ciudad> ciudades = general.listarCiudades();
                    request.setAttribute("ciudades", ciudades);
                    List<Especialidad> esp = general.listarEspecialidades();
                    request.setAttribute("especialidades", esp);
                    request.setAttribute("medico", medico);
                    System.out.println("medico en /medico/gestion/perfil");
                    System.out.println(medico);

                    request.getRequestDispatcher("/VistaMedico/GestionarPerfil.jsp").forward(request, response);
                    }
                    break;
                
                case "/mavenproject1/medico/gestion/perfil":
                    
                    Usuario user = (Usuario) session.getAttribute("user");
                    Medico medico =  general.retornaMedicoPorId(user.getId());
                    System.out.println(medico);
                    System.out.println("Entra a  |/mavenproject1/medico/gestion/perfil|");
                    //
                    List<Ciudad> ciudades = general.listarCiudades();
                    session.setAttribute("ciudades", ciudades);
                    List<Especialidad> esp =  general.listarEspecialidades();
                    session.setAttribute("especialidades", esp);
                    DateTimeFormatter dtf;
                    dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
                    Fecha fecha = new Fecha(dtf.format(LocalDateTime.now()));
                    session.setAttribute("fecha", fecha);
                    if (medico.getClinica() == null || medico.getCiudad() == null || medico.getEspecialidad() == null) {
                        
                        System.out.println(fecha.toString());
                        request.getRequestDispatcher("/VistaMedico/ConfiguraciónInicialDelPerfil.jsp").forward(request, response);
                    }else{
                        System.out.println("ENTRA A GESTIONAR EL OERFIIL");
                        request.getRequestDispatcher("/medico/gestion/perfil").forward(request, response);
                    }
                    
                  
                    
                    
                    break;
                case "/configurar/medico/actualizar/datos":
                    
                    System.out.println("Entra a confiig los datos");
                    
//                    Medico m = general.retornaMedicoPorId(usuario.getId());
                    //System.out.println(m);
                    
                    // Prueba cargar imagen
//                    
                    System.out.println(especialidad);
                    System.out.println(codeCiudad);
                    System.out.println(costoConsulta);
                    System.out.println(clinica);
//                    System.out.println(foto);
                    System.out.println(medicoHandler.modificarDatos(usuario.getId(), especialidad, costoConsulta, codeCiudad, clinica));
                    Medico m = general.retornaMedicoPorId(usuario.getId());
                    System.out.println("Medico actualizado");
                    System.out.println(m);
                    System.out.println(usuario.getId());
                    Map<String, List<String>> citasSemanal = this.buidCitas(request, medicoHandler);
                    this.configurarCitas(citasSemanal, request, medicoHandler, m);
                    request.getRequestDispatcher("/mavenproject1/medico/gestion/perfil").forward(request, response);//TODO: cambiar a que mande a la parte de confit perfil
                    
//                    
//                     final Part imagen;
//                    imagen = request.getPart("imagen");
//                    imagen.write(m.getId());
//                        
//                    
//                    request.getRequestDispatcher("/login/show").forward(request, response);

                    
                    
                    
                    break;
                case "/configurar/medico/image":
                    
                    OutputStream output = response.getOutputStream();
                    String id = request.getParameter("id");
                    System.out.println("Entra ");
                    
                    java.nio.file.Path path = FileSystems.getDefault().getPath("C:/Users/rebec/OneDrive/Escritorio/img", id);

                    Files.copy(path, output);
                    output.flush();
                    
                    break;

                default:
                    request.getRequestDispatcher("/Components/Error.jsp").forward(request, response);
                    break;
            }
        } catch(Exception e){
           System.out.println("Ha ocurrido un error: "+ e);  
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
            String _inicio = (String) request.getParameter("horaInicio" + i);
            String _final = (String) request.getParameter("horaFinal" + i);
            String _frecuencia = (String) request.getParameter("frecuencia" + i);
            String _annio = String.valueOf(fechaReferencia.getFechaHora().getYear());
            int mes = fechaReferencia.getFechaHora().getMonthValue();
            int dia = fechaReferencia.getDiaDelMes();
            String _mes = mes >= 10 ? String.valueOf(mes) : "0" + String.valueOf(mes);
            String _dia = dia >= 10 ? String.valueOf(dia) : "0" + String.valueOf(dia);
            fechaReferencia = fechaReferencia.creearFechaMasDias(1);

            if ((!_inicio.equals("null")) && (!_final.equals("null")) && (!_frecuencia.equals("null"))) {
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
            String horaInicio = entry.getValue().get(0);
            String horaFinal = entry.getValue().get(1);
            String frecuencia = entry.getValue().get(2);
            String annio = entry.getValue().get(3);
            String mes = entry.getValue().get(4);
            String dia = entry.getValue().get(5);

            if ((Integer.parseInt(horaFinal) - Integer.parseInt(horaInicio)) > 0) {

                String strFechaInicio = annio + "-" + mes + "-" + dia + "T" + horaInicio + ":00:00";
                String strFechaFinal = annio + "-" + mes + "-" + dia + "T" + horaFinal + ":00:00";

                System.out.println("Fecha Inicial");
                System.out.println(strFechaInicio);
                System.out.println("Fecha Final");
                System.out.println(strFechaFinal);
                String strFrecuencia = frecuencia.equals("00") ? "01:00:00" : "00:30:00";
                System.out.println(medicoHandler.registrarHorario(m.getId(), strFechaInicio, strFechaFinal, strFrecuencia));

            }

        }
    }



   

}
