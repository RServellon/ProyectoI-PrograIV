
<%@page import="Modelo.Ciudad"%>
<%@page import="java.util.List"%>
<% 
   String registrado =(String) request.getAttribute("registrado");
   if(registrado != null){
     if(!registrado.equals("")){
      registrado = "1";
    }
   }
   
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


        <div>

            <div class="row justify-content-center  vh-100">
                <div class="col-3  h-100">
                    <div class=" d-flex flex-column flex-shrink-0 p-3 text-white  h-100" style="background: #20304c">
                        <span class="fs-4">Dashboard</span>
                        <hr>
                        <ul class="nav nav-pills flex-column mb-auto">
                            <li class="nav-item">
                                <a href="/mavenproject1/admin-dash-board/administrar/medicos/show" class="nav-link text-white " >
                                    Admnistrar Medicos
                                </a>
                            </li>
                            <li>
                                <a href="/mavenproject1/admin-dash-board/administrar/especialidades/show" class="nav-link text-white " >

                                    Admnistrar Especialidades
                                </a>
                            </li>
                            <li>
                                <a href="/mavenproject1/admin-dash-board/administrar/ciudades/show" class="nav-link   active  bg-white " aria-current="page" style="color: black">
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
                            <div>
                                <h5 class="text-center"> Administrar ciudades </h5>
                            </div>
                            
                            <div style=" width: 700px; margin-left: 5em; margin-top: 5em;">
                                <form method="POST" name="PanelDeControl" action="/mavenproject1/admin-dash-board/administrar/ciudades/add" >
                                    <div class="d-flex" style="margin-top:1em; ">
                                        <div class="input-group-prepend d-flex">
                                            <span class="input-group-text" id="basic-addon1">
                                                <i class="fa-solid fa-city" style="font-size: 30px"></i>
                                            </span>
                                        </div>
                                        <input name="Provincia"  type="text" class="form-control fs-4" placeholder="Ingrese la provincia" aria-label="ciudad" aria-describedby="basic-addon1" required>  
                                    </div><!-- Div de digitar provincia -->
                                    
                                    <div class="d-flex" style="margin-top:1em; ">
                                    <div class="input-group-prepend d-flex">
                                        <span class="input-group-text" id="basic-addon1">
                                             <i class="fa-solid fa-tree-city" style="font-size: 30px"></i>
                                        </span>
                                    </div>
                                        <input name="Ciudad"  type="text" class="form-control fs-4" placeholder="Ingrese la ciudad" aria-label="ciudad" aria-describedby="basic-addon1" required>  
                                    </div><!-- Div de digitar ciudad -->
                                    <div style="margin-top:1em; margin-left: 14em;"> 
                                        <button type="submit" class="btn btn-primary" style="background-color:#20304c; width: 200px; height: 50px;">Registrar ciudad</button>
                                    </div>
                                </form>
                                <% if(registrado == "1"){ %>
                                <div class="alert alert-success" role="alert" style="margin-top: 1em;">
                                    <p class="text-center">Ciudad registrada exitosamente</p>
                                </div>
                                <% } %>
                            </div><!-- div del form -->
                        </div>
                    </div>
                </div>
            </div>

        </div>




    </body>
</html>

