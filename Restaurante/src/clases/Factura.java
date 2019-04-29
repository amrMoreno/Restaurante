/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDateTime;

/**
 *
 * @author Adrian
 */
public class Factura extends Mesa{
     private int numeroMesa;
    private Productos[] productosConsumidos;
    private LocalDateTime fecha;

    public Factura(int numeroMesa, Productos[] productosConsumidos, LocalDateTime fecha, Camarero camarero) {
        super(numeroMesa, productosConsumidos, fecha, camarero);
    }
    
}
