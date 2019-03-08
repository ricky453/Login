/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appreg.Clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * @author danny
 */

public class ControladorLogin {
    static Conexion cn;
    static ResultSet rs;
    private static boolean cambio;

    public static boolean isCambio() {
        return cambio;
    }

    public static void setCambio(boolean cambio) {
        ControladorLogin.cambio = cambio;
    }
    
    public static void Agregar(Login pv)throws Error{
        try {
            cn=new Conexion();
            cn.st.executeUpdate("INSERT INTO empleado(CODIGO, NOMBRE, APELLIDO, EMAIL, USERNAME, PASSWORD) VALUES('"+pv.getCodigo()+"','"+pv.getNombre()+"','"+pv.getApellido()+"','"+pv.getEmail()+"','"+pv.getUsername()+"','"+pv.getPassword()+"')");
            
        } catch (SQLException ex) {
            throw new Error("Class ControladorLogin/Agregar", ex.getMessage());
        }
    }
    
    public static int ObtenerMax()throws Error{
        int Usuario=0;   
        cn = new Conexion();
        try {
        rs = cn.st.executeQuery("SELECT max(CODIGO) FROM empleado");
        
            while(rs.next()){
                Usuario = rs.getInt(1);
            }
        }catch (Exception ex){
            throw new Error("Class ControladorLogin/ObtenerMax", ex.getMessage());
        } 
        return Usuario;
    
    }
    public static ArrayList<Login> Obtener()throws Error{
    ArrayList<Object> usuario = new ArrayList<Object>();
    
            cn=new Conexion();   
            try { 
                rs=null;
            rs=cn.st.executeQuery("SELECT * FROM empleado");
            while (rs.next()) {
 
                usuario.add(rs.getString(1));
                usuario.add(rs.getString(2));
                usuario.add(rs.getString(3));
                usuario.add(rs.getString(4));
                usuario.add(rs.getString(5));
            }
            
        } catch (SQLException e) {
            throw new Error("Class ControladorLogin/Obtener",e.getMessage());
        }
        
        ArrayList<Login> usuarios=(ArrayList) usuario;
        return usuarios;
    }
    public static int ObtenerIdUser(String username) throws Error{
        cn = new Conexion();
        int id=0;
        try {
            rs = null;
            rs = cn.st.executeQuery("SELECT CODIGO FROM empleado WHERE USERNAME="+"'"+username+"';");
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
            throw  new Error("Class ControladorLogin/ObtenerCodigo", e.getMessage());
        }
        return id;
    }
    
    public static String ObtenerPass(String id)throws Error{
        String Usuario="";   
        cn = new Conexion();
        try {
        rs = cn.st.executeQuery("SELECT PASSWORD FROM empleado WHERE USERNAME='"+id+"';");
            while(rs.next()){
                Usuario = rs.getString(5);
            }
        }catch (Exception ex){
            throw new Error("Class ControladorLogin/ObtenerPass", ex.getMessage());
        } 
        return Usuario;
    
    }
}
