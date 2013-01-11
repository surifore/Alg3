/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.esi.g34754.alg3.carrefour.database;

import be.esi.g34754.alg3.carrefour.entity.Alerte;
import be.esi.g34754.alg3.carrefour.entity.ChangementFeu;
import be.esi.g34754.alg3.carrefour.entity.Parametres;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Florian
 */
public class CarrefourDB {

    public void saveChangement(ChangementFeu etat){
        persist(etat);
    }
    
    public void saveAlerte(Alerte alerte){
        persist(alerte);
    }
     
    public void saveParametres(Parametres param){
        persist(param);
    }
    
    public void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CarrefourPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
