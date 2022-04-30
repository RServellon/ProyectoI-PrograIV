<%-- 
    Document   : showCitasMedicas
    Created on : Apr 30, 2022, 2:37:59 AM
    Author     : Dell
--%>
<%
    System.out.println("ENTREEE 2");
     //Usuario user = (Usuario) session.getAttribute("user"); 
//    System.out.println(user.toString());
//     if(user == null){
//     System.out.println("no hay usuario registrado");
//     }else{
//      System.out.println(user.toString());
//     }
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
