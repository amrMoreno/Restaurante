/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author 1DAM
 */
public class Restaurante {
    private String nombre;
    private String direccion;
    private int numeroMesas;

    public Restaurante(String nombre, String direccion, int numeroMesas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroMesas = numeroMesas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroMesas() {
        return numeroMesas;
    }

    public void setNumeroMesas(int numeroMesas) {
        this.numeroMesas = numeroMesas;
    }
   
}
