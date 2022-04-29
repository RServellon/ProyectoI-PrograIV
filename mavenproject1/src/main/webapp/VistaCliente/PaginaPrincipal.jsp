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
       <div class="row row-padding" >
          <form class="form-inline d-flex" method="POST" name="BusquedaCita" action="search">
                
<!--                campo de busqueda especialidad-->
            <div class="col-sm d-flex">
                <div class="input-group-prepend">
                   <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-briefcase-medical icons"></i></span>
                </div>
                <input name="Especialidad" type="text" class="form-control fs-4" placeholder="Especialidad" aria-label="Especialidad" aria-describedby="basic-addon1">
            </div>

<!--                campo de busqueda provincia-->
             <div class="col-sm d-flex col-padding margin-space">
                <div class="input-group-prepend margin-space">
                   <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-city icons"></i></span>
                </div>
               <input name= "Provincia" type="text" class="form-control fs-4" placeholder="Provincia" aria-label="Provincia" aria-describedby="basic-addon1">
             </div>

 <!--                cboton de submit-->
              <div class="col-sm d-flex justify-content-evenly">
                  <div class="">
                      <button class="btn btn-primary my-2 my-sm-0 boton fs-4" type="submit">Buscar</button>
                  </div>
              </div>
                
          </form>
       </div>

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
