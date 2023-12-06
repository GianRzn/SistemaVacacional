/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sisvac.model;

public class Vacacion {
    private int id_vacacion;
    private int codigo_trabajador;
    private String fecha_inicio;
    private String fecha_fin;
    private int num_dias;
    public Vacacion(){
    }
    public Vacacion(
            int id_vacacion,int codigo_trabajador,String fecha_inicio,
            String fecha_fin,int num_dias){
        
        this.id_vacacion=id_vacacion;
        this.codigo_trabajador=codigo_trabajador;
        this.fecha_inicio=fecha_inicio;
        this.fecha_fin=fecha_fin;
        this.num_dias=num_dias;
    }
    public int getId_vacacion(){
        return id_vacacion;
    }
    public int getCodigo_trabajador(){
        return codigo_trabajador;
    }
    public String getFecha_inicio(){
        return fecha_inicio;
    }
    public String getFecha_fin(){
        return fecha_fin;
    }
    public int getNum_dias(){
        return num_dias;
    }
    public void setId_vacacion(int t){
        this.id_vacacion=t;
    }
    public void setCodigo_trabajador(int t){
        this.codigo_trabajador=t;
    }
    public void setFecha_inicio(String t){
        this.fecha_inicio=t;
    }
    public void setFecha_fin(String t){
        this.fecha_fin=t;
    }
    public void setNum_dias(int t){
        this.num_dias=t;
    }
}
