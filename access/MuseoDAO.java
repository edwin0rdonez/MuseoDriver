/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

/*import java.sql.Connection;
import java.sql.PreparedStatement;*/
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;
import servicios.Fachada;
/**
 *
 * @author Yovany
 */
public class MuseoDAO { //DFata Access Object
    
    public int saveMuseo(Museo museo){
        Connection conexion = null;
        PreparedStatement pstm;
        int resultado;
        resultado = 0;
        try {
            conexion = Fachada.getConnection();
            String sql = "INSERT INTO museo VALUES(?,?)" ;
        
            pstm = conexion.prepareStatement(sql);
            
            pstm.setInt(1, museo.getMu_id());
            pstm.setString(2, museo.getMu_nombre());
            
            resultado = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return resultado;
    }
    
    public int deleteMuseo(int mu_id){
        Connection conexion = null;
        PreparedStatement pstm;
        int resultado;
        resultado = 0;
        try {
            conexion = Fachada.getConnection();
            String sql = "DELETE FROM museo WHERE mu_id = ?" ;
        
            pstm = conexion.prepareStatement(sql);
            
            pstm.setInt(1, mu_id);            
            
            resultado = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return resultado;
    }
    
    public int updateMuseo(Museo museo){
        Connection conexion = null;
        PreparedStatement pstm;
        int resultado;
        resultado = 0;
        try {
            conexion = Fachada.getConnection();
            String sql = "UPDATE INTO museo " +
                    " SET mu_nombre = ? WHERE mu_id = ?";
        
            pstm = conexion.prepareStatement(sql);
                        
            pstm.setString(1, museo.getMu_nombre());
            pstm.setInt(2, museo.getMu_id());
            
            resultado = pstm.executeUpdate();
            
        } catch (SQLException ex) {
            System.out.println("Error : " + ex.getMessage());
        }
        return resultado;
    }    
    
    public ArrayList<Museo> getListMuseos(int mu_id){
        Connection conexion = null;
        PreparedStatement pstm;
        ResultSet rs = null;
        ArrayList<Museo> listMuseos = new ArrayList();
        String sql ="";
        
        conexion = Fachada.getConnection();
        if (mu_id == 0){
            sql = " SELECT * FROM museo ORDER BY mu_id";
        }else{
            sql = " SELECT * FROM museo" + 
                    " WHERE mu_id = ?";
        }
        try {
            pstm = conexion.prepareStatement(sql);
            
            if(mu_id != 0){
                pstm.setInt(1, mu_id);
            }
            
            rs = pstm.executeQuery();
            
            Museo museo = null;
            while(rs.next()){
                museo = new Museo();
                museo.setMu_id(rs.getInt("mu_id"));
                museo.setMu_nombre(rs.getString("mu_nombre"));
                listMuseos.add(museo);
            }
        } catch (SQLException ex) {
            System.out.println("Error  : " + ex.getMessage());
        }
        return listMuseos;
        
    }
}
