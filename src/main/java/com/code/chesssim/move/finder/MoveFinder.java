package com.code.chesssim.move.finder;

import java.util.List;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.move.PossibleMove;

/**
 * This class defines methods for finding moves based on move template (direction, quantum)
 * 
 * @author Alf
 *
 */
public interface MoveFinder {

	List<BoardPosition> findPossibleMoves(PossibleMove possibleMove, BoardPosition initialPosition);

}
