<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        <img src="../assets/images/retrato-perfil-doc.jpg" class="" style="border-radius: 50%; max-height: 220px;">
                  </div>
                  <hr>
                  <div class="d-flex" style="font-size: 20px;">
                      <i class="fa-solid fa-user-doctor" style="padding-top:5.5px; color:#20304c;"> </i>
                       <p class="text-center  align-items-center">Nombre</p>
                  </div>
                  <div  class="d-flex" style="font-size: 20px;">
                      <i class="fa-regular fa-calendar-days" style="padding-top:5.5px; color:#20304c;"></i>
                      <p>Fecha cita</p>
                  </div>
                  <div  class="d-flex" style="font-size: 20px;">
                      <i class="fa-solid fa-map-location-dot" style="padding-top:5.5px; color:#20304c;"></i>
                      <p>Ubicacion local</p>
                  </div>
                  <div  class="d-flex" style="font-size: 20px;">
                      <i class="fa-solid fa-briefcase-medical" style="padding-top:5.5px; color:#20304c;"></i>
                      <p>Especialidad</p>
                  </div>
                  
                  <div class="d-flex justify-content-center align-items-center">
                  <form method="POST" name="ConfirmarCita" action="confirm">
                      <button type="submit" class="btn btn-primary" style="background-color:#20304c; width: 200px;">Primary</button>
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
