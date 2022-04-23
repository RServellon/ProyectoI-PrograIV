
<%@page import="Modelo.Especialidad"%>
<%@page import="Modelo.DAO.MedicoHandler"%>
<%@page import="Modelo.ClaseServicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Medico"%>

<%
    //llamamos a la clase handler del medico para utilizar sus metodos en base de datos
         MedicoHandler handlerMed = new MedicoHandler();
         String especialidad = (String)request.getAttribute("Especialidad");
         String provincia = (String)request.getAttribute("Provincia");
         //obtenemos la lista con los medicos que se hayan encontrado
         List<Medico> medicos = handlerMed.listarMedicoPorProvinciaYEspecialidad(provincia, especialidad);
         Especialidad espec;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <head>
        <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Busqueda de cita</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="../CSS/PaginaPrincipalClientes.css" rel="stylesheet">
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
     <% if(medicos.isEmpty()){ %>
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
<!--             Columna de informacion del medico-->
            <div class="col-sm">
                <div class="d-flex">
                      <div class="block-size">
                      <img src="../assets/images/retrato-perfil-doc.jpg" class="imagen-perfil">
                      <% espec=handlerMed.retornaEspecialidadPorCodigo(c.getEspecialidad()); %>
                      <p class="p-especialidad" title=<%=espec.getDescripcion()%>> <%= espec.getNombre()%></p>
                      </div>
                      <div>
                       <p class="fs-4 fw-bold p-info-doc"><%=c.getNombre()%></p>
                       <p class="fs-5 p-info-doc">Costo:<%=" "+Math.round(c.getCostoConsulta())%></p>
                       <p class="fs-5 p-info-doc">Ciudad:<%=" "+handlerMed.retornaCiudadPorCodigo(c.getCiudad()).getNombre()%></p>
                       <hr class="hr-margin">
                       <p class="fs-5 p-info-doc"><%=" "+c.getClinica()%></p>
                      </div>
                </div>
             </div>
<!--            Columnas de los horarios-->
             <div class="col-sm">
    
             </div>
                      
        </div>
        </div>
        <% } %>
         </div>
    </body>
</html>
