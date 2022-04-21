
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Medico"%>

<%
    //datos de prueba
    Medico med1 = new Medico("Odontologia", "Heredia", 5000, null, "Clinica", "estado", "foto de perfil", "resena", "123", "Eren Jaeger", "pass1", "medico");
    Medico med2 = new Medico("Neurocirugia", "Alajuela", 5000, null, "Clinica", "estado", "foto de perfil", "resena", "id", "Sanji Vismoke", "pass2", "medico");
     Medico med3 = new Medico("Otorringsdasn", "Guanacaste", 5000, null, "Clinica", "estado", "foto de perfil", "resena", "id", "Nami Sandia", "pass2", "medico");
  //  Model model = (Model) request.getAttribute("model"); //extrae el modelo que es una clase que tiene al usuario y una lista de cuentas asociadas a ese usuario
    ArrayList<Medico> medicos = new ArrayList();
    medicos.add(med1);
    medicos.add(med2);
    medicos.add(med3);
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="../CSS/PaginaPrincipalClientes.css" rel="stylesheet">
        <title>buscar</title>
    </head>
    <body>
        <%@ include file  ="../Components/Header.jsp" %>
        
          <div class="container-lg">
<!--        fila de busqueda(HACERLO EN INCLUDE-->
             <div class="row row-padding" >
          <form class="form-inline d-flex" method="POST" name="pagina_busqueda" action="inicio/busquedaCita">
                
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
    </body>
</html>
