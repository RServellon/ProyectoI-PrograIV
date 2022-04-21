/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.Ciudad;
import Modelo.DAO.SQLConnection.SQLExecutor;
import Modelo.Especialidad;
import Modelo.Medico;
import Modelo.Usuario;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rebec
 */
public class AdminHandler extends GeneralHandler {
    
    // admitir medicos, agregar ciudades, agregar especialidades
    // listar medicos por estado, listar medicos por especialidad, ubicacion
    // listar ciudades y epsecialidades
    
    public AdminHandler(){
        this.executor = new SQLExecutor(usernameBD, passwordBD);
    }
    
    public boolean aceptarMedico(String id){
        try {
            String valores[] = new String[3];
            valores[0] = "update medicos set estado = ? where id = ?;";
            valores[1] = "ESP";
            valores[2] = id;

            executor.prepareStatement(valores);
            return true;
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
    
    public boolean registrarCiudad(Ciudad ciudad) {
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
           
            String valores[] = new String[4];
            valores[0] = "insert into ciudades(codigo, nombre, provincia) values (?, ?, ?);";
            valores[1] = ciudad.getCodigo();
            valores[2] = ciudad.getNombre();
            valores[3] = ciudad.getProvincia();

            executor.prepareStatement(valores);
            return true;
            
        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    public boolean registrarEspecialidad(Especialidad especialidad) {
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
           
            String valores[] = new String[4];
            valores[0] = "insert into especialidades(codigo, nombre, descripcion) values (?, ?, ?);";
            valores[1] = especialidad.getCodigo();
            valores[2] = especialidad.getNombre();
            valores[3] = especialidad.getDescripcion();

            executor.prepareStatement(valores);
            return true;
            
        } catch(Exception throwables){
            throwables.printStackTrace();
        }   
        return false;
    }
    
    public List<Medico> listarMedicos(){
        List<Medico> lista = new ArrayList<>();
        Medico medico;
        String sql1 ="select * from medicos";
        String id;
       
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql1);
            while(rs.next()){
                id = rs.getString("id");                
                medico = this.retornaMedicoPorId(id);                
                lista.add(medico);
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        return lista;
    }
    
    public List<Medico> listarMedicosPorEstado(String estado){
        List<Medico> lista = new ArrayList<>();
        Medico medico;
        String sql ="select * from medicos where estado = '" + estado + "';";
        String id;
       
        try{
            executor = new SQLExecutor(usernameBD, passwordBD);
            ResultSet rs = executor.ejecutaQuery(sql);
            
            switch(estado){
                case "APRO":
                    while(rs.next()){
                        if(rs.getString("estado").equals("APRO")){
                        id = rs.getString("id");                
                        medico = this.retornaMedicoPorId(id);                
                        lista.add(medico);
                        }
                    }
                break;
                case "ESP":
                     while(rs.next()){
                        if(rs.getString("estado").equals("ESP")){
                        id = rs.getString("id");                
                        medico = this.retornaMedicoPorId(id);                
                        lista.add(medico);
                        }
                    }
                break;
                case "REC":
                     while(rs.next()){
                        if(rs.getString("estado").equals("REC")){
                        id = rs.getString("id");                
                        medico = this.retornaMedicoPorId(id);                
                        lista.add(medico);
                        }
                    }
                break;
                default:
                break;
            }
        } catch(SQLException throwables){
            throwables.printStackTrace();
        }   
        return lista;
    }
   
}
