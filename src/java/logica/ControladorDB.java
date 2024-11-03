/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 39GX
 */
public class ControladorDB {
    
    String usuario;
    String contraseña;
    String url;
    java.sql.Connection conexion;
       
    public ControladorDB(String url, String usuario, String contraseña){        
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.url = url; 
        
        
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                this.conexion = DriverManager.getConnection(this.url,this.usuario,this.contraseña);
            } catch (SQLException ex) {
                Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void crear(String codeSql) {
        
        
        
        //
        java.sql.Statement statement = null;
        
        try {
            
            if(this.conexion.isClosed()){
                this.conexion = DriverManager.getConnection(this.url,this.usuario,this.contraseña);
            }
            
            statement = this.conexion.createStatement();
            statement.executeUpdate(codeSql);
                     
        } catch (SQLException ex) {
            System.out.println("error" + ex);
        }
    }
    
    public ResultSet leer(String codeSql) {
        
        java.sql.Statement statement = null;
        
        try {
            if(this.conexion.isClosed()){
                this.conexion = DriverManager.getConnection(this.url,this.usuario,this.contraseña);
            }
            
            statement = this.conexion.createStatement();
            
            ResultSet rs = statement.executeQuery(codeSql);
            
            return rs;
            
            
            
        } catch (SQLException ex) {
            System.out.println("error" + ex);
            
            return null;
        }
    }
    
    
    public void cerrarConexion(){
        try {
            if(!this.conexion.isClosed()) this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
