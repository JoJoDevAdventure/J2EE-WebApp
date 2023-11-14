package Dao;

import java.util.List;

import entite.Produit;

public interface iGestCatalogue {
	
	public void addProduct(Produit p);

	List<Produit> getAllProducts();

	public void deleteProduct(int id);

	public void updateProduct(Produit p);

	public Produit getProduct(int id);

	public List<Produit> getproduitsBYMC(String mc);

}
