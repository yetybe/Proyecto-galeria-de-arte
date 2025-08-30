/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dmena
 */
public class LectorCVS
{
    public static Map<String, Object> leerDatosDesdeCSV() throws IOException 
    {
        ArrayList<Artista> artistas = new ArrayList<>();
        ArrayList<ObraArte> obras = new ArrayList<>();
        Map<Integer, Artista> mapaArtistas = new HashMap<>();
        
        BufferedReader br = new BufferedReader(new FileReader(""));
        String linea;
        boolean primeraLinea = true;
            
        while ((linea = br.readLine()) != null)
        {
            if (primeraLinea) {
                primeraLinea = false;
                continue;
            }
            String[] datos = linea.split(",");
            
            if (datos.length >= 6) 
            {
                    
                int idArtista = Integer.parseInt(datos[0]);
                String nombreArtista = datos[1];
                String nacionalidad = datos[2];
                        
                int idObra = Integer.parseInt(datos[3].trim());
                String tituloObra = datos[4];
                int anioObra = Integer.parseInt(datos[5]);
                float precioObra = Float.parseFloat(datos[6]);
                
                Artista artista;
                if (mapaArtistas.containsKey(idArtista)) 
                {
                    artista = mapaArtistas.get(idArtista);
                } 
                else 
                {
                    artista = new Artista(idArtista, nombreArtista, nacionalidad);
                    artistas.add(artista);
                    mapaArtistas.put(idArtista, artista);
                }
                ObraArte obra = new ObraArte(idObra, tituloObra, artista.getNombre(), anioObra, precioObra, true);
                obras.add(obra);
            }
        }
        Map<String, Object> resultado = new HashMap<>();
        resultado.put("artistas", artistas);
        resultado.put("obras", obras);
        
        return resultado;
    }
}
