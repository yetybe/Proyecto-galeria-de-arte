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


    public void venderObra(int idObra, Exposicion exposicion) 
    {
        ObraArte obraParaVender = null;
        for (ObraArte obra : exposicion.getObras()) {
            if (obra.getId() == idObra) {
                obraParaVender = obra;
                break;
            }
        }

        if (obraParaVender != null) {
            
            this.montoTotalGaleria += obraParaVender.getPrecio();
            this.obrasVendidas.add(obraParaVender);
            
            obraParaVender.setDisponibilidad(false);
            
           
            exposicion.eliminarObra(idObra); 
        }
    }

    public double getMontoTotalGaleria() {
        return montoTotalGaleria;
    }

    public List<ObraArte> getObrasVendidas() {
        return obrasVendidas;
    }
}