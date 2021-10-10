package com.code.chesssim.move.finder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.VariableStepMove;
import com.code.chesssim.move.generator.MoveGenerator;
import com.code.chesssim.move.generator.MoveGeneratorFactory;

/**
 * This class computes the possible moves for a VariableStepMove based on an
 * initial position on the board
 * 
 * @author Alf
 *
 */
public final class VariableStepMoveFinder implements MoveFinder {

	private MoveGeneratorFactory moveGeneratorFactory;

	public VariableStepMoveFinder(MoveGeneratorFactory moveGeneratorFactory) {
		super();
		this.moveGeneratorFactory = moveGeneratorFactory;
	}

	@Override
	public List<BoardPosition> findPossibleMoves(PossibleMove possibleMove, BoardPosition initialPosition) {
		VariableStepMove variableStepMove = (VariableStepMove) possibleMove;

		// get generator for movestep.direction
		Optional<MoveGenerator> moveGenerator = moveGeneratorFactory
				.getMoveGenerator(variableStepMove.getMoveStep().getMoveDirection());
		if (moveGenerator.isEmpty()) {
			return Collections.emptyList();
		}

		return generateMoves(moveGenerator.get(), initialPosition);
	}

	public List<BoardPosition> generateMoves(MoveGenerator moveGenerator, BoardPosition initialPosition) {
		List<BoardPosition> possibleMoveList = new ArrayList<>();
		Optional<BoardPosition> nextPosition = moveGenerator.getNextMove(initialPosition);
		while (nextPosition.isPresent()) {
			possibleMoveList.add(nextPosition.get());
			nextPosition = moveGenerator.getNextMove(nextPosition.get());
		}
		return possibleMoveList;
	}
}
