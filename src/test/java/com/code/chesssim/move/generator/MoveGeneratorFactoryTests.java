package com.code.chesssim.move.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.types.MoveDirection;

class MoveGeneratorFactoryTests {

	@Test
	void up_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD).getMoveGenerator(MoveDirection.UP);
		assertTrue(moveGenerator.isPresent());
		//first rank
		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(0,2)); 
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(1,2))); 
		//middle
		move = moveGenerator.get().getNextMove(new BoardPosition(3,3));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(4,3)));
		//last but one rank
		move = moveGenerator.get().getNextMove(new BoardPosition(6,6));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(7,6))); 
	}
	
	@Test
	void up_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD).getMoveGenerator(MoveDirection.UP);
		assertTrue(moveGenerator.isPresent());

		//corner last rank
		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(7,0)); 
		assertTrue(move.isEmpty()); 
		
		//last rank
		move = moveGenerator.get().getNextMove(new BoardPosition(7,3));
		assertTrue(move.isEmpty()); 
	}
	
	@Test
	void down_move_generator_with_valid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void down_move_generator_with_invalid_position() {
		fail("Not yet implemented");
	}

	@Test
	void left_move_generator_with_valid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void left_move_generator_with_invalid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_up_left_move_generator_with_valid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_up_left_move_generator_with_invalid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_up_right_move_generator_with_valid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_up_right_move_generator_with_invalid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_down_left_move_generator_with_valid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_down_left_move_generator_with_invalid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_down_right_move_generator_with_valid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void diagonal_down_right_move_generator_with_invalid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void right_move_generator_with_valid_position() {
		fail("Not yet implemented");
	}
	
	@Test
	void right_move_generator_with_invalid_position() {
		fail("Not yet implemented");
	}
	

}
