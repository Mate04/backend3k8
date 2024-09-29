import entities.Pedido;
import entities.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory mf = Persistence.createEntityManagerFactory("miUnidadPersistencia");
        EntityManager em = mf.createEntityManager();
        em.getTransaction().begin();
        Usuario usuario = new Usuario("Matias");
        em.persist(usuario);
        em.getTransaction().commit();
    }
}
