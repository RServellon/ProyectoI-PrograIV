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
       listMedicos = new ArrayList();
       listMedicos.add(new Medico("Odontologia", "Heredia", 5000, null, "Clinica", "estado", "foto de perfil"));

       listMedicos.add(new Medico("Neurocirugia", "San Jose", 15000, null, "Clinica", "estado", "foto de perfil"));
    }
    
    
    //este metodo me buscara un medico por especialidad y provincia
    public Medico retornarMedico(String especialidad, String provincia){
        for(int i = 0 ; i < listMedicos.size(); i++){
            Medico med = listMedicos.get(i);
            if(med.getEspecialidad() == especialidad && med.getCiudad() == provincia){
              return med;  
            }
        }
       return null; //no existe
    }

}
