package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.*;

public class KingValidator implements MoveValidator {

	private Board board;
	
	public KingValidator(Board board) {
		this.board = board;
	}
	
	
	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) 
			throws InvalidKingMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		int xAbs = Math.abs(Math.abs(xFrom) - Math.abs(xTo));
		int yAbs = Math.abs(Math.abs(yFrom) - Math.abs(yTo));
		
		if ( xAbs > 1 || yAbs > 1) {
			throw new InvalidKingMoveException();
		}
		
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) 
			throws InvalidKingMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
			for (int i = (xFrom-1); i <= (xFrom+1); i++) {
				for (int j = (yFrom-1); j <= (yFrom+1); j++) {
					
					Coordinate actualCoordinate = new Coordinate(i, j);
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null && actPiece.getColor() != fromPiece.getColor()) {
						throw new InvalidKingMoveException();
				}
			}
		} 		
	}
}


