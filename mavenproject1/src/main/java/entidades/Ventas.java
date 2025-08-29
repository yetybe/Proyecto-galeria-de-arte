/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Ventas {
    
    private Map<Integer, ObraArte> obrasAlaVenta;
    private float fondosGaleria;
    
    public Ventas(float fondosIniciales) {
        obrasAlaVenta = new HashMap<>();
        fondosGaleria = fondosIniciales; // Inicializar con los fondos proporcionados
    }
    
    public void agregarObra(ObraArte obra) {
        if (obra == null) return;
        obrasAlaVenta.put(obra.getId(), obra); 
    }
    
    public void eliminarObra(int idObra) { 
        obrasAlaVenta.remove(idObra);
    }
    
    public ObraArte buscarObra(int idObra) { 
        return obrasAlaVenta.get(idObra);
    }
    
    public boolean contieneObra(int idObra) { 
        return obrasAlaVenta.containsKey(idObra);
    }
    
    public void venderObra() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            
            System.out.print("Ingrese el ID de la obra que desea vender: ");
            int id = Integer.parseInt(reader.readLine());
            
            
            ObraArte obra = buscarObra(id);
            
            if (obra != null) {
                
                float precioVenta = obra.getPrecio(); 
                
                
                eliminarObra(id);
                
              
                fondosGaleria += precioVenta;
                
                // Mensaje de éxito
                System.out.println("bra vendida con éxito!");
                System.out.println("Obra: " + obra.getTitulo()); 
                System.out.println("Precio: $" + precioVenta);
                System.out.println("Fondos actualizados: $" + fondosGaleria);
                
            } else {
                System.out.println("No se encontró ninguna obra con ID: " + id);
            }
            
        } catch (NumberFormatException e) {
            System.out.println("❌ Error: Debe ingresar un número válido para el ID");
        } catch (IOException e) {
            System.out.println("❌ Error de lectura: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el reader");
            }
        }
    }
    
    
    public void mostrarFondos() {
        System.out.println("Fondos actuales de la galería: $" + fondosGaleria);
    }
    
    
    public float getFondosGaleria() {
        return fondosGaleria;
    }
}
    
