/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;
import java.util.List;
import java.util.ArrayList;


public class Exposicion {
    
    private int id;
    private List<ObraArte> obrasExhibidas; 
    
    public Exposicion(int id) {
        this.id = id;
        this.obrasExhibidas = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
  
     public List<ObraArte> getObras() {
        return new ArrayList<>(obrasExhibidas); 
    }
    
    
    public boolean agregarObra(ObraArte obra) {
        if (obra == null) {
            return false; 
        }
        if (obrasExhibidas.contains(obra)) {
            return false;
        }
        
        if (!obra.getDisponibilidad()) {
            return false; 
        }
        
        return obrasExhibidas.add(obra);
    }

    
    public boolean eliminarObra(int idObra) {
        return obrasExhibidas.removeIf(obra -> obra.getId() == idObra);
    }
    
    // Métodos adicionales útiles
    public int getCantidadObras() {
        return obrasExhibidas.size();
    }
    
    public boolean contieneObra(ObraArte obra) {
        return obrasExhibidas.contains(obra);
    }
    
   
}

