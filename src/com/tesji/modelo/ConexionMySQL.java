/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesji.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Mitzi_Torales
 */
public class ConexionMySQL {

    private String usuario = "root";
    private String pass = "familiadetijuana";
    private String host = "localhost";
    private String nombre_BD = "biblioteca";

    private Connection con = null;

    public Connection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance(); 
            String servidor = "jdbc:mysql://" + host + "/" + nombre_BD;
            con = DriverManager.getConnection(servidor, usuario, pass);
            return con;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, "Error con la conexion en el servidor"
                    + " de Base de Datos");
            return null;
        }
    }
}