package com.code.chesssim.app;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.board.ChessSquare;
import com.code.chesssim.datamappers.BoardDataMapperImpl;
import com.code.chesssim.input.SimulationInput;
import com.code.chesssim.move.evaluator.EmptyBoardMoveEvaluatorImpl;
import com.code.chesssim.move.generator.MoveGeneratorFactory;
import com.code.chesssim.move.plan.MovementPlanFactory;
import com.code.chesssim.types.ChessPiece;

class ChessSimulatorRunnerTests {

	private static ChessSimulatorRunner runner;
	
	@BeforeAll
	public static void init() {
		runner = new ChessSimulatorRunner(new BoardDataMapperImpl(), new MovementPlanFactory(), new EmptyBoardMoveEvaluatorImpl(new MoveGeneratorFactory(ChessBoard.STANDARD)));
	}
	
	@Test
	void moves_possible() {
		assertTrue(runner.simulateMoves(new SimulationInput(ChessPiece.PAWN, new ChessSquare("A3"))).size()>0);
	}
	
	@Test
	void no_moves_possible() {
		assertTrue(runner.simulateMoves(new SimulationInput(ChessPiece.PAWN, new ChessSquare("A8"))).isEmpty());
	}

}
