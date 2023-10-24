package Dao;

import entite.produit;

public class Test {
	public static void main(String[] args) {
		iGestCatalogue gestion = new gestCatalogue();
		
		gestion.addProduct(new produit(0, "Laptop Asus", "EFGH5GD678", 49));

	System.out.print(gestion.getAllProducts());	
		
	}

}
