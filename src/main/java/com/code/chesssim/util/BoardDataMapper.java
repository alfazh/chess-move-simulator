package com.code.chesssim.util;

import java.util.Optional;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessSquare;
import com.code.chesssim.types.ChessPiece;

/**
 * This interface defines methods for mapping data about chess piece and board
 * positions from the input provided by the user to the model that is used to
 * calculate moves
 * 
 * @author Alf
 *
 */
public interface BoardDataMapper {

	Optional<ChessSquare> toChessSquare(BoardPosition boardPosition);

	Optional<BoardPosition> toBoardPosition(ChessSquare chessSquare);

	Optional<ChessPiece> toChessPiece(String chessPiece);

}
