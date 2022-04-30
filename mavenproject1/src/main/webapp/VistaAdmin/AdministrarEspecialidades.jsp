<%-- 
    Document   : AdministrarEspecialidades
    Created on : 30 abr. 2022, 9:00:22
    Author     : norma
--%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%
List<Especialidad> especialidades = (List<Especialidad>) session.getAttribute("especialidades");

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
                                <a href="/mavenproject1/admin-dash-board/administrar/medicos/show" class="nav-link text-white "  >
                                    Admnistrar Medicos
                                </a>
                            </li>
                            <li>
                                <a href="/mavenproject1/admin-dash-board/administrar/especialidades/show" class="nav-link active  bg-white " aria-current="page" style="color: black">

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
                         <div class="row">
                            <div class="col">
                            </div>
                            <div class="col">
                                <h5>
                                    Administrar Especialidades
                                </h5>
                            </div>
                            <div class="col">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col" >
                                <h6 class="text-center">
                                    Especialidades actuales
                                </h6>
                                
                                <%for (Especialidad e : especialidades) {%>
                                <div class="row my-2 mx-1" style=" border: 3px solid #20304c ">
                                    <p>
                                        <%=e.getNombre()%>: <%=e.getDescripcion()%>   ID(<%=e.getCodigo()%>)
                                    </p>
                                    <br>
                                </div>
                                <%}%>
                            </div>
                            <div class="col" >
                                <h6 class="text-center">
                                    Agregar una Nueva Especialidad
                                </h6>
                                
                                <form method="POST" name="PanelDeControl" action="/mavenproject1/admin-dash-board/administrar/especialidades/add" >
                                    
                                    
                                    
                                    <div class="row text-center align-items-center">
                                        <div class="col"></div>

                                        <div class="col-8 align-items-center text-center" >
                                            <label class="form-label" for="typeUser">Nombre</label>
                                            <input type="text" id="nombreUsuario" name="nombreEspecialidad" class="form-control form-control-md" required />
                                        </div>
                                        <div class="col"></div>

                                    </div>
                                    
                                    
                                    
                                    <div class="row text-center align-items-center">
                                        <div class="col"></div>

                                        <div class="col-8 align-items-center text-center" >
                                            <label class="form-label" for="typeUser">ID</label>
                                            <input type="number" id="nombreUsuario" name="idEspecialidad" class="form-control form-control-md" required />
                                        </div>
                                        <div class="col"></div>

                                    </div>
                                    
                                    
                                    
                                    <div class="row text-center align-items-center">
                                        <div class="col"></div>

                                        <div class="col-8 align-items-center text-center" >
                                            <label class="form-label" for="typeUser">Descripcion</label>
                                            <textarea  id="Descipcion" name="descripcion" class="form-control form-control-md" required></textarea>
                                        </div>
                                        <div class="col"></div>

                                    </div>
                                    
                                    
                                    
                                    <div class="row text-center align-items-center">
                                        <div class="col"></div>
                                        
                                        <div class="col-4 align-items-center text-center" >
                                            
                                            
                                            <div id="boton_submit" class="boton-submit">
                                                <button class="btn btn-outline-secondary btn-lg px-2" type="submit">Continuar</button>
                                            </div>
                                        </div>
                                        <div class="col"></div>
                                        
                                    </div>
                                    
                                </form>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </div>




    </body>
</html>
