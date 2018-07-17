package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class KnightValidator implements MoveValidator {

	// koń
	
	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException {

		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		int diffrenceXYFrom = Math.abs(Math.abs(xFrom) - Math.abs(yFrom));
		int diffrenceXYTo = Math.abs(Math.abs(xTo) - Math.abs(yTo));
		
		// jedno musi sie równać 2 , a drugie 1, zeby ruch był dostepny 
		
		if ((diffrenceXYFrom != 2 && diffrenceXYTo != 1) || (diffrenceXYFrom != 1 && diffrenceXYTo != 2)) {
			throw new InvalidMoveException();
		}
		
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		
	}

}
