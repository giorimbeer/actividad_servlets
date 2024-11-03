<%-- 
    Document   : productos
    Created on : 29/10/2024, 1:57:35 a. m.
    Author     : 39GX
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
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
        
        <h1>Ingresar Producto</h1>
        
        <form action="SvProductos" method ="POST" >
            
            <label >Nombre:</label><br/>
            <input type="text" name="nombre" >
            <br/><br/>
            
            <label >Precio:</label><br/>
            <input type="text" name="precio" >
            <br/><br/>
            
            <label>Descripcion:</label><br/>
            <textarea name="descripcion" rows="10" cols="20"></textarea>
            <br/><br/>
            
            <label>Imagen:</label><br/>
            <input type="text" name="imagen">
            <br/><br/>
            
            <label>Codigo categoria:</label><br/>
            <input type="text" name="categoria">
            <br/><br/>
            
            <button type="submit">Enviar</button>
            
        </form>
        
    </body>
</html>
