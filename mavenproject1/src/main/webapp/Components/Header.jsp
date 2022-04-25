<%-- 
    Document   : Header
    Created on : 19 abr. 2022, 21:12:39
    Author     : norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario"%>
<% Usuario user = (Usuario) session.getAttribute("user"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
              <link href="/mavenproject1/CSS/login.css" rel="stylesheet">
    </head>
    <body>
        
        <% if(user == null){%>
            <nav class="navbar navbar-light " style="background-color: #20304c;">
                <a class="navbar-brand mx-4" href="/mavenproject1/index.jsp" style="color: white">
                    <img src="/mavenproject1/assets/Icon pages/home.png">
                    <label class="form-label" >Inicio</label>
                </a>

                <div class="mx-10" id="navbarNav">
                    <ul class="nav justify-content-end" >
                        <li class="nav-item">
                            <a class="nav-link active" style="color:white" href="/mavenproject1/Components/aboutUs.jsp">
                                <img src="/mavenproject1/assets/Icon pages/info.png">

                                <label class="form-label" >About</label>

                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" style="color: white" href="/mavenproject1/VistaCliente/PaginaPrincipal.jsp">
                                <img src="/mavenproject1/assets/Icon pages/search.png">

                                <label class="form-label" >Buscar</label>
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" style="color: white" href="/mavenproject1/login/show">
                                <img src="/mavenproject1/assets/Icon pages/log-in.png">
                                <label class="form-label" >Login</label>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
        <% }%>
        <% if (user != null){%>
        <nav class="navbar navbar-light " style="background-color: #20304c;">
            <a class="navbar-brand mx-4" href="/mavenproject1/index.jsp" style="color: white">
                <img src="/mavenproject1/assets/Icon pages/home.png">
                <label class="form-label" >Inicio</label>
            </a>

            <div class="mx-10" id="navbarNav">
                <ul class="nav justify-content-end" >
                    <li class="nav-item">
                        <a class="nav-link active" style="color:white" href="/mavenproject1/Components/aboutUs.jsp">
                            <img src="/mavenproject1/assets/Icon pages/info.png">

                            <label class="form-label" >About</label>

                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link active" style="color:white" href="/mavenproject1/admin-dash-board">
                            <img src="/mavenproject1/assets/Icon pages/admin-dash.png">

                            <label class="form-label" >Admin Settings</label>

                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="/mavenproject1/VistaCliente/PaginaPrincipal.jsp">
                            <img src="/mavenproject1/assets/Icon pages/search.png">

                            <label class="form-label" >Buscar</label>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="/mavenproject1/manage/profile">
                            <img src="/mavenproject1/assets/Icon pages/profile.png">
                            <label class="form-label" ><%=user.getNombre()%></label>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="/mavenproject1/log-out">
                            <img src="/mavenproject1/assets/Icon pages/log-out.png">
                            <label class="form-label" >Log Out</label>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        <% }%>
        
         <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
    </body>
</html>
