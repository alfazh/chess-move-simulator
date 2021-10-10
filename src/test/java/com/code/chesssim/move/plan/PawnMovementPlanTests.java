package com.code.chesssim.move.plan;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.MultiStepMove;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.PossibleMove.StepType;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

public class PawnMovementPlanTests {
	@Test
	void test_valid_moves_in_plan() {
		PieceMovementPlan pawnMovementPlan = new PawnMovementPlan();
		List<PossibleMove> possibleMoveList = pawnMovementPlan.getPossibleMoves();
		assertTrue(possibleMoveList.size()==1);
		assertTrue(possibleMoveList.stream().filter(m->m.getStepType().equals(StepType.MULTI_STEP)).anyMatch(m -> {
			MultiStepMove sm = (MultiStepMove)m;
			return sm.getAllowedMove().parallelStream().anyMatch(s -> s.equals(MoveStep.of(MoveDirection.UP, StepQuantum.ONE)));
			}));
	}
	
	@Test
	void test_invalid_moves_not_in_plan() {
		PieceMovementPlan pawnMovementPlan = new PawnMovementPlan();
		List<PossibleMove> possibleMoveList = pawnMovementPlan.getPossibleMoves();
		assertTrue(possibleMoveList.size()==1);
		assertTrue(
				possibleMoveList.stream().filter(m -> m.getStepType().equals(StepType.VARIABLE_STEP)).findAny().isEmpty());
		assertTrue(possibleMoveList.stream().filter(m->m.getStepType().equals(StepType.MULTI_STEP)).noneMatch(m -> {
			MultiStepMove sm = (MultiStepMove)m;
			return sm.getAllowedMove().parallelStream().anyMatch(s -> s.equals(MoveStep.of(MoveDirection.UP, StepQuantum.TWO)));
			}));
	}
}
