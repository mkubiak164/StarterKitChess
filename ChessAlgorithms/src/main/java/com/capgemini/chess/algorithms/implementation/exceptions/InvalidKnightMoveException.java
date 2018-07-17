package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidKnightMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 36592934024563569L;

	public InvalidKnightMoveException() {
		super("Invalid knight move!");
	}
	
	public InvalidKnightMoveException(String message) {
		super("Invalid knight move! " + message);
	}

}
