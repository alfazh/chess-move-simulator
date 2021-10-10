package com.code.chesssim.move.finder;

import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.PossibleMove.StepType;
import com.code.chesssim.move.generator.MoveGeneratorFactory;

/**
 * Factory class for looking up MoveFinder implementations based on step type
 * 
 * @author Alf
 *
 */
public final class MoveFinderFactory {

	public static MoveFinder getMoveFilder(PossibleMove.StepType stepType, MoveGeneratorFactory moveGeneratorFactory) {
		if (StepType.MULTI_STEP.equals(stepType)) {
			return new MultiStepMoveFinder(moveGeneratorFactory);
		} else if (StepType.VARIABLE_STEP.equals(stepType)) {
			return new VariableStepMoveFinder(moveGeneratorFactory);
		} else {
			throw new IllegalArgumentException("No move finders exist for step: " + stepType);
		}
	}

}
