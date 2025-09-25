/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author dmena
 */
public class Pintura extends ObraArte 
{
    private String estilo;
    private String soporte;
    private String dimensiones2D;
    
    public Pintura(int id, String titulo, String artista, int ano, float precio,String estilo, String soporte, String dimensiones2D)
    {
        super(id, titulo, artista, ano, precio , true );
        this.estilo = estilo;
        this.soporte = soporte;
        this.dimensiones2D = dimensiones2D;
    }
    
    public String getEstilo(){ return estilo; }
    public void setEstilo(String estilo){ this.estilo = estilo; }
    
    public String getSoporte(){ return soporte; }
    public void setSoporte(String soporte){ this.soporte = soporte; }
    
    public String getDimensiones2D(){ return dimensiones2D; }
    public void setDimensiones2D(String dimensiones2D){ this.dimensiones2D = dimensiones2D; }
}
