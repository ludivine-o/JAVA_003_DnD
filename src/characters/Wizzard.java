package characters;

import equipment.Philter;
import equipment.Spell;

//import java.awt.desktop.SystemEventListener;
//import java.util.HashMap;

public class Wizzard extends Character{
	//private String nom;
	//private String imageURL;
	//private int niveauDeVie;
	//private int forceAttaque;
//	public static final int niveauDeVieMin = 3;
//	public static final int niveauDeVieMax = 6;
//	public static final int forceAttaqueMin = 8;
//	public static final int forceAttaqueMax = 15;
	private Spell sort;
	private Philter philtre;
	private String labelEquipementAttack = "le sort du Magicien";
	private String labelEquipementDefense = "le philtre du Magicien";
	
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Wizzard() {
		super();
		sort = new Spell();
		philtre = new Philter();
	}

	// Constructeur moit'
	public Wizzard(String name) {
		super(name);
		sort = new Spell();
		philtre = new Philter();
	}

	// Constructeur complet
	public Wizzard (String name, String url) {
		super(name, url);
		sort = new Spell();
		philtre = new Philter();
	}
	
	
	/* ---------------------------Methods ---------------------- */
	@Override
	public String toString() {
		return this.nom + " est un Magicien. Il a " + this.niveauDeVie + " de vie, et " + this.forceAttaque
				+ " d'attaque.\n";
	}

	@Override
	public String toStringFull() {
		return (this.nom + " est un Magicien. Il a " + this.niveauDeVie + " de vie,  et " + this.forceAttaque + " d'attaque.\n"
				+ "Son sort est : " + this.sort.getNom() + " d'une valeur d'attaque de " + this.sort.getNiveauAttaque() + 
				"\nSon philtre est : " + this.philtre.getNom() + " d'une valeur de " + this.philtre.getNiveauDefense());
	}
	
	@Override
	public void attaque() {
		//truc
	}
	@Override
	public void defense() {
		//truc
	}
	
	@Override
	public String getLabelEquipementAttack() {
		return this.labelEquipementAttack;
	}
	
	@Override
	public String getLabelEquipementDefense() {
		return this.labelEquipementDefense;
	}
	@Override
	public void SetEquipementAttack(String string_new, int int_new) {
		this.sort.setNom(string_new);
		this.sort.setNiveauAttaque(int_new);
	}
	@Override
	public void SetEquipementDefense(String new_value, int int_new) {
		this.philtre.setNom(new_value);
		this.philtre.setNiveauDefense(int_new);
	}
	
	
	//  --------- Getters ---------
	public String getSort() {
		return this.sort.getNom();
	}

	public String getPhiltre() {
		return this.philtre.getNom();
	}

	//---------Setters---------
	public void setSort(Spell newValue) {
		this.sort = newValue;
	}

	public void setPhiltre(Philter newValue) {
		this.philtre = newValue;
	}







}
