package equipment;


public class Shield extends Equipment {
	private int niveauDefense;

	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Shield() {
		super();
		this.niveauDefense = 5;
	}
		
	// Constructeur complet
	public Shield(int niveauAttaque) {
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
