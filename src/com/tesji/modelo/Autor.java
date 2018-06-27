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
public class Autor {
     private ConexionMySQL conexion = new ConexionMySQL();//Instancia a la clase conexion
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Autor() {
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
     public boolean alta(String nomb, String pat, String mat){
        try {
            String query = "INSERT INTO autor VALUES(NULL,'"+nomb+"','"+pat+"','"+mat+"')";
                   //inserta una sentencia sql
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
