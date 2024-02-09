package DAO;
import model.Lieu;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class LieuDao {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        try {
            ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("TP3_J2E");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addLieu(Lieu lieu) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            em.persist(lieu);

            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }
    public static void updateLieu(int idLieu, String newadresse, String newville) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            Lieu lieu = em.find(Lieu.class, idLieu);
            if (lieu != null) {
                lieu.setAdresse(newadresse);
                lieu.setVille(newville);
            }

            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void deleteLieu(int idLieu) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

           Lieu lieu = em.find(Lieu.class, idLieu);
            if (lieu != null) {
                em.remove(lieu);
            }

            et.commit();
        } catch (Exception ex) {
            if (et != null && et.isActive()) {
                et.rollback();
            }
            ex.printStackTrace();
            em.close();
        }
    }
    public static Lieu selectLieu(int idLieu) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        try {
            return em.find(Lieu.class, idLieu);
        } finally {
            em.close();
        }
    }

    public void closeEntityManagerFactory() {
        if (ENTITY_MANAGER_FACTORY != null && ENTITY_MANAGER_FACTORY.isOpen()) {
            ENTITY_MANAGER_FACTORY.close();
        }
    }
}
