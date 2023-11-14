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

import entite.Categorie;

public class GestionCategorieImpl implements IGestionCategorie{


		
	    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");
	    
	    EntityManager em = emf.createEntityManager();


		@Override
		public void addCategorie(Categorie p) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public List<Categorie> getAllCategories() {
	        EntityManager em = emf.createEntityManager();

	        try {
	            CriteriaBuilder cb = em.getCriteriaBuilder();
	            CriteriaQuery<Categorie> cq = cb.createQuery(Categorie.class);
	            Root<Categorie> root = cq.from(Categorie.class);
	            CriteriaQuery<Categorie> select = cq.select(root);
	            TypedQuery<Categorie> tq = em.createQuery(select);
	            return tq.getResultList();
	        } finally {
	            em.close();
	        }
		}

		@Override
		public void deleteAllCategories(int id) {

			
		}

		@Override
		public void updateCategorie(Categorie p) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Categorie getGategorie(int id) {
	        EntityManager em = emf.createEntityManager();

	        try {
	            return em.find(Categorie.class, id);
	        } finally {
	            em.close();
	        }
		}

		@Override
		public List<Categorie> getproduitsBYMC(String mc) {
			// TODO Auto-generated method stub
			return null;
		}
	

}
