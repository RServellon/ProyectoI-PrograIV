<%-- 
    Document   : ConfiguraciónInicialDelPerfil
    Created on : 25 abr. 2022, 15:08:29
    Author     : norma
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Fecha"%>
<%@page import="Modelo.Especialidad"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Ciudad"%>
<%
    List<Ciudad> ciudades = (List<Ciudad>) session.getAttribute("ciudades");
    List<Especialidad> especialidades = (List<Especialidad>) session.getAttribute("especialidades");
    Fecha fecha1  = (Fecha) session.getAttribute("fecha");
    Fecha fecha2 = fecha1.creearFechaMasDias(1);
    Fecha fecha3 = fecha1.creearFechaMasDias(2);
    Fecha fecha4 = fecha1.creearFechaMasDias(3);
    Fecha fecha5 = fecha1.creearFechaMasDias(4);
    Fecha fecha6 = fecha1.creearFechaMasDias(5);
    Fecha fecha7 = fecha1.creearFechaMasDias(6);
    
    List<Fecha> fechas = new ArrayList<Fecha>();
    fechas.add(fecha1);
    fechas.add(fecha2);
    fechas.add(fecha3);
    fechas.add(fecha4);
    fechas.add(fecha5);
    fechas.add(fecha6);
    fechas.add(fecha7);
    


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
        
        
        <div class="">
            
            <div class="row my-5">

                <div class="col-2" >

                </div>
                <div class="col-8 align-items-center text-center" >
                    <h4>
                        Hola <%=user.getNombre()%>! porfavor termina de configurar la información de tu perfil
                    </h4>
                    
                </div>
                    <div class="col-2" >

                </div>
            </div>

                    <div>
                        <form method="POST" name="ControladorMedico" action="/mavenproject1/configurar/medico/actualizar/datos" >
                            <div class="row  text-center ">

                                <div class="col" >
                                </div>
                                <div class="col-3" >
                                    <label>
                                        Especialidad
                                    </label>
                                    <select id="especialidad" name="especialidad" class='form-control form-control-md'>

                                        <%for (Especialidad e : especialidades) {%>
                                        <option value="<%=e.getCodigo()%>" ><%=e.getNombre()%></option>
                                        <%}%>

                                    </select>
                                </div>
                                <div class="col-3 " >

                                    <div id="ingresoUser" class="form-outline form-white mb-4">

                                        <label class="form-label" for="typeUser">Ciudad</label>
                                        <select id="ciudad" name="ciudad" class='form-control form-control-md'>

                                            <%for (Ciudad c : ciudades) {%>
                                            <option value="<%=c.getCodigo()%>" ><%=c.getNombre()%></option>
                                            <%}%>

                                        </select>
                                    </div>
                                </div>
                                <div class="col-3" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Costo de consulta</label>
                                        <input type="number" id="nombreUsuario" name="costoConsulta" class="form-control form-control-md" required />
                                    </div>
                                </div>
                                            <div class="col" >
                                            </div>

                            </div>

                            <div class="row my-5 text-center">

                                <div class="col" >
                                </div>
                                
                                <div class="col-2" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Clinica</label>
                                        <input type="text" id="nombreUsuario" name="clinica" class="form-control form-control-md" required />
                                    </div>
                                </div>
                                <div class="col-6 text-center" >
                                    <div id="ingresoUser" class="form-outline form-white mb-4">
                                        <label class="form-label" for="typeUser">Seleccione una foto de perfil</label>
                                        <input type="file" id="nombreUsuario" name="foto" class="form-control form-control-md" />
                                    </div>
                                </div>
                                
                                <div class="col" >
                                </div>


                            </div>

                            <div class="row my-5" style="border-top:  3px solid #20304c; ">

                                <div class="col"></div>
                             
                                <%for(int i = 0; i<7; i++){%>
                                    <div class="col-1 align-items-center text-center my-5"  >
                                        <div class="row">
                                            <div class="row">
                                                <h6>
                                                    <%= fechas.get(i).getDiaLiteral()%> <%= fechas.get(i).getDiaDelMes()%> de <%= fechas.get(i).getMesLiteral()%>
                                                </h6>
                                            </div>
                                            <div class="row">
                                                <h6>
                                                    Hora de inicio:
                                                </h6>
                                                <div class="col mx-0">
                                                    <select  name="horaInicio<%=i%>" class='form-control form-control-sm'>


                                                        <option value="null" >Nada</option>
                                                        <option value="07" >7</option>
                                                        <option value="08" >8</option>
                                                        <option value="09" >9</option>
                                                        <option value="10" >10</option>
                                                        <option value="11" >11</option>
                                                        <option value="12" >12</option>
                                                        <option value="13" >13</option>
                                                        <option value="14" >14</option>
                                                        <option value="15" >15</option>
                                                        <option value="16" >16</option>
                                                        <option value="17" >17</option>
                                                        <option value="18" >18</option>
                                                        <option value="19" >19</option>
                                                        <option value="20" >20</option>
                                                        <option value="21" >21</option>


                                                    </select>
                                                </div>

                                            </div>
                                            <div class="row">
                                                <h6>
                                                    Hora final:
                                                </h6>
                                                <div class="col">
                                                    <select  name="horaFinal<%=i%>" class='form-control form-control-sm'>

                                                        <option value="null" >Nada</option>
                                                        <option value="07" >7</option>
                                                        <option value="08" >8</option>
                                                        <option value="09" >9</option>
                                                        <option value="10" >10</option>
                                                        <option value="11" >11</option>
                                                        <option value="12" >12</option>
                                                        <option value="13" >13</option>
                                                        <option value="14" >14</option>
                                                        <option value="15" >15</option>
                                                        <option value="16" >16</option>
                                                        <option value="17" >17</option>
                                                        <option value="18" >18</option>
                                                        <option value="19" >19</option>
                                                        <option value="20" >20</option>
                                                        <option value="21" >21</option>


                                                    </select>
                                                </div>
                                                
                                            </div>
                                            <div class="row">
                                                <h6>
                                                    Frecuencia de consulta<br>
                                                </h6>
                                                <div class="col">
                                                    <select  name="frecuencia<%=i%>" class='form-control form-control-sm'>
                                                        <option value="null" >Nada</option>
                                                        <option value="30" >Cada 30 Minutos</option>
                                                        <option value="00" >Cada 60 Minutos</option>
                                                    </select>
                                                </div>

                                            </div>

                                        </div>

                                    </div>  
                                <%}%>
                                
                                <div class="col"></div>

                             


                            </div>
                                            
                                            
                            
                               
                            

                                            
                                            
                                            
                                            
                                            

                            <div class="row">

                                <div class="col" >

                                </div>
                                <div class="col-4" >
                                    <h6>
                                        NOTA: Para que el horario sea tomado en cuenta todos los campos deben estar seleccionados
                                    </h6>
                                </div>
                                <div class="col" >

                                </div>
                            </div>
                                
                            <div class="row">

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
                                            
                                            
                                            

                    
        </div>
        
        
    </body>
</html>
