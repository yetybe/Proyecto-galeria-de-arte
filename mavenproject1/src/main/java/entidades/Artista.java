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

    private int  id;
    private String nombre;
    private String nacionalidad;
    private List<ObraArte> obras; 
    
    public Artista( int id , String nombre  , String nacionalidad )
    {
        this.id = id;
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
        obras = new ArrayList<>();
        
    }
    
    public int getId()
    {
        return id;
    }
    public  String getNombre()
    {
        return nombre;
    }
    public String getNacionalidad()
    {
        return nacionalidad;
    }
    public List<ObraArte> getObras()
    {
        return obras;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    public void setNomebre(int id)
    {
        this.id = id;
    }
    public void setNacionalidad(int id)
    {
        this.id = id;
    }
    public void set
    
}
    

