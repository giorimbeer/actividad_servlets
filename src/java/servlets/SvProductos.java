/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ControladorDB;
import logica.Producto;



@WebServlet(name = "SvProductos", urlPatterns = {"/SvProductos"})
public class SvProductos extends HttpServlet {

    ControladorDB baseDatos = new ControladorDB("jdbc:mysql://localhost:3306/my_proyect","root","");
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Producto> listaProductos  = new ArrayList<>();
        
        //listaProductos.add( new Producto("Ventana", 100000, "Ventana elegante de 1m x 1m", "direccion imagen") );
        //listaProductos.add( new Producto("Puerta", 150000, "puerta masisa de color madera de 180 x 80 cm", "direccion imagen") );
        //listaProductos.add( new Producto("Cocina", 800000, "Cocina integral sencilla compuesta de ....", "direccion imagen") );
        
        
        ResultSet rs = baseDatos.leer("select * from producto");   
        
        try {
            while(rs.next()){
                listaProductos.add( new Producto(rs.getString("nombre") , rs.getInt("precio"),
                        rs.getString("descripcion"), rs.getString("imagen") ) );
            }
        } catch (SQLException ex) {
            Logger.getLogger(SvProductos.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        HttpSession miSesion = request.getSession();
        miSesion.setAttribute("litaProductos", listaProductos);
        
        response.sendRedirect("mostrarProductos.jsp");
        
       baseDatos.cerrarConexion();
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String nombre = request.getParameter("nombre");
        String precio = request.getParameter("precio");
        String descripcion = request.getParameter("descripcion");
        String imagen = request.getParameter("imagen");
        String categoria = request.getParameter("categoria");
             
        baseDatos.crear("insert into producto(precio,imagen,nombre,descripcion,id_Categoria) "
                                    + "values ("+precio+",'"+imagen+"','"+nombre+"','"+descripcion+"',"+categoria+" )");   
        
        
        response.sendRedirect("crearProducto.jsp");
        
        baseDatos.cerrarConexion();
        
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
