package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.*;

public class PawnValidator implements MoveValidator {
	
	// pionek
	
	private Board board;
	
	public PawnValidator(Board board) {
		this.board = board;
	}

	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) 
			throws InvalidPawnMoveException {

		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		int difX = Math.abs(Math.abs(xFrom) - Math.abs(xTo));
		int difY = Math.abs(Math.abs(yFrom) - Math.abs(yTo));
		
		// jezeli tylko y+1, wtedy normalny ruch, jezeli to pierwszy ruch to moze być y+2, 
		// albo x +/-1 i y+1, wtedy na tym polu musi stac pionek przeciwnika i bedzie to bicie
		
		boolean isThisFirstMove = true;
		
		if(isThisFirstMove == false && difX == 2) {
			throw new InvalidPawnMoveException();
		}
		
		if (difY != 0) {
			throw new InvalidPawnMoveException();
		}
		
		if (difX > 2)
			throw new InvalidPawnMoveException();
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) 
			throws InvalidPawnMoveException {
		
		
	}

}
