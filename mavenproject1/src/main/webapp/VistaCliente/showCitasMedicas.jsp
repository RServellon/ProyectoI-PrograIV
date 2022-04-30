<%-- 
    Document   : showCitasMedicas
    Created on : Apr 30, 2022, 2:37:59 AM
    Author     : Dell
--%>
<%@page import="Modelo.Medico"%>
<%@page import="Modelo.DAO.MedicoHandler"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="Modelo.DAO.PacienteHandler"%>
<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
<%@page import="Controlador.Cliente.ModelConfirmarCita"%>
<%
     Especialidad espec = null;
     Medico med = null;
     MedicoHandler medHandler = new MedicoHandler();
    //se saca al uusuario de la sesion
     Usuario usuario = (Usuario) session.getAttribute("user");
     //Se llama al handler de Pacientes
     PacienteHandler pacHandler = new PacienteHandler();
     //Se extrae la lista de citas de ese usuario
     List<Cita> listCitas = null;
      if (usuario != null) {
          listCitas = pacHandler.listarCitasPorIdPaciente(usuario.getId());
      }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Components/Head.jsp" %>
         <link href="../CSS/PaginaPrincipalClientes.css" rel="stylesheet">
    </head>
    <body>
        <%@ include file  ="../Components/Header.jsp" %>
        <div class="container-lg">
                <p class="text-center fs-2" style="margin-top: 1em;">Historial de citas medicas</p>
            <!-- If que se muestra si no hay citas registradas-->
            <% if(listCitas.isEmpty()) {%>
            <div class="row row-padding justify-content-evenly">
                <div class="alert alert-danger " role="alert">
                    <p class="fs-3">No tiene citas agendadas de momento
                    </p>
                </div> 
            </div> 
            <% }else{ %>
            <!--Aqui se realiza for con la informacion de los medicos que existen segun la busqueda realizada-->
            <% for (Cita c : listCitas) {%>
            <%
                //extraigo el medico y especialidad de esa cita
                med = medHandler.retornaMedicoPorId(c.getId_medico());
                Especialidad esp = medHandler.retornaEspecialidadPorCodigo(med.getEspecialidad());
            %>
            <!--        style="overflow-x: auto; width: 530px; white-space: nowrap;"-->
            <div class="row row-padding row-margin border border-3 shadow p-3 mb-5 bg-body rounded-3 d-flex" style="margin-top: 2em;" >
                <!--            informacion de cada medico -->
                <!--             Columna de informacion del medico-->
                <div class="container-info d-flex" style="max-width: 380px;">
                    <div class="d-flex">
                        <div class="block-size">
                            <img src="../assets/images/retrato-perfil-doc.jpg" class="imagen-perfil" >
                            <p class="p-especialidad fs-4" title="<%=esp.getDescripcion()%>"> <%= esp.getNombre()%> </p>
                        </div>
                        <div>
                            <p class="fs-4 fw-bold p-info-doc"><%=med.getNombre()%></p>
                            <p class="fs-5 p-info-doc">Costo:<%=" " + Math.round(med.getCostoConsulta())%></p>
                            <p class="fs-5 p-info-doc">Ciudad:<%=" " + medHandler.retornaCiudadPorCodigo(med.getCiudad()).getNombre()%></p>
                            <hr class="hr-margin">
                            <p class="fs-5 p-info-doc"><%=" " + med.getClinica()%></p>
                        </div>
                    </div>
                </div>
<!--                        Columna de informacion de hora de cita-->
                        <div  class="container-info" style="max-width: 330px; background-color: #20304c; color: white;">
                            <div style="margin-top: 1em;">
                            <p class="text-center fs-4 fw-bold">Informacion de cita</p>
                            </div>
                            <div>
                            <p class="text-center fs-5">Fecha: <%= c.getFecha().getFormatoddMMyyyy() %> </p>
                            </div>
                            <div>
                            <p class="text-center fs-5">Hora: <%= c.getFecha().getHoraHHMM() %> </p>
                            </div>
                            <div>
                            <p class="text-center fs-5">Estado <%= c.getEstado() %> </p>
                            </div>
                        </div>
<!--                            Columna de anotaciones y estado-->
                       <div  class="container-info" style="max-width: 300px;">
                           <div>
                               <p class="text-center fs-4 fw-bold">Anotaciones</p>
                           </div>
                           <div style="overflow-x:no-display ; overflow-y: auto; max-width: 300px; height: 150px">
                                 <p class="text-center fs-5"><%= c.getAnotaciones() %></p>
                           </div> 
                       </div>
            </div>   <!-- row -->
            <% } }%>
        </div><!-- container-->
    </body>
</html>
