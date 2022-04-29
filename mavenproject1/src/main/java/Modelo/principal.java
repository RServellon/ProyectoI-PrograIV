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

 //clase de servicio para metodos de ayuda
    ClaseServicio ser = ClaseServicio.instance();
    //llamamos a la clase handler del medico para utilizar sus metodos en base de datos
         MedicoHandler handlerMed = new MedicoHandler();
         List<Medico> medicos = handlerMed.listarMedicoPorProvinciaYEspecialidad("", "Odontologia");
         Especialidad espec;
         List<Horario> listHorarios=null;
         //Lista de lista de horarios para la vista
         List<List<Horario>> liliHorarios = null;

                        //Aquí las instrucciones del método
        listHorarios=handlerMed.listarHorarios(medicos.get(0).getId());
        liliHorarios = ser.retornarListaListaHorarios(listHorarios);
        /*
        Josep
        [[Horario{id_medico=103, horaFechaInicio=SUNDAY, 10 APRIL 2022 8: 0: 0, horaFechaFinal=SUNDAY, 10 APRIL 2022 11: 0: 0, frecuencia=00:30:00.0000000}]]
        Maria Vargas
        [[Horario{id_medico=104, horaFechaInicio=SUNDAY, 10 APRIL 2022 10: 0: 0, horaFechaFinal=SUNDAY, 10 APRIL 2022 12: 0: 0, frecuencia=00:30:00.0000000}], 
        [Horario{id_medico=104, horaFechaInicio=MONDAY, 11 APRIL 2022 4: 0: 0, horaFechaFinal=MONDAY, 11 APRIL 2022 5: 0: 0, frecuencia=00:30:00.0000000}, 
        Horario{id_medico=104, horaFechaInicio=MONDAY, 11 APRIL 2022 15: 0: 0, horaFechaFinal=MONDAY, 11 APRIL 2022 16: 0: 0, frecuencia=00:30:00.0000000}]]
        */
        System.out.println("Lista de Horarios del medico: "+medicos.get(1).getNombre()+"\n"+listHorarios.toString());
        
        System.out.println("\nLista de lista de Horarios:" + "\n" + liliHorarios.toString());
        
        
        
        }
}
