/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisvac.app.sesion;

import sisvac.data.database.dao.TrabajadorDao;
import sisvac.app.gui.GestorGui;
import sisvac.data.model.Trabajador;
import java.util.List;

/**
 *
 * @author frank
 */
public class GestorSesion {
    private static GestorSesion instance;
    private int userId;
    private String userNombre;
    private String userTipo;
    private String msg;
    
    public GestorSesion( ) {
        // Constructor privado para evitar instanciación directa
    }
    public static GestorSesion getInstance() {
        if (instance == null) {
            instance = new GestorSesion();
        }
        return instance;
    }
    
    public void initializeSesion(){
        
    }
    public  boolean login(String u, String p){
        
        if( esFormatoValido( u,  p) ){
            
            int uId = 7;
            String uPass = "admin";
            String uNombre = "Frank";
            String uTipo = "colaborador";
            
            return true;
        }else{
            return false;
        }
        
    }
    public  boolean esFormatoValido(String u, String p){
        //validaciones
        //DNI y pass != vacio;
        //DNI Numerico
        //DNI Registrado
        //Password Igual
        return true;
        
    }
   // public  Trabajador buscaUsuario(String u){
        
        
     /*  TrabajadorDao trabajadordb = new TrabajadorDao(); 
       Trabajador trabajadorUsuario = trabajadordb.obtenerTrabajadorSegunDni(u);
       trabajadorUsuario.toString();
       
                System.out.println("validando al usuario");
                *
        return trabajadorUsuario;*/
        
        
        
   // }
  
    
}
