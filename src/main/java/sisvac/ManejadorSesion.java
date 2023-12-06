/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisvac;

import sisvac.model.TrabajadorDao;
import sisvac.model.Trabajador;
import java.util.List;

/**
 *
 * @author frank
 */
public class ManejadorSesion {
    private static ManejadorSesion instance;
    private int userId;
    private String userNombre ="";
    private String userTipo = "";
    private String dni = "";
    private String msg ="";
    
    public ManejadorSesion( ) {
        // Constructor privado para evitar instanciación directa
    }
    public static ManejadorSesion getInstance() {
        if (instance == null) {
            instance = new ManejadorSesion();
        }
        return instance;
    }
    
    public void inicializar(){
        
       userId = 0;
       userNombre ="";
       userTipo = "";
       msg ="";
    }
    public  boolean login(String u, String p){
        boolean respuesta;
        if( esFormatoValido( u,  p) ){
            
            if (esUsuario(u,p)){
                respuesta = true;
            } else {
                respuesta = false;
            }
        }else{
            respuesta = false;
        }
        System.out.println("respuesta  "+respuesta );
        return respuesta;
    }
    public  boolean esFormatoValido(String u, String p){
        //validaciones
        //DNI y pass != vacio;
        //DNI Numerico
        //DNI Registrado
        //Password Igual
        return true;
        
    }

    public  boolean esUsuario(String u, String p){
        boolean respuesta = false;
        TrabajadorDao tDao = new TrabajadorDao();
        Trabajador tUsuario = tDao.obtenerTrabajadorUsuario(u);
        System.out.println("comparando| " +tUsuario  );
        if (tUsuario == null){
            respuesta = false;
        } else if ( u.equals(tUsuario.getDni()) ){
            userId = tUsuario.getCodigo();
            userNombre =tUsuario.getNombre();
            userTipo = tUsuario.getUsuario_tipo();
            dni = tUsuario.getDni();
            msg ="usuario logeado|"+userId+": "+userNombre+": "+userTipo;
            respuesta = true;
        }
        System.out.println("comparando| " +u+ " : "+getUserTipo() );
        return respuesta;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserNombre() {
        return userNombre;
    }

    public String getUserTipo() {
        return userTipo;
    }
    public String getDni() {
        return dni;
    }
    public String getMsg() {
        return msg;
    }
    
}
