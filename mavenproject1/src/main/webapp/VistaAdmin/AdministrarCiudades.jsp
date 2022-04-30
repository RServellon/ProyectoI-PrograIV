<%-- 
    Document   : AdministrarCiudades
    Created on : 30 abr. 2022, 9:08:52
    Author     : norma
--%>

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
                                    <div>
                                        <h5 class="fs-4 text-center">Digite la ciudad a listar</h5>
                                    </div>
                                    <div class="d-flex" style="margin-top:1em; ">
                                    <div class="input-group-prepend d-flex">
                                        <span class="input-group-text" id="basic-addon1">
                                            <i class="fa-solid fa-city" style="font-size: 30px"></i>
                                        </span>
                                    </div>
                                    <input name="Ciudad"  type="text" class="form-control fs-4" placeholder="Ciudad" aria-label="ciudad" aria-describedby="basic-addon1">  
                                    <div> 
                                        <button type="submit" class="btn btn-primary" style="background-color:#20304c; width: 200px; height: 100%;">Listar ciudad</button>
                                    </div>
                                    </div><!-- Div de digitar ciudad -->
                                    
                                   
                                </form>
                            </div><!-- div del form -->
                        </div>
                    </div>
                </div>
            </div>

        </div>




    </body>
</html>

