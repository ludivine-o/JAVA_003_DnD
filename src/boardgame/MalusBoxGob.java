package boardgame;

public class MalusBoxGob extends BoardBox{

	public static final String MALUS_GOB = "Aïe ! une bande de Gobelins mal peignés !";
	
	public MalusBoxGob(int caseNbr) {
		super(caseNbr, MALUS_GOB, "attack", 1);
	}
	
	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event + "\nCette facheuse rencontre fait diminuer le niveau " 
		+ this.type + " de " + this.value;

	}

}
