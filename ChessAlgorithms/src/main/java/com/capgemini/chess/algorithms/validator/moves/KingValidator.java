package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class KingValidator implements MoveValidator {

	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		int xAbs = Math.abs(Math.abs(xFrom) - Math.abs(xTo));
		int yAbs = Math.abs(Math.abs(yFrom) - Math.abs(yTo));
		
		if ( xAbs > 1 || yAbs > 1) {
			throw new InvalidMoveException();
		}
		
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		/*int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
			for (int i = (xFrom-1); i <= (xFrom+1); i++) {
				for (int j = (yFrom-1); j <= (yFrom+1); j++) {
					nPiece = piece[i][j].getPiece();
					
				}
			}*/
		
	} 

}
