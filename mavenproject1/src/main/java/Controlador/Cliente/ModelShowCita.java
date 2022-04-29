/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador.Cliente;

import Modelo.Medico;

/**
 *
 * @author Dell
 */
public class ModelShowCita {
    
    Medico medico;
    String horaCita;
    String fecha;

    public ModelShowCita(Medico medico, String horaCita, String fecha) {
        this.medico = medico;
        this.horaCita = horaCita;
        this.fecha = fecha;
    }

    public ModelShowCita() {
        this.medico = null;
        this.horaCita = "";
        this.fecha = "";
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public String getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(String horaCita) {
        this.horaCita = horaCita;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "ModelShowCita{" + "medico=" + medico + ", horaCita=" + horaCita + ", fecha=" + fecha + '}';
    }
    
    
}
