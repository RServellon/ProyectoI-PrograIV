<%-- Document : Login Created on : Apr 13, 2022, 7:04:07 PM Author : @ --%>

  <%@page contentType="text/html" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Login page</title>
      <link href="CSS/login.css" rel="stylesheet">
      <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>

    <body>
      <section class="vh-100 gradient-custom background-radial-gradient">
        <div class="container py-5 h-100">
          <div class="row  justify-content-center align-items-center h-100">
            <div class="col-8 col-md-8 col-lg-6 col-xl-5">
                
                <div class="card bg-glass" style="border-radius: 1rem;">
                    <div class="card-body px-5 py-4 px-md-5 text-center container-login ">
                  <form method="POST" name="pagina_logeo" action="login">

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

                      <div id="tipo_usuario" class="form-group radio-usuario">
                        <label>
                          <i class="fa-solid fa-user-doctor"></i>
                          Medico
                          <input for="medico" type="radio" name="tipo_usuario">
                        </label>
                        <label>
                          <i class="fa-solid fa-user-injured"></i>
                          Paciente
                          <input for="paciente" type="radio" name="tipo_usuario">
                        </label>
                        <label>
                          <i class="fa-solid fa-user-gear"></i>
                          Admin
                          <input for="administrador" type="radio" name="tipo_usuario">
                        </label>
                      </div>

                      <div id="boton_submit" class="boton-submit">
                        <button class="btn btn-outline-secondary btn-lg px-5" type="submit">Iniciar sesion</button>
                      </div>


                    </div>

                    <div>
                      <!--                Aqui se debe de colocar la pagina GENERAL para registrar (quitar registroMedico y registroCliente)-->
                      <p class="mb-0">Si no tienes una cuenta registrate <a href="VistaCliente/RegistroCliente.jsp"
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
    </body>

    </html>