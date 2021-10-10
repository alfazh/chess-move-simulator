package com.code.chesssim.move;

import java.util.Collections;
import java.util.List;

/**
 * This immutable class defines a move plan in which multiple steps can be
 * chained together to represent a final possible position
 * 
 * @author Alf
 *
 */
public final class MultiStepMove extends PossibleMove {

	private final List<MoveStep> moveStepPlan;

	public MultiStepMove(List<MoveStep> allowedMove) {
		super();
		this.moveStepPlan = allowedMove;
	}

	public static MultiStepMove ofSingleStep(MoveStep moveStep) {
		return new MultiStepMove(Collections.singletonList(moveStep));
	}

	public List<MoveStep> getAllowedMove() {
		return moveStepPlan;
	}

	@Override
	public StepType getStepType() {
		return StepType.MULTI_STEP;
	}

}
