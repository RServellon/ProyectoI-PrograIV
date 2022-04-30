/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Cliente;

import Modelo.Cita;
import Modelo.Usuario;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ModelConfirmarCita {
    Usuario user;
    List<Cita> listCitas;

    public ModelConfirmarCita(Usuario user, List<Cita> listCitas) {
        this.user = user;
        this.listCitas = listCitas;
    }

    public ModelConfirmarCita() {
        user = null;
        listCitas = null;
    }

    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }

    public List<Cita> getListCitas() {
        return listCitas;
    }

    public void setListCitas(List<Cita> listCitas) {
        this.listCitas = listCitas;
    }

    @Override
    public String toString() {
        return "ModelConfirmarCita{" + "user=" + user + ", listCitas=" + listCitas + '}';
    }
    
    public boolean confirmarSesion(){
        if(user.getId() == null){
            return false; //no existe sesion
        }
        return true; //existe sesion
    }
    
    
}
