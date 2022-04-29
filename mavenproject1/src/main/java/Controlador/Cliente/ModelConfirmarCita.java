/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Cliente;

import Modelo.Cita;

/**
 *
 * @author Dell
 */
public class ModelConfirmarCita {
    Cita cita;

    public ModelConfirmarCita(Cita cita) {
        this.cita = cita;
    }

    public ModelConfirmarCita() {
        cita = null;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    @Override
    public String toString() {
        return "ModelConfirmarCita{" + "cita=" + cita + '}';
    }
    
}
