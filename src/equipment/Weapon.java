package equipment;

public class Weapon extends Equipment{
	private int niveauAttaque;

	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Weapon () {
		super();
		this.niveauAttaque = 5;
	}
	// Constructeur complet
	public Weapon (String nom, int niveauAttaque) {
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
