package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.*;

public class BishopValidator implements MoveValidator {

	private Board board;
	
	public BishopValidator(Board board) {
		this.board = board;
	}
	
	
	// Goniec
	
	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) 
			throws InvalidBishopMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		int absDiffrenceXYFrom = Math.abs(Math.abs(xFrom) - Math.abs(yFrom));
		int absDiffrenceXYTo = Math.abs(Math.abs(xTo) - Math.abs(yTo));
		
		if (absDiffrenceXYFrom != absDiffrenceXYTo) {
			throw new InvalidBishopMoveException();
		}
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) 
			throws InvalidBishopMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		if (xFrom < xTo && yFrom < yTo) {
			for (int i = xFrom+1; i < xTo; i++) {
				for (int j = yFrom+1; j < yTo; j++) {
					
					Coordinate actualCoordinate = new Coordinate(i, j);
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidBishopMoveException();
					}
				}
			}
		}
		
		if (xFrom < xTo && yFrom > yTo) {
			for (int i = xFrom+1; i < xTo; i++) {
				for (int j = yFrom=1; j > yTo; j--) {
					
					Coordinate actualCoordinate = new Coordinate(i, j);
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidBishopMoveException();
					}
				}
			}
		}
		
		if (xFrom > xTo && yFrom > yTo) {
			for (int i = xFrom-1; i > xTo; i--) {
				for (int j = yFrom-1; j > yTo; j--) {
					
					Coordinate actualCoordinate = new Coordinate(i, j);
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidBishopMoveException();
					}
				}
			}
		}

		if (xFrom > xTo && yFrom < yTo) {
			for (int i = xFrom-1; i > xTo; i--) {
				for (int j = yFrom+1; j < yTo; j++) {
					
					Coordinate actualCoordinate = new Coordinate(i, j);
					Piece fromPiece = board.getPieceAt(from);
					Piece actPiece = board.getPieceAt(actualCoordinate);
					
					if (actPiece != null) {
						throw new InvalidBishopMoveException();
					}
				}
			}
		}
	}

}
