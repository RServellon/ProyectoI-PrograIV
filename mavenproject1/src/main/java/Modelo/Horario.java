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
    private Fecha hora_inicio = new Fecha();
    private Fecha hora_final = new Fecha();
    private String frecuencia;

    public Horario() {
    }

    public Horario(String id_medico, String fechaHora_inicio, String fechaHora_final, String frecuencia) {
        this.id_medico = id_medico;
        this.frecuencia = frecuencia;
        this.hora_inicio.setFechaHora(fechaHora_inicio);
        this.hora_inicio.setFechaHora(fechaHora_final);
    }



    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }


    public String getHora_inicioString() {
        return this.hora_inicio.toString();
    }
    
    public Fecha getHora_inicio() {
        return this.hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio.setFechaHora(hora_inicio);
    }

    public String getHora_finalString() {
        return hora_final.toString();
    }
    
    public Fecha getHora_final() {
        return hora_final;
    }
    
    public void setHora_final(String hora_final) {
        this.hora_final.setFechaHora(hora_final);
    }

    public String getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    @Override
    public String toString() {
        return "Horario{" + "id_medico=" + id_medico + ", horaFechaInicio=" + hora_inicio.toString() + ", horaFechaFinal=" + hora_final.toString() + ", frecuencia=" + frecuencia + '}';
    }
}
