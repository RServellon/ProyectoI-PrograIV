/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Modelo.DAO.SQLConnection.SQLExecutor;
import Modelo.Especialidad;

/**
 *
 * @author rebec
 */
public class AdminHandler extends GeneralHandler {
    
    // admitir medicos, agregar ciudades, agregar especialidades
    // listar medicos por estado, listar ciudades y epsecialidades
    
    public AdminHandler(){
        this.executor = new SQLExecutor(usernameBD, passwordBD);
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
}
