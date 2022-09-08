/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yovany
 */
public class Fachada {
    private static String bdUrl = "jdbc:mysql://localhost:3306/museo";  //museo es el nombre de Base de Datos
    private static String user = "root"; // el usuario root en MySql
    private static String password = ""; // La clave del usuario root
    private static Connection conexion = null;
    private static String driver = "com.mysql.jdbc.Driver";
    
    public static Connection getConnection(){
        try {
            if (conexion == null){
                Class.forName(driver);
                conexion = DriverManager.getConnection(bdUrl, user, password);
            }
        } catch (ClassNotFoundException | SQLException ex) {
               System.out.println("Error : " + 
                       ex.getMessage());
        }
        return conexion;
   }
}
