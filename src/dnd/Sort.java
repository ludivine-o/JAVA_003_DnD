package dnd;

public class Sort extends Equipement{
	int niveauAttaque;
	
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public Sort() {
		super();
		this.niveauAttaque = 5;
	}
	// Constructeur complet
	public Sort(String nom, int niveau) {
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
