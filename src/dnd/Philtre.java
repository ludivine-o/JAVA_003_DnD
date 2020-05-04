package dnd;

public class Philtre extends Equipement{
	private int niveauDefense;
	
	
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Philtre() {
		super();
		this.niveauDefense = 5;
	}
	// Constructeur complet
	public Philtre (String nom, int valeur) {
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
