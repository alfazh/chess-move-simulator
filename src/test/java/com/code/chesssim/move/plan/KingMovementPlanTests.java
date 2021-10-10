package com.code.chesssim.move.plan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.MultiStepMove;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.PossibleMove.StepType;
import com.code.chesssim.types.MoveDirection;
import com.code.chesssim.types.StepQuantum;

class KingMovementPlanTests {

	@Test
	void test_valid_moves_in_plan() {
		PieceMovementPlan kingMovementPlan = new KingMovementPlan();
		List<PossibleMove> possibleMoveList = kingMovementPlan.getPossibleMoves();
		assertTrue(possibleMoveList.size()==8);
		possibleMoveList.stream().filter(m->m.getStepType().equals(StepType.MULTI_STEP)).anyMatch(m -> {
			MultiStepMove sm = (MultiStepMove)m;
			return sm.getAllowedMove().parallelStream().anyMatch(s -> s.equals(MoveStep.of(MoveDirection.DOWN, StepQuantum.ONE)));
			});
		
		possibleMoveList.stream().filter(m->m.getStepType().equals(StepType.MULTI_STEP)).anyMatch(m -> {
			MultiStepMove sm = (MultiStepMove)m;
			return sm.getAllowedMove().parallelStream().anyMatch(s -> s.equals(MoveStep.of(MoveDirection.RIGHT, StepQuantum.ONE)));
			});
		
		possibleMoveList.stream().filter(m->m.getStepType().equals(StepType.MULTI_STEP)).anyMatch(m -> {
			MultiStepMove sm = (MultiStepMove)m;
			return sm.getAllowedMove().parallelStream().anyMatch(s -> s.equals(MoveStep.of(MoveDirection.DIAGONAL_DOWN_RIGHT, StepQuantum.ONE)));
			});
		
		possibleMoveList.stream().filter(m->m.getStepType().equals(StepType.MULTI_STEP)).anyMatch(m -> {
			MultiStepMove sm = (MultiStepMove)m;
			return sm.getAllowedMove().parallelStream().anyMatch(s -> s.equals(MoveStep.of(MoveDirection.DIAGONAL_UP_LEFT, StepQuantum.ONE)));
			});
		
	}
	
	@Test
	void test_invalid_moves_not_in_plan() {
		PieceMovementPlan kingMovementPlan = new KingMovementPlan();
		List<PossibleMove> possibleMoveList = kingMovementPlan.getPossibleMoves();
		assertTrue(possibleMoveList.size()==8);
		possibleMoveList.stream().filter(m->m.getStepType().equals(StepType.MULTI_STEP)).noneMatch(m -> {
			MultiStepMove sm = (MultiStepMove)m;
			return sm.getAllowedMove().parallelStream().noneMatch(s -> s.equals(MoveStep.of(MoveDirection.DOWN, StepQuantum.TWO)));
			});

	}

}
