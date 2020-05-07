package characters;

abstract public class Character {
	protected String nom;
	protected String imageURL;
	protected int niveauDeVie = 5;
	protected int forceAttaque = 5 ;

	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Character() {
		this.nom = "Inconnu";
		this.imageURL = "Inconnu";
		this.niveauDeVie = 5;
		this.forceAttaque = 5;
	}
	// Constructeur moit'
	public Character(String nom) {
		this.nom = nom;
		this.imageURL = "Inconnu";
		this.niveauDeVie = 5;
		this.forceAttaque = 5;
	}
	// Constructeur complet
	public Character(String nom, String imageURL) {
		if (nom.equals("") || imageURL.equals("")) {
			throw new IllegalArgumentException("Paramètres invalides. Réssayer");
		}
		this.nom = nom;
		this.imageURL = imageURL;
		//		this.niveauDeVie = niveauDeVie;
		//		this.forceAttaque = forceAttaque;
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
		if (forceAttaque<1) {
			this.forceAttaque = 1;
		}
		else {
			this.forceAttaque = forceAttaque;
		}
	}
	
	public abstract String toStringFull();
	public abstract String getLabelEquipementAttack();
	public abstract String getLabelEquipementDefense();
	public abstract void SetEquipementDefense(String new_value, int int_new);
	public abstract void SetEquipementAttack(String new_value, int int_new);
	public abstract void attaque();
	public abstract void defense();
	
}
