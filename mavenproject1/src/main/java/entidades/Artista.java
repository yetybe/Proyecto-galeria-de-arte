/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List; 

/**
 *
 * @author Benja
 */
public class Artista {

    private int id;
    private String nombre;
    private String nacionalidad;
    private List<ObraArte> obras;
    
    public Artista(int id, String nombre, String nacionalidad) 
    {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        this.obras = new ArrayList<>(); //
    
       
    }
    
     public int getId() 
        {
            return id;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public String getNacionalidad() {
            return nacionalidad;
        }
    
    
        public List<ObraArte> getObras() {
            return new ArrayList<>(obras); 
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
    
        public void setNacionalidad(String nacionalidad) 
        {
            this.nacionalidad = nacionalidad;
        }
        
       public void agregarObra(ObraArte obra)
       {
          if (obra == null) return;
          obras.add(obra);
       }
       
       
       
      
        public boolean eliminarObra(int idObra)
        {
            return obras.removeIf(obra -> obra.getId() == idObra);
        }
        
    public ObraArte buscarObra(int id) 
    {
        List<ObraArte> aux = getObras();
        for (ObraArte obra : aux) {
            if (obra.getId() == id) {
                return obra;
            }
        }
        return null;
    }
        
        
        
               

}
    

