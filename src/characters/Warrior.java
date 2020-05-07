package characters;

import equipment.Shield;
import equipment.Weapon;

public class Warrior extends Character{

//	public static final int niveauDeVieMin = 5;
//	public static final int forceAttaqueMin = 5;
//	public static final int forceAttaqueMax = 10;
	public static final int MAX_LIFE = 10;
	private Weapon arme;
	private Shield bouclier;
	private String labelEquipmentAttack = "l'arme du guerrier";
	private String labelEquipmentDefense= "le bouclier du guerrier";	


	/* ---------------------------Constructors ----------------------*/
	
	//Constructeur par defaut
	public Warrior () {
		super();
		nom = "Inconnu";
		imageURL = "Pas d'image";
		niveauDeVie = 5;
		forceAttaque = 5;
		arme = new Weapon();
		bouclier = new Shield();
	}
	
	//Constructeur moit'
	public Warrior (String name) {
		super(name);
		arme = new Weapon();
		bouclier = new Shield();
	}
	
	//Constructeur complet
	public Warrior (String name, String url) {
		super(name, url);
		arme = new Weapon();
		bouclier = new Shield();
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

	
	// Getters
	public String getArme() {
		return this.arme.getNom();
	}
	public String getBouclier() {
		return this.bouclier.getNom();
	}
	@Override
	public String getLabelEquipementAttack() {
		return this.labelEquipmentAttack;
	}
	@Override
	public String getLabelEquipementDefense() {
		return this.labelEquipmentDefense;
	}

	//Setters
	public void setArme(Weapon newValue) {
		this.arme = newValue;
	}
	public void setBouclier(Shield newValue) {
		this.bouclier = newValue;
	}
	public void setLabelEquipementAttack(String labelEquipementAttack) {
		this.labelEquipmentAttack = labelEquipementAttack;
	}
	public void setLabelEquipementDefense(String labelEquipementDefense) {
		this.labelEquipmentDefense = labelEquipementDefense;
	}
	public void SetEquipementAttack(String string_new, int int_new) {
		this.arme.setNom(string_new);
		this.arme.setNiveauAttaque(int_new);
	}
	public void SetEquipementDefense(String new_value, int int_new) {
		this.bouclier.setNom(new_value);
		this.bouclier.setNiveauDefense(int_new);
	}
	@Override
	public void setLife(int niveauDeVie) {
		super.setLife(niveauDeVie);
		if (getLife() > MAX_LIFE) {
			this.niveauDeVie = MAX_LIFE;
		}
	}
	



	
}
		
