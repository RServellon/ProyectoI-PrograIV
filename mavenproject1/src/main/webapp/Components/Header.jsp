<%-- 
    Document   : Header
    Created on : 19 abr. 2022, 21:12:39
    Author     : norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
              <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        
        <nav class="navbar navbar-light " style="background-color: #20304c;">
            <a class="navbar-brand mx-4" href="#" style="color: white">
                <img src="../assets/Icon pages/home.png">
                <label class="form-label" >Inicio</label>
            </a>

            <div class="mx-10" id="navbarNav">
                <ul class="nav justify-content-end" >
                    <li class="nav-item">
                        <a class="nav-link active" style="color:white" href="#">
                            <img src="../assets/Icon pages/info.png">
                            
                            <label class="form-label" >About</label>
                            
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="#">
                            <img src="../assets/Icon pages/search.png">
                            
                            <label class="form-label" >Buscar</label>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" style="color: white" href="../Login.jsp">
                            <img src="../assets/Icon pages/log-in.png">
                            <label class="form-label" >Login</label>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
         <script src="https://unpkg.com/boxicons@2.1.2/dist/boxicons.js"></script>
        <script src="https://kit.fontawesome.com/d621e66b58.js" crossorigin="anonymous"></script>
    </body>
</html>
