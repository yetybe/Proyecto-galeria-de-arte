/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.pucv.mavenproject1;

import entidades.Artista;
import entidades.ObraArte;
import entidades.Pintura;
import entidades.Escultura;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import entidades.Inventario;

/**
 *
 * @author dmena
 */

public class VentanaAgregar extends javax.swing.JFrame {

    private ArrayList<Artista> listaArtistas;
    private Inventario inventarioGeneral ;

    public VentanaAgregar(ArrayList<Artista> listaArtistas, Inventario i) {
        this.listaArtistas = listaArtistas;
        inventarioGeneral = i;
        initComponents();
        inicializar();
    }
    
    private void inicializar() {
        // Poblar comboTipoObra
        comboTipoObra.setModel(new DefaultComboBoxModel<>(new String[]{"Pintura", "Escultura"}));
        
        llenarCombo();
        // Poblar comboArtista con nombre
        
        btnAgregarArtista.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirVentanaAgregarArtista();
            }
        });
        
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Recargar();
            }
        });
        
        // Mostrar/ocultar paneles según selección
        comboTipoObra.addActionListener(e -> {
            String tipo = (String) comboTipoObra.getSelectedItem();
            if ("Pintura".equals(tipo)) {
                panelPintura.setVisible(true);
                panelEscultura.setVisible(false);
            } else {
                panelPintura.setVisible(false);
                panelEscultura.setVisible(true);
            }
            this.pack();
        });

        comboTipoObra.setSelectedIndex(0);
        panelPintura.setVisible(true);
        panelEscultura.setVisible(false);

        btnCancelar.addActionListener(e -> this.dispose());
        btnGuardar.addActionListener(e -> guardarObra());
    }
    
    private void llenarCombo()
    {
        DefaultComboBoxModel<String> artistaModel = new DefaultComboBoxModel<>();
        for (Artista a : listaArtistas) {
            artistaModel.addElement(a.getNombre());
        }
        comboArtista.setModel(artistaModel);
    }
    
    private void Recargar()
    {
        llenarCombo();
    }
    
       private void guardarObra() {
        try {
            String tipo = (String) comboTipoObra.getSelectedItem();
            // Validar campos específicos según el tipo
            if ("Pintura".equals(tipo)) {
                if (txtEstilo.getText().trim().isEmpty() ||
                    txtSoporte.getText().trim().isEmpty() ||
                    txtDimensiones2D.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Complete todos los campos de Pintura.");
                    return;
                }
            } else { // Escultura
                if (txtMaterial.getText().trim().isEmpty() ||
                    txtPeso.getText().trim().isEmpty() ||
                    txtDimensiones3D.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Complete todos los campos de Escultura.");
                    return;
                }
            }
            // Validar básicos
            if (txtId.getText().trim().isEmpty() ||
                txtAnio.getText().trim().isEmpty() ||
                txtTitulo.getText().trim().isEmpty() ||
                txtPrecio.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete los campos obligatorios.");
                return;
            }

            int id;
            try {
                id = Integer.parseInt(txtId.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID debe ser entero.");
                return;
            }
            
            if (inventarioGeneral != null && inventarioGeneral.existeId(id)) {
                JOptionPane.showMessageDialog(this, "Ya existe una obra con ese ID. Elija otro ID.");
                return;
            }
            
            int anio;
            try {
                anio = Integer.parseInt(txtAnio.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Año debe ser entero.");
                return;
            }

            String titulo = txtTitulo.getText().trim();

            float precio;
            try {
                precio = Float.parseFloat(txtPrecio.getText().trim());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Precio debe ser numérico.");
                return;
            }

            // Obtener artista
            int idxArtista = comboArtista.getSelectedIndex();
            if (idxArtista < 0) {
                JOptionPane.showMessageDialog(this, "Seleccione un artista.");
                return;
            }
            Artista artistaObj = listaArtistas.get(idxArtista);
            String nombreArtista = artistaObj.getNombre();

            ObraArte nuevaObra;

            if ("Pintura".equals(tipo)) {
                String estilo = txtEstilo.getText().trim();
                String soporte = txtSoporte.getText().trim();
                String dimensiones2D = txtDimensiones2D.getText().trim();
                
                //  Validar estilo y soporte 
                if (!estilo.matches("[\\p{L} ]+")) {
                    JOptionPane.showMessageDialog(this, "El estilo debe contener solo letras");
                    return;
                }
                if (!soporte.matches("[\\p{L} ]+")) {
                    JOptionPane.showMessageDialog(this, "El soporte debe contener solo letras");
                    return;
                }
                nuevaObra = new Pintura(id, titulo, nombreArtista, anio, precio, estilo, soporte, dimensiones2D);

            } else { // Escultura
                String material = txtMaterial.getText().trim();
                int pesoInt;
                String dimensiones3D = txtDimensiones3D.getText().trim();
                
                  if (material.matches("\\d+")) { 
                    JOptionPane.showMessageDialog(this, "El material no puede ser un número.");
                    return;
                }
                try {
                    pesoInt = Integer.parseInt(txtPeso.getText().trim());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "El peso debe ser un número entero.");
                    return;
                }
                
                String peso = String.valueOf(pesoInt);

                nuevaObra = new Escultura(id, titulo, nombreArtista, anio, precio, material, peso, dimensiones3D);
            }

            // Agregar a listas
            inventarioGeneral.agregarObra(nuevaObra);
            artistaObj.agregarObra(nuevaObra);

            JOptionPane.showMessageDialog(this, "Obra agregada correctamente.");
            this.dispose();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
    private void abrirVentanaAgregarArtista()
    {
        VentanaAgregarArtista ventanaArtista = new VentanaAgregarArtista(listaArtistas);
        ventanaArtista.setVisible(true); 
    }
    /**
     * Creates new form VentanaAgregar
     */
    public VentanaAgregar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        comboTipoObra = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        panelEscultura = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtMaterial = new javax.swing.JTextField();
        txtPeso = new javax.swing.JTextField();
        txtDimensiones3D = new javax.swing.JFormattedTextField();
        comboArtista = new javax.swing.JComboBox<>();
        panelPintura = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtEstilo = new javax.swing.JTextField();
        txtSoporte = new javax.swing.JTextField();
        txtDimensiones2D = new javax.swing.JFormattedTextField();
        btnAgregarArtista = new javax.swing.JButton();
        btnRecargar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tipo Obra :");

        jLabel2.setText("ID :");

        jLabel3.setText("Año :");

        jLabel4.setText("Artista :");

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jLabel5.setText("Titulo :");

        jLabel6.setText("Precio :");

        comboTipoObra.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboTipoObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoObraActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        btnGuardar.setText("Guardar");

        jLabel14.setText("Material :");

        jLabel15.setText("Peso :");

        jLabel16.setText("Dimensiones 3D:");

        try {
            txtDimensiones3D.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###x###x###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout panelEsculturaLayout = new javax.swing.GroupLayout(panelEscultura);
        panelEscultura.setLayout(panelEsculturaLayout);
        panelEsculturaLayout.setHorizontalGroup(
            panelEsculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEsculturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEsculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDimensiones3D, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addGroup(panelEsculturaLayout.createSequentialGroup()
                        .addGroup(panelEsculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15))
                        .addGap(18, 18, 18)
                        .addGroup(panelEsculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaterial, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(txtPeso))))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        panelEsculturaLayout.setVerticalGroup(
            panelEsculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEsculturaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelEsculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtMaterial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelEsculturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtPeso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDimensiones3D, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        comboArtista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel11.setText("Estilo :");

        jLabel12.setText("Soporte :");

        jLabel13.setText("Dimensiones 2D:");

        try {
            txtDimensiones2D.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###x###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtDimensiones2D.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDimensiones2DActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelPinturaLayout = new javax.swing.GroupLayout(panelPintura);
        panelPintura.setLayout(panelPinturaLayout);
        panelPinturaLayout.setHorizontalGroup(
            panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPinturaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPinturaLayout.createSequentialGroup()
                        .addGroup(panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtSoporte, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                            .addComponent(txtEstilo)))
                    .addGroup(panelPinturaLayout.createSequentialGroup()
                        .addGroup(panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(txtDimensiones2D, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelPinturaLayout.setVerticalGroup(
            panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPinturaLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtEstilo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPinturaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtSoporte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDimensiones2D, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        btnAgregarArtista.setText("Agregar Artista");

        btnRecargar.setText("Recargar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(58, 58, 58)
                .addComponent(btnCancelar)
                .addGap(98, 98, 98))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboTipoObra, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAnio, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtId)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboArtista, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnAgregarArtista)
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRecargar))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelPintura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(37, 37, 37)
                        .addComponent(panelEscultura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(comboTipoObra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnAgregarArtista)
                    .addComponent(btnRecargar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPintura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelEscultura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDimensiones2DActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDimensiones2DActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDimensiones2DActionPerformed
    
    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {                                      
    // Puedes dejar esto vacío o agregar lógica si necesitas
}                                     

    private void comboTipoObraActionPerformed(java.awt.event.ActionEvent evt) {                                              
    // Puedes dejar esto vacío, porque ya manejas el cambio de panels en inicializar()
    // O si quieres, puedes llamar a tu lógica existente:
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaAgregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaAgregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArtista;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JComboBox<String> comboArtista;
    private javax.swing.JComboBox<String> comboTipoObra;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel panelEscultura;
    private javax.swing.JPanel panelPintura;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JFormattedTextField txtDimensiones2D;
    private javax.swing.JFormattedTextField txtDimensiones3D;
    private javax.swing.JTextField txtEstilo;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtMaterial;
    private javax.swing.JTextField txtPeso;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtSoporte;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
