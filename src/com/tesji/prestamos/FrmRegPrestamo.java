/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesji.prestamos;

import com.tesji.modelo.Prestamo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Mitzi_Torales
 */
public class FrmRegPrestamo extends javax.swing.JFrame {

    Prestamo crudPrestamo;

    /**
     * Creates new form FrmRegPrestamo
     */
    public FrmRegPrestamo() {
        initComponents();
        crudPrestamo = new Prestamo();
        iniciar();
        llenarStatus();
    }

    public void llenarStatus() {
        try {
            ResultSet rs = crudPrestamo.llenarStatus();
            while (rs.next()) {
                String edit = rs.getString("descripcionEstatus");
                cmbStatus.addItem(edit);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error al cargar los datos de la Base de Datos");
        }
    }

    private void verificar() {
        String usuario = txtUsuario.getText();
        if (usuario.trim().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No se ha especificado el número de usuario a buscar");
            txtUsuario.setText(null);
            txtUsuario.requestFocus();
            return;//saca del metodo si se cumple el if ya no se ejecutan las demas condiciones
        }
        try {
            int id = Integer.valueOf(usuario);//Se convierte de string a entero
            ResultSet rs = crudPrestamo.mostrarUsuario(id);
            if (rs != null) {
                while (rs.next()) {
                    String user = rs.getString("nombre");
                    lblVerificar.setText(user + " usuario encontrado");
                    activar();
                }
            } else {
                lblVerificar.setText("Usuario no encontrado");
                usuario();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException er) {
            JOptionPane.showMessageDialog(rootPane, "El id del usuario debe ser numérico");
        }
    }

    private void verificarIsbn() {
        String idlibro = txtIsbn1.getText();
        if (idlibro.trim().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "No se ha especificado el ISBN");
            txtIsbn1.setText(null);
            txtIsbn2.requestFocus();
            return;//saca del metodo si se cumple el if ya no se ejecutan las demas condiciones
        }
        try {
            //int id = Integer.valueOf(usuario);//Se convierte de string a entero
            ResultSet rs = crudPrestamo.mostrarIsbn(idlibro);
            if (rs != null) {
                while (rs.next()) {
                    String user = rs.getString("isbn");
                    lblVerificarIsbn1.setText(user + " ISBN encontrado");
                    //activar();
                }
            } else {
                lblVerificarIsbn1.setText("ISBN no encontrado");
                //usuario();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void altaPstLib(String idLibro, String status) {
        //String isbn = txtIsbn1.getText();
        int idPrestamo = Integer.parseInt(txtIdPrestamo.getText());

        if (idLibro.trim().length() == 0) {
            JOptionPane.showMessageDialog(rootPane, "El campo isbn no debe"
                    + "estar vacio\nIntente de nuevo",
                    "Prestamo Libro", JOptionPane.ERROR_MESSAGE);
            txtIsbn1.requestFocus();
        } else {
            if (crudPrestamo.ingresarPrestamoLibro(idLibro, idPrestamo, status)) {
                JOptionPane.showMessageDialog(rootPane, "Presamo Libro registrado correctamente");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Problemas al registar Prestamo Libro"
                        + "\nIntente de nuevo");
            }
        }
    }

    private void idPrestamo() {

        try {
            //int id = Integer.valueOf(usuario);//Se convierte de string a entero
            ResultSet rs = crudPrestamo.mostrar();
            if (rs != null) {
                while (rs.next()) {
                    String user = rs.getString("idPrestamo");
                    txtIdPrestamo.setText(user);
                    //activar();
                }
            } else {
                lblVerificar.setText("id no encontrado");
                usuario();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de la Base de Datos.",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        lblVerificar.setText("No. Verificado");
        txtUsuario.setText(null);
        txtUsuario.requestFocus();
        calFechaEntrega.setCalendar(null);
        calFechaPrestamo.setCalendar(null);
    }

    private void iniciar() {
        txtUsuario.setEnabled(false);
        btnAltaAlumno.setEnabled(false);
        btnCancelar.setEnabled(false);
        btnRegistrar.setEnabled(false);
        btnVerificar.setEnabled(false);
        calFechaEntrega.setEnabled(false);
        calFechaPrestamo.setEnabled(false);
        txtIdPrestamo.setEnabled(false);
        txtIsbn1.setEnabled(false);
        txtIsbn2.setEnabled(false);
        btnCancelarPstLib.setEnabled(false);
        btnRegistarPrsLib.setEnabled(false);
        cmbStatus.setSelectedIndex(0);
        cmbStatus.setEnabled(false);
    }

    private void nuevo() {
        txtUsuario.setEnabled(true);
        btnVerificar.setEnabled(true);
    }

    private void usuario() {
        btnAltaAlumno.setEnabled(true);
        btnVerificar.setEnabled(false);
    }

    private void activar() {
        calFechaEntrega.setEnabled(true);
        calFechaPrestamo.setEnabled(true);
        btnRegistrar.setEnabled(true);
        btnCancelar.setEnabled(true);
    }

    private void activarPstLib() {
        txtIdPrestamo.setEnabled(true);
        txtIsbn1.setEnabled(true);
        txtIsbn2.setEnabled(true);
        btnCancelarPstLib.setEnabled(true);
        btnRegistarPrsLib.setEnabled(true);
//        cmbStatus.setEnabled(true);
    }

    private void desacPstLib() {
        txtIdPrestamo.setEnabled(false);
        txtIsbn1.setEnabled(false);
        txtIsbn2.setEnabled(false);
        btnCancelarPstLib.setEnabled(false);
        btnRegistarPrsLib.setEnabled(false);
        cmbStatus.setEnabled(false);
    }

    private void limpiarPstLib() {
        txtIdPrestamo.setText(null);
        txtIsbn1.setText(null);
        txtIsbn2.setText(null);
        cmbStatus.setSelectedIndex(0);
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
        jLabel2 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        btnAltaAlumno = new javax.swing.JButton();
        lblVerificar = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        calFechaPrestamo = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        calFechaEntrega = new com.toedter.calendar.JDateChooser();
        btnNuevo = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        txtIdPrestamo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtIsbn1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtIsbn2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbStatus = new javax.swing.JComboBox();
        lblVerificarIsbn1 = new javax.swing.JLabel();
        btnRegistarPrsLib = new javax.swing.JButton();
        btnCancelarPstLib = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PRESTAMOS");

        jPanel1.setBackground(new java.awt.Color(255, 102, 0));
        jPanel1.setForeground(new java.awt.Color(255, 102, 0));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Vani", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(".:: REGISTRO DE PRÉSTAMOS ::.");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("No. Usuario");

        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });

        btnAltaAlumno.setText("DAR DE ALTA");

        lblVerificar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblVerificar.setForeground(new java.awt.Color(255, 255, 255));
        lblVerificar.setText("No. Verificado");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Fecha de préstamo");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fecha de entrega");

        btnNuevo.setText("NUEVO");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnRegistrar.setText("REGISTRAR");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("CANCELAR");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnRegresar.setText("REGRESAR");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("No. Préstamo");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("ISBN");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("ISBN");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");

        cmbStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "-- Seleccione --" }));

        btnRegistarPrsLib.setText("REGISTRAR");
        btnRegistarPrsLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistarPrsLibActionPerformed(evt);
            }
        });

        btnCancelarPstLib.setText("CANCELAR");
        btnCancelarPstLib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarPstLibActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnRegresar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(btnVerificar))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addComponent(btnNuevo)
                                    .addGap(69, 69, 69)
                                    .addComponent(btnRegistrar)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnCancelar))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(25, 25, 25)
                                            .addComponent(calFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lblVerificar)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addGap(18, 18, 18)
                                                .addComponent(calFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addGap(34, 34, 34)
                                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnAltaAlumno)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(89, 89, 89)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(80, 80, 80)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIdPrestamo)
                                    .addComponent(txtIsbn1)
                                    .addComponent(txtIsbn2)
                                    .addComponent(cmbStatus, 0, 139, Short.MAX_VALUE))
                                .addGap(31, 31, 31)
                                .addComponent(lblVerificarIsbn1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(btnRegistarPrsLib)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelarPstLib, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAltaAlumno)
                    .addComponent(jLabel2))
                .addGap(11, 11, 11)
                .addComponent(btnVerificar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblVerificar)
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(calFechaPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(calFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIsbn1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtIsbn2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblVerificarIsbn1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistarPrsLib)
                    .addComponent(btnCancelarPstLib))
                .addGap(30, 30, 30)
                .addComponent(btnRegresar)
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
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        // TODO add your handling code here:
        //Validar que el campo fecha de entrega no este vacio
        String usuario = txtUsuario.getText();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");//en el mes es en mayusculas para que se tome en numerico si es en minusculas sería en letra
        if (calFechaPrestamo.getCalendar() != null) {
            //Extraer la fecha en un objeto de tipo DATE del paquete java.util
            //Date es igual que el tipo string y no es necesario llevar el objeto
            Date fechaOriginal = calFechaPrestamo.getCalendar().getTime();
            String fechaCorrecta = formato.format(fechaOriginal);
            if (calFechaEntrega.getCalendar() != null) {
                Date original = calFechaEntrega.getCalendar().getTime();
                String correcta = formato.format(original);

                if (usuario.trim().length() != 0) {
                    int user = Integer.parseInt(usuario);
                    //metodo activa calendario

                    if (crudPrestamo.ingresarPrestamos(correcta, fechaCorrecta, user)) {
                        JOptionPane.showMessageDialog(rootPane, "Préstamo registrado correctamente");
                        limpiar();
                        idPrestamo();
                        activarPstLib();
                           cmbStatus.setSelectedIndex(2);
//                        txtIdPrestamo.setText(crudPrestamo.mostrar().toString());
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Problemas al registrar "
                                + "libro\nIntente de nuevo");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "ingrese un id de usuario");
                    //metodo activar boton registrar

                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Seleccione la fecha de entrega");
            }

        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccione la fecha de préstamo");
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        // TODO add your handling code here:
        verificar();
    }//GEN-LAST:event_btnVerificarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        // TODO add your handling code here:
        limpiar();
        nuevo();
