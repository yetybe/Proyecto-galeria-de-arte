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
        obrasInventario = new HashMap<>();
         
    }
     
    
    /* public void agregarObra(ObraArte obra) {
    if (obra == null) return ;
    obrasInventario.put(obra.getId(), obra); 
    }*/
    
    public void agregarObra(ObraArte obra) {
    try {
        if (obra == null) {
            throw new IllegalArgumentException("La obra no puede ser nula");
        }
        if (obra.getId() <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0");
        }
        if (obrasInventario.containsKey(obra.getId())) {
            throw new IllegalStateException("Ya existe una obra con ID: " + obra.getId());
        }
        
        obrasInventario.put(obra.getId(), obra);
        System.out.println("Obra agregada: " + obra.getTitulo());
        
    } catch (IllegalArgumentException | IllegalStateException e) {
        
        System.err.println("Error al agregar obra: " + e.getMessage());
    } 

}
    
    public void  eliminarObra(int idObra) { 
        obrasInventario.remove(idObra);
    }
    
    public ObraArte buscarObra(int idObra) { 
        return obrasInventario.get(idObra);
    }
    
    //Sobrecarga de métodos: busca por ID y verifica si está disponible 
    public ObraArte buscarObra(int idObra, boolean disponible)
    {
        ObraArte obra = obrasInventario.get(idObra);
        if(obra != null && (!disponible || obra.getDisponibilidad()))
        {
            return obra;
        }
        return null;
    }
    
    public boolean contieneObra(int idObra) { 
        return obrasInventario.containsKey(idObra);
    }
    
    
}
    
    
    

