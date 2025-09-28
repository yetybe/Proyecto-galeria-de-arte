/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package edu.pucv.mavenproject1;

import entidades.Inventario;
import entidades.ObraArte;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import java.util.Map;
import entidades.Exposicion;

/**
 *
 * @author dmena
 */
public class VentanaEliminar extends javax.swing.JFrame {
    
    private Map<Integer, Exposicion> exposiciones;
    private Inventario inventarioGeneral;

    /**
     * Creates new form VentanaEliminar
     */
    public VentanaEliminar(Map<Integer, Exposicion> exposiciones , Inventario i) {
        this.exposiciones = exposiciones;
        inventarioGeneral = i;
        initComponents();
        configuracionInicial();
    }

    private void configuracionInicial() {
        this.setTitle("Eliminar Obra de Exposición");
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        listaObras.setVisible(false);
        cargarExposicionesEnComboBox();
        
        // Configurar acción del botón cancelar
        btnCancelar.addActionListener(e -> this.dispose());
    }
    
    private void cargarExposicionesEnComboBox() {
        comboExposiciones.removeAllItems();
        comboExposiciones.addItem("Seleccione una exposición...");

        if (exposiciones == null || exposiciones.isEmpty()) {
            comboExposiciones.addItem("No hay exposiciones disponibles");
            comboExposiciones.setEnabled(false);
            return;
        }

        for (Exposicion exposicion : exposiciones.values()) {
            comboExposiciones.addItem(exposicion.getId() + ": " + exposicion.getNombre());
        }
    }
    
    private void mostrarObrasDeLaExposicion(int idExposicion) {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        Exposicion exposicionSeleccionada = exposiciones.get(idExposicion);
        
        if (exposicionSeleccionada != null && exposicionSeleccionada.getObras() != null) {
            for (ObraArte obra : exposicionSeleccionada.getObras()) {
                listModel.addElement(obra.getId() + ": " + obra.getTitulo() + " - " + obra.getArtista());
            }
        }
        
        if (listModel.isEmpty()) {
            listModel.addElement("Esta exposición no tiene obras registradas.");
        }
        
        listaObras.setModel(listModel);
        listaObras.setVisible(true);
    }

                                             


    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        comboExposiciones = new javax.swing.JComboBox<>();
        panelObrasArtista = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaObras = new javax.swing.JList<>();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Eliga el exposicion :");

        comboExposiciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboExposiciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboExposicionesActionPerformed(evt);
            }
        });

        jLabel2.setText("Obras exposicion");

        listaObras.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        listaObras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(listaObras);

        javax.swing.GroupLayout panelObrasArtistaLayout = new javax.swing.GroupLayout(panelObrasArtista);
        panelObrasArtista.setLayout(panelObrasArtistaLayout);
        panelObrasArtistaLayout.setHorizontalGroup(
            panelObrasArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObrasArtistaLayout.createSequentialGroup()
                .addGroup(panelObrasArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelObrasArtistaLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel2))
                    .addGroup(panelObrasArtistaLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        panelObrasArtistaLayout.setVerticalGroup(
            panelObrasArtistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelObrasArtistaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelObrasArtista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboExposiciones, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(btnEliminar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboExposiciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(panelObrasArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        if (listaObras.getSelectedValue() == null) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una obra de la lista.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String obraSeleccionadaTexto = listaObras.getSelectedValue();
        
        if (!obraSeleccionadaTexto.contains(":")) {
            JOptionPane.showMessageDialog(this, "Selección inválida.", "Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Extraer ID de la obra
        int idObra = Integer.parseInt(obraSeleccionadaTexto.split(":")[0].trim());
        
        // Obtener la exposición seleccionada
        String exposicionSeleccionada = (String) comboExposiciones.getSelectedItem();
        int idExposicion = Integer.parseInt(exposicionSeleccionada.split(":")[0].trim());
        Exposicion exposicion = exposiciones.get(idExposicion);

        // Buscar la obra en la exposición
        ObraArte obraAEliminar = null;
        for (ObraArte obra : exposicion.getObras()) {
            if (obra.getId() == idObra) {
                obraAEliminar = obra;
                break;
            }
        }

        if (obraAEliminar == null) {
            JOptionPane.showMessageDialog(this, "La obra no se encuentra en esta exposición.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        int respuesta = JOptionPane.showConfirmDialog(this,
                "¿Seguro que desea eliminar '" + obraAEliminar.getTitulo() + "' de la exposición?",
                "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        
        if (respuesta == JOptionPane.YES_OPTION) {
            // Eliminar la obra de la exposición
            exposicion.eliminarObra(idObra);
            
            // También eliminar del inventario general si es necesario
            if (inventarioGeneral != null) {
                inventarioGeneral.eliminarObra(idObra);
            }
            
            JOptionPane.showMessageDialog(this, "Obra eliminada exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            
            // Actualizar la lista de obras
            mostrarObrasDeLaExposicion(idExposicion);
        }
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void comboExposicionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboExposicionesActionPerformed
        if (comboExposiciones.getSelectedIndex() > 0) {
            String exposicionSeleccionada = (String) comboExposiciones.getSelectedItem();
            // Extraer el ID de la exposición (formato: "ID: Nombre")
            int idExposicion = Integer.parseInt(exposicionSeleccionada.split(":")[0].trim());
            mostrarObrasDeLaExposicion(idExposicion);
        } else {
            listaObras.setVisible(false);
        }
    }//GEN-LAST:event_comboExposicionesActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboExposiciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaObras;
    private javax.swing.JPanel panelObrasArtista;
    // End of variables declaration//GEN-END:variables


}