
package sisvac.data.model;

/**
 *
 * @author frank
 */
public class Trabajador {
    private String codigo;
    private String nombre;
    private String cargo;
    private String codigo_jefe;
    private String dni;
    private String fecha_ingreso;
    private String usuario_pass;
    private String usuario_tipo;
    
    public Trabajador (){
        this.dni = "";
        this.usuario_pass = "";
          this.usuario_pass = "";
    }
    public Trabajador (String dni, String pass){
        
        this.dni = dni;
        this.usuario_pass = pass;
    }
    public Trabajador (String codigo, String nombre, String cargo, String codigo_jefe, 
            String dni,String fecha_ingreso, String pass){
        this.codigo = codigo;
        this.nombre = nombre;
        this.cargo = cargo;
        this.codigo_jefe = codigo_jefe;
        this.dni = dni;
        this.fecha_ingreso= fecha_ingreso;
        this.usuario_pass = pass;
        
    }
    
    public String getCodigo(){
        return this.codigo;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getCargo(){
        return this.cargo;
    }
    public String getCodigo_jefe(){
        return this.codigo_jefe;
    }
    public String getDni(){
        return this.dni;
    }
    public String getFecha_ingreso(){
        return this.fecha_ingreso;
    }
    public String getUsuario_pass(){
        return this.usuario_pass;
    }
    public String getUsuario_tipo(){
        return this.usuario_pass;
    }
    
    public void setCodigo(String s){
        this.codigo = s;
    }
    public void setNombre(String s){
        this.nombre= s;
    }
    public void setCargo(String s){
        this.cargo= s;
    }
    public void setCodigo_jefe(String s){
        this.codigo_jefe= s;
    }
    public void setDni(String s){
        this.dni= s;
    }
    public void setFecha_ingreso(String s){
        this.fecha_ingreso = s;
    }
    public void setUsuario_pass(String s){
        this.usuario_pass= s;
    }
    public void setUsuario_tipo(String s){
        this.usuario_pass= s;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + fecha_ingreso +
                '}';
    }
}

