package boardgame;

public class MalusBoxOrcs extends BoardBox {

	public static final String MALUS_ORCS = "Oups ! une troupe d'Orcs puants !";
	
	
	public MalusBoxOrcs(int caseNbr) {
		super(caseNbr, MALUS_ORCS, "life", 1);

	}


	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event + "\nCette facheuse rencontre fait diminuer le niveau " 
		+ this.type + " de " + this.value;

	}

	
	
	
}
