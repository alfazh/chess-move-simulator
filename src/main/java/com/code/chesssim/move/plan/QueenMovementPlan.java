package com.code.chesssim.move.plan;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.MultiStepMove;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.VariableStepMove;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

/**
 * This class defines the move plan for a queen
 * 
 * @author Alf
 *
 */
public final class QueenMovementPlan implements PieceMovementPlan {

	@Override
	public List<PossibleMove> getPossibleMoves() {
		List<PossibleMove> possibleMoveList = new ArrayList<>();

		// move one step forward
		possibleMoveList.add(new VariableStepMove(MoveStep.of(MoveDirection.UP, StepQuantum.VARIABLE_RANGE_BOUND)));

		// backward
		possibleMoveList.add(new VariableStepMove(MoveStep.of(MoveDirection.DOWN, StepQuantum.VARIABLE_RANGE_BOUND)));

		// left
		possibleMoveList.add(new VariableStepMove(MoveStep.of(MoveDirection.LEFT, StepQuantum.VARIABLE_RANGE_BOUND)));

		// right
		possibleMoveList.add(new VariableStepMove(MoveStep.of(MoveDirection.RIGHT, StepQuantum.VARIABLE_RANGE_BOUND)));

		// diagonal moves
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_UP_LEFT, StepQuantum.VARIABLE_RANGE_BOUND)));
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_UP_RIGHT, StepQuantum.VARIABLE_RANGE_BOUND)));
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_DOWN_LEFT, StepQuantum.VARIABLE_RANGE_BOUND)));
		possibleMoveList.add(MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.DIAGONAL_DOWN_RIGHT, StepQuantum.VARIABLE_RANGE_BOUND)));

		return Collections.unmodifiableList(possibleMoveList);
	}

}
