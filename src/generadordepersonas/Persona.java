/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadordepersonas;

/**
 *
 * @author juani
 */
public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private String genero;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String dni, String genero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Nombre=" + nombre + " apellidos=" + apellidos + " dni=" + dni + " genero=" + genero;
    }
    
    
    
}
