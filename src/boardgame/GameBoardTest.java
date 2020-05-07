package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import characters.*;
import characters.Character;


class GameBoardTest {

	GameBoard board;
	Character warior;
	BoardBox box;
	
	@BeforeEach
	void setup() {
		board = new GameBoard();
		warior = new Warrior();
		box = new BonusBoxPotion(1, 5);
	}
	
	@Test
	void thatBoardContain64Box() {
		GameBoard board = new GameBoard();
			
		assertEquals(64, board.board.size());

	}

	@Test
	void lifePointIsLimitedWhenWariorFoundPotion() {

		warior.setLife(9);
		
		board.applyBonusBoxEvent(box, warior);
		
		assertEquals(10, warior.getLife());
			
	}
	
	@Test
	void lifePointIncreaseCorrectlyWhenWariorFoundPotion() {
		GameBoard board = new GameBoard();
		Character warior = new Warrior();
		warior.setLife(2);
		BoardBox box = new BonusBoxPotion(1, 5);
		
		board.applyBonusBoxEvent(box, warior);
		
		assertEquals(7, warior.getLife());
			
	}
	
	
}
