/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.laboratorio2ctomas;

/**
 *
 * @author carlo
 */

import vistas.Login; 
import javax.swing.SwingUtilities;

public class Laboratorio2ctomas {

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Login ventanaLogin = new Login();
                ventanaLogin.setLocationRelativeTo(null); 
                ventanaLogin.setVisible(true);
            }
        });
        
    }
}
