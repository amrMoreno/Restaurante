/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author 1DAM
 */
public class Productos {
    private String nombre;
    private TipoProducto tipoDeProducto;
    private float precio;
    
 public enum TipoProducto{
        ENTRANTE,
        MEDIO_ENTRANTE,
        COMIDA_PRINCIPAL,
        REFRESCO,
        VINOS,
        LICORES,
        POSTRES,
        COPAS
    }

    public Productos(String nombre, TipoProducto tipoDeProducto, float precio) {
        this.nombre = nombre;
        this.tipoDeProducto = tipoDeProducto;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoProducto getTipoDeProducto() {
        return tipoDeProducto;
    }

    public void setTipoDeProducto(TipoProducto tipoDeProducto) {
         /*switch (tipoDeProducto) {
            case ("entrantes"):
                this.tipoDeProducto = TipoPlato.ENTRANTE;

                break;
            case ("medio entrante"):
                this.tipoDeProducto = TipoPlato.MEDIO_ENTRANTE;

                break;
            case ("comida principal"):
                this.tipoDeProducto = TipoPlato.COMIDA_PRINCIPAL;

                break;
            case ("refresco"):
                this.tipoDeProducto = TipoPlato.REFRESCO;

                break;
            case ("vino"):
                this.tipoDeProducto = TipoPlato.VINOS;

                break;
           
            case ("licores"):
                this.tipoDeProducto = TipoPlato.LICORES;

                break;
            case ("postres"):
                this.tipoDeProducto = TipoPlato.POSTRES;

                break;
            case ("copa"):
                this.tipoDeProducto = TipoPlato.COPAS;

                break;
                
        }*/
        this.tipoDeProducto = tipoDeProducto;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
   
    
    
    
    
}
