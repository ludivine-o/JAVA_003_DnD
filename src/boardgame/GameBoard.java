package boardgame;

import java.util.ArrayList;
import java.util.Random;

import characters.Character;
import equipment.Equipment;
import equipment.Weapon;

public class GameBoard {

	
	Equipment bonusMassue = new Weapon("Massue", 1);
	Equipment bonusArc = new Weapon("Arc", 3);
	public final int BOARDSIZE = 64;
	public ArrayList<BoardBox> board = new ArrayList<BoardBox>(BOARDSIZE);
	
	public GameBoard() {
		for(int i = 0;i<BOARDSIZE;i++){
			Random r = new Random();
			int randomBox = r.nextInt(7);
			BoardBox var;
			if (randomBox == 2) {
				var = new MalusBoxOrcs(i, 2);
			}
			else if (randomBox == 3) {
				var = new MalusBoxGob(i, 1);
			}
			else if (randomBox == 4) {
				var = new BonusBoxPotion(i, 2);
			}
			else if (randomBox == 5) {
				var = new BonusBoxTreasure(i, i, bonusArc);
			}
			else {
				var = new EmptyBox(i);	
			}
			board.add(var);
		}
	}
	
	public Character applyMalusBoxEvent(BoardBox actualBox, Character activePlayer) {
		if (actualBox.type.equals("life")) {
			int value = activePlayer.getLife() - actualBox.getValue();
			activePlayer.setLife(value);
			System.out.println("Votre niveau de vie est maintenant à " + activePlayer.getLife());
		}
		else if (actualBox.type.equals("attack")) {
			int value = activePlayer.getAttack() - actualBox.getValue();
			activePlayer.setAttack(value);
			System.out.println("Votre niveau d'attaque est maintenant à " + activePlayer.getAttack());
		}
		return activePlayer;
	}
	
	public Character applyBonusBoxEvent(BoardBox actualBox, Character activePlayer) {
		if (actualBox.type.equals("life")) {
			int value = activePlayer.getLife() + actualBox.getValue();
			activePlayer.setLife(value);
			System.out.println("Votre niveau de vie est maintenant à " + activePlayer.getLife());
		}
		else if (actualBox.type.equals("attack")) {
			int value = activePlayer.getAttack() + actualBox.getValue();
			activePlayer.setAttack(value);
			System.out.println("Votre niveau d'attaque est maintenant à " + activePlayer.getAttack());
		}
		return activePlayer;
	}
	
	
}

