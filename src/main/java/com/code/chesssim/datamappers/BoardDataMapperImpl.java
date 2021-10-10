package com.code.chesssim.datamappers;

import java.util.Arrays;
import java.util.Optional;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessSquare;
import com.code.chesssim.types.ChessPiece;

public class BoardDataMapperImpl implements BoardDataMapper {

	@Override
	public Optional<ChessSquare> toChessSquare(BoardPosition boardPosition) {
		char colChar = mapToColChar(boardPosition.getCol());
		int row = boardPosition.getRow()+1;
		
		return Optional.of(new ChessSquare(String.valueOf(colChar)+row));
	}

	private char mapToColChar(int row) {
		return (char) (row+'A');
	}
	
	private int mapFromColChar(char value) {
		return (int)(value-'A');
	}

	@Override
	public Optional<BoardPosition> toBoardPosition(ChessSquare chessSquare) {
		int row = Integer.valueOf(String.valueOf(chessSquare.getChessSquare().charAt(1)))-1;
		int col = mapFromColChar(chessSquare.getChessSquare().charAt(0));
		return Optional.of(new BoardPosition(row, col));
	}

	public Optional<ChessPiece> toChessPiece(String chessPiece) {
		Optional<String> piece = Arrays.stream(ChessPiece.values()).map(p->p.toString()).filter(p->p.equalsIgnoreCase(chessPiece)).findFirst();
		if(piece.isPresent()) {
			return Optional.of(ChessPiece.valueOf(chessPiece.toUpperCase()));
		}
		
		return Optional.empty();
	}
}
