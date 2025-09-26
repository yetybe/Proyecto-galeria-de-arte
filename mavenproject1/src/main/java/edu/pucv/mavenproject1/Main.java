/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.pucv.mavenproject1;

/**
 *
 * @author Benja
 */
import java.io.*;
import java.util.*;
import entidades.Artista;
import entidades.Exposicion;
import entidades.ObraArte;
import javax.swing.SwingUtilities;

public class Main {
    // Listas para almacenar los datos
    private static List<Artista> artistas = new ArrayList<>();
    private static List<ObraArte> obras = new ArrayList<>();
    private static Map<Integer, Exposicion> exposiciones = new HashMap<>();
    
    public static void main(String[] args)throws IOException
    {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                // Pasar las listas vacías al MenuPrincipal
                VentanaMain menu = new VentanaMain();
                menu.setVisible(true);
            }
        });
    }
    
    
    public void crearExposicion() {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el id de la nueva exposicion:");
    int numId = scanner.nextInt();
    scanner.nextLine(); 

    
    System.out.println("Ingrese el nombre de la nueva exposicion:");
    String name = scanner.nextLine();
    
    System.out.println("Ingrese la fecha de inicio de la nueva exposicion:");
    String dateBeggin = scanner.nextLine();
    
    System.out.println("Ingrese la fecha de termino de la nueva exposicion:");
    String dateEnd = scanner.nextLine();
    
    Exposicion newExpo = new Exposicion(numId , name , dateBeggin , dateEnd  );

    exposiciones.put(numId, newExpo);
    System.out.println("\n¡Exposición '" + name + "' creada exitosamente!");
           
    
}
    
    public void eliminarExposicion(){
       
    if (exposiciones.isEmpty()) {
        System.out.println("No hay exposiciones creadas para eliminar.");
        return; 
    }
    
    Scanner scan = new Scanner(System.in);
    
    System.out.println("Ingrese el id de la exposicion que desea eliminar:");
    int id = scan.nextInt();
    
    if (exposiciones.containsKey(id)) {
        
     
        Exposicion exposicionEliminada = exposiciones.remove(id);
        
        System.out.println("\n¡Éxito! La exposición '" + exposicionEliminada.getNombre() + "' (ID: " + id + ") ha sido eliminada.");
        
    } else {
        
        System.out.println("\nError: No se encontró ninguna exposición con el ID " + id + ".");
    }
    
    
   }
   
    public void mostrarExposicion(){
        
        if (exposiciones.isEmpty()) {
        System.out.println("No hay exposiciones creadas para eliminar.");
        return; 
        }
        
        Scanner scan = new Scanner(System.in);
        System.out.println("Ingrese el id de la exposicion que desea buscar:");
        int id = scan.nextInt();
        
        if (exposiciones.containsKey(id)) {
        
     
        Exposicion infoExpo = exposiciones.get(id);
        
        System.out.println("\n--- Información de la Exposición ---");
        System.out.println("ID: " + infoExpo.getId());
        System.out.println("Nombre: " + infoExpo.getNombre());
        System.out.println("Fecha de Inicio: " + infoExpo.getFechaIn());
        System.out.println("Fecha de Fin: " + infoExpo.getFechaFin());
        
        System.out.println("\n--- Obras en esta Exposición ---");
        List<ObraArte> obrasEnExpo = infoExpo.getObras(); // Suponiendo que tienes un getObras()
        
        if (obrasEnExpo.isEmpty()) {
            System.out.println("Esta exposición aún no tiene obras asignadas.");
        } else {
            // Si hay obras, las recorremos y mostramos
            for (ObraArte obra : obrasEnExpo) {
                System.out.println(" -> ID Obra: " + obra.getId() + " | Título: " + obra.getTitulo() + " | Artista: " + obra.getArtista());
            }
        }
        System.out.println("------------------------------------");
        
    } 
    else {
    
        System.out.println("\nError: No se encontró ninguna exposición con el ID " + id + ".");
   
        }
}
        
        
        
        
        
        
        
 
            

   
   
   
    
    
}
