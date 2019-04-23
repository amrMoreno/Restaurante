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
    private TipoPlato tipoDeProducto;
    private String precio;
    
    
    public enum TipoPlato{
        ENTRANTE,
        MEDIO_ENTRANTE,
        COMIDA_PRINCIPAL,
        REFRESCO,
        VINOS,
        LICORES,
        POSTRES,
    }
    
}
