/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tesji.modelo;

import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author Mitzi_Torales
 */
public  class Validar {
    
    public static void soloNumeros(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char letra = evt.getKeyChar();
                if(Character.isLetter(letra)){
                    evt.consume();
                    //getToolkit().beep();sonido
                }
            }
        });
    }    
    public static void soloLetras(JTextField txt) {
        txt.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt){
                char letra = evt.getKeyChar();
                if(Character.isDigit(letra)){
                    evt.consume();
                    //getToolkit().beep();sonido
                }
            }
        });
    }   
}
