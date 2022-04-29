/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;



/**
 *
 * @author rebec
 */
public class Cita {
    private String id_medico;
    private String id_paciente;
    private Fecha fecha = new Fecha(); //LocalDateTime year-month-day HH-mm-ss-ns
    private String estado;
    private String anotaciones;
    
    public Cita() {
    }

    public Cita(String id_medico, String id_paciente, String fecha, String estado, String anotaciones) {
        this.fecha.setFechaHora(fecha);
        this.id_medico = id_medico;
        this.id_paciente = id_paciente;
        this.estado = estado;
        this.anotaciones = anotaciones;
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

    public String getFechaString() {
        return fecha.toString();
    }
    
    public Fecha getFecha(){
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.setFechaHora(fecha);
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    @Override
    public String toString() {
        return "Cita{" + "id_medico=" + id_medico + ", id_paciente=" + id_paciente + ", fecha=" + fecha.getFechaHora()+ ", estado=" + estado + ", anotaciones=" + anotaciones + '}';
    }
   
}
