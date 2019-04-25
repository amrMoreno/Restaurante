/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.time.LocalDateTime;

/**
 *
 * @author 1DAM
 */
public class Mesa {
    private int numeroMesa;
    private Productos[] productosConsumidos;
    private LocalDateTime fecha;
    private Camarero camarero;

    public Mesa(int numeroMesa, Productos[] productosConsumidos, LocalDateTime fecha, Camarero camarero) {
        this.numeroMesa = numeroMesa;
        this.productosConsumidos = productosConsumidos;
        this.fecha = fecha;
        this.camarero = camarero;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Productos[] getProductosConsumidos() {
        return productosConsumidos;
    }

    public void setProductosConsumidos(Productos[] productosConsumidos) {
        this.productosConsumidos = productosConsumidos;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public Camarero getCamarero() {
        return camarero;
    }

    public void setCamarero(Camarero camarero) {
        this.camarero = camarero;
    }
    
}
