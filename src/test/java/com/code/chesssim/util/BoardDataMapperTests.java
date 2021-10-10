package com.code.chesssim.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessSquare;

class BoardDataMapperTests {

	private static BoardDataMapper boardDataMapper;
	
	@BeforeAll
	static void init() {
		boardDataMapper = new BoardDataMapperImpl();
	}
	
	@Test
	void test_valid_board_position() {
		Optional<BoardPosition> position = boardDataMapper.toBoardPosition(new ChessSquare("H6"));
		assertTrue(position.isPresent());
		assertTrue(position.get().equals(new BoardPosition(5,7)));
		
	}
	
	@Test
	void test_valid_chess_square() {
		Optional<ChessSquare> chessSquare = boardDataMapper.toChessSquare(new BoardPosition(5,7));
		assertTrue(chessSquare.isPresent());
		assertTrue(chessSquare.get().getChessSquare().equals("H6"));
	}
	
	@Test
	void test_valid_chess_piece() {
		assertNotNull(boardDataMapper.toChessPiece("king"));
	}

	@Test
	void test_invalid_chess_piece() {
		assertNotNull(boardDataMapper.toChessPiece("horse"));
	}
	
}
