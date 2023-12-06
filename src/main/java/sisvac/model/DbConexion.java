package sisvac.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConexion {
    private Connection conn;
    private static DbConexion instance;
    private DbConexion() {}
    public void  inicializar() {
        System.out.println("Inntento conexion to SQLite 1.");
        //conn = null;
        try {
            
            // db parameters
            String url = "jdbc:sqlite:SQLite/dbSistemaVacacional.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
           /* try {
                if (conn != null) {
                    System.out.println(" conexion funciona perfecto");
                    //conn.close();
                }
            } catch (SQLException ex) {
                System.out.println("No se ha establecido la conexion");
                //System.out.println(ex.getMessage());
            }*/
           
           System.out.println("Intento de connect realizado");
        }
    }
    //Regresa Instancia, primero la establece si no existe previamente;
    public static DbConexion getInstance() {
        if (instance == null) {
            instance = new DbConexion();
        }
        return instance;
    }
    
    //Getter
    public Connection getConn(){
        return conn;
    }
  
}
