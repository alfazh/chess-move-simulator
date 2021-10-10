package com.code.chesssim.move.plan;

import java.util.List;

import com.code.chesssim.move.PossibleMove;

/**
 * This interface defines a moveplan for a chess piece
 * 
 * @author Alf
 *
 */
public interface PieceMovementPlan {
	List<PossibleMove> getPossibleMoves();
}
