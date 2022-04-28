/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Calificacion;
import Modelo.Cita;
import Modelo.DAO.SQLConnection.SQLExecutor;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author rebec
 */
public class PacienteHandler extends GeneralHandler {
    public PacienteHandler() {
        this.executor = new SQLExecutor(usernameBD, passwordBD);
    }
    
    
      public boolean registrarCita(String codigo, String id_medico, String id_paciente, String fechaHora, String anotaciones){
        if(this.verificaUsuarioExiste(id_medico) && this.verificaUsuarioExiste(id_paciente)){
             try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores1[] = new String[7];
                valores1[0] = "insert into citas(codigo, id_medico, id_paciente, fechaHora, estado, anotaciones) values (?, ?, ?, ?, ?, ?);";
                valores1[1] = codigo;
                valores1[2] = id_medico;
                valores1[3] = id_paciente;
                valores1[4] = fechaHora; // con este formato 2022-04-10 16:00:00
                valores1[5] = "REGISTRADO"; // todas las citas empiezan siendo registradas
                valores1[6] = anotaciones;

                executor.prepareStatement(valores1);
                return true;

            } catch(Exception throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }
    
    public boolean borrarCita(String codigo){
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            String valores[] = new String[2];
            valores[0] = "delete from citas where codigo = ?;";
            valores[1] = codigo;
            executor.prepareStatement(valores);
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
          return false;
    }
    
    public boolean cambiarEstadoCita(String codigo, String estado){
        try{
            String valores1[] = new String[3];
            valores1[0] = "update citas set estado = ? where codigo = ?;";
            valores1[1] = estado;
            valores1[2] = codigo;

            executor.prepareStatement(valores1);
            return true;
            
         } catch(Exception throwables){
                throwables.printStackTrace();
            }
        return false;
    }
    
     public boolean registrarCalificacion(String idMedico, String idPaciente, String calificacion){
            try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores1[] = new String[4];
                valores1[0] = "insert into calificaciones(id_medico, id_paciente, calificacion) values (?, ?, ?);";
                valores1[1] = idMedico;
                valores1[2] = idPaciente;
                valores1[3] = calificacion;

                executor.prepareStatement(valores1);
                return true;

            } catch(Exception throwables){
                throwables.printStackTrace();
            }
        
         return false;
    }
     
     public boolean borrarCalificacion(String idMedico, String idPaciente){
          try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            String valores[] = new String[3];
            valores[0] = "delete from calificaciones where id_medico = ? and id_paciente = ?;";
            valores[1] = idMedico;
            valores[2] = idPaciente;

            executor.prepareStatement(valores);
            return true;
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
          return false;
     }
    
    public boolean cambiarCalificacion(String idMedico, String idPaciente, String calificacion){
        try{
            String valores1[] = new String[4];
            valores1[0] = "update calificaciones set calificacion = ? where id_medico = ? and id_paciente = ?;";
            valores1[1] = calificacion;
            valores1[2] = idMedico;
            valores1[3] = idPaciente;

            executor.prepareStatement(valores1);
            return true;
            
         } catch(Exception throwables){
                throwables.printStackTrace();
            }
        return false;
    }
    
   

}
