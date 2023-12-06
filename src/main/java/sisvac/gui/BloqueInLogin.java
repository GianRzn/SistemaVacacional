
package sisvac.gui;

import sisvac.ManejadorGui;
import javax.swing.JPanel;

/**
 *
 * @author frank
 */

// Implementación de la vista de inicio de sesión Swing
public class BloqueInLogin implements Bloque {
    private JPanel panel;
    private ManejadorGui gestorGui;  // Agrega una referencia al ManejadorGui

    public BloqueInLogin() {
        //this.gestorGui = gestorGui;
    }
    @Override
    public void initialize() {
        // Utiliza el panel diseñado en NetBeans
        panel = new BloqueInLoginGui();
    }

    @Override
    public JPanel getViewPanel() {
        return panel;
    }
}