
package sisvac.app.gui;

import javax.swing.JPanel;

/**
 *
 * @author frank
 */

// Implementación de la vista de inicio de sesión Swing
public class BloqueLogin implements Bloque {
    private JPanel panel;
    private GestorGui gestorGui;  // Agrega una referencia al GestorGui

    public BloqueLogin(GestorGui gestorGui) {
        this.gestorGui = gestorGui;
    }
    @Override
    public void initialize() {
        // Utiliza el panel diseñado en NetBeans
        panel = new BloqueLoginGui(gestorGui);
    }

    @Override
    public JPanel getViewPanel() {
        return panel;
    }
}