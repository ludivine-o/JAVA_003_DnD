package dnd;

abstract public class Perso {
	protected String nom;
	protected String imageURL;
	protected int niveauDeVie;
	protected int forceAttaque;

	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Perso() {
		this.nom = "Inconnu";
		this.imageURL = "Inconnu";
		this.niveauDeVie = 5;
		this.forceAttaque = 5;
	}
	// Constructeur moit'
	public Perso(String nom) {
		this.nom = nom;
		this.imageURL = "Inconnu";
		this.niveauDeVie = 5;
		this.forceAttaque = 5;
	}
	// Constructeur complet
	public Perso(String nom, String imageURL, int niveauDeVie, int forceAttaque) {
		if (nom.equals("") || imageURL.equals("")) {
		throw new IllegalArgumentException("Paramètres invalides. Réssayer");
	}
		this.nom = nom;
		this.imageURL = imageURL;
		this.niveauDeVie = niveauDeVie;
		this.forceAttaque = forceAttaque;
	}
	
	/* ---------------------------Methods() ---------------------- */
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getURL() {
		return imageURL;
	}
	public void setURL(String imageURL) {
		this.imageURL = imageURL;
	}
	public int getLife() {
		return niveauDeVie;
		
	}
	public void setLife(int niveauDeVie) {
		this.niveauDeVie = niveauDeVie;
	}
	public int getAttack() {
		return forceAttaque;
	}
	public void setAttack(int forceAttaque) {
		this.forceAttaque = forceAttaque;
	}
	
	abstract String toStringFull();
	abstract String getLabelEquipementAttack();
	abstract String getLabelEquipementDefense();
	abstract void SetEquipementDefense(String new_value, int int_new);
	abstract void SetEquipementAttack(String new_value, int int_new);
	abstract void attaque();
	abstract void defense();
	
}
