package com.code.chesssim.board;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChessBoardTests {

	@Test
	void validate_standard_chess_board() {
		ChessBoard chessBoard = ChessBoard.STANDARD;
		assertTrue(chessBoard.getNumRows() == 8);
		assertTrue(chessBoard.getNumCols() == 8);
	}

	@Test
	void validate_nonstandard_chess_board() {
		ChessBoard chessBoard = new ChessBoard(9, 9);
		assertTrue(chessBoard.getNumRows() == 9);
		assertTrue(chessBoard.getNumCols() == 9);
	}

	@Test
	void invalid_board_size() {
		assertThrows(IllegalArgumentException.class, () -> new ChessBoard(1, 1));
	}

	@Test
	void boardpos_is_out_of_range() {
		Assertions.assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(0, 9).isEmpty());
	}

	@Test
	void boardpos_is_in_range() {
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(1, 3).isPresent());
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(4, 4).isPresent());
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(4, 4).isPresent());
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(6, 7).isPresent());
	}

	@Test
	void boardpos_is_on_edge() {
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(7, 7).isPresent());
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(0, 0).isPresent());
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(5, 0).isPresent());
		assertTrue(ChessBoard.STANDARD.evaluateAndGetBoardPosition(0, 6).isPresent());
	}

}
