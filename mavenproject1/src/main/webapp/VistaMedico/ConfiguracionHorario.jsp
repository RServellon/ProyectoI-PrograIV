<%-- 
    Document   : ConfiguracionHorario
    Created on : 29 abr. 2022, 23:23:47
    Author     : norma
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Fecha"%>
<%
    Fecha fecha = (Fecha) session.getAttribute("fecha");


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
                <div  class="col-3"></div>
                
                
                <div class="col-4 my-5 ">
                    <form method="POST" name="ControladorMedico" action="/mavenproject1/medico/gestionar/horario/procesar">
                        <div class="">
                            <h5>
                                Configurar Horario
                            </h5>
                            <div class="row my-3" >

h
                                <div class="col align-items-center text-center my-5"  >
                                    <div class="row">
                                        <div class="row">
                                            <h6>
                                                fecha
                                            </h6>
                                            <input type="date" id="start" name="calendario" value="<%= fecha.getFormatoYYYY_MM_DD()%>" min="<%= fecha.getFormatoYYYY_MM_DD()%>" >

                                        </div>
                                        <div class="row">
                                            <h6>
                                                Hora de inicio:
                                            </h6>
                                            <div class="col mx-0">
                                                <select  name="horaInicio" class='form-control form-control-sm'>


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
                                                <select  name="horaFinal" class='form-control form-control-sm'>

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
                                                <select  name="frecuencia" class='form-control form-control-sm'>
                                                    <option value="30" >Cada 30 Minutos</option>
                                                    <option value="00" >Cada 60 Minutos</option>
                                                </select>
                                            </div>

                                        </div>

                                    </div>
                                            <div class="row">

                                                <div class="col-2" >

                                                </div>
                                                <div class="col-8 align-items-center text-center">
                                                    <div id="boton_submit" class="boton-submit">
                                                        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">Continuar</button>
                                                    </div>
                                                </div>
                                                <div class="col-2" >

                                                </div>
                                            </div>
                                    

                                </div>  





                            </div>
                            


                        </div>
                    </form>
                </div>
                                            
                                            <div  class="col-3"></div>


            </div>


        </div>
    </body>
</html>

