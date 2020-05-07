package boardgame;

import equipment.Equipment;





/*
 * equipement warrior: arc (attaque +1)
equipement warrior: massue (attaque +3)
equipement warrior: épée (attaque +5)
equipement magicien: éclair (attaque +2)
equipement magicien: boule de feu (attaque +7)
 */


public class BonusBoxTreasure extends BoardBox{

	

	public static final String BONUS_TREASURE = "Cool ! un trésor de guerre !";
	Equipment bonusStuff;
	
	
	public BonusBoxTreasure(int caseNbr, int point, Equipment stuff) {
		super(caseNbr, BONUS_TREASURE);
		bonusStuff = stuff; 
	}
		
	@Override
	public String toString() {
		return "Case n°" + this.caseNbr + ", : " + this.event + 
				"Waouh ! " + this.bonusStuff.getNom() + " !"
				+ "\nCette heureuse trouvaille améliore le niveau " + this.type 
				+ " de " + this.value;
	}
}
	

