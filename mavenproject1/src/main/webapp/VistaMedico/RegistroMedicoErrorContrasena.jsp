<%-- Document : RegistroMedico Created on : 13 abr. 2022, 0:12:21 Author : norman --%>
    <% String nombre=(String) request.getAttribute("first-name"); String apellido=(String)
        request.getAttribute("last-name"); String id=(String) request.getAttribute("id"); String errorCode=(String)
        request.getAttribute("error-code"); %>
        
        <%@page contentType="text/html" pageEncoding="UTF-8" %>
            <!DOCTYPE html>
            <html>

            <head>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <title>Registro</title>
                <link rel="stylesheet" href="../CSS/StyleRegistro.css" type="text/css">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
                    integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
                    crossorigin="anonymous">
            </head>

            <body >

                <%@ include file  ="../Components/Header.jsp" %>
                <section class="overflow-hidden">

                    <div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5 align-items-center">
                        <div class="row gx-lg-5 align-items-center mb-5">
                            <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
                                <h1 class="mt-1 display-5 fw-bold ls-tight" >
                                    Registro General <br />
                                </h1>
                                <h3 style="color: hsl(218, 81%, 15%)">Por Favor ingrese sus datos</h3>
                                <p class="mb-4 opacity-70" style="color: #26395b">
                                    Nota: Debe ingresar sus datos correctos
                                </p>
                            </div>

                            <div class="col-lg-1 ">
                                
                            </div>
                            <div class="col-lg-10 mb-5 mb-lg-0 ml-6 position-relative align-items-center">
                                <div class="alert alert-danger" role="alert">
                                    <%=errorCode%>
                                </div> 
                            

                            <div class="card bg-glass">
                                <div class="card-body px-4 ml-6 py-5 px-md-5">
                                    <form method="POST" name="ControladorRegistro" action="/mavenproject1/registrar/medico">
                                        <!-- 2 column grid layout with text inputs for the first and last names -->
                                        <div class="row">
                                            <div class="col-md-6 mb-4">
                                                <div class="form-outline">
                                                    <input type="text" name="first-name" class="form-control"
                                                        value="<%=nombre%>" />
                                                    <label class="form-label" for="form3Example1">Nombre</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6 mb-4">
                                                <div class="form-outline">
                                                    <input type="text" name="last-name" class="form-control"
                                                        value="<%=apellido%>" />
                                                    <label class="form-label" for="form3Example2">Apellidos</label>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- ID-->
                                        <div class="form-outline mb-4">
                                            <input required type="text" name="id" class="form-control"
                                                value="<%=id%>" />
                                            <label class="form-label" for="form3Example3">Identificación</label>
                                        </div>



                                        <!-- Password input -->
                                        <div class="form-outline mb-4">
                                            <input type="password" name="pwd" class="form-control" />
                                            <label class="form-label" for="form3Example4">Contraseña</label>
                                        </div>
                                        <!-- Password input -->
                                        <div class="form-outline mb-4">
                                            <input type="password" name="pwd-confirmation" class="form-control" />
                                            <label class="form-label" for="form3Example4">Confirmar Contraseña</label>
                                        </div>
                                        
                                        <div id="tipo_usuario" class="form-group radio-usuario">
                                            <label>
                                                <i class="fa-solid fa-user-doctor"></i>
                                                Medico
                                                <input value="medico" type="radio" name="tipo_usuario" required>
                                            </label>
                                            <label>
                                                <i class="fa-solid fa-user-injured"></i>
                                                Paciente
                                                <input value="paciente" type="radio" name="tipo_usuario">
                                            </label>
                                            <label>
                                                <i class="fa-solid fa-user-gear"></i>
                                                Admin
                                                <input value="admi" type="radio" name="tipo_usuario">
                                            </label>
                                        </div>


                                        <!-- Submit button -->
                                        <button type="submit" class="btn btn-primary btn-block mb-4">
                                            Registrarse
                                        </button>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    </div>
                </section>
                




                <!--link de bootstrap-->
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
                    integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
                    crossorigin="anonymous"></script>
                <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
            </body>

            </html>