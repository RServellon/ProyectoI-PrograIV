/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author norma
 */
public class Modelo {
    Usuario current;
    
    public Modelo() {
        this.reset();
    }

    public void reset() {
        setCurrent(new Usuario());
    }

    public Usuario getCurrent() {
        return current;
    }

    public void setCurrent(Usuario current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return "Modelo{" + "current=" + current + '}';
    }
    
}
