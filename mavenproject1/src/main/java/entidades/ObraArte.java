/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Benja
 */
public class ObraArte{
private int id;
private String titulo;
private String artista;
private int anio;
private float precio;
private boolean disponibilidad;


public ObraArte(int id, String titulo, String artista, int ano, float precio, boolean disponibilidad) {
this.id = id;
this.titulo = titulo;
this.artista = artista;
this.anio = ano;
this.precio = precio;
this.disponibilidad = true; 
 }

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

public String getArtista() {
	return artista;
}

public void setArtista(String artista) {
	this.artista = artista;
}

public int getAnio() {
	return anio;
}

public void setAnio(int ano) {
	this.anio = ano;
}

public float getPrecio() {
	return precio;
}

public void setPrecio(float precio) {
	this.precio = precio;
}

public boolean getDisponibilidad() {
	return disponibilidad;
}

public void setDisponibilidad(boolean disponibilidad) {
	this.disponibilidad = disponibilidad;
}

public String getDescripcion()
{
    return  Integer.toString(id) + " - " + titulo + " - " + anio;
}

}