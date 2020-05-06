package boardgame;

import java.util.ArrayList;
import java.util.Random;

import characters.Character;

public class GameBoard {

	public final int BOARDSIZE = 10;
	public ArrayList<BoardBox> board = new ArrayList<BoardBox>(BOARDSIZE);
	
	public GameBoard() {
		for(int i = 0;i<BOARDSIZE;i++){
			Random r = new Random();
			int randomBox = r.nextInt(7);
			BoardBox var;
			if (randomBox == 2) {
				var = new MalusBoxOrcs(i);
			}
			else if (randomBox == 3) {
				var = new MalusBoxOrcs(i);
			}
			else if (randomBox == 4) {
				var = new MalusBoxOrcs(i);
			}
			else if (randomBox == 5) {
				var = new MalusBoxOrcs(i);
			}
			else {
				var = new MalusBoxOrcs(i);	
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

