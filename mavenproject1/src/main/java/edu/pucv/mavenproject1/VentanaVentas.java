/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.pucv.mavenproject1;

import entidades.Exposicion;
import entidades.Inventario;
import entidades.ObraArte;
import entidades.Ventas;
import java.util.Map;
import javax.swing.JOptionPane;

public class VentanaVentas extends javax.swing.JFrame {

    private Map<Integer, Exposicion> mapaDeExposiciones;
    private Inventario inventarioGeneral;
    private Ventas sistemaDeVentas;

    /**
     * Constructor modificado para recibir los datos de la galería.
     */
    public VentanaVentas(Map<Integer, Exposicion> exposiciones, Inventario inventario, Ventas ventas) {
        this.mapaDeExposiciones = exposiciones;
        this.inventarioGeneral = inventario;
        this.sistemaDeVentas = ventas;
        
        initComponents();
        configuracionInicial(); // Método para configurar la ventana al inicio
    }
    private void configuracionInicial() 
    {
        this.setTitle("Módulo de Ventas"); // Pone un título a la ventana
        vender.setText("Vender Obra Seleccionada"); // Cambia el texto del botón
        cargarExposiciones(); // Carga las exposiciones en el primer ComboBox
    }

    private void cargarExposiciones() {
        exposiciones.removeAllItems(); // Limpia el ComboBox

        if (mapaDeExposiciones == null || mapaDeExposiciones.isEmpty()) {
            exposiciones.addItem("No hay exposiciones para vender obras");
            exposiciones.setEnabled(false);
            obrasExposicion.setEnabled(false);
            vender.setEnabled(false);
            return;
        }
        
        exposiciones.addItem("Seleccione una exposición...");
        for (Exposicion expo : mapaDeExposiciones.values()) {
            exposiciones.addItem(expo.getNombre());
        }
    }
    
    /**
     * Carga las obras de la exposición seleccionada en el segundo ComboBox.
     */
    private void cargarObrasDeExposicion(String nombreExposicion) {
        obrasExposicion.removeAllItems(); // Limpia el segundo ComboBox

        // Buscamos el objeto Exposicion que corresponde al nombre seleccionado
        Exposicion exposicionSeleccionada = null;
        for (Exposicion expo : mapaDeExposiciones.values()) {
            if (expo.getNombre().equals(nombreExposicion)) {
                exposicionSeleccionada = expo;
                break;
            }
        }

        if (exposicionSeleccionada != null && !exposicionSeleccionada.getObras().isEmpty()) {
            obrasExposicion.addItem("Seleccione una obra...");
            for (ObraArte obra : exposicionSeleccionada.getObras()) {
                if(obra.getDisponibilidad()){ // Solo mostramos obras disponibles
                   obrasExposicion.addItem(obra.getId() + ": " + obra.getTitulo());
                }
            }
        } else {
            obrasExposicion.addItem("No hay obras en esta exposición");
        }
    }                      

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jMenu1 = new javax.swing.JMenu();
        jLabel1 = new javax.swing.JLabel();
        exposiciones = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        obrasExposicion = new javax.swing.JComboBox<>();
        vender = new javax.swing.JButton();

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Elija una exposicion:");

        exposiciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        exposiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exposicionesActionPerformed(evt);
            }
        });

        jLabel2.setText("Elige  una obra de la exposcion:");

        obrasExposicion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        obrasExposicion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obrasExposicionActionPerformed(evt);
            }
        });

        vender.setText("VENDER");
        vender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(266, 266, 266)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(exposiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vender)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(obrasExposicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(355, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(exposiciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(obrasExposicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(85, 85, 85)
                .addComponent(vender)
                .addContainerGap(157, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exposicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exposicionesActionPerformed
        // TODO add your handling code here:
        if (exposiciones.getSelectedIndex() > 0) { // Si no es el item "Seleccione..."
        String nombreExpoSeleccionada = (String) exposiciones.getSelectedItem();
            cargarObrasDeExposicion(nombreExpoSeleccionada);
        } 
        else 
        {
            obrasExposicion.removeAllItems();
        }
        
    }//GEN-LAST:event_exposicionesActionPerformed

    private void obrasExposicionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obrasExposicionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_obrasExposicionActionPerformed

    private void venderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_venderActionPerformed
        // TODO add your handling code here:
        if (exposiciones.getSelectedIndex() <= 0 || obrasExposicion.getSelectedIndex() <= 0) {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una exposición y una obra válidas.", "Error de Selección", JOptionPane.ERROR_MESSAGE);
        return;
        }

        String nombreExpo = (String) exposiciones.getSelectedItem();
        String obraSeleccionadaTexto = (String) obrasExposicion.getSelectedItem();
        
        // Extraemos el ID de la obra del texto del ComboBox ("ID: Título")
        int idObra = Integer.parseInt(obraSeleccionadaTexto.split(":")[0]);
        
        // Buscamos la exposición
        Exposicion expo = null;
        for(Exposicion e : mapaDeExposiciones.values()){
            if(e.getNombre().equals(nombreExpo)){
                expo = e;
                break;
            }
        }
        
        // Llamamos al método de venta
        sistemaDeVentas.venderObra(idObra, expo);
        
        // Eliminamos la obra del inventario general
        inventarioGeneral.eliminarObra(idObra);
        
        // Mostramos confirmación
        JOptionPane.showMessageDialog(this, "¡La obra ha sido vendida exitosamente!", "Venta Completada", JOptionPane.INFORMATION_MESSAGE);

        // Actualizamos la lista de obras para que ya no aparezca la vendida
        cargarObrasDeExposicion(nombreExpo);
    }//GEN-LAST:event_venderActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> exposiciones;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JComboBox<String> obrasExposicion;
    private javax.swing.JButton vender;
    // End of variables declaration//GEN-END:variables
}
