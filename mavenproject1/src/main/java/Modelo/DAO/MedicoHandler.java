/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.DAO.SQLConnection.SQLExecutor;

/**
 *
 * @author rebec
 */
public class MedicoHandler {
    private final String usernameBD = "sa";
    private final String passwordBD = "password";
    private SQLExecutor executor;

    public MedicoHandler(SQLExecutor executor) {
        this.executor = new SQLExecutor(usernameBD, passwordBD);
    }
    
    
    public boolean registrarMedico(String id, String especialidad, String costo, String ciudad, String clinica, String estado){
         try{
            executor = new SQLExecutor(usernameBD, passwordBD);
           
            String valores[] = new String[7];
            valores[0] = "insert into medicos(id, especialidad, costo, ciudad, clinica, estado) values (?, ?, ?, ?, ?, ?);";
            valores[1] = id;
            valores[2] = especialidad;
            valores[3] = costo;
            valores[4] = ciudad;
            valores[5] = clinica;
            valores[6] = estado;

            executor.prepareStatement(valores);
            return true;
         
            } catch(Exception throwables){
            throwables.printStackTrace();
        }   
        return false;
    }
}
