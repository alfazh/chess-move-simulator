package com.code.chesssim.move.evaluator;

import java.util.List;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.move.plan.PieceMovementPlan;

/**
 * Interface class that defines the behaviors/methods for getting possible moves
 * 
 * @author Alf
 *
 */
public interface MoveEvaluator {

	/**
	 * This method computes and returns the list of allowed moves baed on given
	 * board position and piece movement plan
	 * 
	 * @param boardPosition
	 * @param pieceMovementPlan
	 * @return
	 */
	List<BoardPosition> getPossibleMoves(BoardPosition boardPosition, PieceMovementPlan pieceMovementPlan);

}
