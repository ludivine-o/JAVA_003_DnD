package boardgame;

public class MalusBoxOrcs extends BoardBox {

	public static final String MALUS_ORCS = "Oups ! une troupe d'Orcs puants !";
	private int decreaseValue;
	
	public MalusBoxOrcs(int caseNbr, int decrease) {
		super(caseNbr, MALUS_ORCS);
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
