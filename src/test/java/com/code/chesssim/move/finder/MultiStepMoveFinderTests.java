package com.code.chesssim.move.finder;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.MultiStepMove;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.generator.MoveGeneratorFactory;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

class MultiStepMoveFinderTests {
	
	private static MoveFinder moveFinder;

	@BeforeAll
	static void init() {
		moveFinder = new MultiStepMoveFinder(new MoveGeneratorFactory(ChessBoard.STANDARD));
	}
	
	@Test
	void test_singlestep_possiblemoves_exist() {
		PossibleMove possibleMove = MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.LEFT, StepQuantum.ONE));
		BoardPosition initialPosition = new BoardPosition(2,3);
		List<BoardPosition> possibleMoves =moveFinder.findPossibleMoves(possibleMove, initialPosition);
		assertTrue(possibleMoves.size()==1);
		BoardPosition finalPosition = possibleMoves.get(0); 
		assertTrue(finalPosition.equals(new BoardPosition(2,2)));
	}
	
	@Test
	void test_multistep_possiblemoves_exist() {
		
		MoveStep firstStep = new MoveStep(MoveDirection.UP, StepQuantum.TWO);
		MoveStep secondStep = new MoveStep(MoveDirection.RIGHT, StepQuantum.ONE);
		PossibleMove possibleMove = new MultiStepMove(Arrays.asList(firstStep, secondStep));
		
		BoardPosition initialPosition = new BoardPosition(2,3);
	
		List<BoardPosition> possibleMoves =moveFinder.findPossibleMoves(possibleMove, initialPosition);
		assertTrue(possibleMoves.size()==1);
		BoardPosition finalPosition = possibleMoves.get(0); 
		assertTrue(finalPosition.equals(new BoardPosition(4,4)));
	}
	
	@Test
	void test_singlestep_no_possiblemoves() {
		PossibleMove possibleMove = MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.RIGHT, StepQuantum.ONE));
		BoardPosition initialPosition = new BoardPosition(7,7);
		List<BoardPosition> possibleMoves =moveFinder.findPossibleMoves(possibleMove, initialPosition);
		assertTrue(possibleMoves.isEmpty());
	}

}
