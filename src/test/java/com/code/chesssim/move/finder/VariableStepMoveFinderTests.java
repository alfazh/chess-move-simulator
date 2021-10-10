package com.code.chesssim.move.finder;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.VariableStepMove;
import com.code.chesssim.move.generator.MoveGeneratorFactory;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

class VariableStepMoveFinderTests {
	
	private static MoveFinder moveFinder;

	@BeforeAll
	static void init() {
		moveFinder = new VariableStepMoveFinder(new MoveGeneratorFactory(ChessBoard.STANDARD));
	}
	
	@Test
	void test_variablestep_horizontal_possiblemoves_exist() {
		PossibleMove possibleMove = new VariableStepMove(MoveStep.of(MoveDirection.LEFT, StepQuantum.VARIABLE_RANGE_BOUND));
		BoardPosition initialPosition = new BoardPosition(2,3);
		List<BoardPosition> possibleMoves =moveFinder.findPossibleMoves(possibleMove, initialPosition);
		assertTrue(possibleMoves.size()==3);
	}
	
	@Test
	void test_variablestep_vertical_possiblemoves_exist() {
		PossibleMove possibleMove = new VariableStepMove(MoveStep.of(MoveDirection.UP, StepQuantum.VARIABLE_RANGE_BOUND));
		BoardPosition initialPosition = new BoardPosition(4,4);
		List<BoardPosition> possibleMoves =moveFinder.findPossibleMoves(possibleMove, initialPosition);
		assertTrue(possibleMoves.size()==3);
	}
	
	@Test
	void test_variablestep_diagonal_possiblemoves_exist() {
		PossibleMove possibleMove = new VariableStepMove(MoveStep.of(MoveDirection.DIAGONAL_UP_RIGHT, StepQuantum.VARIABLE_RANGE_BOUND));
		BoardPosition initialPosition = new BoardPosition(0,0);
		List<BoardPosition> possibleMoves=moveFinder.findPossibleMoves(possibleMove, initialPosition);
		assertTrue(possibleMoves.size()==7);
	}
	
	@Test
	void test_variablestep_no_possiblemoves() {
		PossibleMove possibleMove = new VariableStepMove(MoveStep.of(MoveDirection.DIAGONAL_UP_LEFT, StepQuantum.VARIABLE_RANGE_BOUND));
		BoardPosition initialPosition = new BoardPosition(7,7);
		List<BoardPosition> possibleMoves =moveFinder.findPossibleMoves(possibleMove, initialPosition);
		assertTrue(possibleMoves.isEmpty());
	}


}
