<%-- 
    Document   : mostrar
    Created on : 28/10/2024, 6:50:25 p. m.
    Author     : 39GX
--%>

<%@page import="logica.Producto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.List"%>
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
        
        <h1>Lista De Productos</h1>
        
        <%
            List<Producto> listaProductos = (List) request.getSession().getAttribute("litaProductos");
            
            for(Producto producto : listaProductos){
        
        %>
       
        <p>Nombre: <%=producto.getNombre()%> </p>
        <p>Precio: <%=producto.getPrecio()%> </p>
        <p>Descripcion: <%=producto.getDescripcion()%> </p>
        <p>Imagen: <%=producto.getImagen()%> </p>
        <p>----------------------------------</p>
        
        <% } %>
        
    </body>
</html>
