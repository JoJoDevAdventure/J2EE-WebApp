package entite;

public class produit {
	int id;
	String nom;
	String pren;
	int qte;
	
	public produit(int id, String nom, String pren, int qte) {
		this.nom = nom;
		this.pren = pren;
		this.qte = qte;
		this.id=id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPren() {
		return pren;
	}

	public void setPren(String pren) {
		this.pren = pren;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	@Override
	public String toString() {
		return "produit [id=" + id + ", nom=" + nom + ", pren=" + pren + ", qte=" + qte + "]";
	}
	
	
	

}
