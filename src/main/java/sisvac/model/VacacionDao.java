
package sisvac.model;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frank
 */
public class VacacionDao {
    final Connection appDbConexion;
    public VacacionDao(){
        DbConexion  DbConexionInstance =  DbConexion.getInstance(); 
        appDbConexion = DbConexionInstance.getConn();
    }
    public  List<Vacacion> obtenerVacaciones(int codigo ) {
        
        List<Vacacion> vacacionList = new ArrayList<>();
        String sql = "SELECT *  FROM vacacion WHERE codigo_trabajador = '"+codigo+"'";
        try {
            Statement stmt  = appDbConexion.createStatement();
            ResultSet rs    = stmt.executeQuery(sql);
            if(rs.next()){
                System.out.println("el codigo jefe : "+rs.getString("codigo_trabajador") );
                Vacacion itemVacacion;
                do {
                    itemVacacion= new Vacacion ();
                    itemVacacion.setId_vacacion(rs.getInt("id_vacacion"));
                    itemVacacion.setCodigo_trabajador(rs.getInt("codigo_trabajador")); 
                    itemVacacion.setFecha_inicio(rs.getString("fecha_inicio")); 
                    itemVacacion.setFecha_fin(rs.getString("fecha_fin"));
                    itemVacacion.setNum_dias(rs.getInt("num_dias")); 
                    //itemTrabajador.setCorreo(rs.getString("nombre")); 
                    vacacionList.add(itemVacacion);
                
                } while (rs.next());
            }else{ 
                //return null;
            }
        } catch (SQLException e) {
            System.out.println("error de sentencia SQL: "+sql );
            System.out.println(e.getMessage()+"<<<-");
            e.printStackTrace();
        } finally{
            
            System.out.println("sentencia SQL: "+sql );
            
        }
        //trabajadores.add(new Trabajador());
       
       return vacacionList;
    }
    
    public  boolean borrarVacaciones(List<Vacacion> vacacionList, String codigo_trabajador) {
        String sqlInsert = "INSERT INTO vacacion (columna) VALUES (?)";
        return true;
    }
    public  boolean agregarVacaciones(List<Vacacion> vacacionList, int codigo_trabajador) {
        
        String sqlInsert = "INSERT INTO vacacion (codigo_trabajador, fecha_inicio, fecha_fin, num_dias) VALUES (?, ?, ?, ?)";
        try {
            
            if (!vacacionList.isEmpty()) {
            // Bucle for-each para iterar sobre la lista
            for (Vacacion vacacionItem : vacacionList) {
                
                PreparedStatement stmt  = appDbConexion.prepareStatement(sqlInsert);
                stmt.setString(1, "1");
                stmt.setString(2, "2");
                stmt.setString(3, "3");
                stmt.setString(4, "4");
                int filasInsertadas = stmt.executeUpdate();

                System.out.println("insertadas:"+filasInsertadas+vacacionItem);
            }
        } else {
            System.out.println("La lista está vacía.");
        }
            
        } catch (SQLException e) {
            System.out.println("error de sentencia SQL: "+sqlInsert );
            System.out.println(e.getMessage()+"<<<-");
            e.printStackTrace();
        } finally{
            
            System.out.println("sentencia SQL: "+sqlInsert );
            
        }
        //trabajadores.add(new Trabajador());
       
       return true;
    }
}
