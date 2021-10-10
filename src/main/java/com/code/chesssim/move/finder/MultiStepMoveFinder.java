package com.code.chesssim.move.finder;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.move.MoveStep;
import com.code.chesssim.move.MultiStepMove;
import com.code.chesssim.move.PossibleMove;
import com.code.chesssim.move.generator.MoveGenerator;
import com.code.chesssim.move.generator.MoveGeneratorFactory;

/**
 * This class computes the possible moves for a MultiStepMove based on an
 * initial position on the board
 * 
 * @author Alf
 *
 */
public final class MultiStepMoveFinder implements MoveFinder {

	private MoveGeneratorFactory moveGeneratorFactory;

	public MultiStepMoveFinder(MoveGeneratorFactory moveGeneratorFactory) {
		super();
		this.moveGeneratorFactory = moveGeneratorFactory;
	}

	@Override
	public List<BoardPosition> findPossibleMoves(PossibleMove possibleMove, BoardPosition initialPosition) {
		MultiStepMove multiStepMove = (MultiStepMove) possibleMove;
		Optional<BoardPosition> nextPosition = Optional.of(initialPosition);

		for (MoveStep moveStep : multiStepMove.getAllowedMove()) {
			Optional<MoveGenerator> moveGeneratorOpt = moveGeneratorFactory
					.getMoveGenerator(moveStep.getMoveDirection());
			if (moveGeneratorOpt.isEmpty()) {
				throw new IllegalStateException("Fail to find move generator for " + moveStep.getMoveDirection()); // fail
																													// fast
			}

			MoveGenerator moveGenerator = moveGeneratorOpt.get();
			int stepQuantum = moveStep.getStepQuantum().getValue();
			// Run generator for quantum steps to complete the step.
			while (stepQuantum-- > 0) {
				nextPosition = moveGenerator.getNextMove(nextPosition.get());
				if (nextPosition.isEmpty()) {
					// if we are not able to advance to the next position then no point in trying
					// rest of the steps
					return Collections.emptyList();
				}
			}
		}

		return Collections.singletonList(nextPosition.get());
	}

}
