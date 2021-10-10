package com.code.chesssim.util;

import com.code.chesssim.board.ChessSquare;
import com.code.chesssim.types.ChessPiece;

public class SimulationInput {

	private final ChessPiece chessPiece;
	private final ChessSquare chessSquare;

	public SimulationInput(ChessPiece chessPiece, ChessSquare chessSquare) {
		super();
		this.chessPiece = chessPiece;
		this.chessSquare = chessSquare;
	}

	public ChessPiece getChessPiece() {
		return chessPiece;
	}

	public ChessSquare getChessSquare() {
		return chessSquare;
	}

}
