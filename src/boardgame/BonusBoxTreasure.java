package boardgame;

public class BonusBoxTreasure extends BoardBox{

	public static final String BONUS_TREASURE = "Cool ! un trésor de guerre !";
	
	public BonusBoxTreasure(int caseNbr) {
		super(caseNbr, BONUS_TREASURE, "attack", 1);
		// TODO Auto-generated constructor stub
	}
	

	
	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event + "\nCette heureuse trouvaille améliore le niveau " + this.type 
				+ " de " + this.value;
	}
}
	

