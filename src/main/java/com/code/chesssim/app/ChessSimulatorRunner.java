package com.code.chesssim.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.code.chesssim.evaluator.MoveEvaluator;

@Component
public class ChessSimulatorRunner implements CommandLineRunner {

	private MoveEvaluator moveEvaluator;

	private static final Logger logger = LoggerFactory.getLogger(ChessSimulatorRunner.class);

	@Override
	public void run(String... args) throws Exception {

		// Read input data from CLI

		// Map the data into piece and board position

		// lookup movement plan for piece

		// use move evaluator to find possible moves

		// transform the moves into chess square notations and print

		// exit

	}

}
