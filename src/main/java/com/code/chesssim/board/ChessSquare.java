package com.code.chesssim.board;

/**
 * Immutable class that encapsulates string representation of a chess piece
 * 
 * @author Alf
 *
 */
public class ChessSquare {

	private final String chessSquare;

	public ChessSquare(String chessSquare) {
		super();
		this.chessSquare = chessSquare;
	}

	public String getChessSquare() {
		return chessSquare;
	}

}
