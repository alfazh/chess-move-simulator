package com.code.chesssim.move.plan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.MultiStepMove;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;
/**
 * 
 *This class defines the moveplan for the king
 * @author Alf
 *
 */
public final class KingMovementPlan implements PieceMovementPlan {

	public List<PossibleMove> getPossibleMoves() {
		List<PossibleMove> possibleMoveList = new ArrayList<>();

		// move one step forward
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.UP, StepQuantum.ONE)));

		// backward
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DOWN, StepQuantum.ONE)));

		// left
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.LEFT, StepQuantum.ONE)));

		// right
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.RIGHT, StepQuantum.ONE)));

		// diagonal
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_UP_LEFT, StepQuantum.ONE)));
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_UP_RIGHT, StepQuantum.ONE)));
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_DOWN_LEFT, StepQuantum.ONE)));
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_DOWN_RIGHT, StepQuantum.ONE)));

		return Collections.unmodifiableList(possibleMoveList);
	}

}
