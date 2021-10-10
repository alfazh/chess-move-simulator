package com.code.chesssim.move.generator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.types.MoveDirection;

class MoveGeneratorFactoryTests {

	@Test
	void up_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.UP);
		assertTrue(moveGenerator.isPresent());
		// first rank
		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(0, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(1, 2)));
		// middle
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 3));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(4, 3)));
		// last but one rank
		move = moveGenerator.get().getNextMove(new BoardPosition(6, 6));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(7, 6)));
	}

	@Test
	void up_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.UP);
		assertTrue(moveGenerator.isPresent());

		// corner last rank
		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(7, 0));
		assertTrue(move.isEmpty());

		// last rank
		move = moveGenerator.get().getNextMove(new BoardPosition(7, 3));
		assertTrue(move.isEmpty());
	}

	@Test
	void down_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DOWN);
		assertTrue(moveGenerator.isPresent());

		// first rank
		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(2, 2)));
		// middle
		move = moveGenerator.get().getNextMove(new BoardPosition(5, 3));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(4, 3)));
		// last but one rank
		move = moveGenerator.get().getNextMove(new BoardPosition(1, 6));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(0, 6)));
	}

	@Test
	void down_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DOWN);
		assertTrue(moveGenerator.isPresent());

		// corner last rank
		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(0, 0));
		assertTrue(move.isEmpty());

		// last rank
		move = moveGenerator.get().getNextMove(new BoardPosition(0, 4));
		assertTrue(move.isEmpty());
	}

	@Test
	void left_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.LEFT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(3, 1)));

		move = moveGenerator.get().getNextMove(new BoardPosition(5, 3));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(5, 2)));

		move = moveGenerator.get().getNextMove(new BoardPosition(1, 6));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(1,5)));
	}

	@Test
	void left_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.LEFT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(7, 0));
		assertTrue(move.isEmpty());

		move = moveGenerator.get().getNextMove(new BoardPosition(3, 0));
		assertTrue(move.isEmpty());
	}

	@Test
	void right_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.RIGHT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(3, 3)));

		move = moveGenerator.get().getNextMove(new BoardPosition(5, 3));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(5, 4)));

		move = moveGenerator.get().getNextMove(new BoardPosition(1, 6));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(1,7)));
	}

	@Test
	void right_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.RIGHT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(0, 7));
		assertTrue(move.isEmpty());

		move = moveGenerator.get().getNextMove(new BoardPosition(3, 7));
		assertTrue(move.isEmpty());
	}
	
	@Test
	void diagonal_up_left_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_UP_LEFT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(4, 1)));
	}

	@Test
	void diagonal_up_left_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_UP_LEFT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(7, 0));
		assertTrue(move.isEmpty());
	}

	@Test
	void diagonal_up_right_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_UP_RIGHT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(4, 3)));
	}

	@Test
	void diagonal_up_right_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_UP_RIGHT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(7, 7));
		assertTrue(move.isEmpty());
	}

	@Test
	void diagonal_down_left_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_DOWN_LEFT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(2, 1)));
	}

	@Test
	void diagonal_down_left_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_DOWN_LEFT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(0, 0));
		assertTrue(move.isEmpty());
	}

	@Test
	void diagonal_down_right_move_generator_with_valid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_DOWN_RIGHT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(3, 2));
		assertTrue(move.isPresent() && move.get().equals(new BoardPosition(2, 3)));
		}

	@Test
	void diagonal_down_right_move_generator_with_invalid_position() {
		Optional<MoveGenerator> moveGenerator = new MoveGeneratorFactory(ChessBoard.STANDARD)
				.getMoveGenerator(MoveDirection.DIAGONAL_DOWN_RIGHT);
		assertTrue(moveGenerator.isPresent());

		Optional<BoardPosition> move = Optional.empty();
		move = moveGenerator.get().getNextMove(new BoardPosition(0, 3));
		assertTrue(move.isEmpty());	
	}


}
