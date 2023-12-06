/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisvac.gui;

/**
 *
 * @author frank
 */
public class BloqueFactory {
       public Bloque getBloque( String tipoBloque){
         switch (tipoBloque.toLowerCase()) {
                case "buscador":
                    return new BloqueInBuscador();
                case "empleado":
                    return new BloqueInEmpleado();
                case "vacaciones":
                    return new BloqueInVacaciones();
                case "colaboradores":
                    return new BloqueInColaboradores();
                case "login":
                default:
                    return new BloqueInLogin();
                    //throw new IllegalArgumentException("Tipo de forma no reconocido: " + shapeType);
            }

         
       }
}
