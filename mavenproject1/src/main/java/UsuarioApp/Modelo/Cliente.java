/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UsuarioApp.Modelo;

/**
 *
 * @author norma
 */
public class Cliente {
    private String nombre;
    private String clave;
    private String user;
    private String rutaFotoPerfil;

    public Cliente(String nombre, String clave, String user, String rutaFotoPerfil) {
        this.nombre = nombre;
        this.clave = clave;
        this.user = user;
        this.rutaFotoPerfil = rutaFotoPerfil;
    }

    public Cliente() {
        this.nombre = "null";
        this.clave = "null";
        this.user = "null";
        this.rutaFotoPerfil = "null";
    }

    public String getNombre() {
        return nombre;
    }

    public String getClave() {
        return clave;
    }

    public String getUser() {
        return user;
    }

    public String getRutaFotoPerfil() {
        return rutaFotoPerfil;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setRutaFotoPerfil(String rutaFotoPerfil) {
        this.rutaFotoPerfil = rutaFotoPerfil;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("nombre=").append(nombre);
        sb.append(", clave=").append(clave);
        sb.append(", user=").append(user);
        sb.append(", rutaFotoPerfil=").append(rutaFotoPerfil);
        sb.append('}');
        return sb.toString();
    }
    
}
