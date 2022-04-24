/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Time;
import java.time.LocalDateTime;

/**
 *
 * @author norma
 * 
 * Clase encargada de manejar el horario de un médico
 */
public class Horario {
    private String id_medico;
    private Fecha fecha_hora_inicio = new Fecha();
    private Fecha fecha_hora_final = new Fecha();
    private String frecuencia;

    public Horario() {
    }

    public Horario(String id_medico, String fechaHora_inicio, String fechaHora_final, String frecuencia) {
        this.id_medico = id_medico;
        this.frecuencia = frecuencia;
        this.fecha_hora_inicio.setFechaHora(fechaHora_inicio);
        this.fecha_hora_final.setFechaHora(fechaHora_final);
    }



    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }


    public String getFechaHoraInicioString() {
        return this.fecha_hora_inicio.toString();
    }
    
    public Fecha getFechaHoraInicio() {
        return this.fecha_hora_inicio;
    }

    public void setFechaHoraInicio(String hora_inicio) {
        this.fecha_hora_inicio.setFechaHora(hora_inicio);
    }

    public String getFechaHoraFinalString() {
        return fecha_hora_final.toString();
    }
    
    public Fecha getFechaHoraFinal() {
        return fecha_hora_final;
    }
    
    public void setFechaHoraFinal(String hora_final) {
        this.fecha_hora_final.setFechaHora(hora_final);
    }
    
    public String getHoraInicio(){
        return this.fecha_hora_inicio.getHora();
    }
    
    public String getHoraFinal(){
        return this.fecha_hora_final.getHora();
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Horario{" + "id_medico=" + id_medico + ", horaFechaInicio=" + fecha_hora_inicio.toString() + ", horaFechaFinal=" + fecha_hora_final.toString() + ", frecuencia=" + frecuencia + '}';
    }
}
