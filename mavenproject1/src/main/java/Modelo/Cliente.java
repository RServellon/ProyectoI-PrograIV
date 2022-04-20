/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author norma
 */
public class Cliente {
    private String nombre;
    //cedula?
    private Usuario usuario;

    public Cliente(String nombre, Usuario usuario) {
        this.nombre = nombre;
        this.usuario = usuario;
    }

    public Cliente() {
        this.nombre = "null";
        this.usuario = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setUsuario(Usuario user) {
        this.usuario = user;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("nombre=").append(nombre);
        sb.append('}');
        return sb.toString();
    }
    
}
