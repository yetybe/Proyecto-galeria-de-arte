/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author dmena
 */
public class Escultura extends ObraArte
{
    private String material;
    private String peso;
    private String dimensiones3D;
    private String tipo = "Escultura";
    
    public Escultura(int id, String titulo, String artista, int ano, float precio,String material, String peso, String dimensiones3D)
    {
        super(id, titulo, artista, ano, precio ,true);
        this.material = material;
        this.peso = peso;
        this.dimensiones3D = dimensiones3D;
    }
    
    public String getMaterial(){ return material; }
    public void setMaterial(String material){ this.material = material; }
    
    public String getPeso(){ return peso; }
    public void setPeso(String peso){ this.peso = peso; }
    
    public String getDimensiones3D(){ return dimensiones3D; }
    public void setDimensiones3D(String dimensiones3D){ this.dimensiones3D = dimensiones3D; }
    
    public String getTipo(){ return tipo; }
    
    @Override
    public String getDescripcion()
    {
        return  Integer.toString(this.getId()) + " - " + this.getTitulo() + " - " + this.getAnio() + " - " + tipo + " - "+ material + " - " + peso + " - " + dimensiones3D;
    }
}
