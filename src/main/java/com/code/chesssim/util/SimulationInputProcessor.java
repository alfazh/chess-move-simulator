package com.code.chesssim.util;

import java.util.EnumSet;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.code.chesssim.board.ChessSquare;
import com.code.chesssim.types.ChessPiece;

public final class SimulationInputProcessor {

	private static final EnumSet<ChessPiece> SUPPORTED_PIECE_SET = EnumSet.of(ChessPiece.KING, ChessPiece.QUEEN,
			ChessPiece.PAWN);

	private static final Pattern POSITION_PATTERN = Pattern.compile("[ABCDEFGH][12345678]");

	private static final Logger logger = LoggerFactory.getLogger(SimulationInputProcessor.class);

	private static final String USAGE = "Invalid input. Please provide 1 CLI argument in format <chess piece>,<position>. Eg. Pawn, A2. Supported pieces: Pawn, King, Queen.";

	public static Optional<SimulationInput> processInput(String[] args, BoardDataMapper boardDataMapper) {
		if (args.length < 1) {
			logger.info(USAGE);
			return Optional.empty();
		}

		String[] inputData = args[0].split(",");
		if (inputData.length < 2) {
			logger.info(USAGE);
			return Optional.empty();
		}

		String pieceString = inputData[0].strip();
		String positionString = inputData[1].strip().toUpperCase();

		Optional<ChessPiece> chessPiece = boardDataMapper.toChessPiece(pieceString);
		Optional<ChessSquare> chessSquare = isPositionStringValid(positionString)
				? Optional.of(new ChessSquare(positionString))
				: Optional.empty();

		if (chessPiece.isEmpty() || chessSquare.isEmpty() || !SUPPORTED_PIECE_SET.contains(chessPiece.get())) {
			logger.info(USAGE);
			return Optional.empty();
		}

		return Optional.of(new SimulationInput(chessPiece.get(), chessSquare.get()));
	}

	private static boolean isPositionStringValid(String positionString) {
		Matcher matcher = POSITION_PATTERN.matcher(positionString);
		return matcher.find();
	}

}
