
package persistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Ordenes;


public class ControladoraPersistencia {
    
    OrdenesJpaController usuJpa = new OrdenesJpaController();
    
    public void crearOrden(Ordenes usu){
        usuJpa.create(usu);
    }
    
    public List<Ordenes> traerOrdenes(){
            
        
        return usuJpa.findOrdenesEntities();
    }

    public void borrarOrden(int id_eliminar) {
        try {
            usuJpa.destroy(id_eliminar);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
