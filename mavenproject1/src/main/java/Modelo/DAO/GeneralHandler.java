/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.DAO.SQLConnection.SQLExecutor;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * aqui se hace toda la magiia de la conección
 * @author norma
 */
public class GeneralHandler {
    final String usernameBD = "sa";
    final String passwordBD = "password";
    SQLExecutor executor;

    public GeneralHandler() {
        this.executor = new SQLExecutor(usernameBD, passwordBD);
    }
 

    public boolean validarLogin(Usuario usuario){
        String cadena;
        ResultSet resultSet;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            resultSet = executor.ejecutaQuery("select * from usuarios");
            while (resultSet.next()) {
                if (    resultSet.getString("clave").equals(usuario.getClave()) 
                        &&
                        resultSet.getString("id").equals(usuario.getId())) {
                    return true;
                }
            }            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
    public boolean registrarUsuarioGeneral(String username, String id, String password, String tipo){
         if(!verificaUsuarioExiste(id)){
            try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores[] = new String[5];
                valores[0] = "insert into usuarios(id, nombre, clave, tipo) values (?, ?, ?, ?);";
                valores[1] = id;
                valores[2] = username;
                valores[3] = password;
                valores[4] = tipo;
                executor.prepareStatement(valores);
                return true;
            } catch(Exception throwables){
            throwables.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean verificaUsuarioExiste(String id){
        ResultSet resultSet;
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            resultSet = executor.ejecutaQuery("select * from usuarios");
            while(resultSet.next()){
                if(resultSet.getString("id").equals(id)){
                    return true;
                }
            }
        }catch(SQLException exception){
            exception.printStackTrace();
        }
        return false;
    }
    
    public Usuario retornaUserPorId(String id){
        Usuario usuario = new Usuario();
        executor = new SQLExecutor(usernameBD, passwordBD);
        String sql ="select * from usuarios where id = " + id + ";";
        ResultSet rs = executor.ejecutaQuery(sql);
       
        try{
            while(rs.next()){
            usuario.setId(rs.getString("id"));
            usuario.setNombre(rs.getString("nombre"));
            usuario.setClave(rs.getString("clave"));
            usuario.setTipo(rs.getString("tipo"));
            }

        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        return usuario;
    }
}
