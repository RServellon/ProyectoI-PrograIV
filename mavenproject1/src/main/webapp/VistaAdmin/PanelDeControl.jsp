<%-- 
    Document   : PanelDeControl
    Created on : 21 abr. 2022, 23:23:09
    Author     : norma
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Panel de Control</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <link href="../CSS/PanelDeControl.css" rel="stylesheet">
    </head>
    <body>
        <%@ include file  ="/Components/Header.jsp" %>
        
        <h1 class="h">
            hola mundo
        </h1>
        
        <div class="mx-0" id="contenedor-dash">
           
            <div class="row justify-content-center">
                <div class="col-3" style="background: blue">
                    One of two columns
                </div>
                <div class="col-9" style="background: red">
                    main
                </div>
            </div>
            
        </div>
        
        

        
    </body>
</html>
