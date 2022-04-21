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
 * validar login, retorna usuario por id, retorna medico por id
 * registra usuario general
 * registra usuario segun tipo
 * verifica usuario existe
 * listar medicos por especialidad, ubicacion
 * listar medicos por especialidad y ubicacion
 */
public class GeneralHandler {
//    final String usernameBD = "sa";
    final String usernameBD = "sas";
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
    
    
    public boolean registrarUsuario(String username, String id, String password, String tipo){
        if(!verificaUsuarioExiste(id)){
            try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores1[] = new String[5];
                valores1[0] = "insert into usuarios(id, nombre, clave, tipo) values (?, ?, ?, ?);";
                valores1[1] = id;
                valores1[2] = username;
                valores1[3] = password;
                valores1[4] = tipo;
                executor.prepareStatement(valores1);
                  
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
            
            switch(tipo){
                case "admin":
                    try{
                        executor = new SQLExecutor(usernameBD, passwordBD);
                        String valores1[] = new String[2];
                        valores1[0] = "insert into administradores(id) values (?);";
                        valores1[1] = id;
                        executor.prepareStatement(valores1);
                        return true;

                    } catch(Exception throwables){
                        throwables.printStackTrace();
                    }
                break;
                case "paciente":
                    try{
                        executor = new SQLExecutor(usernameBD, passwordBD);
                        String valores1[] = new String[2];
                        valores1[0] = "insert into pacientes(id) values (?);";
                        valores1[1] = id;
                        executor.prepareStatement(valores1);
                        return true;

                    } catch(Exception throwables){
                        throwables.printStackTrace();
                    }
                break;
                case "medico":
                    try{
                        executor = new SQLExecutor(usernameBD, passwordBD);
                        String valores1[] = new String[7];
                        valores1[0] = "insert into medicos(id, especialidad, costo, ciudad, clinica, estado) values (?, ?, ?, ?, ?, ?);";
                        valores1[1] = id;
                        valores1[2] = null;
                        valores1[3] = null;
                        valores1[4] = null;
                        valores1[5] = null;
                        valores1[6] = null;
                        
                        executor.prepareStatement(valores1);
                        return true;

                    } catch(Exception throwables){
                        throwables.printStackTrace();
                    }
                break;
                default:
                break;
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
    
   public List<Medico> listarMedicoPorProvinciaYEspecialidad(String provincia, String especialidad){
        List<Medico> lista = new ArrayList<>();
        Medico medico;        
        String id;
        ResultSet rs;
        String sql;
              
        
        if(provincia == null && especialidad != null){
            sql = "select medicos.id, especialidades.nombre from medicos, especialidades where "
                + "especialidades.codigo = medicos.especialidad and especialidades.nombre = '" + especialidad + "' and "
                + "medicos.estado = 'APRO';";
            try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                rs = executor.ejecutaQuery(sql);

                while(rs.next()){
                    id = rs.getString("id");   
                    medico = this.retornaMedicoPorId(id);                
                    lista.add(medico);
                  }
            } catch(SQLException throwables){
                  throwables.printStackTrace();
            }   
        }
        else{
            if(especialidad == null && provincia != null){
                sql = "select medicos.id, ciudades.provincia from medicos, ciudades where "
                    + "ciudades.codigo = medicos.ciudad and ciudades.provincia = '" + provincia + "' and "
                    + "medicos.estado = 'APRO';";
                 
                try{
                    executor = new SQLExecutor(usernameBD, passwordBD);
                    rs = executor.ejecutaQuery(sql);

                    while(rs.next()){
                        id = rs.getString("id");   
                        medico = this.retornaMedicoPorId(id);                
                        lista.add(medico);
                    }
                } catch(SQLException throwables){
                      throwables.printStackTrace();
                }   
            }
            else{
                if(especialidad != null && provincia != null){
                    sql = "select medicos.id, especialidades.nombre, ciudades.provincia from " 
                        + "medicos, especialidades, ciudades where " 
                        + "especialidades.codigo = medicos.especialidad and ciudades.codigo = medicos.ciudad and "
                        + "especialidades.nombre = '"+ especialidad +"' and ciudades.provincia = '"+ provincia + "' and medicos.estado = 'APRO';";
                 
                    try{
                        executor = new SQLExecutor(usernameBD, passwordBD);
                        rs = executor.ejecutaQuery(sql);

                        while(rs.next()){
                            id = rs.getString("id");   
                            medico = this.retornaMedicoPorId(id);                
                            lista.add(medico);
                        }
                    } catch(SQLException throwables){
                          throwables.printStackTrace();
                    }   
                }
            }
        }
        return lista;
    }
}
