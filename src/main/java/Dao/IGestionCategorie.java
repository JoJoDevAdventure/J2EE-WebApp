package Dao;

import java.util.List;

import entite.Categorie;

public interface IGestionCategorie {
	
	public void addCategorie(Categorie p);

	List<Categorie> getAllCategories();

	public void deleteAllCategories(int id);

	public void updateCategorie(Categorie p);

	public Categorie getGategorie(int id);

	public List<Categorie> getproduitsBYMC(String mc);
}
