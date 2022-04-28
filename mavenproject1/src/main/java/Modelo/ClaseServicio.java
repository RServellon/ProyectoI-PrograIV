/*
 ESTA CLASE SIRVE PARA HACER PRUEBAS CON DATOS QUEMADOS, BUSCAR MEDICOS , CLIENTES Y INGRESAR UNOS POR DEFECTO
 */
package Modelo;

import Modelo.DAO.MedicoHandler;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class ClaseServicio {
    private static ClaseServicio uniqueInstance;
    
    public static ClaseServicio instance(){
        if (uniqueInstance == null){
            uniqueInstance = new ClaseServicio();
        }
        return uniqueInstance; 
    }
    
     ArrayList<Medico> listMedicos;
    
    
    private ClaseServicio(){
        
    }
   
    public List<List<Horario>> retornarListaListaHorarios(List<Horario> li){
        //String para almacenar el formato de dia
        String formatoFecha = "";
        List<String> fechasRegistradas = new ArrayList();
         //se insertara aqui una lista distinta segun el dia
        List<List<Horario>> listlistH = new ArrayList();
        for(int i = 0 ; i<li.size() ; i++){
         //se insertara en este los horarios de un unico dia
         List<Horario> listHorariosFijos = new ArrayList();
            //se verifica que la fecha no este en el registro
            if(!fechasRegistradas.contains(li.get(i).getFechaHoraInicio().getFormatoddMMyyyy())){
                formatoFecha = li.get(i).getFechaHoraInicio().getFormatoddMMyyyy();
                //se inserta en el registro
                fechasRegistradas.add(formatoFecha);
             //ingresamos en la lista nueva los horarios que correspondan con la fecha correspondiente
             for(int j = 0 ; j<li.size(); j++){
                 if(formatoFecha.equals(li.get(j).getFechaHoraInicio().getFormatoddMMyyyy())){
                     //agrega el horario
                     listHorariosFijos.add(li.get(j));
                 }
             }
             listlistH.add(listHorariosFijos);
            }
        }
        return listlistH;
    }
    
    public List<String> horasSegunFrecuencia(Horario horario){
        MedicoHandler handler = new MedicoHandler();
        List<String> horas = new ArrayList();
        System.out.println("Antes del for " + horario.getHoraInicialSola() + ", " + horario.getHoraFinalSola());

        for(int i=horario.getHoraInicialSola(); i <= horario.getHoraFinalSola(); i++){
            String f = horario.getFechaHoraInicio().getFormatoyyyyMMdd();
            String fechaA = f.concat(" " + String.valueOf(i) + ":00:");
            System.out.println("Entro: " + fechaA);
            if(handler.verificaHoraRegistrada(horario.getId_medico(), "2022-04-10 16:00:00")){
                horas.add(fechaA);
            }
            if(horario.getFrecuencia().equals("00:30:00") && horario.getHoraFinalSola() != i){
                String fechaB = horario.getFechaHoraInicio().getFormatoyyyyMMdd().concat(" " + String.valueOf(i) + ":30:00");
                horas.add(fechaB);
            }
        }
        return horas;
    }

}
