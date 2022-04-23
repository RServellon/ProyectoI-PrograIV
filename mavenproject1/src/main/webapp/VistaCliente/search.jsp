
<%@page import="Modelo.ClaseServicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Medico"%>

<%
         //llamamos a la clase de servicio que tiene el metodo para retornar a esos medicos segun especialidad y provincia
         ClaseServicio service = ClaseServicio.instance();
         String especialidad = (String)request.getAttribute("Especialidad");
         String provincia = (String)request.getAttribute("Provincia");
         //obtenemos la lista con los medicos que se hayan encontrado
         ArrayList<Medico> medicos = service.retornarMedico(especialidad, provincia);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda de cita</title>
        <link href="../CSS/PaginaPrincipalClientes.css" rel="stylesheet">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <%@ include file  ="../Components/Header.jsp" %>
        
          <div class="container-lg">
<!--        fila de busqueda(HACERLO EN INCLUDE-->
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

<!--    Se realiza un if si no se encuentra informacion para ningun medico-->
       <% if(medicos.size()==0){ %>
             <div class="row row-padding justify-content-evenly">
                       <div class="alert alert-danger " role="alert">
                            <p class="fs-3">Lo sentimos no hemos encontrado ningun doctor en nuestros registros con
                              <br> Especialidad: <%=especialidad %>
                              <br> Pronvincia: <%= provincia %>
                            </p>
                        </div> 
                   </div>
                     
       <% } %>
<!--Aqui se realiza for con la informacion de los medicos que existen segun la busqueda realizada-->
        <% for(Medico c:medicos){%>
        <div class="row row-padding row-margin border border-3 shadow p-3 mb-5 bg-body rounded-3">
<!--            informacion de cada medico -->
          <h3><%= c.getNombre()%></h3>
          <h3><%= c.getCiudad()%></h3>
           <h3><%= c.getEspecialidad()%></h3>
        </div>
        <% } %>
         </div>
        <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
    </body>
</html>
