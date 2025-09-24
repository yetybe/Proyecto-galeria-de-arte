/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.pucv.mavenproject1;
import java.util.*;
import entidades.Artista;
import entidades.ObraArte;
/**
 *
 * @author dmena
 */
public class MenuPrincipal extends javax.swing.JFrame {
    private ArrayList<Artista> listaArtistas;
    private ArrayList<ObraArte> listaObras;
    
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
    
    public MenuPrincipal(ArrayList<Artista> listaArt, ArrayList<ObraArte> listaObr) {
        this.listaArtistas = listaArt;
        this.listaObras = listaObr;
        initComponents();
        configurarComponentes(); // Agregar esta línea
    }
    
    public MenuPrincipal() {
        this.listaArtistas = new ArrayList<>(); // Lista vacía por defecto
        this.listaObras = new ArrayList<>();    // Lista vacía por defecto
        initComponents();
        configurarComponentes();
    }
    
    public ArrayList<Artista> getListaArtistas()
    {
        return listaArtistas;
    }
    
    public ArrayList<ObraArte> getListaObras()
    {
        return listaObras;
    }
    
    private void configurarComponentes() {
        // Configurar ComboBox
        String[] opciones = {"Seleccione función", "Agregar Elemento", "Editar Elemento", "Eliminar Elemento"};
        comboFunciones.setModel(new javax.swing.DefaultComboBoxModel<>(opciones));
    
        // Configurar botón Ejecutar (CORREGIDO)
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });
    
        // Configurar botón Salir (CORREGIDO)
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
                VentanaAgregar ventana = new VentanaAgregar(listaArtistas, listaObras);
                ventana.setVisible(true);
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
    
    public static void main(String args[]) {
        
        ArrayList<Artista> artistas = new ArrayList<>();
        ArrayList<ObraArte> obras = new ArrayList<>();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                new MenuPrincipal(artistas, obras).setVisible(true);
            }
        });
    }

}
