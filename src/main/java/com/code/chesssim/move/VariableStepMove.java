package com.code.chesssim.move;

import com.code.chesssim.types.StepQuantum;

/**
 * This immtable class defines a single step that has variable quantum. Each
 * move represents a final possible position
 * 
 * @author Alf
 *
 */
public final class VariableStepMove extends PossibleMove {

	private final MoveStep moveStep;

	public VariableStepMove(MoveStep moveStep) {
		super();
		if(moveStep==null || !StepQuantum.VARIABLE_RANGE_BOUND.equals(moveStep.getStepQuantum())) {
			throw new IllegalArgumentException("Variable move steps must have quantum "+StepQuantum.VARIABLE_RANGE_BOUND);
		}
		
		this.moveStep = moveStep;
	}

	public MoveStep getMoveStep() {
		return moveStep;
	}

	@Override
	public StepType getStepType() {
		return StepType.VARIABLE_STEP;
	}

}
