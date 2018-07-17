package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidBishopMoveException extends InvalidMoveException {

	
	private static final long serialVersionUID = 4143714125982543362L;

	public InvalidBishopMoveException() {
		super("Invalid bishop move!");
	}
	
	public InvalidBishopMoveException(String message) {
		super("Invalid bishop move! " + message);
	}

}
