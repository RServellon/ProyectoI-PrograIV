/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 *
 * @author rebec
 */
public class Fecha {
    private LocalDateTime fechaHora;

    public Fecha() {
    }

    public Fecha(String fechaHora) {
        fechaHoraFormateada(fechaHora);
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        fechaHoraFormateada(fechaHora.toString());
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
    
    public String getFechaHoraSinFormato(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(fechaHora);
        return strDate;
    }
    
    
    public void fechaHoraFormateada(String fechaHora){ // "2020-09-12 09:40:30:00"
        DateTimeFormatter f =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
        LocalDateTime dateTime = LocalDateTime.parse(fechaHora, f);
        this.fechaHora = dateTime;
    }

    @Override
    public String toString() {
        return this.getFecha() + " " + this.getHora();
    }
    
    
}
