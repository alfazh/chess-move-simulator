package com.code.chesssim.app;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.code.chesssim.board.BoardPosition;
import com.code.chesssim.board.ChessSquare;
import com.code.chesssim.evaluator.MoveEvaluator;
import com.code.chesssim.move.plan.MovementPlanFactory;
import com.code.chesssim.move.plan.PieceMovementPlan;
import com.code.chesssim.util.BoardDataMapper;
import com.code.chesssim.util.SimulationInput;
import com.code.chesssim.util.SimulationInputProcessor;

@Component
public class ChessSimulatorRunner implements CommandLineRunner {

	private final BoardDataMapper boardDataMapper;

	private final MovementPlanFactory moveplanFactory;

	private final MoveEvaluator moveEvaluator;

	@Autowired
	private ApplicationContext appContext;

	private static final Logger logger = LoggerFactory.getLogger(ChessSimulatorRunner.class);

	@Autowired
	public ChessSimulatorRunner(BoardDataMapper boardDataMapper, MovementPlanFactory moveplanFactory,
			MoveEvaluator moveEvaluator, ApplicationContext appContext) {
		super();
		this.boardDataMapper = boardDataMapper;
		this.moveplanFactory = moveplanFactory;
		this.moveEvaluator = moveEvaluator;
		this.appContext = appContext;
	}

	@Override
	public void run(String... args) throws Exception {
		// Read input data from CLI
		Optional<SimulationInput> simulationRequest = SimulationInputProcessor.processInput(args, boardDataMapper);

		if (simulationRequest.isPresent()) {
			SimulationInput simInput = simulationRequest.get();
			// lookup board position and piece movement plan
			BoardPosition initialPosition = boardDataMapper.toBoardPosition(simInput.getChessSquare()).get();
			PieceMovementPlan pieceMovementPlan = moveplanFactory.getPieceMovementPlan(simInput.getChessPiece());

			// find possible moves
			List<BoardPosition> possibleMoveList = moveEvaluator.getPossibleMoves(initialPosition, pieceMovementPlan);

			// print output
			if (!CollectionUtils.isEmpty(possibleMoveList)) {
				logger.info("Possible moves: "
						+ possibleMoveList.stream().map(boardDataMapper::toChessSquare).filter(Optional::isPresent)
								.map(Optional::get).map(ChessSquare::getChessSquare).collect(Collectors.toList()));
			} else {
				logger.info("No valid moves found");
			}
		}

		// exit
		shutdownApplication();
	}

	public void shutdownApplication() {
		int exitCode = SpringApplication.exit(appContext, (ExitCodeGenerator) () -> 0);
		System.exit(exitCode);
	}
}
