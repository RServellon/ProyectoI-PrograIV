<!DOCTYPE html>
<html>

<head>
    <title>Pagina inicial</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link href="CSS/PaginaPrincipalClientes.css" rel="stylesheet">
      <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
      
</head>

<body>
     
    <nav class="navbar navbar-light " style="background-color: #20304c;">
        <a class="navbar-brand mx-4" href="index.jsp" style="color: white">
            <img src="assets/Icon pages/home.png">
            <label class="form-label" >Inicio</label>
        </a>

        <div class="mx-10" id="navbarNav">
            <ul class="nav justify-content-end" >
                <li class="nav-item">
                    <a class="nav-link active" style="color:white" href="Components/aboutUs.jsp">
                        <img src="assets/Icon pages/info.png">

                        <label class="form-label" >About</label>

                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="VistaCliente/PaginaPrincipal.jsp">
                        <img src="assets/Icon pages/search.png">

                        <label class="form-label" >Buscar</label>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" style="color: white" href="Login.jsp">
                        <img src="assets/Icon pages/log-in.png">
                        <label class="form-label" >Login</label>
                    </a>
                </li>
            </ul>
        </div>
    </nav>
    
    <div class="container-lg">
<!--        fila de busqueda-->
       <div class="row row-padding">
          <form class="form-inline d-flex" method="POST" name="pagina_busqueda" action="search">
                
<!--                campo de busqueda especialidad-->
            <div class="col-sm d-flex ">
                <div class="input-group-prepend">
                   <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-briefcase-medical icons"></i></span>
                </div>
                <input name="Especialidad" type="text" class="form-control" placeholder="Especialidad" aria-label="Especialidad" aria-describedby="basic-addon1">
            </div>

<!--                campo de busqueda provincia-->
             <div class="col-sm d-flex col-padding margin-space">
                <div class="input-group-prepend margin-space">
                   <span class="input-group-text" id="basic-addon1"><i class="fa-solid fa-city icons"></i></span>
                </div>
               <input name= "Provincia" type="text" class="form-control" placeholder="Provincia" aria-label="Provincia" aria-describedby="basic-addon1">
             </div>

 <!--                cboton de submit-->
              <div class="col-sm d-flex justify-content-evenly">
                  <div class="">
                      <button class="btn btn-primary my-2 my-sm-0 boton" type="submit">Buscar</button>
                  </div>
              </div>
                
          </form>
       </div>

<!--    Fila de informacion-->
     <div class="row row-padding justify-content-evenly">
         
         <div class="col-sm col-padding margin-space justify-content-evenly">
                 <div class="input-group-prepend">
                   <span class="input-group-text size-span" id="basic-addon1">
                       <i class="fa-solid fa-magnifying-glass icons-1"></i>
                   </span>
                      <br> <p class="fs-3">Busca doctores segun la <br>especialidad que necesites y ciudad</p>
                </div>
         </div>
         <div class="col-sm col-padding margin-space justify-content-evenly">
                 <div class="input-group-prepend">
                   <span class="input-group-text size-span" id="basic-addon1">
                       <i class="fa-solid fa-calendar-days icons-1"></i>
                   </span>
                      <p class="fs-3">Realiza una cita con ese doctor  <br>seleccionando el horario que mejor <br>se te ajuste y eso es todo!</p>
                </div>
         </div>
         
     </div>


    </div>
    
    

        <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
</body>
</html>




