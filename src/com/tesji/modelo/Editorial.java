/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesji.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Mitzi_Torales
 */
public class Editorial {

    private ConexionMySQL conexion = new ConexionMySQL();//Instancia a la clase conexion
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Editorial() {
        try {
            if ((con = conexion.conectar()) == null) {
                JOptionPane.showMessageDialog(null, "Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean alta(String nomb, String pais, String fecha) {
        try {
            String query = "INSERT INTO editorial VALUE (null,'"+nomb+
                    ",(SELECT pais.idPais From pais WHERE pais.nombre = '"+pais+"'),'"+fecha+"')";
            //inserta una sentencia sql
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}