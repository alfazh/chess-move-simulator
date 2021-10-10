package com.code.chesssim.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.move.plan.PieceMovementPlan;

public class EmptyBoardMoveEvaluatorImpl implements MoveEvaluator {

		
	@Override
	public List<BoardPosition> getPossibleMoves(BoardPosition boardPosition, PieceMovementPlan pieceMovementPlan) {
		// validate input params
		List<BoardPosition> boardPositionList = new ArrayList<>();

		// get chess board and run through all moves from movement plan starting from
		// boardPosition. store and return all possibilities
		return boardPositionList;

	}

}
