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
    private String nombre;
    private String fechaInicio;
    private String fechaFin;
    
    public Exposicion(int id , String nombre , String fechaInicio , String fechaFin ) {
        this.id = id;
        this.obrasExhibidas = new ArrayList<>();
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        
    }
    
    public int getId() {
        return id;
    }
    
    public String getNombre(){
        
       return nombre;
    }
    
    public String getFechaIn(){
        
       return fechaInicio;
    }
    
    public String getFechaFin(){
        
       return fechaFin;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public void setFechaIn(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
    
     public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
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

