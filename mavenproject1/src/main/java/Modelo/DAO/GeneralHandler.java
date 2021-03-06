/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Calificacion;
import Modelo.Ciudad;
import Modelo.DAO.SQLConnection.SQLExecutor;
import Modelo.Especialidad;
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
 * registra usuario general -> falta probar
 * registra usuario segun tipo -> falta probar
 * verifica usuario existe
 * listar medicos por especialidad y ubicacion
 * listar medicos aprobados
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
                if(rs.getString("costo")!=null){
                    usuario.setCostoConsulta(Double.parseDouble(rs.getString("costo")));
                }
                else{
                    usuario.setCostoConsulta(0.00);
                }
                usuario.setCiudad(rs.getString("ciudad"));
                usuario.setClinica(rs.getString("clinica"));
                usuario.setEstado(rs.getString("estado"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return usuario;
    }
    
    public boolean registrarMedico(String id, String especialidad, String costo, String ciudad, String clinica){
          try{
                        executor = new SQLExecutor(usernameBD, passwordBD);
                        String valores1[] = new String[7];
                        valores1[0] = "insert into medicos(id, especialidad, costo, ciudad, clinica, estado) values (?, ?, ?, ?, ?, ?);";
                        valores1[1] = id;
                        valores1[2] = null;
                        valores1[3] = null;
                        valores1[4] = null;
                        valores1[5] = null;
                        valores1[6] = "ESP";
                        //al registrar un medico siempre su estado es espera a aprobaci??n
                        
                        executor.prepareStatement(valores1);
                        return true;

                    } catch(Exception throwables){
                        throwables.printStackTrace();
                    }
          return false;
    }
    
    public boolean registrarAdministrador(String id){
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
         return false;
    }
    
    public boolean registrarPaciente(String id){
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
        
         return false;
    }
    
    
    public boolean registrarUsuario(String username, String id, String password, String tipo){
        if(!verificaUsuarioExiste(id)){
            try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores1[] = new String[5];
                valores1[0] = "insert into usuarios(id, nombre, clave, tipo) values (?, ?, ?, ?)";
                valores1[1] = id;
                valores1[2] = username;
                valores1[3] = password;
                valores1[4] = tipo;
                executor.prepareStatement(valores1);
                
                switch(tipo){
                    case "admin":
                        this.registrarAdministrador(id);
                    break;
                    case "medico":
                        this.registrarMedico(id, null, null, null, null);
                    break;
                    case "paciente":
                        this.registrarPaciente(id);
                    break;
                }
                return true;
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
        
          
        }

        return false;
    }
    
    public boolean borarMedico(String id){
         try{
                     executor = new SQLExecutor(usernameBD, passwordBD);
                    String valores[] = new String[2];
                    valores[0] = "delete from medicos where id = ?;";
                    valores[1] = id;
                    executor.prepareStatement(valores);
                    return true;
                    } catch(Exception throwables){
                        throwables.printStackTrace();
                    }
         return false;
    }
    
    public boolean borarAdmin(String id){
          try{
                    executor = new SQLExecutor(usernameBD, passwordBD);
                    String valores[] = new String[2];
                    valores[0] = "delete from administradores where id = ?;";
                    valores[1] = id;
                    executor.prepareStatement(valores);
                    return true;
                    } catch(Exception throwables){
                        throwables.printStackTrace();
                    }
          return false;
    }
    
    public boolean borrarPaciente(String id){
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            String valores[] = new String[2];
            valores[0] = "delete from pacientes where id = ?;";
            valores[1] = id;
            executor.prepareStatement(valores);
            return true;
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
          return false;
    }
    
        public boolean borrarUsuario(String id, String tipo){
            try{
                switch(tipo){
                    case "admin":
                        this.borarAdmin(id);
                    break;
                    case "medico":
                        this.borarMedico(id);
                    break;
                    case "paciente":
                        this.borrarPaciente(id);
                    break;
                    
                }
                
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores1[] = new String[2];
                valores1[0] = "delete from usuarios where id = ?;";
                valores1[1] = id;
                executor.prepareStatement(valores1);
          
             return true;
            } catch(Exception throwables){
                throwables.printStackTrace();
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
        Medico medico = null;        
        String id;
        ResultSet rs;
        String sql;
              
        
        if(provincia.equals("") && especialidad != null){
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
            if(especialidad.equals("") && provincia != null){
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
   
    public List<Medico> listarMedicosAprobados(){
        List<Medico> lista = new ArrayList<>();
        Medico medico = null;
        String sql ="select * from medicos where estado = 'APRO';";
        String id;
       
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql);
            while(rs.next()){
                if(rs.getString("estado").equals("APRO")){
                    id = rs.getString("id");                
                    medico = this.retornaMedicoPorId(id);                
                    lista.add(medico);
                }
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        return lista;
    }
    
  
    public Especialidad retornaEspecialidadPorCodigo(String codigo){
        Especialidad especialidad = new Especialidad();
        String sql ="select * from especialidades where codigo = " + codigo + ";";
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery(sql);
            while (rs.next()){
                especialidad.setCodigo(codigo);
                especialidad.setNombre(rs.getString("nombre"));
                especialidad.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return especialidad;
    }
    
    public List<Especialidad> listarEspecialidades(){
        List<Especialidad> lista = new ArrayList<>();
        Especialidad especialidad = null;
        String sql ="select * from especialidades;";
        String codigo;
       
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql);
            while(rs.next()){
                codigo = rs.getString("codigo");                
                especialidad = this.retornaEspecialidadPorCodigo(codigo);                
                lista.add(especialidad);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        return lista;
    }
    
    public Ciudad retornaCiudadPorCodigo(String codigo){
        Ciudad ciudad = null;
        String sql ="select * from ciudades where codigo = " + codigo + ";";
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery(sql);
            while (rs.next()){
                ciudad = new Ciudad();
                ciudad.setCodigo(codigo);
                ciudad.setNombre(rs.getString("nombre"));
                ciudad.setProvincia(rs.getString("provincia"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return ciudad;
    }
    
     public List<Ciudad> listarCiudades(){
        List<Ciudad> lista = new ArrayList<>();
        Ciudad ciudad = null;
        String sql ="select * from ciudades;";
        String codigo;
       
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql);
            while(rs.next()){
                codigo = rs.getString("codigo");                
                ciudad = this.retornaCiudadPorCodigo(codigo);                
                lista.add(ciudad);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        return lista;
    }
     
     
      public Calificacion retornaCalificacion(String idMedico, String idPaciente){
        Calificacion calif = new Calificacion();
        String sql ="select * from calificaciones where id_medico = " + idMedico + " and id_paciente = "+ idPaciente + ";";
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery(sql);
            while (rs.next()){
                calif.setId_medico(rs.getString("id_medico"));   
                calif.setId_paciente(rs.getString("id_paciente"));
                calif.setCalificacion(rs.getString("calificacion"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return calif;
    }
}