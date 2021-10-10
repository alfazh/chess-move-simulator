package com.code.chesssim.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.code.chesssim.board.ChessBoard;
import com.code.chesssim.evaluator.EmptyBoardMoveEvaluatorImpl;
import com.code.chesssim.evaluator.MoveEvaluator;
import com.code.chesssim.move.generator.MoveGeneratorFactory;
import com.code.chesssim.move.plan.MovementPlanFactory;
import com.code.chesssim.util.BoardDataMapper;
import com.code.chesssim.util.BoardDataMapperImpl;

@Configuration
public class ChessSimulatorConfiguration {

	@Bean
	public BoardDataMapper boardDataMapper() {
		return new BoardDataMapperImpl();
	}

	@Bean
	public MovementPlanFactory movementPlanFactory() {
		return new MovementPlanFactory();
	}

	@Bean
	public MoveGeneratorFactory moveGeneratorFactory() {
		return new MoveGeneratorFactory(ChessBoard.STANDARD);
	}

	@Bean
	public MoveEvaluator moveEvaluator() {
		return new EmptyBoardMoveEvaluatorImpl(moveGeneratorFactory());
	}

}
