<%-- 
    Document   : ConfiguraciónInicialDelPerfil
    Created on : 25 abr. 2022, 15:08:29
    Author     : norma
--%>
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


                             
                                <div class="col align-items-center text-center my-5"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                <%= fecha1.getDiaLiteral()%> <%= fecha1.getDiaDelMes()%> de <%= fecha1.getMesLiteral()%>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                                <select  name="horaInicio1" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora final:
                                                <select  name="horaFinal1" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>
                                                    <option value="21" >9 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Frecuencia de consulta<br>
                                                (minutos)
                                            </h6>
                                            <input type="number" name="frecuencia1" class="form-control form-control-sm" required />

                                        </div>

                                    </div>

                                </div>  

                             
                                <div class="col align-items-center text-center my-5"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                <%= fecha2.getDiaLiteral()%> <%= fecha2.getDiaDelMes()%> de <%= fecha2.getMesLiteral()%>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                                <select  name="horaInicio2" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora final:
                                                <select  name="horaFinal2" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>
                                                    <option value="21" >9 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Frecuencia de consulta<br>
                                                (minutos)
                                            </h6>
                                            <input type="number" name="frecuencia2" class="form-control form-control-sm" required />

                                        </div>

                                    </div>

                                </div>  

                             
                                <div class="col align-items-center text-center my-5"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                <%= fecha3.getDiaLiteral()%> <%= fecha3.getDiaDelMes()%> de <%= fecha3.getMesLiteral()%>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                                <select  name="horaInicio3" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora final:
                                                <select  name="horaFinal3" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>
                                                    <option value="21" >9 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Frecuencia de consulta<br>
                                                (minutos)
                                            </h6>
                                            <input type="number" name="frecuencia3" class="form-control form-control-sm" required />

                                        </div>

                                    </div>

                                </div>  

                             
                                <div class="col align-items-center text-center my-5"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                <%= fecha4.getDiaLiteral()%> <%= fecha4.getDiaDelMes()%> de <%= fecha4.getMesLiteral()%>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                                <select  name="horaInicio4" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora final:
                                                <select  name="horaFinal4" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>
                                                    <option value="21" >9 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Frecuencia de consulta<br>
                                                (minutos)
                                            </h6>
                                            <input type="number" name="frecuencia4" class="form-control form-control-sm" required />

                                        </div>

                                    </div>

                                </div>  

                            </div>
                                            
                                            
                            <div class="row" style="">


                             
                                <div class="col align-items-center text-center"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                <%= fecha5.getDiaLiteral()%> <%= fecha5.getDiaDelMes()%> de <%= fecha5.getMesLiteral()%>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                                <select  name="horaInicio5" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora final:
                                                <select  name="horaFinal5" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>
                                                    <option value="21" >9 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Frecuencia de consulta<br>
                                                (minutos)
                                            </h6>
                                            <input type="number" name="frecuencia5" class="form-control form-control-sm" required />

                                        </div>

                                    </div>

                                </div>  

                             
                                <div class="col align-items-center text-center"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                <%= fecha6.getDiaLiteral()%> <%= fecha6.getDiaDelMes()%> de <%= fecha6.getMesLiteral()%>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                                <select  name="horaInicio6" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora final:
                                                <select  name="horaFinal6" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>
                                                    <option value="21" >9 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Frecuencia de consulta<br>
                                                (minutos)
                                            </h6>
                                            <input type="number" name="frecuencia6" class="form-control form-control-sm" required />

                                        </div>

                                    </div>

                                </div>  

                             
                                <div class="col align-items-center text-center"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                <%= fecha7.getDiaLiteral()%> <%= fecha7.getDiaDelMes()%> de <%= fecha7.getMesLiteral()%>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                                <select  name="horaInicio7" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora final:
                                                <select  name="horaFinal7" class='form-control form-control-sm'>


                                                    <option value="07" >7 AM</option>
                                                    <option value="08" >8 AM</option>
                                                    <option value="09" >9 AM</option>
                                                    <option value="10" >10 AM</option>
                                                    <option value="11" >11 AM</option>
                                                    <option value="12" >12 AM</option>
                                                    <option value="13" >1 PM</option>
                                                    <option value="14" >2 PM</option>
                                                    <option value="15" >3 PM</option>
                                                    <option value="16" >4 PM</option>
                                                    <option value="17" >5 PM</option>
                                                    <option value="18" >6 PM</option>
                                                    <option value="19" >7 PM</option>
                                                    <option value="20" >8 PM</option>
                                                    <option value="21" >9 PM</option>


                                                </select>
                                            </h6>
                                        </div>
                                        <div class="row">
                                            <h6>
                                                Frecuencia de consulta<br>
                                                (minutos)
                                            </h6>
                                            <input type="number" name="frecuencia7" class="form-control form-control-sm" required />

                                        </div>

                                    </div>

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
                                            
                                            
                                            

                    
        </div>
        
        
    </body>
</html>
