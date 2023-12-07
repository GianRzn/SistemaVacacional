package sisvac;

import sisvac.gui.BloqueInLogin;
import javax.swing.SwingUtilities;
import sisvac.model.DbConexion;


public class SistemaVacacional {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            startApplication();
        });
      
       
    }
    private static void startApplication() {
        
        
        //DbConexion appDBConexion = new DbConexion(); 
        DbConexion appDB = DbConexion.getInstance();
        appDB.inicializar();
        
        //Inicio de Session
        ManejadorSesion appSesion = ManejadorSesion.getInstance(); 
        appSesion.inicializar();
        
        //Inicio de Pantallas
        ManejadorGui gui = ManejadorGui.getInstance();
        gui.inicializar();
        
            // Instanciar BloqueInLogin con la referencia de ManejadorGui
            BloqueInLogin loginView = new BloqueInLogin();
            loginView.initialize();
            gui.mostrarPanel("login");
            gui.showFrame();     
    } 
}
