package Dao;

import java.util.List;  

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import entite.Produit;

public class GestionCatalogueImpl implements iGestCatalogue {
	
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
    
    EntityManager em = emf.createEntityManager();
    
    @Override
    public void addProduct(Produit p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.persist(p);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }

    @Override
    public List<Produit> getAllProducts() {
        EntityManager em = emf.createEntityManager();

        try {
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<Produit> cq = cb.createQuery(Produit.class);
            Root<Produit> root = cq.from(Produit.class);
            CriteriaQuery<Produit> select = cq.select(root);
            TypedQuery<Produit> tq = em.createQuery(select);
            return tq.getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteProduct(int id) {
    		EntityTransaction et=em.getTransaction();
    		et.begin();
    		em. remove(getProduct(id));
    		et.commit();
    }

    @Override
    public void updateProduct(Produit p) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            em.merge(p);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
    
    @Override
    public Produit getProduct(int id) {
        EntityManager em = emf.createEntityManager();

        try {
            return em.find(Produit.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Produit> getproduitsBYMC(String mc) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Produit> query = em.createQuery(
                "SELECT p FROM produit p WHERE p.nom LIKE :mc", Produit.class);
            query.setParameter("mc", "%" + mc + "%");
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}
