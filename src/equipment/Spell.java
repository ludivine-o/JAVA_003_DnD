package equipment;

public class Spell extends Equipment{
	int niveauAttaque;
	
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Spell() {
		super();
		this.niveauAttaque = 5;
	}
	// Constructeur complet
	public Spell(String nom, int niveau) {
		super(nom);
		this.niveauAttaque = niveau;
	}
	
	/* ---------------------------Methods() ---------------------- */
	public int getNiveauAttaque() {
		return niveauAttaque;
	}
	public void setNiveauAttaque(int niveauAttaque) {
		this.niveauAttaque = niveauAttaque;
	}

}
