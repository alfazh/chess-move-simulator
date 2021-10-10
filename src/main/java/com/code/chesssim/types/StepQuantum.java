package com.code.chesssim.types;

/**
 * This class defines the quantum of steps that a chess piece can take
 * 
 * @author Alf
 *
 */
public enum StepQuantum {
	ONE(1), TWO(2), VARIABLE_RANGE_BOUND(-1);

	final int value;

	StepQuantum(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
