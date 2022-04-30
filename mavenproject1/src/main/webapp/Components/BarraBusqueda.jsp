<!--        fila de busqueda-->
<%
          String provincia =(String)session.getAttribute("provincia");
          if(provincia == null){
            provincia = "";
          }
          String especialidad =(String)session.getAttribute("especialidad");
          if(provincia.length() == 0){
            provincia = "";
          }
          if(especialidad == null){
            especialidad = "";
          }
          if( especialidad.length() == 0){
          especialidad = "";
          }
%>
       <div class="row row-padding" >
          <form class="form-inline d-flex" method="POST" name="BusquedaCita" action="search">
                
<!--                campo de busqueda especialidad-->
            <div class="col-sm d-flex">
                <div class="input-group-prepend">
                   <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-briefcase-medical icons"></i></span>
                </div>
                <input name="Especialidad" value="<%=especialidad%>"  type="text" class="form-control fs-4" placeholder="Especialidad" aria-label="Especialidad" aria-describedby="basic-addon1">
            </div>

<!--                campo de busqueda provincia-->
             <div class="col-sm d-flex col-padding margin-space">
                <div class="input-group-prepend margin-space">
                   <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-city icons"></i></span>
                </div>
               <input name= "Provincia" value="<%=provincia%>" type="text" class="form-control fs-4" placeholder="Provincia" aria-label="Provincia" aria-describedby="basic-addon1">
             </div>

 <!--                cboton de submit-->
              <div class="col-sm d-flex justify-content-evenly">
                  <div class="">
                      <button class="btn btn-primary my-2 my-sm-0 boton fs-4" type="submit">Buscar</button>
                  </div>
              </div>
                
          </form>
       </div>
