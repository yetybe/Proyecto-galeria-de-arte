/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.pucv.mavenproject1;

/**
 *
 * @author dmena
 */
public class MenuPrincipal extends javax.swing.JFrame {
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboFunciones = new javax.swing.JComboBox<>();
        btnEjecutar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        comboFunciones.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnEjecutar.setText("jButton1");

        btnSalir.setText("jButton2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(comboFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addGap(0, 235, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 250, Short.MAX_VALUE)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboFunciones;
    // End of variables declaration//GEN-END:variables
    
    public MenuPrincipal() {
        initComponents();
        configurarComponentes(); // Agregar esta línea
    }
    
    private void configurarComponentes() {
        // Configurar las opciones del ComboBox
        String[] opciones = {"Seleccione función", "Agregar Elemento", "Editar Elemento", "Eliminar Elemento"};
        comboFunciones.setModel(new javax.swing.DefaultComboBoxModel<>(opciones));
        
        // Agregar action listener al botón
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
        
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
    }

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {
        String opcion = (String) comboFunciones.getSelectedItem();
        
        switch(opcion) {
            case "Agregar Elemento":
                new VentanaAgregar(this, true).setVisible(true);
                break;
            case "Editar Elemento":
                new VentanaEditar(this, true).setVisible(true);
                break;
            case "Eliminar Elemento":
                new VentanaEliminar(this, true).setVisible(true);
                break;
            default:
                javax.swing.JOptionPane.showMessageDialog(this, "Seleccione una función válida");
        }
    }
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {
        // Preguntar confirmación antes de salir
        int respuesta = javax.swing.JOptionPane.showConfirmDialog(
            this, 
            "¿Está seguro que desea salir del programa?", 
            "Confirmar salida", 
            javax.swing.JOptionPane.YES_NO_OPTION
        );
        
        if (respuesta == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0); // Cierra la aplicación completamente
        }
    }
    
    public static void main(String args[])
    {
        
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

}
