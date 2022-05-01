<%-- 
    Document   : GestionarCitas
    Created on : 25 abr. 2022, 10:39:40
    Author     : norma
--%>

<%@page import="Modelo.DAO.GeneralHandler"%>
<%@page import="Modelo.Cita"%>
<%@page import="java.util.List"%>
<%

String estado =  request.getParameter("estado");
String idCliente =  request.getParameter("idCliente");
List<Cita> citas = (List<Cita>) session.getAttribute("citas");
GeneralHandler general = new GeneralHandler();

System.out.println(estado);
System.out.println(idCliente);
System.out.println(citas);
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
                        Gestión de citas
                    </h5>
                    
                    <div class="row row-padding" >
                        <form class="form-inline d-flex" method="POST" name="ControladorMedico" action="/mavenproject1/administrar/citas">

                            <div class="col"></div>
                            
                            <!--                campo de busqueda especialidad-->
                            <div class="col-4 d-flex">
                                <div class="input-group-prepend">
                                </div>
                                <%if(estado != null){%>
                                <input name="estado" value="<%=estado%>"  type="text" class="form-control fs-4" placeholder="Estado" aria-label="Estado" aria-describedby="basic-addon1">
                                <%}%>
                                <%if(estado == null){%>
                                <input name="estado" value="" type="text" class="form-control fs-4" placeholder="Estado" aria-label="Estado" aria-describedby="basic-addon1">
                                <%}%>
                            </div>

                            <!--                campo de busqueda provincia-->
                            <div class="col-4 d-flex col-padding margin-space">
                                <div class="input-group-prepend margin-space">
                                </div>
                                <%if(idCliente != null){%>
                                <input name= "idCliente" value="<%=idCliente%>" type="text" class="form-control fs-4" placeholder="Id Cliente" aria-label="Id Cliente" aria-describedby="basic-addon1">
                                <%}%>
                                <%if(idCliente == null){%>
                                <input name= "idCliente" type="text" value="" class="form-control fs-4" placeholder="Id Cliente" aria-label="Id Cliente" aria-describedby="basic-addon1">
                                <%}%>
                            </div>

                            <!--                cboton de submit-->
                            <div class="row">
                                <div class="col-3 d-flex justify-content-evenly">
                                    <div class="">
                                        <button class="btn btn-primary my-2 my-sm-0 boton fs-4" type="submit">Buscar</button>
                                    </div>
                                </div>
                            </div>
                            
                            <div class="col"></div>

                        </form>
                    </div>

                    <%for(Cita c: citas){%>
                            <div class="row">
                                <div class="col-1"></div>
                                <div class="col my-3 mx-5 text-center" style="border: 3px solid gray;">
                                    <div class="row">
                                        Paciente: <%=general.retornaUserPorId(c.getId_paciente()).getNombre()%>   Hora: <%=c.getFechaString()  %> (<%=c.getEstado()%>)
                                    </div>
                                    <div class="row">
                                        Anotaciones: <%=c.getAnotaciones() %> 
                                    </div>
                                        <%if(c.getEstado().equals("ESPERA")){%>
                                        <div class="row">
                                            <div class="col-4"></div>
                                            <div class="col align-items-center" style="max-width: 90px; background: green;  border-radius: 5px;margin-bottom: 9px;">
                                                <a href="/mavenproject1/medico/gestionar/citas/aceptar?citaAceptada=<%=c.getId_medico() %>" style="color: white;">Aceptar</a>
                                            </div>
                                            <div class="col align-items-center" style="max-width: 90px; background: red;  border-radius: 5px;margin-bottom: 9px;">
                                                <a href="/mavenproject1/medico/gestionar/citas/descartar?citaDescartada=<%=c.getId_medico()%>" style="color: white;">
                                                    Descartar
                                                </a>
                                            </div>
                                            <div class="col-4"></div>
                                        </div>
                                        <%}%>
                                        <%if(c.getEstado().equals("REGISTRADO")){%>
                                        <div style="max-width: 90px; background: cornflowerblue;  border-radius: 5px;margin-bottom: 9px;">
                                            <a href="/mavenproject1/medico/gestionar/citas/concluir?citaConcluida=<%=c.getId_medico()%>" style="color: white;">
                                                Concluir
                                            </a>
                                        </div>
                                        <%}%>
                                </div>
                                <div class="col-1"></div>

                            </div>
                    <%}%>



                </div>

            </div>


        </div>
    </body>
</html>


