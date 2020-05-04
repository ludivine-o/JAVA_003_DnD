package dnd;

public class Warrior{
	private String nom;
	private String imageURL;
	private int niveauDeVie;
	private int niveauDeVieMin = 5;
	private int niveauDeVieMax = 10;
	private int forceAttaque;
	private int forceAttaqueMin = 5;
	private int forceAttaqueMax = 10;
	private Arme arme;
	private Bouclier bouclier;
	

	/* ---------------------------Methods ----------------------*/
	public String toString() {
		return this.nom + " est un Guerrier. Il a " + this.niveauDeVie + " de vie, et " + this.forceAttaque + " d'attaque." ;
	}
	
	// Getters
	public String getName() {
		return this.nom;
	}
	public String getURL() {
		return this.imageURL;
	}
	public int getLife() {
		return this.niveauDeVie;
	}
	public int getAttack() {
		return this.forceAttaque;
	}
	public String getArme() {
		return this.arme.nom;
	}
	public String getBouclier() {
		return this.bouclier.nom;
	}

	//Setters
	public void setName(String newValue) {
		this.nom = newValue;
	}
	public void setURL(String newValue) {
		this.imageURL = newValue;
	}
	public void setLife(int newValue) {
		this.niveauDeVie = newValue;
	}
	public void setAttack(int newValue) {
		this.forceAttaque = newValue;
	}
	public void setArme(Arme newValue) {
		this.arme = newValue;
	}
	public void setBouclier(Bouclier newValue) {
		this.bouclier = newValue;
	}
	
		
	/* ---------------------------Constructors ----------------------*/
	
	//Constructeur par defaut
	public Warrior () {
		nom = "Inconnu";
		imageURL = "Pas d'image";
		niveauDeVie = 5;
		forceAttaque = 5;
		arme = new Arme();
		bouclier = new Bouclier();
	}

	//Constructeur moit'
	public Warrior (String name) {
		nom = name;
		imageURL = "Pas d'image";
		niveauDeVie = 5;
		forceAttaque = 5;
		arme = new Arme();
		bouclier = new Bouclier();
	}

	//Constructeur complet
	public Warrior (String name, String url, int life, int attack) {
		if (name.equals("") || url.equals("") || life < niveauDeVieMin || life > niveauDeVieMax || attack > forceAttaqueMax || attack < forceAttaqueMin) {
			throw new IllegalArgumentException("Paramètres invalides. Réssayer");
		}
		nom = name;
		imageURL = url;
		niveauDeVie = life;
		forceAttaque = attack;
		arme = new Arme();
		bouclier = new Bouclier();
	}
}
