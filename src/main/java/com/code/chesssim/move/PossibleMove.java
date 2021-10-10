package com.code.chesssim.move;

/**
 * Base class defining a move for a chess piece.
 * 
 * @author Alf
 *
 */
public abstract class PossibleMove {
	
	public enum StepType {
		MULTI_STEP, //multiple steps chained together to represent a final possible position 
		VARIABLE_STEP //single step that has variable quantum. Each move represents a final possible position 
	}

	abstract public StepType getStepType();

}
