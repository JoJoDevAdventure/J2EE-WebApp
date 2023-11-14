package entite;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produit {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Use GenerationType.IDENTITY for auto-increment
	int id;
	String nom;
	String pren;
	int qte;
	@ManyToOne
    private Categorie categorie;
	
    public Produit() {
    	
    }

    public Produit(String nom, String pren, int qte, Categorie categorie) {
		this.nom = nom;
		this.pren = pren;
		this.qte = qte;
		this.categorie = categorie;
    }
    
    public Produit(int id, String nom, String pren, int qte, Categorie categorie) {
    	this.id = id;
		this.nom = nom;
		this.pren = pren;
		this.qte = qte;
		this.categorie = categorie;
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
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	@Override
	public String toString() {
		return "produit [id=" + id + ", nom=" + nom + ", pren=" + pren + ", qte=" + qte + "]";
	}

}
