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
    
    public boolean contieneObra(int idObra) { 
        return obrasPrestamo.containsKey(idObra);
    }
    
    public realizarPrestamo(int idObra)
    {
        int idPrestado = obrasPrestamo.buscarObra(idObra);
        
    }
    

}
