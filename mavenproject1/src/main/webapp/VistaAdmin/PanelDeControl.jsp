<%-- 
    Document   : PanelDeControl
    Created on : 21 abr. 2022, 23:23:09
    Author     : norma
--%>
<%@page import="Modelo.DAO.AdminHandler"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Medico"%>
<%
    
List<Medico> aprobados = (List<Medico>) session.getAttribute("aprobados");
List<Medico> pendientes =  (List<Medico>) session.getAttribute("pendientes");
List<Medico> restringidos = (List<Medico>) session.getAttribute("restringidos");
AdminHandler adminHandler = (AdminHandler) session.getAttribute("adminHandler");


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Control</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="../CSS/PanelDeControl.css" rel="stylesheet">
    </head>
    <body>
        <%@ include file  ="/Components/Header.jsp" %>
        
        
        <div  >
           
            <div class="row justify-content-center  vh-100">
                <div class="col-3  h-100">
                    <div class=" d-flex flex-column flex-shrink-0 p-3 text-white  h-100" style="background: #20304c">
                        <span class="fs-4">Dashboard</span>
                        <hr>
                        <ul class="nav nav-pills flex-column mb-auto">
                            <li class="nav-item">
                                <a href="/mavenproject1/admin-dash-board/administrar/medicos/show" class="nav-link active bg-white " aria-current="page" style="color: black">
                                    Admnistrar Medicos
                                </a>
                            </li>
                            <li>
                                <a href="/mavenproject1/admin-dash-board/administrar/especialidades/show" class="nav-link text-white">
                                    
                                    Admnistrar Especialidades
                                </a>
                            </li>
                            <li>
                                <a href="/mavenproject1/admin-dash-board/administrar/ciudades/show" class="nav-link text-white">
                                    
                                    Administrar Ciudades
                                </a>
                            </li>
                          
                        
                        </ul>
                        <hr>
                    </div>
                </div>
                <div class="col-9  h-100 my-5" >
                    <!--border border-3-->
                    <div class="container" id="main" style="border-radius: 9px; height: 80%; overflow: scroll;"  >
                        <div class="row text-center">
                            <div class="col">
                            </div>
                            <div class="col">
                                <h5>
                                    Administrar Medicos
                                </h5>
                            </div>
                            <div class="col">
                            </div>
                        </div>
                        <div class="row text-center">
                            <div class="col" >
                                <h6>
                                    Medicos Aprobados
                                </h6>
                                <%for(Medico m: aprobados){%>
                                <div class="col my-1" style="border: 3px solid gray">
                                    <div class="row my-2">

                                        <div class="col">
                                            <h6><%=m.getNombre()%></h6>
                                        </div>
                                            <%if (m.getCiudad() != null) {%>
                                            <div class="col">
                                                <h6><%= adminHandler.retornaEspecialidadPorCodigo(m.getEspecialidad()).getNombre()%></h6>
                                            </div>
                                            <div class="col">
                                                <h6><%= adminHandler.retornaCiudadPorCodigo(m.getCiudad()).getNombre()%></h6>
                                            </div>
                                            <div class="col">
                                                <h6><%=m.getClinica()%></h6>
                                            </div>
                                            <%}%>
                                    </div>
                                    <div class="row">
                                        <div class="col" >

                                        </div>
                                        <div class="col mb-2" style="background: red; border-radius: 5px; max-width: 100px; ">
                                            <a style="color: white; " href="/mavenproject1/admin-dash-board/administrar/medicos/restringir?idASuspender=<%=m.getId()%>" >Suspender</a>
                                        </div>
                                        <div class="col" >

                                        </div>
                                    </div>
                                </div>
                                <%}%>
                                
                            </div>
                            <div class="col" >
                                <h6>
                                    Medicos Retenidos
                                </h6>
                                
                                <%for (Medico m : restringidos) {%>
                                <div class="col my-1" style="border: 3px solid gray">
                                    <div class="row my-2">

                                        <div class="col">
                                            <h6><%=m.getNombre()%></h6>
                                        </div>
                                            <%if (m.getCiudad() != null) {%>
                                            <div class="col">
                                                <h6><%= adminHandler.retornaEspecialidadPorCodigo(m.getEspecialidad()).getNombre()%></h6>
                                            </div>
                                            <div class="col">
                                                <h6><%= adminHandler.retornaCiudadPorCodigo(m.getCiudad()).getNombre()%></h6>
                                            </div>
                                            <div class="col">
                                                <h6><%=m.getClinica()%></h6>
                                            </div>
                                            <%}%>
                                    </div>
                                    <div class="row">
                                        <div class="col" >

                                        </div>
                                        <div class="col mb-2" style="background: green; border-radius: 5px; max-width: 100px; ">
                                            <a style="color: white; " href="/mavenproject1/admin-dash-board/administrar/medicos/reactivar?idAReactivar=<%=m.getId()%>" >Reactivar</a>
                                        </div>
                                        <div class="col" >

                                        </div>
                                    </div>
                                </div>
                                <%}%>
                            </div>
                            <div class="col" >
                                <h6>
                                    Nuevas Solicitudes
                                </h6>
                                
                                <%for (Medico m : pendientes) {%>
                                <div class="col my-1" style="border: 3px solid gray">
                                    <div class="row my-2">

                                        <div class="col">
                                            <h6><%=m.getNombre()%></h6>
                                        </div>
                                        <%if(m.getCiudad() != null ){%>
                                            <div class="col">
                                                <h6><%= adminHandler.retornaEspecialidadPorCodigo(m.getEspecialidad()).getNombre()%></h6>
                                            </div>
                                            <div class="col">
                                                <h6><%= adminHandler.retornaCiudadPorCodigo(m.getCiudad()).getNombre()%></h6>
                                            </div>
                                            <div class="col">
                                                <h6><%=m.getClinica()%></h6>
                                            </div>
                                        <%}%>
                                    </div>
                                    <div class="row">
                                        <div class="col" >

                                        </div>
                                        <div class="col mb-2" style="background: green; border-radius: 5px; max-width: 100px; ">
                                            <a style="color: white; " href="/mavenproject1/admin-dash-board/administrar/medicos/aceptar?idAAceptar=<%=m.getId()%>" >Aceptar</a>
                                        </div>
                                        <div class="col mb-2" style="background: red; border-radius: 5px; max-width: 100px; ">
                                            <a style="color: white; " href="/mavenproject1/admin-dash-board/administrar/medicos/rechazar?idARechazar=<%=m.getId()%>" >Rechazar</a>
                                        </div>
                                        <div class="col" >

                                        </div>
                                    </div>
                                </div>
                                <%}%>
                                

                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        </div>
        
        

        
    </body>
</html>
