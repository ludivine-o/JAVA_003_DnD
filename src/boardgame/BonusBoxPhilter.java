package boardgame;

public class BonusBoxPhilter extends BoardBox{

	
	public static final String BONUS_PHILTER = "Super ! une potion de guerison !";
	
	public BonusBoxPhilter(int caseNbr) {
		super(caseNbr, BONUS_PHILTER, "life", 1);

	}

	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event + "\nCette heureuse trouvaille améliore le niveau " + this.type 
				+ " de " + this.value;
	}
	
}
