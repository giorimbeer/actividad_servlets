

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>inicio</title>
        
        <link rel="stylesheet" href="/estilos/header.css">
    </head>
    <body>
        
        <h1>Pagina principal</h1>
        
        <nav>
            <ul>
                <li><a href="index.jsp">PAGINA PRINCIPAL</a></li>
                <br></br>
                <li>
                    <form action ="SvProductos" method = "GET">
                        <button type="submit" > ver productos </button>
                    </form>
                </li>
                <br></br>
                <li><a href="crearProducto.jsp">CREAR PRODUCTO</a></li>                    
            </ul>
        </nav>
    </body>
</html>
