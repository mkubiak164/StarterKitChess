package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public interface MoveValidator {
	
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException;
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) throws InvalidMoveException;

}
