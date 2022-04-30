<%-- 
    Document   : GestionarCitas
    Created on : 25 abr. 2022, 10:39:40
    Author     : norma
--%>

<%


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



                </div>

            </div>


        </div>
    </body>
</html>


