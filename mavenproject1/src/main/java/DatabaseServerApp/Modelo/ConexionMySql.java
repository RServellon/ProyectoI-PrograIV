/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DatabaseServerApp.Modelo;

import com.mysql.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author norma
 */
public class ConexionMySql {
    
    public static String url = "jdbc:mysql://localhost/proyecto1";
    public static String usuario = "sa";
    public static String clave = "password";
    public static String clase = "com.mysql.jdbc.Driver";
    PreparedStatement ps = null;
    
    public static Connection conectar() {
        Connection conexion = null;
        try {
            Class.forName(clase);
            conexion = (Connection) DriverManager.getConnection(url, usuario, clave);
            System.out.println("Conexion establecida..");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
        return conexion;
    }
    
    
    
    
    public ResultSet ejecutarConsulta(String sql) throws Exception {
        Statement st = null;
        st = conectar().createStatement();
        ResultSet rs = st.executeQuery(sql);
        return rs;
    }
    
    
    
    
    public int ejecutarActualizacionP(String sql, Object[] params) throws SQLException {
        ps = conectar().prepareStatement(sql);
        //definir los valores para los argumentos
        for (int i = 0; i < params.length; i++) {
            ps.setObject(i + 1, params[i]);
        }
        int r = ps.executeUpdate(); //retorna la cantidad de registros actualizados    
        return r;
    }
    
    
    public void desconectar() throws SQLException {
        conectar().close();
    }

    
}
