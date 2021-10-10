package com.code.chesssim.move.plan;

import java.util.Collections;
import java.util.List;

import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.MultiStepMove;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;
/**
 * This class defines the moveplan for a pawn
 * 
 * @author Alf
 *
 */
public final class PawnMovementPlan implements PieceMovementPlan {

	public List<PossibleMove> getPossibleMoves() {
		
		// move one step forward (at the moment)
		PossibleMove possibleMove = MultiStepMove.ofSingleStep(MoveStep.of(MoveDirection.UP, StepQuantum.ONE));

		return Collections.singletonList(possibleMove);
	}

}
