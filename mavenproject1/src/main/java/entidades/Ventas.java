/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

import java.util.ArrayList;
import java.util.List;

public class Ventas {

    private double montoTotalGaleria;
    private List<ObraArte> obrasVendidas;

    public Ventas() {
        this.montoTotalGaleria = 0.0;
        this.obrasVendidas = new ArrayList<>();
    }


    public void venderObra(int idObra, Exposicion exposicion) {
        ObraArte obraParaVender = null;

        // 1. Buscar la obra dentro de la lista de obras de la exposición.
        for (ObraArte obra : exposicion.getObras()) {
            if (obra.getId() == idObra) {
                obraParaVender = obra;
                break; // Salimos del bucle una vez que la encontramos.
            }
        }

        if (obraParaVender != null && obraParaVender.getDisponibilidad()) {
            

            this.montoTotalGaleria += obraParaVender.getPrecio();
            
            // Cambiamos el estado de la obra a "no disponible".
            obraParaVender.setDisponibilidad(false);
            
            // Añadimos la obra a nuestro registro de ventas.
            this.obrasVendidas.add(obraParaVender);
            
            // (Opcional) La eliminamos de la exposición porque ya fue vendida.
            exposicion.eliminarObra(idObra);
            
            System.out.println("\n¡Venta exitosa!");
            System.out.println("Se vendió la obra: '" + obraParaVender.getTitulo() + "' por $" + obraParaVender.getPrecio());
            System.out.println("Monto total de la galería ahora es: $" + this.montoTotalGaleria);
            
        } else if (obraParaVender != null && !obraParaVender.getDisponibilidad()) {
            System.out.println("\nError: La obra '" + obraParaVender.getTitulo() + "' ya ha sido vendida y no está disponible.");
        } else {
            System.out.println("\nError: No se encontró una obra con el ID " + idObra + " en la exposición seleccionada.");
        }
    }

    public double getMontoTotalGaleria() {
        return montoTotalGaleria;
    }

    public List<ObraArte> getObrasVendidas() {
        return obrasVendidas;
    }
}