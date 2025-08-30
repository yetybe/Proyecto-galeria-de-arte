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


public class Prestamos {
    
    private Map<Integer , ObraArte> obrasPrestamo; 
    public Prestamos()
    {
        obrasPrestamo = new HashMap<>();
    }
    
    public void agregarObra(ObraArte obra) {
    if (obra == null) return ;
    obrasPrestamo.put(obra.getId(), obra); 
    }
    
    public void  eliminarObra(int idObra) { 
        obrasPrestamo.remove(idObra);
    }
    
    public ObraArte buscarObra(int idObra) { 
        return obrasPrestamo.get(idObra);
    }
    
    // Sobrecarga de métodos: buscar obra por ID y muestra un mensaje
    public ObraArte buscarObra(int idObra, String mensaje)
    {
        ObraArte obra = obrasPrestamo.get(idObra);
        if(obra != null)
        {
            System.out.println(mensaje + ": " + obra.getTitulo());
        }
        else
        {
            System.out.println(mensaje + ": No se encontró la obra con el ID: " + idObra);
        }
        return obra; 
    }
    
    public boolean contieneObra(int idObra) { 
        return obrasPrestamo.containsKey(idObra);
    }
    
    public boolean realizarPrestamo(int idObra)
    {
        ObraArte obra = buscarObra(idObra);
        if (obra != null)
        {
            eliminarObra(idObra);
            System.out.println("Préstamo realizado con éxito");
            System.out.println("Obra: " + obra.getTitulo());
            return true;
        }
        else
        {
            System.out.println("No se encontró ninguna obra con ID: " + idObra);
            return false;
        }
    }
    
}
