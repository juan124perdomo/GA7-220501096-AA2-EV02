
package persistencia;

import java.util.List;
import logica.Ordenes;


public class ControladoraPersistencia {
    
    OrdenesJpaController usuJpa = new OrdenesJpaController();
    
    public void crearOrden(Ordenes usu){
        usuJpa.create(usu);
    }
    
    public List<Ordenes> traerOrdenes(){
            
        
        return usuJpa.findOrdenesEntities();
    }
    
    
}
