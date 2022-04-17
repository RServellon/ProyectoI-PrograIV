/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UsuarioApp.Modelo.DAO;

import UsuarioApp.Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



/*
 * @author norma
 */
public class LoginDAO {
    boolean rspta = false;
    String sql = "";
    ResultSet rs = null;
 

    public boolean validarLogin(Usuario tm) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto1?useSSL=false", "root", "password");
        sql = "SELECT * from `usuarios` WHERE id=" + tm.getId() + " AND clave='" + tm.getClave() + "'";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();
        rspta = rs.next();
        System.out.println(rs.getString("id"));
        System.out.println(rs.getString("nombre"));
        return rspta;
    }   
}
