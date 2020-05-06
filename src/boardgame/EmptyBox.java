package boardgame;

public class EmptyBox extends BoardBox{

	
	/* ---------------------------Constructors ---------------------- */
	// Constructeur par defaut
	public EmptyBox(int caseNbr) {
		super(caseNbr, "Chance ! c'est une case vide !", null, 0);
	}

	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event; 
	}

	


}
