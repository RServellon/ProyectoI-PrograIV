<%@page import="Modelo.Medico"%>
<%@page import="Modelo.DAO.MedicoHandler"%>
<%@page import="Controlador.Cliente.ModelShowCita"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
 MedicoHandler medH = new MedicoHandler();
 //Extraemos datos de la sesion
 String idMedico =(String) session.getAttribute("idMedico");
 String horaCita=(String) session.getAttribute("horaCita");;
 String fechaCita=(String) session.getAttribute("fechaCita");
 System.out.println("med: "+ idMedico+" horaCita: "+horaCita+" fecha: "+fechaCita);
 //creamos al medico:
 Medico med = medH.retornaMedicoPorId(idMedico);
//modelo que tiene el medico, la hora(en stiring) y la fecha (en string)
// ModelShowCita model = (ModelShowCita) request.getAttribute("model"); 
%>
<!DOCTYPE html>
<html>
    <head>
         <%@ include file="../Components/Head.jsp" %>
    </head>
    <body>
         <%@ include file  ="../Components/Header.jsp" %>
         <div class="container-sm">
            <div class="row justify-content-center">
<!--                <div class="col"></div>-->
              <div class="col shadow p-3 mb-5 bg-body rounded" style="max-width: 300px; margin-top: 3em;">
                  <div class="" style="max-height:400px; margin-left: 3em; margin-right: auto;">
                        <img src="../assets/images/102.jpg" class="" style="border-radius: 50%; max-height: 220px;">
                  </div>
                  <hr>
                  <div class="d-flex" style="font-size: 20px;">
                      <i class="fa-solid fa-user-doctor" style="padding-top:5.5px; color:#20304c;  margin-right: 10px;"> </i>
                       <p class="text-center  align-items-center"> <%= med.getNombre() %></p>
                  </div>
                  
                  <div  class="d-flex" style="font-size: 20px;">
                      <i class="fa-regular fa-calendar-days" style="padding-top:5.5px; color:#20304c; margin-right: 10px;"></i>
                      <p> <%= fechaCita +" "+ horaCita%></p>
                  </div>
                  
                  <div  class="d-flex" style="font-size: 20px;">
                      <i class="fa-solid fa-map-location-dot" style="padding-top:5.5px; color:#20304c;  margin-right: 10px;"></i>
                      <p> <%= med.getClinica() %></p>
                  </div>
                  
                  <div  class="d-flex" style="font-size: 20px;">
                      <i class="fa-solid fa-briefcase-medical" style="padding-top:5.5px; color:#20304c;  margin-right: 10px;"></i>
                      <p> <%= medH.retornaEspecialidadPorCodigo(med.getEspecialidad()).getNombre() %> </p>
                  </div>
                  
                  <div class="d-flex justify-content-center align-items-center">
                  <form method="POST" name="ConfirmarCita" action="/mavenproject1/VistaCliente/confirmarCita?idMed=<%=med.getId()%>&fecha=<%=fechaCita%>&horaCita=<%=horaCita%>">
                      <button type="submit" class="btn btn-primary" style="background-color:#20304c; width: 200px;">Confirmar cita</button>
                  </form>
                  </div>
              </div>
<!--                <div class="col"></div>-->
            </div>  <!-- final de fila 1 -->
            
<!--            Fila para comentarios y resenas-->
            <div class="row justify-content-center">
                
                
            </div>
            
          </div>
    </body>
</html>
