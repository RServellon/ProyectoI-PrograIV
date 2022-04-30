<%-- 
    Document   : showCitasMedicas
    Created on : Apr 30, 2022, 2:37:59 AM
    Author     : Dell
--%>
<%@page import="Controlador.Cliente.ModelConfirmarCita"%>
<%
    ModelConfirmarCita model =(ModelConfirmarCita)request.getAttribute("model");
    System.out.println(model.getUser().toString());
    
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Components/Head.jsp" %>
    </head>
    <body>
        <%@ include file  ="../Components/Header.jsp" %>
        <h1>Esta pagina me muestra las citas del cliente</h1>
    </body>
</html>
