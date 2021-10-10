package com.code.chesssim.move.finder;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.move.PossibleMove.StepType;
import com.code.chesssim.move.generator.MoveGeneratorFactory;

class MoveFinderFactoryTests {

	@Test
	void test_get_multistep_movefinder() {
		assertNotNull(MoveFinderFactory.getMoveFilder(StepType.MULTI_STEP, new MoveGeneratorFactory(ChessBoard.STANDARD)));
	}
	
	@Test
	void test_get_variablestep_movefinder() {
		assertNotNull(MoveFinderFactory.getMoveFilder(StepType.VARIABLE_STEP,  new MoveGeneratorFactory(ChessBoard.STANDARD)));
	}
	
}
