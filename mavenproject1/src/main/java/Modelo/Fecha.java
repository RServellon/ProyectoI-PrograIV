/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author rebec
 */
public class Fecha {
    private LocalDateTime fechaHora;

    public Fecha() {
    }

    public Fecha(String fechaHora) {
        crearFechaHora(fechaHora);
    }

    public String getFechaHora() {
        return fechaHora.toString();
    }

    public void setFechaHora(String fechaHora) {
        crearFechaHora(fechaHora);
    }
    
    public String getFecha(){
        return fechaHora.getDayOfWeek().toString() + ", "+ fechaHora.getDayOfMonth()+ " " + fechaHora.getMonth().name() + " " + fechaHora.getYear();
    }
    
    public String getHora(){
       int hora = fechaHora.getHour();
       int  min = fechaHora.getMinute();
       int seg = fechaHora.getSecond();
       return  String.format("%d: %d: %d", hora, min, seg);
    }
    
    public void crearFechaHora(String fechaHora){ // "2020-09-12 09:40:30:00"
        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.from(f.parse(fechaHora));
        this.fechaHora = dateTime;
    }

    @Override
    public String toString() {
        return "Fecha{" + "fechaHora=" + this.getFechaHora() + '}';
    }
    
    
}
