package com.code.chesssim.move.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.types.MoveDirection;

/**
 * Factory class for setting up direction based move generators and getting
 * access to these generators based on the direction
 * 
 * @author Alf
 *
 */
public class MoveGeneratorFactory {

	private static final Map<MoveDirection, MoveGenerator> moveGeneratorMap = new HashMap<>();

	public MoveGeneratorFactory(ChessBoard chessBoard) {
		MoveGenerator upMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow() + 1, p.getCol());
		MoveGenerator downMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow() - 1, p.getCol());
		MoveGenerator leftMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow(), p.getCol() - 1);
		MoveGenerator rightMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow(), p.getCol() + 1);
		MoveGenerator diagonalUpLeftMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow() + 1, p.getCol() - 1);
		MoveGenerator diagonalUpRightMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow() + 1, p.getCol() + 1);
		MoveGenerator diagonalDownLeftMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow() - 1, p.getCol() - 1);
		MoveGenerator diagonalDownRightMoveGenerator = p -> chessBoard.evaluateAndGetBoardPosition(p.getRow() - 1, p.getCol() + 1);

		moveGeneratorMap.put(MoveDirection.UP, upMoveGenerator);
		moveGeneratorMap.put(MoveDirection.DOWN, downMoveGenerator);
		moveGeneratorMap.put(MoveDirection.LEFT, leftMoveGenerator);
		moveGeneratorMap.put(MoveDirection.RIGHT, rightMoveGenerator);
		moveGeneratorMap.put(MoveDirection.DIAGONAL_UP_LEFT, diagonalUpLeftMoveGenerator);
		moveGeneratorMap.put(MoveDirection.DIAGONAL_UP_RIGHT, diagonalUpRightMoveGenerator);
		moveGeneratorMap.put(MoveDirection.DIAGONAL_DOWN_LEFT, diagonalDownLeftMoveGenerator);
		moveGeneratorMap.put(MoveDirection.DIAGONAL_DOWN_RIGHT, diagonalDownRightMoveGenerator);
	}

	public Optional<MoveGenerator> getMoveGenerator(MoveDirection moveDirection) {
		return Optional.ofNullable(moveGeneratorMap.get(moveDirection));
	}
}
