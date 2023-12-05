
package sisvac.data.database.dao;


import java.sql.Connection;
import sisvac.data.database.DbConexion;
import sisvac.data.model.Trabajador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frank
 */
public class TrabajadorDao {
    final Connection appDbConexion;
    public TrabajadorDao(){
        DbConexion  DbConexionInstance =  DbConexion.getInstance(); 
        appDbConexion = DbConexionInstance.getConn();
    }
    
    public List<Trabajador> obtenerSubordinados() {
        List<Trabajador> trabajadores = new ArrayList<>();
        trabajadores.add(new Trabajador());
       
        return trabajadores;
    }
    public Trabajador obtenerTrabajador(String dni){
        Trabajador theTrabajador = new Trabajador();
      //  new DbConexion()
                
        String sql = "SELECT *  FROM trabajador WHERE dni = '"+dni+"'";
        
        try {
            Statement stmt  = appDbConexion.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("el codigo ::: "+rs.getString("codigo") );
                do {                    
                    theTrabajador.setCodigo(rs.getString("codigo"));
                    theTrabajador.setDni(rs.getString("dni"));
                    theTrabajador.setNombre(rs.getString("nombre")); 
                    theTrabajador.setCargo(rs.getString("cargo")); 
                    theTrabajador.setFecha_ingreso(rs.getString("fecha_ingreso")); 
                } while (rs.next());
            }else{
                theTrabajador.setCodigo("0");
                return theTrabajador;
            }
        } catch (SQLException e) {
            System.out.println("error de sentencia SQL: "+sql );
            System.out.println(e.getMessage()+"<<<-");
            e.printStackTrace();
        }
             System.out.println("____:::"+theTrabajador.getCodigo() );   
        return theTrabajador;
    }
    public Trabajador obtenerTrabajadorUsuario(String dni){
        Trabajador theTrabajador = new Trabajador();
      //  new DbConexion()
                
        String sql = "SELECT codigo, dni, usuario_pass  FROM trabajador WHERE dni = '"+dni+"'";
        
        try {
            Statement stmt  = appDbConexion.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                
                do {                    
                    theTrabajador.setCodigo(rs.getString("codigo"));
                    theTrabajador.setDni(rs.getString("dni"));
                    theTrabajador.setUsuario_pass(rs.getString("usuario_pass")); 
                    theTrabajador.setUsuario_tipo(rs.getString("usuario_tipo")); 
                } while (rs.next());
            }else{
                theTrabajador.setCodigo("0");
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
