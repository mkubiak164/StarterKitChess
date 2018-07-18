package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.*;

public class RookValidator implements MoveValidator {
	
	private Board board;
	
	public RookValidator(Board board) {
		this.board = board;
	}
	
	
	// wieza
	
	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) 
			throws InvalidRookMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		if (xFrom != xTo && yFrom != yTo) {
			throw new InvalidRookMoveException();
		}	
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) 
			throws InvalidRookMoveException {
		
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
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidRookMoveException();
					}
				}
			}
			else {
				for(int i=xFrom-1; i<=xTo; i--) {
					
					Coordinate actualCoordinate = new Coordinate(i, yFrom);
					
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidRookMoveException();
					}		
				}
			}
		}
		
		if (difY != 0 && difX == 0) {
			if (yFrom < yTo) {
				for(int i=yFrom+1; i<=yTo; i++) {

					Coordinate actualCoordinate = new Coordinate(xFrom, i);
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidRookMoveException();
					}
				}
			}
			else {
				for(int i=yFrom-1; i<=yTo; i--) {
					
					Coordinate actualCoordinate = new Coordinate(xFrom, i);
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidRookMoveException();
					}			
				}
			}
		}
	}
	
	

}
