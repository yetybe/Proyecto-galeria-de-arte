/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author dmena
 */
import entidades.Artista;
import entidades.ObraArte;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LectorCSV {
    
    public static Map<String, Object> leerDatosDesdeCSV(String rutaArchivo) throws IOException {
        List<Artista> artistas = new ArrayList<>();
        List<ObraArte> obras = new ArrayList<>();
        Map<Integer, Artista> mapaArtistas = new HashMap<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            boolean primeraLinea = true;
            
            while ((linea = br.readLine()) != null) {
                // Saltar la primera línea si es el encabezado
                if (primeraLinea) {
                    primeraLinea = false;
                    continue;
                }
                
                // Dividir la línea por comas
                String[] datos = linea.split(",");
                
                if (datos.length >= 6) {
                    try {
                        // Leer datos del artista
                        int idArtista = Integer.parseInt(datos[0].trim());
                        String nombreArtista = datos[1].trim();
                        String nacionalidad = datos[2].trim();
                        
                        // Leer datos de la obra
                        String idObra = datos[3].trim();
                        String tituloObra = datos[4].trim();
                        int anioObra = Integer.parseInt(datos[5].trim());
                        float precioObra = Float.parseFloat(datos[6].trim());
                        
                        // Crear o recuperar el artista
                        Artista artista;
                        if (mapaArtistas.containsKey(idArtista)) {
                            artista = mapaArtistas.get(idArtista);
                        } else {
                            artista = new Artista(idArtista, nombreArtista, nacionalidad);
                            artistas.add(artista);
                            mapaArtistas.put(idArtista, artista);
                        }
                        
                        // Crear la obra de arte
                        ObraArte obra = new ObraArte(idObra, tituloObra, artista, anioObra, precioObra, true);
                        obras.add(obra);
                        
                    } catch (NumberFormatException e) {
                        System.err.println("Error al convertir número en línea: " + linea);
                    }
                }
            }
        }
        
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("artistas", artistas);
        resultado.put("obras", obras);
        
        return resultado;
    }
}
