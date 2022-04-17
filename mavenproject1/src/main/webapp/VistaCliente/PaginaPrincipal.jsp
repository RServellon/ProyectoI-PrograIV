<%-- 
    Document   : PaginaPrincipal
    Created on : 17 abr. 2022, 1:59:24
    Author     : norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicio</title>
        <link href="../CSS/PaginaPrincipalClientes.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <nav class="navbar navbar-light " style="background-color: #8AB5D3;">
            <a class="navbar-brand mx-4" href="#">
                Inicio
                <img src="../assets/Icon pages/home.png">
            </a>

            <div class="mx-10" id="navbarNav">
                <ul class="nav justify-content-end" >
                    <li class="nav-item">
                        <a class="nav-link active" style="color:black" href="#">
                            <img src="../assets/Icon pages/info.png">
                            About
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color:black" href="#">
                            <img src="../assets/Icon pages/search.png">
                            Buscar
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color:black" href="#">
                            <img src="../assets/Icon pages/log-in.png">
                            Login
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <div class="container ">
            <div class="row mx-2">
                
                <div class="col-8  mx-5 listado-citas-container" style=" margin-top: 30px;">
                    <div class="listado-citas">
                        Listado Medicos
                    </div>
                    
                </div>
                <div class="col-3 search-filter-container" style=" margin-top: 30px;">
                    <div class="search-filter">
                        filtros
                    </div>
                </div>
            </div>
            
        </div>
        
        
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
    </body>
</html>
