/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.pucv.mavenproject1;

/**
 *
 * @author ashlo
 */
import entidades.Artista;
import entidades.Exposicion;
import entidades.Inventario;
import entidades.ObraArte;
import entidades.Ventas;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VentanaReportes extends javax.swing.JFrame {
    private Inventario inventarioGeneral;
    private Map<Integer, Exposicion> exposiciones;
    private Ventas sistemaVentas;

    public VentanaReportes(Inventario i, Map<Integer, Exposicion> exposiciones , Ventas v) {
        inventarioGeneral = i;
        this.exposiciones = exposiciones;
        sistemaVentas = v;
       
        initComponents();
        configuracionInicial();
    }
    
    private void configuracionInicial() 
    {
        this.setTitle("Generador de Reportes");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        jComboBox1.removeAllItems();
        jComboBox1.addItem("Seleccione un reporte...");
        jComboBox1.addItem("Inventario Completo");
        jComboBox1.addItem("Exposiciones Actuales");
        jComboBox1.addItem("Reporte de Ventas");
    }
     
    private void mostrarReporteInventario() 
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Título");
        model.addColumn("Artista");
        model.addColumn("Año");
        model.addColumn("Precio");
        model.addColumn("Disponibilidad");

        for (ObraArte obra : inventarioGeneral.getObrasComoLista()) {
            model.addRow(new Object[]{
                obra.getId(),
                obra.getTitulo(),
                obra.getArtista(),
                obra.getAnio(),
                String.format("$%.2f", obra.getPrecio()),
                obra.getDisponibilidad() ? "Disponible" : "En exposición/Vendida"
            });
        }
        jTable2.setModel(model);
    }
    
    private void mostrarReporteExposiciones() 
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Exposición");
        model.addColumn("Nombre");
        model.addColumn("Cantidad de Obras");

        for (Exposicion expo : exposiciones.values()) {
            model.addRow(new Object[]{
                expo.getId(),
                expo.getNombre(),
                expo.getCantidadObras()
            });
        }
        jTable2.setModel(model);
    }
    
    private void mostrarReporteVentas() 
    {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Obra");
        model.addColumn("Título");
        model.addColumn("Artista");
        model.addColumn("Precio de Venta");

        for (ObraArte obra : sistemaVentas.getObrasVendidas()) {
            model.addRow(new Object[]{
                obra.getId(),
                obra.getTitulo(),
                obra.getArtista(),
                String.format("$%.2f", obra.getPrecio())
            });
        }
        
        // Fila final con el total de ganancias
        model.addRow(new Object[]{"", "", "--- TOTAL GANANCIAS ---", "$" + sistemaVentas.getMontoTotalGaleria()});
        
        jTable2.setModel(model);
    }
    
    private void generarReporteTxt() 
    {
        String opcion = (String) jComboBox1.getSelectedItem();
        if (opcion == null || opcion.equals("Seleccione un reporte...")) return; // No hacer nada si no hay selección

        try (PrintWriter pw = new PrintWriter("reporte_" + opcion.replace(" ", "_") + ".txt")) {
            pw.println("--- REPORTE DE LA GALERÍA: " + opcion + " ---");
            pw.println("Fecha: " + new java.util.Date());
            pw.println("-------------------------------------------------");

            if ("Inventario Completo".equals(opcion)) {
                for (ObraArte obra : inventarioGeneral.getObrasComoLista()) {
                    pw.println("ID: " + obra.getId() + " | Título: " + obra.getTitulo() + " | Precio: $" + String.format("$%.2f", obra.getPrecio()));
                }
            } else if ("Exposiciones Actuales".equals(opcion)) {
                for (Exposicion expo : exposiciones.values()) {
                    pw.println("ID: " + expo.getId() + " | Nombre: " + expo.getNombre() + " | Obras: " + expo.getCantidadObras());
                }
            } else if ("Reporte de Ventas".equals(opcion)) {
                for (ObraArte obra : sistemaVentas.getObrasVendidas()) {
                    pw.println("ID: " + obra.getId() + " | Título: " + obra.getTitulo() + " | Vendida por: $" + String.format("$%.2f", obra.getPrecio()));
                }
                pw.println("-------------------------------------------------");
                pw.println("GANANCIAS TOTALES: $" + String.format("$%.2f", sistemaVentas.getMontoTotalGaleria()));
            }
            
            JOptionPane.showMessageDialog(this, "Reporte '" + opcion + "' guardado en un archivo .txt.", "Reporte Generado", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al escribir el archivo de reporte.", "Error de Archivo", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
                            
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        generarReporte = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        botonCerrar = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Reportes de la Galería");
        jLabel1.setMaximumSize(new java.awt.Dimension(130, 16));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        generarReporte.setText("Generar reporte");
        generarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generarReporteActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        botonCerrar.setText("Cerrar");
        botonCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(generarReporte, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(290, 290, 290)
                        .addComponent(botonCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(57, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(generarReporte))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(botonCerrar)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generarReporteActionPerformed

        String opcion = (String) jComboBox1.getSelectedItem();

        if (opcion == null || opcion.equals("Seleccione un reporte...")) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un tipo de reporte.", "Selección Inválida", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Usamos un switch para llamar al método correspondiente
        switch (opcion) {
            case "Inventario Completo":
                mostrarReporteInventario();
                break;
            case "Exposiciones Actuales":
                mostrarReporteExposiciones();
                break;
            case "Reporte de Ventas":
                mostrarReporteVentas();
                break;
        }
       
        generarReporteTxt();
    }//GEN-LAST:event_generarReporteActionPerformed

    private void botonCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCerrarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botonCerrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCerrar;
    private javax.swing.JButton generarReporte;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
