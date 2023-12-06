/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisvac.gui;

import javax.swing.JPanel;

/**
 *
 * @author frank
 */

public class BloqueInBuscador implements Bloque {
    private JPanel panel;

    @Override
    public void initialize() {
        // Utiliza el panel diseñado en NetBeans
        panel = new BloqueInBuscadorGui();
    }

    @Override
    public JPanel getViewPanel() {
        return panel;
    }
}