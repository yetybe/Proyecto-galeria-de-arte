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


public class Inventario {
    
    private Map<Integer , ObraArte> obrasInventario; 
     
    public Inventario()
    {
        obrasInventario = new HasMap<>();
         
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
    
    
}
    
    
    

