/*
n                zzzzzzg                                         * To change this license header, choose License Headers in Project Properties.
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
public class Categoria {

    private ConexionMySQL conexion = new ConexionMySQL();//Instancia a la clase conexion
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public Categoria() {
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
      //Inserta un nueva categoria en la Base de Datos
    public boolean alta(String nombCategoria){
        try {
            String query = "INSERT INTO categoria VALUES(null,'"+nombCategoria
                    +"')";//inserta una sentencia sql
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ResultSet mostrarTodasCat() {
        try {
            String query = "SELECT * FROM categoria";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet mostrarPorNombre(String nomb){
          try{
            String query = "SELECT * FROM categoria WHERE nombCategoria LIKE '%"+nomb+"%'";
            rs = st.executeQuery(query);
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public ResultSet mostrarPorId(int id){
       try{
            String query = "SELECT * FROM categoria WHERE idCategoria = "+id;
            rs = st.executeQuery(query);
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        } 
    }
    public boolean actualizarCat(int id,String categoria){
        try {
            String query = "UPDATE categoria SET"
                    + " nombCategoria = '"+categoria+"' WHERE idCategoria = "+id;
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean eliminar(int id){
        try {
            String query = "DELETE FROM categoria WHERE idCategoria = '"+id+"'";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
