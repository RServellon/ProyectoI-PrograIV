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
import java.util.List;
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
@WebServlet(name = "ControladorMedico", urlPatterns = {"/ControladorMedico", "/mavenproject1/configurar-medico-primera-vez", "/mavenproject1/paciente/gestion/perfil", "/configurar/medico/actualizar/datos", "/configurar/medico/image", "/medico/gestion/perfil", "/medico/actualizar/informacion", "/medico/gestionar/horario","/medico/gestionar/horario/procesar", "/administrar/citas"})
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
            Usuario usuario = (Usuario) session.getAttribute("user");
            String especialidad = (String) request.getParameter("especialidad");
            String codeCiudad = (String) request.getParameter("ciudad");
            String costoConsulta = (String)request.getParameter("costoConsulta");
            String clinica = (String) request.getParameter("clinica");
          
            switch (request.getServletPath()) {
                case "/mavenproject1/configurar-medico-primera-vez":
                    request.getRequestDispatcher("/login/show").forward(request, response);
                    break;
                case "/administrar/citas":
                    
                    
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
                        //MedicoHandler medicoHandler = new MedicoHandler();
                       String horaInicio = (String) request.getParameter("horaInicio");
                       String horaFinal = (String) request.getParameter("horaFinal");
                       String frecuencia = (String) request.getParameter("frecuencia");
                       String calendario = (String) request.getParameter("calendario");
                       String strFrecuencia = frecuencia.equals("00") ? "01:00:00" : "00:30:00";
                       
                       String strFechaInicio = calendario+"T"+horaInicio+":00:00";
                       String strFechaFinal= calendario + "T" + horaFinal + ":00:00";
                       
                        System.out.println(strFechaInicio);
                        System.out.println(strFechaFinal);
                        System.out.println(user);
                        
                        
                       
                        if (Integer.parseInt(horaFinal) - Integer.parseInt(horaInicio) > 0) {
                            
                            Horario h = medicoHandler.retornaHorario(user.getId(), strFechaInicio);
                            System.out.println(h);
                            if (h.getId_medico() != null ) {
                                medicoHandler.borrarHorario(user.getId(), strFechaInicio);
                                medicoHandler.registrarHorario(user.getId(), strFechaInicio, strFechaFinal, strFrecuencia);
                            }else{
                                
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
                        //Usuario usuario = (Usuario) session.getAttribute("user");
                        String codeEspecialidad = (String) request.getParameter("especialidad");
                       // String codeCiudad = (String) request.getParameter("ciudad");
                        //String costoConsulta = (String) request.getParameter("costoConsulta");
                        //String clinica = (String) request.getParameter("clinica");
                        String foto = (String) request.getParameter("foto");
                        String descipcion = (String) request.getParameter("descipcion");
                        
                        System.out.println(usuario);
                        System.out.println(codeEspecialidad);
                        System.out.println(codeCiudad);
                        System.out.println(costoConsulta);
                        System.out.println(clinica);
                        
                        ///TODO: -> poner que actualize la foto y descripción
                        System.out.println(foto);
                        System.out.println(descipcion);
                        
                        //MedicoHandler medicoHandler = new MedicoHandler();
                        System.out.println(medicoHandler.modificarDatos(usuario.getId(), codeEspecialidad, costoConsulta, codeCiudad, clinica));
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
                    
                    request.getRequestDispatcher("/VistaMedico/GestionarPerfil.jsp").forward(request, response);
                    }
                    break;
                case "/mavenproject1/medico/gestion/perfil":
                    
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
                    
                    Medico m = general.retornaMedicoPorId(usuario.getId());
                    //System.out.println(m);
                    
                    // Prueba cargar imagen
                    
                    System.out.println(especialidad);
                    System.out.println(codeCiudad);
                    System.out.println(costoConsulta);
                    System.out.println(clinica);
                    //System.out.println(foto);
                    System.out.println(usuario.getId());
                    
                     final Part imagen;
                    imagen = request.getPart("imagen");
                    imagen.write(m.getId());
                        
                    
                    request.getRequestDispatcher("/login/show").forward(request, response);
                    
                    
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

    

    

   

}
