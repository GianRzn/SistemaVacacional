package sisvac;

import sisvac.app.gui.GestorGui;
import sisvac.app.gui.BloqueLogin;
import sisvac.app.sesion.GestorSesion;
import javax.swing.SwingUtilities;
import sisvac.data.database.DbConexion;


public class SistemaVacacional {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            // Este bloque de código se ejecutará en el hilo de eventos de Swing.
            startApplication();
        });
      
       
    }
    private static void startApplication() {
        
        //Inicio de Conexiones
        //DbConexion appDBConexion = new DbConexion(); 
        DbConexion appDB = DbConexion.getInstance();
        appDB.inicializar();
        
        //Inicio de Session
      //  GestorSesion appSesion = new GestorSesion(); 
        
        //Inicio de Información
        
        //Inicio de Pantallas
        GestorGui gui = GestorGui.getInstance();
        gui.initializeMainFrame();
        
            // Instanciar BloqueLogin con la referencia de GestorGui
            BloqueLogin loginView = new BloqueLogin(gui);
            loginView.initialize();
            gui.mostrarPanel("login");
            gui.showFrame();     
    } 
}
