package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidQueenMoveException;

public class QueenValidator implements MoveValidator {

	private Board board;
	
	public QueenValidator(Board board) {
		this.board = board;
	}
	
	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException {
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		int absDiffrenceX = Math.abs(Math.abs(xFrom) - Math.abs(xTo));
		int absDiffrenceY = Math.abs(Math.abs(yFrom) - Math.abs(yTo));
		
		if ((xFrom != xTo) && (yFrom != yTo) && (absDiffrenceX != absDiffrenceY)) {
			throw new InvalidMoveException();
		}
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) 
			throws InvalidQueenMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		int difX = Math.abs(Math.abs(xFrom) - Math.abs(xTo));
		int difY = Math.abs(Math.abs(yFrom) - Math.abs(yTo));
		
		if (difX != 0 && difY == 0) {
			if (xFrom < xTo) {
				for(int i=xFrom+1; i<xTo; i++) {
					
					Coordinate actualCoordinate = new Coordinate(i, yFrom);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidQueenMoveException();
					}
				}
			}
			else {
				for(int i=xFrom-1; i<=xTo; i--) {
					
					Coordinate actualCoordinate = new Coordinate(i, yFrom);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidQueenMoveException();
					}		
				}
			}
		}
		
		if (difY != 0 && difX == 0) {
			if (yFrom < yTo) {
				for(int i=yFrom+1; i<=yTo; i++) {

					Coordinate actualCoordinate = new Coordinate(xFrom, i);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidQueenMoveException();
					}
				}
			}
			else {
				for(int i=yFrom-1; i<=yTo; i--) {
					
					Coordinate actualCoordinate = new Coordinate(xFrom, i);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidQueenMoveException();
					}			
				}
			}
		}
	
	
	if (xFrom < xTo && yFrom < yTo) {
		for (int i = xFrom+1; i < xTo; i++) {
			for (int j = yFrom+1; j < yTo; j++) {
				
				Coordinate actualCoordinate = new Coordinate(i, j);
				Piece actPiece = board.getPieceAt(actualCoordinate);
				
				if (actPiece != null) {
					throw new InvalidQueenMoveException();
				}
			}
		}
	}
	
	if (xFrom < xTo && yFrom > yTo) {
		for (int i = xFrom+1; i < xTo; i++) {
			for (int j = yFrom=1; j > yTo; j--) {
				
				Coordinate actualCoordinate = new Coordinate(i, j);
				Piece actPiece = board.getPieceAt(actualCoordinate);
				
				if (actPiece != null) {
					throw new InvalidQueenMoveException();
				}
			}
		}
	}
	
	if (xFrom > xTo && yFrom > yTo) {
		for (int i = xFrom-1; i > xTo; i--) {
			for (int j = yFrom-1; j > yTo; j--) {
				
				Coordinate actualCoordinate = new Coordinate(i, j);
				Piece actPiece = board.getPieceAt(actualCoordinate);
				
				if (actPiece != null) {
					throw new InvalidQueenMoveException();
				}
			}
		}
	}

	if (xFrom > xTo && yFrom < yTo) {
		for (int i = xFrom-1; i > xTo; i--) {
			for (int j = yFrom+1; j < yTo; j++) {
				
				Coordinate actualCoordinate = new Coordinate(i, j);
				Piece actPiece = board.getPieceAt(actualCoordinate);
				
				if (actPiece != null) {
					throw new InvalidQueenMoveException();
				}
			}
		}
	}
}


}
