
package logica;

import java.util.List;
import persistencia.ControladoraPersistencia;

/**
 *
 * @author juanz
 */
public class Controladora {
    
    ControladoraPersistencia controlpersis = new ControladoraPersistencia();
    
    public void crearOrden(Ordenes usu){
        controlpersis.crearOrden(usu);
    }
    public List<Ordenes> traerOrdenes(){
        return controlpersis.traerOrdenes();
    }
    
    public void borrarOrden(int id_eliminar){
        controlpersis.borrarOrden(id_eliminar);
        
    }

    public Ordenes traerOrden(int id_editar) {
       return controlpersis.traerOrden(id_editar);
        
        
        
        
    }

    public void editarOrdenes(Ordenes usu) {
        
        
        controlpersis.editarOrdenes(usu);
    }
    
}
