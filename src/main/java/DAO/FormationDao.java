package DAO;
import model.Formation;
import model.Lieu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FormationDao {

    private static EntityManagerFactory ENTITY_MANAGER_FACTORY;

    static {
        try {
            ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("TP3_J2E");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addFormation(Formation formation) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            // Assurez-vous que le lieu associé à la formation existe en base de données
            int lieuId = formation.getLieuId();
            Lieu existingLieu = em.find(Lieu.class, lieuId);
            if (existingLieu == null) {
                // Si le lieu n'existe pas, persistez-le
                Lieu newLieu = new Lieu();
                newLieu.setId(lieuId);
                em.persist(newLieu);

                // Mettez à jour la formation avec le lieu persisté
                formation.setLieu(newLieu);
            } else {
                // Mettez à jour la formation avec le lieu existant
                formation.setLieu(existingLieu);
            }

            // Persistez la formation
            em.persist(formation);

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

    public void updateFormation(int id, String newTheme, int newLieuId) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            Formation formation = em.find(Formation.class, id);
            if (formation != null) {
                formation.setTheme(newTheme);

                // Récupérez le Lieu correspondant au nouvel ID
                Lieu newLieu = em.find(Lieu.class, newLieuId);
                if (newLieu != null) {
                    // Mettez à jour la relation
                    formation.setLieu(newLieu);
                }
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



    public Formation selectFormation(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        try {
            return em.find(Formation.class, id);
        } finally {
            em.close();
        }
    }
    public void deleteFormation(int id) {
        EntityManager em = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction et = null;
        try {
            et = em.getTransaction();
            et.begin();

            Formation formation = em.find(Formation.class, id);
            if (formation != null) {
                em.remove(formation);
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


    public void closeEntityManagerFactory() {
        if (ENTITY_MANAGER_FACTORY != null && ENTITY_MANAGER_FACTORY.isOpen()) {
            ENTITY_MANAGER_FACTORY.close();
        }
    }
}
