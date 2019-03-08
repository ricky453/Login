/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appreg.Clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author danny
 */
public class Conexion {
     public Connection conexion;
     public  Statement st;
    
        
            
   
    public  Conexion() throws Error{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "");  
            st = conexion.createStatement();
            
        } catch (Exception e) {
            throw new Error("Conexion.conexion()",e.getMessage());

        }
    }
    
    public Connection conectarBase() throws Error {
      if (conexion == null) {
         try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/Login", "root", "301997");
         } catch (Exception ex) {
            
         }
      }
      return conexion;
   }
    
}
