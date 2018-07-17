package com.capgemini.chess.algorithms.implementation.exceptions;

public class InvalidRookMoveException extends InvalidMoveException {
	
	private static final long serialVersionUID = 6244572626388093213L;

	public InvalidRookMoveException() {
		super("Invalid rook move!");
	}
	
	public InvalidRookMoveException(String message) {
		super("Invalid rook move! " + message);
	}


}
