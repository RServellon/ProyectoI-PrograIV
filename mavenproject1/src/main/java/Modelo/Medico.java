/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


/**
 *
 * @author norma
 */
public class Medico extends Usuario {
    private String especialidad;
    private String ciudad;
    private double costoConsulta;
    private constructorDeHorario horario;
    private String clinica;
    private String estado;
    private String rutaFotoPerfil;
    private String resena;
    
    
    
    public Medico() {
        
    }

    public Medico(String especialidad, String ciudad, double costoConsulta, constructorDeHorario horario, String clinica, String estado, String rutaFotoPerfil, String resena) {
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.costoConsulta = costoConsulta;
        this.horario = horario;
        this.clinica = clinica;
        this.estado = estado;
        this.rutaFotoPerfil = rutaFotoPerfil;
        this.resena = resena;
    }

    public Medico(String especialidad, String ciudad, double costoConsulta, constructorDeHorario horario, String clinica, String estado, String rutaFotoPerfil, String resena, String id, String nombre, String clave, String tipo) {
        super(id, nombre, clave, tipo);
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.costoConsulta = costoConsulta;
        this.horario = horario;
        this.clinica = clinica;
        this.estado = estado;
        this.rutaFotoPerfil = rutaFotoPerfil;
        this.resena = resena;
    }
   
   

   
    
    //sets


    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
      public void setClinica(String clinica) {
        this.clinica = clinica;
    }
      
     public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCostoConsulta(Double costoConsulta) {
        this.costoConsulta = costoConsulta;
    }

    public void setHorario(constructorDeHorario horario) {
        this.horario = horario;
    }

    public void setRutaFotoPerfil(String rutaFotoPerfil) {
        this.rutaFotoPerfil = rutaFotoPerfil;
    }

    public void setResena(String resena) {
        this.resena = resena;
    }
    
    
    //gets

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Double getCostoConsulta() {
        return costoConsulta;
    }

    public constructorDeHorario getHorario() {
        return horario;
    }

    public String getRutaFotoPerfil() {
        return rutaFotoPerfil;
    }

    public String getResena() {
        return resena;
    }

    public String getClinica() {
        return clinica;
    }

  

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "Medico{" + "especialidad=" + especialidad + ", ciudad=" + ciudad + ", costoConsulta=" + costoConsulta + ", horario=" + horario + ", clinica=" + clinica + ", estado=" + estado + ", rutaFotoPerfil=" + rutaFotoPerfil + ", resena=" + resena + '}';
    }
    
    

   

    
    
    
    
    
    
    
    
    
    
    
    
}
