
package sisvac.app.gui;

import javax.swing.JPanel;

/**
 *
 * @author frank
 */

interface GestorGuiVista {
    void initialize();
    JPanel getViewPanel();  // Método para obtener el panel de la vista
}