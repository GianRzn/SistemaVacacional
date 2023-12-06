
package sisvac.model;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TrabajadorDao {
    final Connection appDbConexion;
    public TrabajadorDao(){
        DbConexion  DbConexionInstance =  DbConexion.getInstance(); 
        appDbConexion = DbConexionInstance.getConn();
    }
    
    public List<Trabajador> obtenerColaboradores(String dni) {
        System.out.println(" inicia el buscar colaboradores" );
                
        Trabajador trabajador = obtenerTrabajador(dni);
        int codigo = trabajador.getCodigo();
        List<Trabajador> trabajadorList = new ArrayList<>();
        String sql = "SELECT *  FROM trabajador WHERE codigo_jefe = '"+codigo+"'";
        try {
            Statement stmt  = appDbConexion.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("el codigo jefe : "+rs.getString("codigo_jefe") );
                Trabajador itemTrabajador;
                do {
                    itemTrabajador= new Trabajador ();
                    itemTrabajador.setCodigo(rs.getInt("codigo"));
                    itemTrabajador.setNombre(rs.getString("nombre")); 
                    itemTrabajador.setCargo(rs.getString("cargo")); 
                    itemTrabajador.setCodigo_jefe(rs.getString("codigo_jefe"));
                    itemTrabajador.setDni(rs.getString("dni")); 
                    itemTrabajador.setFecha_ingreso(rs.getString("fecha_ingreso"));
                    //itemTrabajador.setCorreo(rs.getString("nombre")); 
                    trabajadorList.add(itemTrabajador);
                
                } while (rs.next());
            }else{ 
                return null;
            }
        } catch (SQLException e) {
            System.out.println("error de sentencia SQL: "+sql );
            System.out.println(e.getMessage()+"<<<-");
            e.printStackTrace();
        } finally{
            
            System.out.println("sentencia SQL: "+sql );
            
        }
        //trabajadores.add(new Trabajador());
       
        return trabajadorList;
    }
    public Trabajador obtenerTrabajador(String dni){
        Trabajador theTrabajador = new Trabajador();
                
        String sql = "SELECT *  FROM trabajador WHERE dni = '"+dni+"'";
        
        try {
            Statement stmt  = appDbConexion.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("el codigo ::: "+rs.getString("codigo") );
                do {                    
                    theTrabajador.setCodigo(rs.getInt("codigo"));
                    theTrabajador.setDni(rs.getString("dni"));
                    theTrabajador.setNombre(rs.getString("nombre")); 
                    theTrabajador.setCargo(rs.getString("cargo")); 
                    theTrabajador.setFecha_ingreso(rs.getString("fecha_ingreso")); 
                } while (rs.next());
            }else{
                theTrabajador.setCodigo(0);
                return theTrabajador;
            }
        } catch (SQLException e) {
            System.out.println("error de sentencia SQL: "+sql );
            System.out.println(e.getMessage()+"<<<-");
            e.printStackTrace();
        }
             System.out.println("____:::"+theTrabajador.getNombre() );   
        return theTrabajador;
    }
    public Trabajador obtenerTrabajadorUsuario(String dni){
        Trabajador theTrabajador = new Trabajador();
      //  new DbConexion()
                
        String sql = "SELECT codigo, nombre, dni, usuario_pass, usuario_tipo  FROM trabajador WHERE dni = '"+dni+"'";
        
        try {
            Statement stmt  = appDbConexion.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                
                do {                    
                    theTrabajador.setCodigo(rs.getInt("codigo"));
                    theTrabajador.setNombre(rs.getString("nombre"));
                    theTrabajador.setDni(rs.getString("dni"));
                    theTrabajador.setUsuario_pass(rs.getString("usuario_pass")); 
                    theTrabajador.setUsuario_tipo(rs.getString("usuario_tipo")); 
                } while (rs.next());
            }else{
                theTrabajador.setCodigo(0);
                return theTrabajador;
            }
        } catch (SQLException e) {
            System.out.println("error de sentencia SQL: "+sql );
            System.out.println(e.getMessage()+"<<<-");
            e.printStackTrace();
        }
                
        return theTrabajador;
    }
}
