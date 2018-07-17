package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class QueenValidator implements MoveValidator {

	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException {
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		int absDiffrenceXYFrom = Math.abs(Math.abs(xFrom) - Math.abs(yFrom));
		int absDiffrenceXYTo = Math.abs(Math.abs(xTo) - Math.abs(yTo));
		
		if (xFrom != xTo || yFrom != yTo || absDiffrenceXYFrom != absDiffrenceXYTo) {
			throw new InvalidMoveException();
		}
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		
	}

}
