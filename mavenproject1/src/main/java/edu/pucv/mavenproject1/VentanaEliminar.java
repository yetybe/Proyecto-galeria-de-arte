/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edu.pucv.mavenproject1;
import entidades.Artista;
import entidades.ObraArte;
import entidades.Pintura;
import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author dmena
 */
public class VentanaEliminar extends javax.swing.JFrame {
    private ArrayList<Artista> listaArtistas;
    private ArrayList<ObraArte> listObras;
    /**
     * Creates new form VentanaEliminar
     */
    public VentanaEliminar() {
        initComponents();
    }
    
    public VentanaEliminar(ArrayList<Artista> listaArtistas, ArrayList<ObraArte> listaObras) {
        this.listaArtistas = listaArtistas;
        this.listObras = listaObras;
        initComponents();
        configurarComponentes();
    }
    
    private void configurarComponentes()
    {
        listaObras.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        
        llenarComboArtistas();
        
        panelObrasArtista.setVisible(false);
        
        comboArtistas.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                cambiarArtista();
            }
        });
        
        btnEliminar.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                eliminarObra();
            }
        });
        
        btnCancelar.addActionListener(new java.awt.event.ActionListener()
        {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                dispose();
            }
        });
    }
    
    private void llenarComboArtistas()
    {
        comboArtistas.removeAllItems();
        comboArtistas.addItem("Seleccione un artista");
        
        if (listaArtistas != null && !listaArtistas.isEmpty())
        {
            for (Artista artista : listaArtistas)
            {
                comboArtistas.addItem(artista.getNombre());
            }
        }
        else
        {
            comboArtistas.addItem("No hay artistas cargados");
        }
    }
    
    private void cambiarArtista()
    {
        if (comboArtistas.getSelectedIndex() > 0)
        {
            String nombreArtista = (String) comboArtistas.getSelectedItem();
            if (!nombreArtista.equals("No hay artistas cargados"))
            {
                mostrarObrasDelArtista(nombreArtista);
                panelObrasArtista.setVisible(true);
            }
        }
        else
        {
            panelObrasArtista.setVisible(false);
        }
    }
    
    private void mostrarObrasDelArtista(String nombreArtista)
    {
        Artista artista = buscarArtistaPorNombre(nombreArtista);
        if (artista != null && !artista.getObras().isEmpty())
        {
            ArrayList<String> obrasTexto = new ArrayList<>();
            for (ObraArte obra : artista.getObras())
            {
                String tipo = (obra instanceof Pintura) ? "Pintura" : "Escultura";
                obrasTexto.add(obra.getTitulo() + " (" + obra.getAnio() + ") - " + tipo);
            }
            listaObras.setListData(obrasTexto.toArray(new String[0]));
        }
        else 
        {
            listaObras.setListData(new String[]{"No hay obras para este artista"});
            btnEliminar.setEnabled(false);
        }
    }
    
    private Artista buscarArtistaPorNombre(String nombre)
    {
        for (Artista artista : listaArtistas)
        {
            if (artista.getNombre().equals(nombre))
            {
                return artista;
            }
        }
        return null;
    }
    
    private void eliminarObra()
    {
        if (comboArtistas.getSelectedIndex() <= 0)
        {
            JOptionPane.showMessageDialog(this, "Seleccione un artista primero");
            return;
        }
        
        String nombreArtista = (String) comboArtistas.getSelectedItem();
        if (nombreArtista.equals("No hay artistas cargados"))
        {
            JOptionPane.showMessageDialog(this, "No hay artistas cargados en el sistema");
            return;
        }
        
        int indiceObra = listaObras.getSelectedIndex();
        if (indiceObra == -1)
        {
            JOptionPane.showMessageDialog(this, "Seleccione una obra de la lista");
            return;
        }
        
        Artista artista = buscarArtistaPorNombre(nombreArtista);
        if (artista == null || artista.getObras().isEmpty())
        {
            JOptionPane.showMessageDialog(this, "No se encontraron obras para este artista");
            return;
        }
        
        ObraArte obraAEliminar = artista.getObras().get(indiceObra);
        
        VentanaConfirmarEliminar ventanaConfirmar = new VentanaConfirmarEliminar(artista, obraAEliminar);
        ventanaConfirmar.setVisible(true);
    
        int respuesta = JOptionPane.showConfirmDialog(this,
            "¿Está seguro de eliminar esta obra permanentemente?",
            "Confirmar Eliminación",
            JOptionPane.YES_NO_OPTION
        );
    
        if (respuesta == JOptionPane.YES_OPTION) 
        {
            artista.eliminarObra(obraAEliminar.getId());
            listObras.remove(obraAEliminar);
            JOptionPane.showMessageDialog(this, "✅ Obra eliminada exitosamente");
            actualizarListaObras();
        }
    }
    
    // Método para que VentanaConfirmarEliminar pueda actualizar la lista
    public void actualizarListaObras()
    {
        if (comboArtistas.getSelectedIndex() > 0) {
            String nombreArtista = (String) comboArtistas.getSelectedItem();
            mostrarObrasDelArtista(nombreArtista);
        }
        btnEliminar.setEnabled(true);
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
        comboArtistas = new javax.swing.JComboBox<>();
        panelObrasArtista = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaObras = new javax.swing.JList<>();
        btnEliminar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Eliga el Artista :");

        comboArtistas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Obras del Artista");

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
                        .addComponent(comboArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(comboArtistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaEliminar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaEliminar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JComboBox<String> comboArtistas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listaObras;
    private javax.swing.JPanel panelObrasArtista;
    // End of variables declaration//GEN-END:variables
}