//        idPrestamo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        iniciar();
        limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRegistarPrsLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistarPrsLibActionPerformed
        // TODO add your handling code here:
        String isbn1 = txtIsbn1.getText();
        String isbn2 = txtIsbn2.getText();
        String status = cmbStatus.getSelectedItem().toString();
        if (cmbStatus.getSelectedIndex() != 0) {

            if (isbn1.trim().length() != 0) {
                altaPstLib(isbn1, status);
                if (isbn2.trim().length() != 0) {
                    altaPstLib(isbn2, status);
                }
                desacPstLib();
                limpiarPstLib();
                iniciar();
            } else {
                JOptionPane.showMessageDialog(rootPane, "ISBN no puedes estar vacio");
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Seleccionar status", "Prestamo Libro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnRegistarPrsLibActionPerformed

    private void btnCancelarPstLibActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarPstLibActionPerformed
        // TODO add your handling code here:
        limpiarPstLib();
    }//GEN-LAST:event_btnCancelarPstLibActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegPrestamo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegPrestamo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAltaAlumno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelarPstLib;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JButton btnRegistarPrsLib;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnVerificar;
    private com.toedter.calendar.JDateChooser calFechaEntrega;
    private com.toedter.calendar.JDateChooser calFechaPrestamo;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblVerificar;
    private javax.swing.JLabel lblVerificarIsbn1;
    private javax.swing.JTextField txtIdPrestamo;
    private javax.swing.JTextField txtIsbn1;
    private javax.swing.JTextField txtIsbn2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
