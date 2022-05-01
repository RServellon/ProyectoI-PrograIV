<%-- 
    Document   : CouncluirCita
    Created on : 1 may. 2022, 11:36:28
    Author     : norma
--%>

<%@page import="Modelo.Cita"%>
<%

String citaConcluida = request.getParameter("citaConcluida");
Cita citaObj  = (Cita) session.getAttribute("citaObj");
Usuario pacienteObj  = (Usuario) session.getAttribute("pacienteObj");

System.out.println(citaObj);


%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Concluir Cita</title>
    </head>
    <body>
        <%@ include file  ="/Components/Header.jsp" %>
        
        <div class="container">
            
            <form  method="POST" name="ControladorMedico" action="/mavenproject1/medico/gestionar/citas/concluir/update"  >
                <div class="row text-center">

                    <div class="row my-5">


                        <div class="col-2 "></div>
                        <div class="col">
                            <h5>Ingrese las anotaciones para <%= pacienteObj.getNombre() %></h5>
                            <h6>Fecha de la Cita: <%= citaObj.getFechaString() %></h6>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">


                        <div class="col-2"></div>
                        <div class="col">
                            <div id="ingresoUser" class="form-outline form-white mb-4">
                                <textarea id="nombreUsuario" name="anotaciones" class="form-control form-control-lg" style="min-height: 300px;" required ></textarea>
                            </div>
                        </div>
                        <div class="col-2"></div>
                    </div>
                    <div class="row">


                        <div class="col-2"></div>
                        <div class="col">
                            <div id="boton_submit" class="boton-submit">
                                <button class="btn btn-outline-secondary btn-lg px-5" type="submit">Aceptar</button>
                            </div>
                        </div>
                        <div class="col-2"></div>
                    </div>
                </div>
            </form>
            
        </div>
    </body>
</html>
