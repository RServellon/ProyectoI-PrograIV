/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.DAO.SQLConnection.SQLExecutor;
import Modelo.Medico;
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
//    final String usernameBD = "sas";
    final String passwordBD = "password";
    SQLExecutor executor;

    public GeneralHandler() {
        this.executor = new SQLExecutor(usernameBD, passwordBD);
    }
 

    public boolean validarLogin(Usuario usuario){
        String cadena;
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery("select * from usuarios");
            while (rs.next()) {
                if (rs.getString("clave").equals(usuario.getClave()) 
                        &&
                        rs.getString("id").equals(usuario.getId())) {
                    return true;
                }
            }            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
    public Usuario retornaUserPorId(String id){
        Usuario usuario = new Usuario();
        String sql ="select * from usuarios where id = " + id + ";";
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery(sql);
            while (rs.next()){
                usuario.setId(id);
                usuario.setNombre(rs.getString("nombre"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setClave(rs.getString("clave"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuario;
    }
    
    public Medico retornaMedicoPorId(String id){
        Usuario user = this.retornaUserPorId(id);
        Medico usuario = new Medico(user);
        String sql1 ="select * from medicos where id = " + id + ";";
        ResultSet rs = null;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery(sql1);
            while (rs.next()){
                usuario.setEspecialidad(rs.getString("especialidad"));
                usuario.setCostoConsulta(Double.parseDouble(rs.getString("costo")));
                usuario.setCiudad(rs.getString("ciudad"));
                usuario.setClinica(rs.getString("clinica"));
                usuario.setEstado(rs.getString("estado"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuario;
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
    
   
}
