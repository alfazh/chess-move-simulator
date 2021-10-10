package com.code.chesssim.move.evaluator;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.move.generator.MoveGeneratorFactory;
import com.code.chesssim.move.plan.MovementPlanFactory;
import com.code.chesssim.types.ChessPiece;

class EmptyBoardMoveEvaluatorTests {

	private static MovementPlanFactory movePlanFactory;
	private static MoveEvaluator moveEvaluator;

	@BeforeAll
	public static void init() {
		moveEvaluator = new EmptyBoardMoveEvaluatorImpl(new MoveGeneratorFactory(ChessBoard.STANDARD));
		movePlanFactory = new MovementPlanFactory();
	}
	
	@Test
	void test_pawn_on_first_rank() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(0,0), movePlanFactory.getPieceMovementPlan(ChessPiece.PAWN));
		assertTrue(positionList.size()==1);
		assertTrue(positionList.get(0).equals(new BoardPosition(1,0)));
	}
	
	@Test
	void test_pawn_on_last_rank() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(7,3), movePlanFactory.getPieceMovementPlan(ChessPiece.PAWN));
		assertTrue(positionList.isEmpty());
	}
	
	@Test
	void test_king_in_corner() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(7,7), movePlanFactory.getPieceMovementPlan(ChessPiece.KING));
		assertTrue(positionList.size()==3);
	}
	
	@Test
	void test_king_in_center() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(3,3), movePlanFactory.getPieceMovementPlan(ChessPiece.KING));
		assertTrue(positionList.size()==8);
	}
	
	@Test
	void test_king_on_first_rank() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(0,3), movePlanFactory.getPieceMovementPlan(ChessPiece.KING));
		assertTrue(positionList.size()==5);
	}
	
	@Test
	void test_king_on_last_rank() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(7,3), movePlanFactory.getPieceMovementPlan(ChessPiece.KING));
		assertTrue(positionList.size()==5);
	}
	
	@Test
	void test_queen_in_corner() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(0,0), movePlanFactory.getPieceMovementPlan(ChessPiece.QUEEN));
		assertTrue(positionList.size()==21);
	}
	
	@Test
	void test_queen_in_center() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(3,4), movePlanFactory.getPieceMovementPlan(ChessPiece.QUEEN));
		assertTrue(positionList.size()==27);
	}
	
	@Test
	void test_queen_on_first_rank() {
		List<BoardPosition> positionList = moveEvaluator.getPossibleMoves(new BoardPosition(0,1), movePlanFactory.getPieceMovementPlan(ChessPiece.QUEEN));
		assertTrue(positionList.size()==21);
	}
}
