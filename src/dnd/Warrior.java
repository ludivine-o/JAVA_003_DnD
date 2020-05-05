package dnd;

public class Warrior extends Perso{

	public static final int niveauDeVieMin = 5;
	public static final int niveauDeVieMax = 10;
	public static final int forceAttaqueMin = 5;
	public static final int forceAttaqueMax = 10;
	private Arme arme;
	private Bouclier bouclier;
	

	/* ---------------------------Constructors ----------------------*/
	
	//Constructeur par defaut
	public Warrior () {
		super();
		nom = "Inconnu";
		imageURL = "Pas d'image";
		niveauDeVie = 5;
		forceAttaque = 5;
		arme = new Arme();
		bouclier = new Bouclier();
	}
	
	//Constructeur moit'
	public Warrior (String name) {
		super(name);
		arme = new Arme();
		bouclier = new Bouclier();
	}
	
	//Constructeur complet
	public Warrior (String name, String url, int life, int attack) {
		super(name, url, life, attack);
		arme = new Arme();
		bouclier = new Bouclier();
	}
	
	
	/* ---------------------------Methods ----------------------*/
	@Override
	public String toString() {
		return this.nom + " est un Guerrier. Il a " + this.niveauDeVie + " de vie, et " + this.forceAttaque + " d'attaque." ;
	}
	
	@Override
	public String toStringFull() {
		return (this.nom + " est un Guerrier. Il a " + this.niveauDeVie + " de vie,  et " + this.forceAttaque + " d'attaque.\n"
				+ "Son arme est : " + this.arme.getNom() + " d'une valeur d'attaque de " + this.arme.getNiveauAttaque() + 
				"\nSon bouclier est : " + this.bouclier.getNom() + " d'une valeur de défense de " + this.bouclier.getNiveauDefense());
	}
	
	
	@Override
	public void attaque() {
		//truc
	}
	@Override
	public void defense() {
		//truc
	}
	
	public void SetEquipementAttack(String string_new, int int_new) {
		this.arme.setNom(string_new);
		this.arme.setNiveauAttaque(int_new);
	}
	
	public void SetEquipementDefense(String new_value, int int_new) {
		this.bouclier.setNom(new_value);
		this.bouclier.setNiveauDefense(int_new);
	}
	
	// Getters
	public String getArme() {
		return this.arme.getNom();
	}
	public String getBouclier() {
		return this.bouclier.getNom();
	}

	//Setters
	public void setArme(Arme newValue) {
		this.arme = newValue;
	}
	public void setBouclier(Bouclier newValue) {
		this.bouclier = newValue;
	}


	
}
		
