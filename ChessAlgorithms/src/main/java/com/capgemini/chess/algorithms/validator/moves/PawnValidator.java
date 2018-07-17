package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PawnValidator implements MoveValidator {
	
	// pionek

	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException {

		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		// jezeli tylko y+1, wtedy normalny ruch, jezeli to pierwszy ruch to moze być y+2, 
		// albo x +/-1 i y+1, wtedy na tym polu musi stac pionek przeciwnika i bedzie to bicie
		
		
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		
	}

}
