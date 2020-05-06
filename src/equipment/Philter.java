package equipment;

public class Philter extends Equipment{
	private int niveauDefense;
	
	
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Philter() {
		super();
		this.niveauDefense = 5;
	}
	// Constructeur complet
	public Philter (String nom, int valeur) {
		super(nom);
		this.niveauDefense = valeur;
	}


	/* ---------------------------Methods() ---------------------- */
	public int getNiveauDefense() {
		return niveauDefense;
	}
	public void setNiveauDefense(int valeur) {
		this.niveauDefense = valeur;
	}
	
	
	
}
