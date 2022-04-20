<%-- Document : Login Created on : Apr 13, 2022, 7:04:07 PM Author : @ --%>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Login page</title>
      <link href="CSS/login.css" rel="stylesheet">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    
    </head>

    <body class="">
        <%@ include file  ="Components/Header.jsp" %>
        
     <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
                            <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
                            <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

                            <div class="card bg-glass">
                                <div class="card-body px-4 py-5 px-md-5">
                                    <form method="POST" name="RegistrarMedico" action="/mavenproject1/VistaMedico/registrarmedico">
                                        <!-- 2 column grid layout with text inputs for the first and last names -->
                                        <div class="row">
                                            <div class="col-md-6 mb-4">
                                                <div class="form-outline">
                                                    <input type="text" name="first-name" class="form-control" />
                                                    <label class="form-label" for="form3Example1">Nombre</label>
                                                </div>
                                            </div>
                                            <div class="col-md-6 mb-4">
                                                <div class="form-outline">
                                                    <input type="text" name="last-name" class="form-control" />
                                                    <label class="form-label" for="form3Example2">Apellidos</label>
                                                </div>
                                            </div>
                                        </div>

                                        <!-- ID-->
                                        <div class="form-outline mb-4">
                                            <input required type="text" name="id" class="form-control" />
                                            <label class="form-label" for="form3Example3">Identificación</label>
                                        </div>



                                        <!-- Password input -->
                                        <div class="form-outline mb-4">
                                            <input required type="password" name="pwd" class="form-control" />
                                            <label class="form-label" for="form3Example4">Contraseña</label>
                                        </div>
                                        <!-- Password input -->
                                        <div class="form-outline mb-4">
                                            <input required type="password" name="pwd-confirmation"
                                                   class="form-control" />
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
                                                <input value="administrador" type="radio" name="tipo_usuario">
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
        <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
    </body>

    </html>