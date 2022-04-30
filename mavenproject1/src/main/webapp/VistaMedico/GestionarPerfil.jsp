<%-- 
    Document   : GestionarPerfil
    Created on : 25 abr. 2022, 11:41:03
    Author     : norma
--%>
<%@page import="Modelo.Medico"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="Modelo.Ciudad"%>
<%@page import="java.util.List"%>
<%
List<Ciudad> ciudades = (List<Ciudad>) request.getAttribute("ciudades");
List<Especialidad> especialidades = (List<Especialidad>) request.getAttribute("especialidades");
Medico medico = (Medico) request.getAttribute("medico");

System.out.println(ciudades);
System.out.println(especialidades);
System.out.println(medico);


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gestionar perfil</title>
    </head>
    <body>
        <%@ include file  ="/Components/Header.jsp" %>
        
        <div >
            
            <div class="row mx-4 my-3" style="border-bottom: 3px solid #20304c">
                
                <div class="col-1 my-3" style="border: 3px solid #20304c">
                    <h5>
                        foto
                    </h5>
                </div>
                <div class="col-3 my-3">
                    <h5>
                        <%=user.getNombre()%>  <%=user.getId()%>  <%=user.getTipo()%>
                    </h5>
                </div>
                <div class="col-6">

                </div>
            </div>
                    
            <div class="row mx-4 my-3 text-center" style="min-height: 800px;" >
                
                <div class="col-2 my-3" style="border: 3px solid #20304c; " >
                    
                    <button type="button"  class="btn btn-md my-5" style="background: #20304c; ">
                        <a href="/mavenproject1/medico/gestion/perfil" style="color: white; text-decoration: none;">
                            Actualizar Datos
                        </a>
                    </button>
                    
                    <button type="button"  class="btn btn-md my-5" style="background: #20304c; ">
                        <a href="/mavenproject1/medico/gestionar/horario" style="color: white; text-decoration: none;">
                            Conf. Horario Semanal
                        </a>
                    </button>
                    
                    <button type="button"  class="btn btn-md my-5" style="background: #20304c; ">
                        <a href="/mavenproject1/administrar/citas" style="color: white; text-decoration: none;">
                            Administrar Citas
                        </a>
                    </button>
                    
                </div>
                <div class="col-10 my-3">
                    <h5>
                        Actualizar Información de Medico
                    </h5>
                    
                    <div>
                        <form method="POST" name="ControladorMedico" action="/mavenproject1/medico/actualizar/informacion" >
                            <div class="row  text-center ">

                                <div class="col" >
                                </div>
                                <div class="col-3" >
                                    <label>
                                        Especialidad
                                    </label>
                                    <select id="especialidad" name="especialidad" class='form-control form-control-md' >

                                        
                                        <%for (Especialidad e : especialidades) {%>
                                            <% if(e.getCodigo().equals(medico.getEspecialidad()) ){%>
                                                <option selected value="<%=e.getCodigo()%>" ><%=e.getNombre()%></option>
                                            <% }%>
                                            <% if(! e.getCodigo().equals(medico.getEspecialidad()) ){%>
                                                <option value="<%=e.getCodigo()%>" ><%=e.getNombre()%></option>
                                            <% }%>
                                           
                                        <%}%>

                                    </select>
                                </div>
                                <div class="col-3 " >

                                    <div id="ingresoUser" class="form-outline form-white mb-4">

                                        <label class="form-label" for="typeUser">Ciudad</label>
                                        <select id="ciudad" name="ciudad" class='form-control form-control-md'>


                                            
                                            <%for (Ciudad c : ciudades) {%>
                                            <% if (c.getCodigo().equals(medico.getCiudad())) {%>
                                            <option selected value="<%=c.getCodigo()%>" ><%=c.getNombre()%></option>
                                            <% }%>
                                            <% if (!c.getCodigo().equals(medico.getCiudad())) {%>
                                            <option value="<%=c.getCodigo()%>" ><%=c.getNombre()%></option>
                                            <% }%>

                                            <%}%>

                                        </select>
                                    </div>
                                </div>
                                <div class="col-3" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Costo de consulta</label>
                                        <input type="number"  id="nombreUsuario" name="costoConsulta" class="form-control form-control-md" value="<%=medico.getCostoConsulta()%>" required />
                                    </div>
                                </div>
                                <div class="col" >
                                </div>

                            </div>

                            <div class="row my-5 text-center">

                                <div class="col" >
                                </div>

                                <div class="col-4" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Clinica</label>
                                        <input type="text" id="nombreUsuario" name="clinica" class="form-control form-control-md" required value="<%=medico.getClinica() %>" />
                                    </div>
                                </div>
                                <div class="col-5 text-center" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Seleccione una foto de perfil</label>
                                        <input type="file" id="nombreUsuario" name="foto" class="form-control form-control-md" />
                                    </div>
                                </div>

                                <div class="col" >
                                </div>


                            </div>
                            <div class="row my-5 text-center">

                                <div class="col" >
                                </div>

                                
                                <div class="col-5 text-center" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        
                                        <textarea class="form-control z-depth-1" name="descipcion" rows="3" ><%=medico.getClinica() %></textarea>
                                    </div>
                                </div>

                                <div class="col" >
                                </div>


                            </div>


                            <div class="row">

                                <div class="col-2" style="">

                                </div>
                                <div class="col-8 align-items-center text-center" style="">
                                    <div id="boton_submit" class="boton-submit">
                                        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">Actualizar</button>
                                    </div>
                                </div>
                                <div class="col-2" style="">

                                </div>
                            </div>

                        </form>
                    </div>
                    
                </div>
                
            </div>
                    
                    
        </div>
    </body>
</html>
