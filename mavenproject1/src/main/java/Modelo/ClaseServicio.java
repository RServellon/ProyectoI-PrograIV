/*
 ESTA CLASE SIRVE PARA HACER PRUEBAS CON DATOS QUEMADOS, BUSCAR MEDICOS , CLIENTES Y INGRESAR UNOS POR DEFECTO
 */
package Modelo;

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
        Medico med1 = new Medico("Odontologia", "Heredia", 5000, null, "Clinica", "estado", "foto de perfil", "123", "Eren Jaeger", "pass1", "medico");
        Medico med2 = new Medico("Neurocirugia", "Alajuela", 5000, null, "Clinica", "estado", "foto de perfil", "id", "Sanji Vismoke", "pass2", "medico");
        Medico med3 = new Medico("Otorringsdasn", "Guanacaste", 5000, null, "Clinica", "estado", "foto de perfil", "id", "Nami Sandia", "pass2", "medico");
       
        listMedicos = new ArrayList();
        listMedicos.add(med1);
        listMedicos.add(med2);
        listMedicos.add(med3);
        listMedicos.add(med3);
        listMedicos.add(med1);
        listMedicos.add(med1);
        listMedicos.add(med1);
        listMedicos.add(med1);
        
    }
    
    
    //este metodo me buscara medicos por especialidad y provincia
    public ArrayList<Medico> retornarMedico(String especialidad, String provincia){
         ArrayList<Medico> listMedicosFiltrados = new ArrayList();
         for(int i = 0 ; i < listMedicos.size(); i++){
            Medico med = listMedicos.get(i);
            if(med.getEspecialidad().equals(especialidad) && med.getCiudad().equals(provincia)){
              listMedicosFiltrados.add(med);
            }
        }
       return listMedicosFiltrados;
    }

}
