/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Cliente;

/**
 *
 * @author Dell
 */
public class ModelBusquedaCita {
    
    String provincia;
    String especialidad;
    
    public ModelBusquedaCita() {
       provincia = "";
        especialidad = "";
    }
    

    public ModelBusquedaCita(String provincia, String especialidad) {
        this.provincia = provincia;
        this.especialidad = especialidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    
}
