package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import logica.Ordenes;

public class OrdenesJpaController implements Serializable {

    public OrdenesJpaController(EntityManagerFactory emf ) {
        this.emf = Persistence.createEntityManagerFactory("OrdenesPU");
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
        
    }

    public OrdenesJpaController() {
        emf = Persistence.createEntityManagerFactory("OrdenesPU");
    }
    
    
    public void create(Ordenes orden) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(orden);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Ordenes orden) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            orden = em.merge(orden);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findOrdenes(orden.getId()) == null) {
                throw new Exception("La orden con id " + orden.getId() + " no existe.");
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Ordenes orden;
            try {
                orden = em.getReference(Ordenes.class, id);
                orden.getId();
            } catch (EntityNotFoundException enfe) {
                throw new Exception("La orden con id " + id + " no existe.", enfe);
            }
            em.remove(orden);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Ordenes> findOrdenesEntities() {
        return findOrdenesEntities(true, -1, -1);
    }

    public List<Ordenes> findOrdenesEntities(int maxResults, int firstResult) {
        return findOrdenesEntities(false, maxResults, firstResult);
    }

    private List<Ordenes> findOrdenesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT o FROM Ordenes o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Ordenes findOrdenes(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Ordenes.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrdenesCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("SELECT COUNT(o) FROM Ordenes o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}