/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Benja
 */

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ventas {
    
    private Map<Integer , ObraArte> obrasAlaVenta;
    private float fondosGaleria;
    
    public Ventas(float fondos )
    {
        obrasAlaVenta = new HashMap<>();
        fondosGaleria = 0;
    }
    
    public void agregarObra(ObraArte obra) {
    if (obra == null) return ;
    obrasInventario.put(obra.getId(), obra); 
    }
    
    public void  eliminarObra(int idObra) { 
        obrasInventario.remove(idObra);
    }
    
    public ObraArte buscarObra(int idObra) { 
        return obrasInventario.get(idObra);
    }
    
    public boolean contieneObra(int idObra) { 
        return obrasInventario.containsKey(idObra);
    }
    
    public void venderObra(int )
    {
        int id;
        System.out.printf("Ingrese el id de la obra que desee vender :");
        
        
        
    }
    
    
}