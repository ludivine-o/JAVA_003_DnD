package dnd;

//import java.awt.desktop.SystemEventListener;
//import java.util.HashMap;

public class Wizzard {
	private String nom;
	private String imageURL;
	private int niveauDeVie;
	private int niveauDeVieMin = 5;
	private int niveauDeVieMax = 10;
	private int forceAttaque;
	private int forceAttaqueMin = 5;
	private int forceAttaqueMax = 10;
	private Sort sort;
	private Philtre philtre;

	/* ---------------------------Methods ---------------------- */

	public String toString() {
		return this.nom + " est un Magicien. Il a " + this.niveauDeVie + " de vie, et " + this.forceAttaque
				+ " d'attaque.\n";
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

	public String getSort() {
		return this.sort.nom;
	}

	public String getPhiltre() {
		return this.philtre.nom;
	}

	// Setters
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

	public void setSort(Sort newValue) {
		this.sort = newValue;
	}

	public void setPhiltre(Philtre newValue) {
		this.philtre = newValue;
	}

	/* ---------------------------Constructors ---------------------- */

	// Constructeur par defaut
	public Wizzard() {
		nom = "Inconnu";
		imageURL = "Pas d'image";
		niveauDeVie = 5;
		forceAttaque = 5;
		sort = new Sort();
		philtre = new Philtre();

	}

	// Constructeur moit'
	public Wizzard(String name) {
		nom = name;
		imageURL = "Pas d'image";
		niveauDeVie = 5;
		forceAttaque = 5;
		sort = new Sort();
		philtre = new Philtre();

	}

	// Constructeur complet

	public Wizzard (String name, String url, int life, int attack) {
		if (name.equals("") || url.equals("") || life < niveauDeVieMin || life > niveauDeVieMax || attack > forceAttaqueMax || attack < forceAttaqueMin) {
			throw new IllegalArgumentException("Paramètres invalides. Réssayer");
		}
		nom = name;
		imageURL = url;
		niveauDeVie = life;
		forceAttaque = attack;
		sort = new Sort();
		philtre = new Philtre();

	}


}
