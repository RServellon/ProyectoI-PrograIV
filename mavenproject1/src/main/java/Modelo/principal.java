/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Modelo.DAO.MedicoHandler;
import java.util.List;

/**
 *
 * @author Dell
 */
public class principal {
    public static void main (String [ ] args) {
        Fecha fecha = new Fecha("2020-09-12 09:40:30.0");
        System.out.println("fecha1: "+fecha.getFecha());
        System.out.println("fecha2: "+fecha.getFormatoyyyyMMdd());
        System.out.println("fecha3: "+fecha.toString());
        System.out.println("fecha5: "+fecha.getHoraHHMMSS());
        System.out.println("fecha6: "+fecha.getHoraHHMMSS2());
        System.out.println("fecha7: "+fecha.getFormatoyyyyMMdd2());
        System.out.println("fecha8: "+fecha.getFormatoyyyyMMdd2()+" "+fecha.getHoraHHMMSS2());
        String fechaHora = fecha.getFormatoyyyyMMdd2()+ " " + fecha.getHoraHHMMSS2();
         Fecha fecha2 = new Fecha(fechaHora);
          System.out.println("fecha1: "+fecha2.getFecha());
        }
}
