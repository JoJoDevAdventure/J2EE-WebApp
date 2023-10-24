package Dao;

import java.util.List;

import entite.produit;

public interface IgestionCatalogue {
	public void addproduit(produit p);
	  List<produit> getAllProducts() ;
	  public void deleteProduct(int id);
		public void updateProduct(produit p);
		public produit getProduct(int id);
		public List<produit> getproduitsBYMC(String mc);

}
