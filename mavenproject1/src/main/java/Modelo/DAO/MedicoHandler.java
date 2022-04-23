/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Cita;
import Modelo.DAO.SQLConnection.SQLExecutor;
import Modelo.Medico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rebec
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
                valores[0] = "update medicos set especialidad = ?, costo = ?, ciudad = ?, clinica = ? where medicos id = ?;";
                valores[1] = especialidad;
                valores[2] = costo;
                valores[3] = ciudad;
                valores[4] = clinica;
                valores[5] = id;
                executor.prepareStatement(valores);
                  
            } catch(Exception throwables){
                throwables.printStackTrace();
            }
        }
        return respuesta;
    }
    
    public Cita retornaCitaPorCodigo(String codigo){
        Cita cita = new Cita();
        String sql ="select * from citas where codigo = " + codigo + ";";
        ResultSet rs;
        
        try {
            executor = new SQLExecutor(usernameBD, passwordBD);
            rs = executor.ejecutaQuery(sql);
            while (rs.next()){
                cita.setId_medico(rs.getString("id_medico"));   
                cita.setId_paciente(rs.getString("id_paciente"));
                cita.setFecha(rs.getString("fechaHora"));
                cita.setEstado(rs.getString("estado"));
                cita.setAnotaciones(rs.getString("anotaciones"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return cita;
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
    
}
