<%-- 
    Document   : ConfiguraciónInicialDelPerfil
    Created on : 25 abr. 2022, 15:08:29
    Author     : norma
--%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Ciudad"%>
<%
    List<Ciudad> ciudades = (List<Ciudad>) session.getAttribute("ciudades");
    List<Especialidad> especialidades = (List<Especialidad>) session.getAttribute("especialidades");
    


%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Configuracion medico</title>
    </head>
    <body>
        <%@ include file  ="/Components/Header.jsp" %>
        
        
        <div class="container ">
            
            <div class="row my-5">

                <div class="col-2" style="border-bottom: 3px solid #20304c">

                </div>
                <div class="col-8 align-items-center text-center" style="border-bottom: 3px solid #20304c">
                    <h4>
                        Hola <%=user.getNombre()%>! porfavor termina de configurar la información de tu perfil
                    </h4>
                    
                </div>
                    <div class="col-2" style="border-bottom: 3px solid #20304c">

                </div>
            </div>

                    <div>
                        <form method="POST" name="ControladorMedico" action="/mavenproject1/configurar/medico/actualizar/datos" >
                            <div class="row  text-center">

                                <div class="col-4" >
                                    <label>
                                        Especialidad
                                    </label>
                                    <select id="especialidad" name="especialidad" class='form-control form-control-md'>

                                        <%for (Especialidad e : especialidades) {%>
                                        <option value="<%=e.getCodigo()%>" ><%=e.getNombre()%></option>
                                        <%}%>

                                    </select>
                                </div>
                                <div class="col-4 " >

                                    <div id="ingresoUser" class="form-outline form-white mb-4">

                                        <label class="form-label" for="typeUser">Ciudad</label>
                                        <select id="ciudad" name="ciudad" class='form-control form-control-md'>

                                            <%for (Ciudad c : ciudades) {%>
                                            <option value="<%=c.getCodigo()%>" ><%=c.getNombre()%></option>
                                            <%}%>

                                        </select>
                                    </div>
                                </div>
                                <div class="col-4" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Costo de consulta</label>
                                        <input type="number" id="nombreUsuario" name="costoConsulta" class="form-control form-control-md" required />
                                    </div>
                                </div>

                            </div>

                            <div class="row my-5 text-center">

                                <div class="col-4" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Clinica</label>
                                        <input type="text" id="nombreUsuario" name="clinica" class="form-control form-control-md" required />
                                    </div>
                                </div>
                                <div class="col-8 text-center" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Seleccione una foto de perfil</label>
                                        <input type="file" id="nombreUsuario" name="foto" class="form-control form-control-md" />
                                    </div>
                                </div>


                            </div>


                            <div class="row my-5">

                                <div class="col-2" style="border-top: 3px solid #20304c">

                                </div>
                                <div class="col-8 align-items-center text-center" style="border-top:  3px solid #20304c">
                                    <div id="boton_submit" class="boton-submit">
                                        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">Continuar</button>
                                    </div>
                                </div>
                                <div class="col-2" style="border-top: 3px solid #20304c">

                                </div>
                            </div>

                        </form>
                    </div>
                                            
                                            
                                            
                    <div class="row my-5">

                        <div class="col-2" style="border-bottom: 3px solid #20304c">

                        </div>
                        <div class="col-8 align-items-center text-center" style="border-bottom: 3px solid #20304c">
                            <h4>
                                Hola <%=user.getNombre()%>! porfavor termina de configurar la información de tu perfil
                            </h4>

                        </div>
                        <div class="col-2" style="border-bottom: 3px solid #20304c">

                        </div>
                    </div>

                    
        </div>
        
        
    </body>
</html>
