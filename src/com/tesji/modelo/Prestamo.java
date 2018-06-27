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
public class Prestamo {

    private ConexionMySQL conexion = new ConexionMySQL();//Instancia a la clase conexion
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Prestamo() {
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

    public boolean ingresarPrestamos(String prestamo, String entrega, int usuario) {
        try {
            String query = "INSERT INTO prestamo VALUES (null,'" + entrega + "','" + prestamo + "'," + usuario + ")";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean ingresarPrestamoLibro(String isbn, int idPrestamo, String status) {
        try {
            String query = "INSERT INTO prestamolibro VALUES (null,'" + isbn + "'," + idPrestamo + ", (SELECT idEstatus FROM estatus WHERE descripcionEstatus = '" + status + "'))";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet mostrarUsuario(int id) {
        try {
            String query = "SELECT nombre FROM usuario where idUsuario = " + id;
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet llenarStatus() {
        try {
            String query = "SELECT descripcionEstatus FROM estatus ORDER BY descripcionEstatus";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet mostrar() {
        try {
            String query = "SELECT idPrestamo FROM prestamo ORDER BY idPrestamo DESC LIMIT 1";
            rs = st.executeQuery(query);

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet mostrarIsbn(String isbn) {
        try {
            String query = "SELECT isbn from libro where isbn = '" + isbn + "'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
