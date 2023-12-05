package sisvac.app.servicio;

import java.util.List;
import sisvac.data.database.dao.TrabajadorDao;
import sisvac.data.database.DbConexion;
import sisvac.data.model.Trabajador;
import sisvac.data.model.Vacacion;

public class Colector {
    private String db; 
    
    public Trabajador empleado; //informacion empleado
    public List<Vacacion> vacaciones;  //informacion de las vacaciones del empleado
    public List<Colector> subempleados; //informacion de sus subordinados
    
    public Colector(String dni) {
       TrabajadorDao trabajadorDao = new TrabajadorDao();
       
       empleado = trabajadorDao.obtenerTrabajador(dni);
       if(empleado != null){
           //trabajadorDao.obtenerVacaciones(dni);
       }
       
    }
    
    
    
    
}
    
 
   
