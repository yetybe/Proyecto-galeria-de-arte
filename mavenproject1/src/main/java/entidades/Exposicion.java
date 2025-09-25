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
       
        try {
            if (obra == null) {
                throw new IllegalArgumentException("La obra no puede ser nula.");
            }
            if (obrasExhibidas.contains(obra)) {
                throw new IllegalStateException("La obra ya está en la exposición.");
            }
            if (!obra.getDisponibilidad()) {
                throw new IllegalStateException("La obra no está disponible para exhibirse.");
            }

            boolean agregada = obrasExhibidas.add(obra);
            if (agregada) {
                System.out.println("Obra agregada exitosamente: " + obra.getTitulo());
            }
            return agregada;

        } catch (IllegalArgumentException e) {
            System.err.println("Error al agregar obra - Dato inválido: " + e.getMessage());
            return false;
        } catch (IllegalStateException e) {
            System.err.println("Error al agregar obra - Estado inválido: " + e.getMessage());
            return false;
        }
        
    }
  

    
    public boolean eliminarObra(int idObra) {
        try {
            if (idObra <= 0) {
                throw new IllegalArgumentException("El ID debe ser mayor a 0.");
            }

            boolean eliminada = obrasExhibidas.removeIf(obra -> obra.getId() == idObra);

            if (!eliminada) {
                throw new IllegalStateException("No se encontró ninguna obra con ID: " + idObra);
            }

            System.out.println("Obra eliminada exitosamente con ID: " + idObra);
            return true;

        } catch (IllegalArgumentException e) {
            System.err.println("Error al eliminar obra - ID inválido: " + e.getMessage());
            return false;
        } catch (IllegalStateException e) {
            System.err.println("Error al eliminar obra - No encontrada: " + e.getMessage());
            return false;
        }
    }
    
    //Sobrecarga de métodos: elimina por titulo
    public boolean eliminarObra(String titulo) {
        try {
            if (titulo == null || titulo.trim().isEmpty()) {
                throw new IllegalArgumentException("El título no puede ser nulo ni vacío.");
            }

            boolean eliminada = obrasExhibidas.removeIf(obra -> obra.getTitulo().equalsIgnoreCase(titulo));

            if (!eliminada) {
                throw new IllegalStateException("No se encontró ninguna obra con título: " + titulo);
            }

            System.out.println("Obra eliminada exitosamente con título: " + titulo);
            return true;

        } catch (IllegalArgumentException e) {
            System.err.println("Error al eliminar obra - Título inválido: " + e.getMessage());
            return false;
        } catch (IllegalStateException e) {
            System.err.println("Error al eliminar obra - No encontrada: " + e.getMessage());
            return false;
        }
    }
    
    // Métodos adicionales útiles
    public int getCantidadObras() {
        return obrasExhibidas.size();
    }
    
    public boolean contieneObra(ObraArte obra) {
        return obrasExhibidas.contains(obra);
    }
    
    

            
           
    
    
   
}

