package com.code.chesssim.evaluator;

import java.util.ArrayList;
import java.util.List;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.finder.MoveFinder;
import com.code.chesssim.move.finder.MoveFinderFactory;
import com.code.chesssim.move.generator.MoveGeneratorFactory;
import com.code.chesssim.move.plan.PieceMovementPlan;

public class EmptyBoardMoveEvaluatorImpl implements MoveEvaluator {

	private MoveGeneratorFactory moveGeneratorFactory;

	public EmptyBoardMoveEvaluatorImpl(MoveGeneratorFactory moveGeneratorFactory) {
		super();
		this.moveGeneratorFactory = moveGeneratorFactory;
	}

	@Override
	public List<BoardPosition> getPossibleMoves(BoardPosition boardPosition, PieceMovementPlan pieceMovementPlan) {
		// validate input params
		List<BoardPosition> boardPositionList = new ArrayList<>();

		// get chess board and run through all moves from movement plan starting from
		// boardPosition. store and return all possibilities
		for (PossibleMove possibleMove : pieceMovementPlan.getPossibleMoves()) {
			MoveFinder moveFinder = MoveFinderFactory.getMoveFilder(possibleMove.getStepType(), moveGeneratorFactory);
			boardPositionList.addAll(moveFinder.findPossibleMoves(possibleMove, boardPosition));
		}

		return boardPositionList;
	}
}
