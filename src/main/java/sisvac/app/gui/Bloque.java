
package sisvac.app.gui;

import javax.swing.JPanel;

interface Bloque {
    void initialize();
    JPanel getViewPanel();  // Método para obtener el panel de la vista
}