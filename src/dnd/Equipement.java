package dnd;

abstract public class Equipement {
	private String nom;
		
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Equipement() {
		this.nom = "Inconnu";
	}
	// Constructeur complet
	public Equipement(String nom) {
		this.nom = nom;
	}

	/* ---------------------------Methods() ---------------------- */
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


}
