package com.code.chesssim.input;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.code.chesssim.datamappers.BoardDataMapper;
import com.code.chesssim.datamappers.BoardDataMapperImpl;

class SimulationInputProcessorTests {

	private static BoardDataMapper boardDataMapper;

	@BeforeAll
	public static void init() {
		boardDataMapper = new BoardDataMapperImpl();
	}

	@Test
	void empty_input() {
		assertTrue(SimulationInputProcessor.processInput(new String[0], boardDataMapper).isEmpty());
	}

	@Test
	void partial_input() {
		String[] input = new String[1];
		input[0] = "Pawn";
		assertTrue(SimulationInputProcessor.processInput(new String[0], boardDataMapper).isEmpty());
	}

	@Test
	void valid_input() {
		String[] input = new String[1];
		input[0] = "Pawn,A1";
		assertTrue(SimulationInputProcessor.processInput(input, boardDataMapper).isPresent());
	}

	@Test
	void valid_lowercase_input() {
		String[] input = new String[1];
		input[0] = "pawn,a1";
		assertTrue(SimulationInputProcessor.processInput(input, boardDataMapper).isPresent());
	}

	@Test
	void invalid_piece_valid_position() {
		String[] input = new String[1];
		input[0] = "knight,a1";
		assertTrue(SimulationInputProcessor.processInput(input, boardDataMapper).isEmpty());
	}

	@Test
	void valid_piece_invalid_position() {
		String[] input = new String[1];
		input[0] = "king,k1";
		assertTrue(SimulationInputProcessor.processInput(input, boardDataMapper).isEmpty());
	}

	@Test
	void invalid_piece_invalid_position() {
		String[] input = new String[1];
		input[0] = "abc,k1";
		assertTrue(SimulationInputProcessor.processInput(input, boardDataMapper).isEmpty());
	}

}
