package boardgame;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameBoardTest {

	@Test
	void thatBoardContain64Box() {
		GameBoard board = new GameBoard();
			
		assertEquals(64, board.board.size());

	}

}
