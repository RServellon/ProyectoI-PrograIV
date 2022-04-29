
<%@page import="Modelo.Horario"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="Modelo.DAO.MedicoHandler"%>
<%@page import="Modelo.ClaseServicio"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Medico"%>
<%@page import="Controlador.Cliente.ModelBusquedaCita"%>

<%
         //clase de servicio para metodos de ayuda
         ClaseServicio ser = ClaseServicio.instance();
         //llamamos a la clase handler del medico para utilizar sus metodos en base de datos
         MedicoHandler handlerMed = new MedicoHandler();
         ModelBusquedaCita model =(ModelBusquedaCita) request.getAttribute("model");;
         //obtenemos la lista con los medicos que se hayan encontrado
         List<Medico> medicos = handlerMed.listarMedicoPorProvinciaYEspecialidad(model.getProvincia(), model.getEspecialidad());
         List<Horario> listHorarios=null;
         Especialidad espec = null;
         //Lista de lista de horarios para la vista
         List<List<Horario>> liliHorarios = null;
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
           <head>
          <%@ include file="../Components/Head.jsp" %>
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
     <% if(medicos.isEmpty()){%>
             <div class="row row-padding justify-content-evenly">
                       <div class="alert alert-danger " role="alert">
                            <p class="fs-3">Lo sentimos no hemos encontrado ningun doctor en nuestros registros con
                              <br> Especialidad: <%=model.getEspecialidad() %>
                              <br> Pronvincia: <%= model.getProvincia() %>
                            </p>
                        </div> 
                   </div> 
       <% } %>
<!--Aqui se realiza for con la informacion de los medicos que existen segun la busqueda realizada-->
        <% for(Medico c:medicos){%>
<!--        style="overflow-x: auto; width: 530px; white-space: nowrap;"-->
        <div class="row row-padding row-margin border border-3 shadow p-3 mb-5 bg-body rounded-3 d-flex" >
<!--            informacion de cada medico -->
<!--             Columna de informacion del medico-->
            <div class="container-info d-flex" style="max-width: 360px;">
                <div class="d-flex">
                      <div class="block-size">
                      <img src="../assets/images/retrato-perfil-doc.jpg" class="imagen-perfil">
                      <% espec=handlerMed.retornaEspecialidadPorCodigo(c.getEspecialidad()); %>
                      <p class="p-especialidad fs-4" title=<%=espec.getDescripcion()%>> <%= espec.getNombre()%></p>
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
            <div id="scroll" class="container-horarios d-flex": style="overflow-x: auto; overflow-y: auto; white-space: nowrap; max-width: 900px;" >
                <% listHorarios=handlerMed.listarHorarios(c.getId()); 
                 liliHorarios = ser.retornarListaListaHorarios(listHorarios);
                if(!liliHorarios.isEmpty() || liliHorarios != null){
                for(int i = 0 ; i<liliHorarios.size(); i++){ 
               %> 
                <div class="col-sm pad-horario" style="margin-right:15px;" >
                    <h5><%= liliHorarios.get(i).get(0).getFechaHoraFinal().getFormatoddMMyyyy()%></h5>
                 <div style="width:100%; height:130px; overflow-y: scroll;">
                   <%  for(Horario hor: liliHorarios.get(i)){ %>
                   <a href="ConfirmarCita.jsp"><p><%= hor.HoraInicio_Final() %></p></a>
                  <%}%>
                 </div>
                </div>
             <%}}%>
            </div> <!-- container horarios-->
        </div>   <!-- row -->
        <% } %>
         </div><!-- container-->
    </body>
</html>
