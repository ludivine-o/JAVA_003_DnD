package dnd;

public class Arme extends Equipement{
	private int niveauAttaque;

	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Arme () {
		super();
		this.niveauAttaque = 5;
	}
	// Constructeur complet
	public Arme (String nom, int niveauAttaque) {
		super(nom);
		this.niveauAttaque = niveauAttaque;
	}
	/* ---------------------------Methods() ---------------------- */
	public int getNiveauAttaque() {
		return niveauAttaque;
	}
	public void setNiveauAttaque(int niveauAttaque) {
		this.niveauAttaque = niveauAttaque;
	}
	
	
	
}
