
package sisvac;

import java.util.ArrayList;
import java.util.List;
import sisvac.model.TrabajadorDao;
import sisvac.model.VacacionDao;
import sisvac.model.Trabajador;
import sisvac.model.Vacacion;

public class ManejadorDatos {
    
    public Trabajador buscarTrabajador(String dni){
       TrabajadorDao trabajadorDao = new TrabajadorDao();
       Trabajador empleado = trabajadorDao.obtenerTrabajador(dni);
       return empleado;
    }
    
    public List<Vacacion> buscarVacaciones(String dni){
        TrabajadorDao trabajadorDao = new TrabajadorDao();
        Trabajador empleado = trabajadorDao.obtenerTrabajador( dni);
        
        VacacionDao vacacionDao = new VacacionDao();
        
        List<Vacacion> vacacionList = vacacionDao.obtenerVacaciones(empleado.getCodigo());
        
        return vacacionList;
    }
    
    public List<Trabajador> buscarColaboradores(String dni){
       TrabajadorDao trabajadorDao = new TrabajadorDao();
       List<Trabajador> trabajadorList = trabajadorDao.obtenerColaboradores(dni);
       return trabajadorList;
    }
    
    public boolean actualizarVacacion(List<Vacacion>vacacionList,String dni){
        
       Trabajador empleado = buscarTrabajador(dni);
       int codigo = empleado.getCodigo();
       
       VacacionDao vacacionDao = new VacacionDao();
       vacacionDao.agregarVacaciones(vacacionList, codigo);
       
       return true;
    }
    
    
    
}
