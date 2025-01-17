package projeto.unipar.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory emf;
    private static EntityManager em;

    public EntityManagerUtil() {
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("migracao");
            System.out.println("conexão aberta!");
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if (emf != null && emf.isOpen()) {
            emf.close();
            System.out.println("conexão fechada!");
        }
    }

    public static EntityManager getManager() {
        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
            System.out.println("entity manager aberta!");
        }
        return em;
    }

}
