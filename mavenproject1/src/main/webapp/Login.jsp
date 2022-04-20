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
        
        <nav class="navbar navbar-light " style="background-color: #20304c;">
            <a class="navbar-brand mx-4" href="#" style="color: white">
                <img src="assets/Icon pages/home.png">
                <label class="form-label" >Inicio</label>
            </a>

            <div class="mx-10" id="navbarNav">
                <ul class="nav justify-content-end" >
                    <li class="nav-item">
                        <a class="nav-link active" style="color:white" href="#">
                            <img src="assets/Icon pages/info.png">

                            <label class="form-label" >About</label>

                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="#">
                            <img src="assets/Icon pages/search.png">

                            <label class="form-label" >Buscar</label>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="#">
                            <img src="assets/Icon pages/log-in.png">

                            <label class="form-label" >Login</label>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
        
        
   
        
        
        <section class="vh-all ">
            <div class="container py-5 h-100">
                <div class="row  justify-content-center align-items-center h-100">

                    <div class="col-8 col-md-8 col-lg-6 col-xl-5"  >
                        <div class="ilustration-container " style="text-align:center;"> 
                            <img src="assets/ilustrations/medic girl.svg" width="50%" height="50%" >
                        </div>  

                        <div class="card bg-glass" style="border-radius: 1rem;"  >
                            <div class="card-body px-5 py-4 px-md-5 text-center container-login " >
                                <form method="POST" name="pagina_logeo" action="login" >

                                    <div class="mb-md-0 mt-md-4 pb-5">
                                        <h2 class="fw-bold mb-2 text-uppercase">Login</h2>
                                        <p class="mb-5" color="gray">Por favor digite su usuario y contraseña!</p>

                                        <div id="ingresoUser" class="form-outline form-white mb-4">
                                            <input type="text" id="nombreUsuario" name="user" class="form-control form-control-lg" />
                                            <label class="form-label" for="typeUser">Usuario</label>
                                        </div>

                                        <div id="ingresoPass" class="form-outline form-white mb-4">
                                            <input type="password" id="password" name="password" class="form-control form-control-lg" />
                                            <label class="form-label" for="typePasswordX">Contraseña</label>
                                        </div>

                                        <div id="tipo_usuario" class="form-group radio-usuario" required>
                                            <label>
                                                <i class="fa-solid fa-user-doctor"></i>
                                                Medico
                                                <input value="medico" type="radio" name="tipo_usuario">
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

                                        <div id="boton_submit" class="boton-submit">
                                            <button class="btn btn-outline-secondary btn-lg px-5" type="submit">Iniciar sesion</button>
                                        </div>


                                    </div>

                                    <div>
                                        <!--                Aqui se debe de colocar la pagina GENERAL para registrar (quitar registroMedico y registroCliente)-->
                                        <p class="mb-0">Si no tienes una cuenta registrate <a href="VistaMedico/RegistroMedico.jsp"
                                                                                              class="text-primary fw-bold">aqui</a>
                                        </p>
                                    </div>

                                </form>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
    </body>

    </html>