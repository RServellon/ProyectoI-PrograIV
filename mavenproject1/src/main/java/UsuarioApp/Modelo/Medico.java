/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UsuarioApp.Modelo;

import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author norma
 */
public class Medico {
    private String id;
    private String nombre;
    private String especialidad;
    private String ciudad;
    private Double costoConsulta;
    private constructorDeHorario horario;
    private String rutaFotoPerfil;
    private String resena;

    public Medico(String id, String nombre, String especialidad, String ciudad, Double costoConsulta, constructorDeHorario horario, String rutaFotoPerfil, String resena) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.ciudad = ciudad;
        this.costoConsulta = costoConsulta;
        this.horario = horario;
        this.rutaFotoPerfil = rutaFotoPerfil;
        this.resena = resena;
    }
    
    //sets

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

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

    @Override
    public String toString() {
        return "Medico{" + "id=" + id + ", nombre=" + nombre + ", especialidad=" + especialidad + ", ciudad=" + ciudad + ", costoConsulta=" + costoConsulta + ", horario=" + horario + ", rutaFotoPerfil=" + rutaFotoPerfil + ", resena=" + resena + '}';
    }

    public Medico() {
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
