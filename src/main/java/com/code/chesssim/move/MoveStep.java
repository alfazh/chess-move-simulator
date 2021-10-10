package com.code.chesssim.move;

import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

/**
 * This immutable class defines a possible move that a chess piece can make.
 * State consists of the direction in which the piece can move and the quantum
 * of movement.
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((moveDirection == null) ? 0 : moveDirection.hashCode());
		result = prime * result + ((stepQuantum == null) ? 0 : stepQuantum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MoveStep other = (MoveStep) obj;
		if (moveDirection != other.moveDirection)
			return false;
		if (stepQuantum != other.stepQuantum)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MoveStep [moveDirection=" + moveDirection + ", stepQuantum=" + stepQuantum + "]";
	}

}
