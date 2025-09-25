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
    try{
        if(idObra <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0");
        }
        if(!obrasInventario.containsKey(idObra)){
            throw new IllegalStateException("No existe una obra con el ID: " + idObra);
        }
   
        ObraArte obraEliminada = obrasInventario.remove(idObra);
        System.out.println("Obra eliminada exitosamente: " + obraEliminada.getTitulo());
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error al eliminar obra - ID inválido: " + e.getMessage());
        } catch (IllegalStateException e) {
            System.err.println("Error al eliminar obra - No encontrada: " + e.getMessage());
        }
    }
    
    public ObraArte buscarObra(int idObra) { 
    try {
        if (idObra <= 0) {
            throw new IllegalArgumentException("El ID debe ser mayor a 0");
        }
            
        ObraArte obra = obrasInventario.get(idObra);
            
        if (obra == null) {
            throw new IllegalStateException("No se encontró ninguna obra con el ID: " + idObra);
        }
            
        System.out.println("Obra encontrada: " + obra.getTitulo());
        return obra;
            
        } catch (IllegalArgumentException e) {
            System.err.println("Error en búsqueda - ID inválido: " + e.getMessage());
            return null;
        } catch (IllegalStateException e) {
            System.err.println("Error en búsqueda - No encontrada: " + e.getMessage());
            return null;
        }
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
    
    
    

