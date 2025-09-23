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
import entidades.ObraArte;
import entidades.LectorCVS;

public class Main {
    // Listas para almacenar los datos
    private static List<Artista> artistas = new ArrayList<>();
    private static List<ObraArte> obras = new ArrayList<>();
    
    public static void mostrarMenu() {
        System.out.println("\n--------Menu Galeria--------");
        System.out.println("1. Agregar Obra");
        System.out.println("2. Mostrar Inventario");
        System.out.println("3. Cargar datos desde CSV");
        System.out.println("0. Salir");
        System.out.println("----------------------------");
    }
    
    public static void main(String[] args)throws IOException
    {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        
        int opcion;
        
        do {
            mostrarMenu();
            System.out.print("Ingrese su Opción: ");
            
            opcion = Integer.parseInt(scan.readLine());
                
            switch(opcion) {
                case 1:
                    agregarObraManual(scan);
                    break;            
                    
                case 2:
                    mostrarInventario();
                    break;
                    
                case 3:
                    cargarDesdeCSV();
                    break;
                    
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("Opción no válida");
                }
            
        } while(opcion != 0);
    }
    
    private static void agregarObraManual(BufferedReader scan)throws IOException
    {
        System.out.println("Ingrese ID de la Obra :");
        int id = Integer.parseInt(scan.readLine());
        
        System.out.println("Ingrese Titulo de la Obra :");
        String titulo = scan.readLine();
        
        System.out.println("Ingrese ID del Artista");
        int idArtista = Integer.parseInt(scan.readLine());
        
        System.out.println("Ingrese Artista de la Obra :");
        String artist = scan.readLine();
        
        System.out.println("Ingrese Año de la Obra :");
        int ano = Integer.parseInt(scan.readLine());
        
        System.out.println("Ingrese precio de la Obra :");
        float precio = Float.parseFloat(scan.readLine());
        
        ObraArte nuevaObra = new ObraArte(id, titulo, artist, ano, precio);
        obras.add(nuevaObra);
        
        for(Artista aux: artistas)
        {
            if(aux.getId() == idArtista)
            {
                aux.agregarObra(nuevaObra);
                return;
            }
        }
    }
    
    private static void mostrarInventario()
    {
        for(Artista temp: artistas)
        {
            System.out.println("========================");
            System.out.println("ID :" + temp.getId());
            System.out.println("Artista :" + temp.getNombre());
            System.out.println("Nacionalidad :" + temp.getNacionalidad());
            System.out.println("========================");
            System.out.println("Obras del Artista");
            System.out.println("========================");
            for(ObraArte temp2: temp.getObras())
            {
                System.out.println("ID Obra :" + temp2.getId());
                System.out.println("Titulo :" + temp2.getTitulo());
                System.out.println("Año :" + temp2.getAnio());
                System.out.println("Precio :" + temp2.getPrecio());
                if(temp2.getDisponibilidad())
                {
                    System.out.println("Disponible");
                }
                
                else
                {
                    System.out.println("No Disponible");
                }
            }
            System.out.println("========================");
        }
    }
    
    private static void cargarDesdeCSV()throws IOException
    {
        // Usar el lector CSV
        Map<String, Object> datos = LectorCVS.leerDatosDesdeCSV();
        List<Artista> nuevosArtistas = (List<Artista>) datos.get("artistas");
        List<ObraArte> nuevasObras = (List<ObraArte>) datos.get("obras");
        
        // Agregar a las listas existentes (evitando duplicados)
        for (Artista nuevoArtista : nuevosArtistas)
        {
            boolean existe = false;
            for (Artista artistaExistente : artistas)
            {
                if (artistaExistente.getId() == nuevoArtista.getId())
                {
                    existe = true;
                    break;
                }
            }
            if (!existe)
            {
                artistas.add(nuevoArtista);
            }
        }
            
        obras.addAll(nuevasObras);
            
        System.out.println("Datos cargados exitosamente:");
        System.out.println("- Artistas agregados: " + nuevosArtistas.size());
        System.out.println("- Obras agregadas: " + nuevasObras.size());
        
    }
}
