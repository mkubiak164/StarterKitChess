package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidPawnMoveException extends InvalidMoveException {

	private static final long serialVersionUID = -74513436407498767L;

	public InvalidPawnMoveException() {
		super("Invalid pawn move!");
	}
	
	public InvalidPawnMoveException(String message) {
		super("Invalid pawn move! " + message);
	}

}
