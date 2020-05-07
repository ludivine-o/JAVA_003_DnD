package boardgame;

public class MalusBoxGob extends BoardBox{

	public static final String MALUS_GOB = "Aïe ! une bande de Gobelins mal peignés !";


	private int decreaseValue;
	
	
	public MalusBoxGob(int caseNbr, int decrease) {
		super(caseNbr, MALUS_GOB);
		decreaseValue = decrease;
	}
	
	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event + "\nCette facheuse rencontre fait diminuer le niveau " 
		+ this.type + " de " + this.value;

	}

	public int getDecreaseValue() {
		return decreaseValue;
	}

	public void setDecreaseValue(int decreaseValue) {
		this.decreaseValue = decreaseValue;
	}
	
}
