package com.code.chesssim.move.generator;

import java.util.Optional;

import com.code.chesssim.board.BoardPosition;

/**
 * This interface defines a way to compute the next possible move from a
 * particular board position
 * 
 * @author Alf
 *
 */
public interface MoveGenerator {

	Optional<BoardPosition> getNextMove(BoardPosition boardPosition);

}
