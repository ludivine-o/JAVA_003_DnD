package equipment;

abstract public class Equipment {
	private String nom;
		
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Equipment() {
		this.nom = "Inconnu";
	}
	// Constructeur complet
	public Equipment(String nom) {
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
