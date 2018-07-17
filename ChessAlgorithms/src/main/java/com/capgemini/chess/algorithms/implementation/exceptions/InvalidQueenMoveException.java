package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidQueenMoveException extends InvalidMoveException {

	private static final long serialVersionUID = -4674234735255721061L;

	public InvalidQueenMoveException() {
		super("Invalid queen move!");
	}
	
	public InvalidQueenMoveException(String message) {
		super("Invalid queen move! " + message);
	}

}
