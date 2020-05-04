package dnd;

//import java.awt.desktop.SystemEventListener;
//import java.util.HashMap;

public class Wizzard extends Perso{
	//private String nom;
	//private String imageURL;
	//private int niveauDeVie;
	//private int forceAttaque;
	public static final int niveauDeVieMin = 3;
	public static final int niveauDeVieMax = 6;
	public static final int forceAttaqueMin = 8;
	public static final int forceAttaqueMax = 15;
	private Sort sort;
	private Philtre philtre;

	
	
	/* ---------------------------Constructors ---------------------- */

	// Constructeur par defaut
	public Wizzard() {
		super();
		sort = new Sort();
		philtre = new Philtre();

	}

	// Constructeur moit'
	public Wizzard(String name) {
		super(name);
		sort = new Sort();
		philtre = new Philtre();

	}

	// Constructeur complet

	public Wizzard (String name, String url, int life, int attack) {
		super(name, url, life, attack);
//		if (name.equals("") || url.equals("") || life < niveauDeVieMin || life > niveauDeVieMax || attack > forceAttaqueMax || attack < forceAttaqueMin) {
//			throw new IllegalArgumentException("Paramètres invalides. Réssayer");
//		}
		sort = new Sort();
		philtre = new Philtre();

	}
	
	
	/* ---------------------------Methods ---------------------- */
	@Override
	public String toString() {
		return this.nom + " est un Magicien. Il a " + this.niveauDeVie + " de vie, et " + this.forceAttaque
				+ " d'attaque.\n";
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
	public String getSort() {
		return this.sort.getNom();
	}

	public String getPhiltre() {
		return this.philtre.getNom();
	}

	// Setters
	public void setSort(Sort newValue) {
		this.sort = newValue;
	}

	public void setPhiltre(Philtre newValue) {
		this.philtre = newValue;
	}




}
