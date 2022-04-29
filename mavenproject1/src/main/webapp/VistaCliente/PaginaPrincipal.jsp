<%-- 
    Document   : PaginaPrincipal
    Created on : 17 abr. 2022, 1:59:24
    Author     : norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@ include file="../Components/Head.jsp" %>
        <link href="../CSS/PaginaPrincipalClientes.css" rel="stylesheet">
    </head>
    <body>
        <%@ include file  ="/Components/Header.jsp" %>
        
         <div class="container-lg">
    <!--        fila de busqueda-->
     <%@ include file  ="/Components/BarraBusqueda.jsp" %>
<!--    Fila de informacion-->
     <div class="row row-padding justify-content-evenly">
         
         <div class="col-sm col-padding margin-space justify-content-evenly">
                 <div class="input-group-prepend">
                   <span class="input-group-text size-span" id="basic-addon1">
                       <i class="fa-solid fa-magnifying-glass icons-1"></i>
                   </span>
                      <br> <p class="fs-3">Busca doctores segun la <br>especialidad que necesites y ciudad</p>
                </div>
         </div>
         <div class="col-sm col-padding margin-space justify-content-evenly">
                 <div class="input-group-prepend">
                   <span class="input-group-text size-span" id="basic-addon1">
                       <i class="fa-solid fa-calendar-days icons-1"></i>
                   </span>
                      <p class="fs-3">Agenda una cita con ese doctor  <br>seleccionando el horario que mejor <br>se te ajuste y eso es todo!</p>
                </div>
         </div>
         
     </div>


    </div>
    </body>
</html>
