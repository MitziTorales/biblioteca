/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesji.vistaLibro;

import com.tesji.modelo.Libro;
import com.tesji.vistaPrincipal.FrmPrincipal;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mitzi_Torales
 */
public class FrmBuscarLibro extends javax.swing.JFrame {

    DefaultTableModel encabezados = new DefaultTableModel();
    Libro crudLibro = new Libro();

    /**
     * Creates new form FrmBuscarLibro
     */
    public FrmBuscarLibro() {
        initComponents();
        encabezados.addColumn("ISBN");
        encabezados.addColumn("Titulo");
        encabezados.addColumn("Descripción");
        encabezados.addColumn("Existencia");
        encabezados.addColumn("Editorial");
        encabezados.addColumn("Categoría");
        encabezados.addColumn("Edición");
        tablaLibro.setModel(encabezados);
    }

    private void limpiarTabla() {
        txtBuscar.setText(null);
        txtBuscar.requestFocus();
        for (int i = 0; i < encabezados.getRowCount(); i++) {//recorre la tabla 
            encabezados.removeRow(i);//removiendo cada uno
            i -= 1;
        }
    }

    private void mostrarTodos() {
        limpiarTabla();
        try {
            ResultSet rs = crudLibro.mostrarTodosLibros();
            while (rs.next()) {//revisa uno por uno los elementos
                Object row[] = new Object[7];//tamaño de array depende del numero de celdas
                for (int i = 0; i < 7; i++) {
                    //El resulset los indices empiezan
                    //en 1, mi for lo empiezo en 0 por eso le sumo i+1
                    row[i] = rs.getObject(i + 1);
                }
                //Agregamos cada registro al modelo de la tabla
                encabezados.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarCat(String categoria) {
        limpiarTabla();
        try {
            ResultSet rs = crudLibro.mostrarCategoria(categoria);
            while (rs.next()) {//revisa uno por uno los elementos
                Object row[] = new Object[7];//tamaño de array depende del numero de celdas
                for (int i = 0; i < 7; i++) {
                    //El resulset los indices empiezan
                    //en 1, mi for lo empiezo en 0 por eso le sumo i+1
                    row[i] = rs.getObject(i + 1);
                }
                //Agregamos cada registro al modelo de la tabla
                encabezados.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarEdit(String editorial) {
        limpiarTabla();
        try {
            ResultSet rs = crudLibro.mostrarEditoria(editorial);
            while (rs.next()) {//revisa uno por uno los elementos
                Object row[] = new Object[7];//tamaño de array depende del numero de celdas
                for (int i = 0; i < 7; i++) {
                    //El resulset los indices empiezan
                    //en 1, mi for lo empiezo en 0 por eso le sumo i+1
                    row[i] = rs.getObject(i + 1);
                }
                //Agregamos cada registro al modelo de la tabla
                encabezados.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void mostrarTitulo(String titulo) {
        limpiarTabla();
        try {
            ResultSet rs = crudLibro.mostrarTitulo(titulo);
            while (rs.next()) {//revisa uno por uno los elementos
                Object row[] = new Object[7];//tamaño de array depende del numero de celdas
                for (int i = 0; i < 7; i++) {
                    //El resulset los indices empiezan
                    //en 1, mi for lo empiezo en 0 por eso le sumo i+1
                    row[i] = rs.getObject(i + 1);
                }
                //Agregamos cada registro al modelo de la tabla
                encabezados.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void busquedaId(String isbn) {
        limpiarTabla();
        try {
            ResultSet rs = crudLibro.mostrarId(isbn);
            while (rs.next()) {//revisa uno por uno los elementos
                Object row[] = new Object[7];//tamaño de array depende del numero de celdas
                for (int i = 0; i < 7; i++) {
                    //El resulset los indices empiezan
                    //en 1, mi for lo empiezo en 0 por eso le sumo i+1
                    row[i] = rs.getObject(i + 1);
                }
                //Agregamos cada registro al modelo de la tabla
                encabezados.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void limpiar(){
        txtBuscar.setText(null);
        
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btnMostrarTodos = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        cmbBuscarPor = new javax.swing.JComboBox();
        txtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("MOSTAR LIBROS");

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Humnst777 Lt BT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(".:: MOSTRAR LIBROS ::.");

        btnMostrarTodos.setText("MOSTRAR TODOS");
        btnMostrarTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarTodosActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Buscar por");

        cmbBuscarPor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Seleccione--", "ISBN", "TITULO", "CATEGORIA", "EDITORIAL" }));

        btnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/tesji/imagenes/search_32x32-32.gif"))); // NOI18N
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        tablaLibro.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tablaLibro);

        jButton3.setText("LIMPIAR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("NUEVA BUSQUEDA");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("REGRESAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(32, 32, 32)
                .addComponent(cmbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(txtBuscar)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
            .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5)
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton3)
                        .addGap(124, 124, 124)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(215, 215, 215)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(btnMostrarTodos, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMostrarTodos)
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbBuscarPor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMostrarTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarTodosActionPerformed
        // TODO add your handling code here:
        mostrarTodos();
    }//GEN-LAST:event_btnMostrarTodosActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        if (cmbBuscarPor.getSelectedIndex() == 1) {
            String isbn = txtBuscar.getText();
            try {
                if (isbn.trim().length() != 0) {
                    busquedaId(isbn);

                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Ingrese el numero de ISBN a buscar");
                    txtBuscar.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error agregar el ISBN");
            }
        } else if (cmbBuscarPor.getSelectedIndex() == 2) {
            String titulo = txtBuscar.getText();
            if (titulo.trim().length() != 0) {
                mostrarTitulo(titulo);
            } else {
                JOptionPane.showMessageDialog(rootPane,
                        "Ingrese el titulo del libro");
                txtBuscar.requestFocus();
            }
        } else if (cmbBuscarPor.getSelectedIndex() == 3) {
            String categoria = txtBuscar.getText();
            if (categoria.trim().length() != 0) {
                mostrarCat(categoria);
            } else {
                JOptionPane.showMessageDialog(rootPane,
                        "Ingrese el nombre de la Categoria a buscar");
                txtBuscar.requestFocus();
            }
        } else if (cmbBuscarPor.getSelectedIndex() == 4) {
            String editorial = txtBuscar.getText();
            try {
                if (editorial.trim().length() != 0) {
                    mostrarEdit(editorial);
                } else {
                    JOptionPane.showMessageDialog(rootPane,
                            "Ingrese el numero de la editorial a buscar");
                    txtBuscar.requestFocus();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error agregar un numero de categoria");
            }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new FrmPrincipal().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        limpiar();
        limpiarTabla();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBuscarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnMostrarTodos;
    private javax.swing.JComboBox cmbBuscarPor;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable tablaLibro;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}
