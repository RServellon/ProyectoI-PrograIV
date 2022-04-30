<%-- 
    Document   : Header
    Created on : 19 abr. 2022, 21:12:39
    Author     : norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuario"%>
<% 
    Usuario user = (Usuario) session.getAttribute("user"); 
%>
<!DOCTYPE html>
<html>
    <head>
              <%@ include file="/Components/Head.jsp" %>
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
        <% if (user != null && user.getTipo().equals("admin")){%>
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
                        <a class="nav-link active" style="color:white" href="/mavenproject1/admin-dash-board/administrar/medicos/show">
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
        <% if (user != null && user.getTipo().equals("medico") ) {%>
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
                            <i class="fa-solid fa-user-doctor" style="font-size: 20px;"></i>
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
        <% if (user != null && user.getTipo().equals("paciente")) {%>
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
                        <a class="nav-link active" style="color:white" href="/mavenproject1/VistaCliente/showCitasMedicas.jsp">
                            <i class="fa-solid fa-calendar-days" style="font-size: 20px;"></i> 
                            <label class="form-label" >Citas</label>

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
    </body>
</html>
