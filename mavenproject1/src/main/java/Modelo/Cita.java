/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rebec
 */
public class Cita {
    private String id_medico;
    private String id_paciente;
    private LocalDateTime fecha; //LocalDateTime year-month-day HH-mm-ss-ns
    private String estado;
    private String anotaciones;
    
    public Cita() {
    }

    public Cita(String id_medico, String id_paciente, String fecha, String estado, String anotaciones) {
        this.crearFechaHora(fecha);
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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
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
    
    public void crearFechaHora(String fechaHora){ // "2020-09-12 09:40:30:00"
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.from(f.parse(fechaHora));
        this.fecha= dateTime;
    }

    @Override
    public String toString() {
        return "Cita{" + "id_medico=" + id_medico + ", id_paciente=" + id_paciente + ", fecha=" + fecha + ", estado=" + estado + ", anotaciones=" + anotaciones + '}';
    }

 
}
