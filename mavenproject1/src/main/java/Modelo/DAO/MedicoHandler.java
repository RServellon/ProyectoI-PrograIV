/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Calificacion;
import Modelo.Cita;
import Modelo.DAO.SQLConnection.SQLExecutor;
import Modelo.Horario;
import Modelo.Medico;
import com.sun.tools.javac.util.StringUtils;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rebec
 * ingresar horario, listar horarios, modificar datos, retorna cita por codigo
 * listar citas, listar calificaciones
 * registrar horario, borrar horario-> falta probar
 */
public class MedicoHandler extends GeneralHandler {
    public MedicoHandler() {
        this.executor = new SQLExecutor(usernameBD, passwordBD);
    }
    
    public boolean modificarDatos(String id, String especialidad, String costo, String ciudad, String clinica){
        boolean respuesta = false;
        if(this.verificaUsuarioExiste(id)){
            // El id no se puede cambiar
            // tampoco su estado
            try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores[] = new String[6];
                valores[0] = "update medicos set especialidad = ?, costo = ?, ciudad = ?, clinica = ? where id = ?;";
                valores[1] = especialidad;
                valores[2] = costo;
                valores[3] = ciudad;
                valores[4] = clinica;
                valores[5] = id;
                executor.prepareStatement(valores);
                respuesta = true;
                  
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
        }
        return respuesta;
    }
    
    
     
    
    public List<Cita> listarCitasPorEstado(String estado, String id_medico){
        List<Cita> lista = new ArrayList<>();
        Cita cita = null;
        String sql ="select * from citas where estado = '"+ estado +"' and id_medico = " + id_medico + ";";
        String codigo;
         
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql);
            while(rs.next()){
                codigo = rs.getString("codigo");
                cita = this.retornaCitaPorCodigo(codigo);
                lista.add(cita);
                
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        
        return lista;
    }
    
        
    public List<Calificacion> listarCalificaciones(String id_medico){
        List<Calificacion> lista = new ArrayList<>();
        Calificacion calificacion = null;
        String sql ="select * from calificaciones where id_medico = " + id_medico + ";";
         
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql);
            while(rs.next()){
                calificacion = new Calificacion();
                calificacion.setId_medico(id_medico);
                calificacion.setId_paciente(rs.getString("id_paciente"));
                calificacion.setCalificacion(rs.getString("calificacion"));
                lista.add(calificacion);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        
        return lista;
    }
    
    public boolean registrarHorario(String id_medico, String fechaHoraInicio, String fechaHoraFinal, String frecuencia){
        if(this.verificaUsuarioExiste(id_medico)){
             try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores[] = new String[5];
                valores[0] = "insert into horarios(id_medico, fechaHoraInicio, fechaHoraFinal, frecuencia) values (?, ?, ?, ?);";
                valores[1] = id_medico;
                valores[2] = fechaHoraInicio;// con este formato 2022-04-10 16:00:00
                valores[3] = fechaHoraFinal;// con este formato 2022-04-10 16:00:00
                valores[4] = frecuencia; 
                executor.prepareStatement(valores);
                return true;
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean verificaHoraRegistrada(String idMedico, String hora){
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery("select * from citas where id_medico = "+idMedico + ";");
            while (rs.next()) {
                //System.out.println("La que viene " + hora);
                //System.out.println("La de la base " + rs.getString("fechaHora").substring(0,5) + rs.getString("fechaHora").substring(6, 16));
                //System.out.println("PRUEBA " + ((rs.getString("fechaHora").substring(0, 5) + rs.getString("fechaHora").substring(6, 11) + rs.getString("fechaHora").substring(12, 16))));
                //System.out.println("P " + rs.getString("fechaHora").charAt(11));
                 if(rs.getString("fechaHora").charAt(11) != '0' && rs.getString("id_medico").equals(idMedico) && (rs.getString("fechaHora").substring(0, 5) + rs.getString("fechaHora").substring(6, 16)).equals(hora)) {
                     return true;
                 }
                 else{
                     if(rs.getString("id_medico").equals(idMedico) &&(rs.getString("fechaHora").substring(0, 5) + rs.getString("fechaHora").substring(6, 11) + rs.getString("fechaHora").substring(12, 16)).equals(hora)){
                         return true;
                     }
                 }
                
            }            
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
    
    
     public Horario retornaHorario(String id_medico, String fechaHoraInicio){
        Horario horario = new Horario();
        String sql ="select * from horarios where id_medico = '" + id_medico + "' and fechaHoraInicio = '" + fechaHoraInicio+ "' ;";
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery(sql);
            while (rs.next()){
                horario.setId_medico(rs.getString("id_medico"));   
                horario.setFechaHoraInicio(rs.getString("fechaHoraInicio"));
                horario.setFechaHoraFinal(rs.getString("fechaHoraFinal"));
                horario.setFrecuencia(rs.getString("frecuencia"));
                
                
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return horario;
    }
     

     
      public boolean borrarHorario(String id_medico, String fechaHoraInicio){
        if(this.verificaUsuarioExiste(id_medico)){
             try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores[] = new String[3];
                valores[0] = "delete from horarios where id_medico = ? and fechaHoraInicio = ?;";
                valores[1] = id_medico;
                valores[2] = fechaHoraInicio;// con este formato 2022-04-10 16:00:00
                executor.prepareStatement(valores);
                return true;
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
    
    
    public List<Horario> listarHorarios(String id_medico){
        List<Horario> lista = new ArrayList<>();
        Horario horario = null;
        String sql ="select * from horarios where id_medico = " + id_medico + ";";
         
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql);
            while(rs.next()){
                horario = new Horario();
                horario.setId_medico(id_medico);
                horario.setFechaHoraInicio(rs.getString("fechaHoraInicio"));
                horario.setFechaHoraFinal(rs.getString("fechaHoraFinal"));
                horario.setFrecuencia(rs.getString("frecuencia"));
                lista.add(horario);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        
        return lista;
    }
}
