package com.code.chesssim.move.plan;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.code.chesssim.types.ChessPiece;

/**
 * Factory class that supplies moveplans for chess pieces
 * 
 * @author Alf
 *
 */
public class MovementPlanFactory {

	private final Map<ChessPiece, Supplier<PieceMovementPlan>> movementPlanMap;
	
	public MovementPlanFactory() {
		Map<ChessPiece, Supplier<PieceMovementPlan>> movementPlanMap = new HashMap<>();
		movementPlanMap.put(ChessPiece.PAWN, PawnMovementPlan::new);
		movementPlanMap.put(ChessPiece.KING, KingMovementPlan::new);
		movementPlanMap.put(ChessPiece.QUEEN, QueenMovementPlan::new);
		this.movementPlanMap = Collections.unmodifiableMap(movementPlanMap);
	}
	
	
	public PieceMovementPlan getPieceMovementPlan(ChessPiece chessPiece) {
		return movementPlanMap.get(chessPiece).get();
	}

}
