package boardgame;

public class BonusBoxPotion extends BoardBox{

	
	public static final String BONUS_PHILTER = "Super ! une potion de guerison !";
	private int lifeIncrease;
	
	
	public BonusBoxPotion(int caseNbr, int increase) {
		super(caseNbr, BONUS_PHILTER);
		lifeIncrease = increase;
	}

	public int getLifeIncrease() {
		return lifeIncrease;
	}

	public void setLifeIncrease(int lifeIncrease) {
		this.lifeIncrease = lifeIncrease;
	}

	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event + "\nCette heureuse trouvaille améliore le niveau " + this.type 
				+ " de " + this.value;
	}
	
}
