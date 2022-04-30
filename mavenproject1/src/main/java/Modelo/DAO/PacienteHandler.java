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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rebec
 */
public class PacienteHandler extends GeneralHandler {
    public PacienteHandler() {
        this.executor = new SQLExecutor(usernameBD, passwordBD);
    }
    
    
      public boolean registrarCita(String codigo, String id_medico, String id_paciente, String fechaHora, String anotaciones){
          System.out.println("entro al metodo: medico="+id_medico+" paciente="+id_paciente);
        if(this.verificaUsuarioExiste(id_medico) && this.verificaUsuarioExiste(id_paciente)){
             System.out.println("entro al metodo 2");
             try{
                executor = new SQLExecutor(usernameBD, passwordBD);
                String valores1[] = new String[7];
                valores1[0] = "insert into citas(codigo, id_medico, id_paciente, fechaHora, estado, anotaciones) values (?, ?, ?, ?, ?, ?);";
                valores1[1] = codigo;
                valores1[2] = id_medico;
                valores1[3] = id_paciente;
                valores1[4] = fechaHora; // con este formato 2022-04-10 16:00:00
                valores1[5] = "ESPERA"; // todas las citas empiezan en espera hasta que el medico confirme
                valores1[6] = anotaciones;

                executor.prepareStatement(valores1);
                System.out.println("entro al metodo 3 true se registro");
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
    
    public List<Cita> listarCitasPorIdPaciente(String id){
        List<Cita> lista = new ArrayList<>();
        Cita cita = null;
        String sql ="select * from citas where id_paciente = "+ id + ";";
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

}
