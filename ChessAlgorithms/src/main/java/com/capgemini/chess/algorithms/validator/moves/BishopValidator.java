package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class BishopValidator implements MoveValidator {

	// Goniec
	
	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		int absDiffrenceXYFrom = Math.abs(Math.abs(xFrom) - Math.abs(yFrom));
		int absDiffrenceXYTo = Math.abs(Math.abs(xTo) - Math.abs(yTo));
		
		if (absDiffrenceXYFrom != absDiffrenceXYTo) {
			throw new InvalidMoveException();
		}
		
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		if (xFrom < xTo && yFrom < yTo) {
			for (int i = xFrom+1; i < xTo; i++) {
				for (int j = yFrom+1; j < yTo; j++) {
					
				}
			}
		}
		
		if (xFrom < xTo && yFrom > yTo) {
			
		}
		
		if (xFrom > xTo && yFrom > yTo) {
			
		}

		if (xFrom > xTo && yFrom < yTo) {
	
		}
		
	}

}
