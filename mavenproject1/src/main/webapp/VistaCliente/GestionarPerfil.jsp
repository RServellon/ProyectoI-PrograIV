<%-- 
    Document   : GestionarPerfil
    Created on : 25 abr. 2022, 11:42:23
    Author     : norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%@ include file  ="/Components/Header.jsp" %>
        <h1>Gestiionar perfil de Paciente</h1>
        <h1>
            <%=user.getNombre()%>
        </h1>
        <h1>
            <%=user.getId()%>
        </h1>
    </body>
</html>
