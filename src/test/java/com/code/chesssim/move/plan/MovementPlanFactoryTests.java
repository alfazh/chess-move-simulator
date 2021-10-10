package com.code.chesssim.move.plan;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.chesssim.types.ChessPiece;

class MovementPlanFactoryTests {

	private static MovementPlanFactory movementPlanFactory;
	
	@BeforeAll
	static void init() {
		movementPlanFactory = new MovementPlanFactory();
	}
	
	@Test
	void plan_for_king_valid() {
		assertTrue(movementPlanFactory.getPieceMovementPlan(ChessPiece.KING)!=null);
		assertTrue(!movementPlanFactory.getPieceMovementPlan(ChessPiece.KING).getPossibleMoves().isEmpty());
	}
	
	@Test
	void plan_for_queen_valid() {
		assertTrue(movementPlanFactory.getPieceMovementPlan(ChessPiece.QUEEN)!=null);
		assertTrue(!movementPlanFactory.getPieceMovementPlan(ChessPiece.QUEEN).getPossibleMoves().isEmpty());
	}
	
	@Test
	void plan_for_pawn_valid() {
		assertTrue(movementPlanFactory.getPieceMovementPlan(ChessPiece.PAWN)!=null);
		assertTrue(!movementPlanFactory.getPieceMovementPlan(ChessPiece.PAWN).getPossibleMoves().isEmpty());
	}

}
