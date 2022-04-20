/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author rebec
 */
public class Ciudad {
    private String codigo;
    private String nombre;
    private String provincia;

    public Ciudad() {
    }

    public Ciudad(String codigo, String nombre, String provincia) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.provincia = provincia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "codigo=" + codigo + ", nombre=" + nombre + ", provincia=" + provincia + '}';
    }
    
    
    
}
