package com.code.chesssim.move;

import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

/**
 * This immutable class defines a possible move that a chess piece can make. State
 * consists of the direction in which the piece can move and the quantum of
 * movement.
 * 
 * @author Alf
 *
 */
public final class MoveStep {

	public final MoveDirection moveDirection;
	public final StepQuantum stepQuantum;

	public MoveStep(MoveDirection moveDirection, StepQuantum stepQuantum) {
		super();
		this.moveDirection = moveDirection;
		this.stepQuantum = stepQuantum;
	}

	public static MoveStep of(MoveDirection moveDirection, StepQuantum stepQuantum) {
		return new MoveStep(moveDirection, stepQuantum);
	}

	public MoveDirection getMoveDirection() {
		return moveDirection;
	}

	public StepQuantum getStepQuantum() {
		return stepQuantum;
	}

}
