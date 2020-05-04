package dnd;


public class Bouclier extends Equipement {
	private int niveauDefense;

	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Bouclier() {
		super();
		this.niveauDefense = 5;
	}
		
	// Constructeur complet
	public Bouclier(int niveauAttaque) {
		super();
		this.niveauDefense = niveauAttaque;
	}

	/* ---------------------------Methods() ---------------------- */
	public int getNiveauDefense() {
		return niveauDefense;
	}
	public void setNiveauDefense(int niveauAttaque) {
		this.niveauDefense = niveauAttaque;
	}
	
	
	
	
	}
