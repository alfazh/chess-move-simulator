package com.code.chesssim.move;

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
