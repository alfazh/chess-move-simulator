package com.code.chesssim.move.plan;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.PossibleMove.StepType;
import com.code.chesssim.move.VariableStepMove;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

class QueenMovementPlanTests {

	@Test
	void test_valid_moves_in_plan() {
		PieceMovementPlan queenMovementPlan = new QueenMovementPlan();
		List<PossibleMove> possibleMoveList = queenMovementPlan.getPossibleMoves();
		assertTrue(possibleMoveList.size() == 8);
		assertTrue(possibleMoveList.stream().filter(m -> m.getStepType().equals(StepType.VARIABLE_STEP)).anyMatch(m -> {
			VariableStepMove sm = (VariableStepMove) m;
			return sm.getMoveStep().equals(MoveStep.of(MoveDirection.UP, StepQuantum.VARIABLE_RANGE_BOUND));
		}));

		assertTrue(possibleMoveList.stream().filter(m -> m.getStepType().equals(StepType.VARIABLE_STEP)).anyMatch(m -> {
			VariableStepMove sm = (VariableStepMove) m;
			return sm.getMoveStep().equals(MoveStep.of(MoveDirection.LEFT, StepQuantum.VARIABLE_RANGE_BOUND));
		}));

		assertTrue(possibleMoveList.stream().filter(m -> m.getStepType().equals(StepType.VARIABLE_STEP)).anyMatch(m -> {
			VariableStepMove sm = (VariableStepMove) m;
			return sm.getMoveStep()
					.equals(MoveStep.of(MoveDirection.DIAGONAL_DOWN_RIGHT, StepQuantum.VARIABLE_RANGE_BOUND));
		}));

		assertTrue(possibleMoveList.stream().filter(m -> m.getStepType().equals(StepType.VARIABLE_STEP)).anyMatch(m -> {
			VariableStepMove sm = (VariableStepMove) m;
			return sm.getMoveStep()
					.equals(MoveStep.of(MoveDirection.DIAGONAL_UP_LEFT, StepQuantum.VARIABLE_RANGE_BOUND));
		}));
	}

	@Test
	void test_invalid_moves_not_in_plan() {
		PieceMovementPlan queenMovementPlan = new QueenMovementPlan();
		List<PossibleMove> possibleMoveList = queenMovementPlan.getPossibleMoves();
		assertTrue(possibleMoveList.size() == 8);
		assertTrue(
				possibleMoveList.stream().filter(m -> m.getStepType().equals(StepType.MULTI_STEP)).findAny().isEmpty());
		assertTrue(
				possibleMoveList.stream().filter(m -> m.getStepType().equals(StepType.VARIABLE_STEP)).noneMatch(m -> {
					VariableStepMove sm = (VariableStepMove) m;
					return sm.getMoveStep().equals(MoveStep.of(MoveDirection.DOWN, StepQuantum.ONE));
				}));
	}

}
