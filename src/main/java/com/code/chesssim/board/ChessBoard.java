package com.code.chesssim.board;

import java.util.Optional;

/**
 * Immutable class representing a chess board
 * 
 * @author Alf
 *
 */
public class ChessBoard {

	private final int numRows;
	private final int numCols;

	public static final ChessBoard STANDARD = new ChessBoard(8, 8);

	public ChessBoard(int numRows, int numCols) {
		super();

		if(numRows<4 || numCols<4) throw new IllegalArgumentException("Invalid board data");

		this.numRows = numRows;
		this.numCols = numCols;
	}

	public Optional<BoardPosition> evaluateAndGetBoardPosition(int row, int col) {
		if (!isValidPosition(row, col)) {
			return Optional.empty();
		}

		return Optional.of(new BoardPosition(row, col));
	}

	private boolean isValidPosition(int row, int col) {
		return row >= 0 && row < numRows && col >= 0 && col < numCols;
	}

	public int getNumRows() {
		return numRows;
	}

	public int getNumCols() {
		return numCols;
	}

}
