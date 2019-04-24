/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;


import excepciones.DniInvalidoException;
import java.time.LocalDate;

/**
 *
 * @author 1DAM
 */
public class Camarero {
    private String dni;
    private String nombre;

   private String TipoDeCamarero;

    public Camarero(String dni, String nombre , String TipoDeCamarero) throws DniInvalidoException {
        setDni(dni);
        this.nombre = nombre;
        this.TipoDeCamarero = TipoDeCamarero;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) throws DniInvalidoException {
       if (dni.length() != 9) {
            throw new DniInvalidoException("El DNI ha fallado");
        }
        this.dni = dni;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   

    public String getTipoDeCamarero() {
        return TipoDeCamarero;
    }

    public void setTipoDeCamarero(String TipoDeCamarero) {
        this.TipoDeCamarero = TipoDeCamarero;
    }
    
}
