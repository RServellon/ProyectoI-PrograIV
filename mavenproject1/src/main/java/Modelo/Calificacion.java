/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author rebec
 */
public class Calificacion {
    private String id_medico;
    private String id_paciente;
    private String calificacion; //excelente, aceptable, deficiente

    public Calificacion() {
    }

    public Calificacion(String id_medico, String id_paciente, String calificacion) {
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.calificacion = calificacion;
    }

    public String getId_medico() {
        return id_medico;
    }

    public void setId_medico(String id_medico) {
        this.id_medico = id_medico;
    }

    public String getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(String id_paciente) {
        this.id_paciente = id_paciente;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "id_medico=" + id_medico + ", id_paciente=" + id_paciente + ", calificacion=" + calificacion + '}';
    }

    
    
}
