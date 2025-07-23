
package logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ordenes implements Serializable {
    
    
    @Id
    @GeneratedValue (strategy=GenerationType.AUTO)
    private int id;
    private String nombre;
    private String tipo_orden;
    private String descripcion;

    public Ordenes() {
    }

    public Ordenes(int id, String nombre, String tipo_orden, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo_orden = tipo_orden;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

  

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo_orden() {
        return tipo_orden;
    }

    public void setTipo_orden(String tipo_orden) {
        this.tipo_orden = tipo_orden;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
