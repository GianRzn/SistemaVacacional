/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisvac.app.gui;

import javax.swing.JPanel;

/**
 *
 * @author frank
 */

class BloqueBVacaciones implements GestorGuiVista {
    private JPanel panel;

    @Override
    public void initialize() {
        // Utiliza el panel diseñado en NetBeans
        panel = new BloqueBVacacionesGui();
    }

    @Override
    public JPanel getViewPanel() {
        return panel;
    }
}