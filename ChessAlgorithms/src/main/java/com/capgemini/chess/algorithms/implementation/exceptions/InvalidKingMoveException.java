package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidKingMoveException extends InvalidMoveException {

	private static final long serialVersionUID = 4363223569996785654L;

	public InvalidKingMoveException() {
		super("Invalid king move!");
	}
	
	public InvalidKingMoveException(String message) {
		super("Invalid king move! " + message);
	}
}
