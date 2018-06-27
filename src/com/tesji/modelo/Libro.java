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
public class Libro {

    private ConexionMySQL conexion = new ConexionMySQL();//Instancia a la clase conexion
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Libro() {
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

    public ResultSet llenarEditorial() {
        try {
            String query = "SELECT nombre FROM editorial ORDER BY nombre";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean alta(String isbn, String titulo, String desLibro, int existencia, String edit, String cat, int edicion) {
        try {
            String query = "INSERT INTO libro VALUES ('" + isbn + "','" + titulo + "','" + desLibro + "'," + existencia
                    + ",(SELECT idEditorial"
                    + " FROM editorial  WHERE nombre='" + edit + "'),"
                    + "(SELECT idCategoria FROM categoria WHERE nombCategoria='" + cat + "')," + edicion + ")";//inserta una sentencia sql
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet mostrarTodosLibros() {
        try {
            String query = "SELECT libro.isbn, libro.titulo, libro.descripLibro, "
                    + "libro.existencia, editorial.nombre, categoria.nombCategoria, libro.noEdicion"
                    + " FROM libro "
                    + "INNER JOIN editorial On editorial.idEditorial = libro.idEditorial "
                    + "INNER JOIN categoria on categoria.idCategoria = libro.idCategoria;";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet mostrarEditoria(String editorial) {
        try {
            String query = "SELECT libro.isbn, libro.titulo, libro.descripLibro, "
                    + "libro.existencia, editorial.nombre, categoria.nombCategoria, libro.noEdicion"
                    + " FROM libro "
                    + "INNER JOIN editorial On editorial.idEditorial = libro.idEditorial "
                    + "INNER JOIN categoria on categoria.idCategoria = libro.idCategoria "
                    + "WHERE editorial.nombre='" + editorial + "';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet mostrarCategoria(String cat) {
        try {
            String query = "SELECT libro.isbn, libro.titulo, libro.descripLibro, "
                    + "libro.existencia, editorial.nombre, categoria.nombCategoria, libro.noEdicion"
                    + " FROM libro "
                    + "INNER JOIN editorial On editorial.idEditorial = libro.idEditorial "
                    + "INNER JOIN categoria on categoria.idCategoria = libro.idCategoria "
                    + "WHERE categoria.nombCategoria='" + cat + "';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet mostrarTitulo(String titulo) {
        try {
            String query = "SELECT libro.isbn, libro.titulo, libro.descripLibro, "
                    + "libro.existencia, editorial.nombre, categoria.nombCategoria, libro.noEdicion"
                    + " FROM libro "
                    + "INNER JOIN editorial On editorial.idEditorial = libro.idEditorial "
                    + "INNER JOIN categoria on categoria.idCategoria = libro.idCategoria "
                    + "WHERE libro.titulo LIKE '%" + titulo + "%';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet mostrarId(String isbn) {
        try {
            String query = "SELECT libro.isbn, libro.titulo, libro.descripLibro, "
                    + "libro.existencia, editorial.nombre, categoria.nombCategoria, libro.noEdicion"
                    + " FROM libro "
                    + "INNER JOIN editorial On editorial.idEditorial = libro.idEditorial "
                    + "INNER JOIN categoria on categoria.idCategoria = libro.idCategoria "
                    + "where libro.isbn = '" + isbn + "';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean actualizarLibro(String isbn, String titulo, String desLibro, int existencia, String edit, String cat, int edicion) {
        try {
            String query = "UPDATE libro SET titulo = '" + titulo + "', descripLibro = '" + desLibro + "', "
                    + "existencia = "+existencia+", idEditorial = (SELECT idEditorial FROM editorial WHERE nombre= '"+edit+"'), "
                    + "idCategoria = (SELECT idCategoria FROM categoria WHERE nombCategoria= '"+cat+"'), "
                    + "noEdicion = "+edicion
                    + " WHERE isbn ='"+isbn+"'";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
