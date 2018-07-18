package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
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
		
		Piece fromPiece = board.getPieceAt(from);
		Piece toPiece = board.getPieceAt(to);
		Color color = fromPiece.getColor();
		
		if (color == Color.WHITE) {
			
			if (yFrom != 1 && difY > 1) {
				throw new InvalidPawnMoveException();
			}
			if (yFrom == 1 && difY > 2) {
				throw new InvalidPawnMoveException();
			}
			if (yFrom > yTo) {
				throw new InvalidPawnMoveException();
			}
			if (difX > 1) {
				throw new InvalidPawnMoveException();
			}
			if(difY == 0) {
				throw new InvalidPawnMoveException();
			}
			if(difX == 1 && toPiece == null) {
				throw new InvalidPawnMoveException();
			}
			if(difX == 0 && difY == 1 && toPiece != null) {
				throw new InvalidPawnMoveException();
			}
		}
		
		if (color == Color.BLACK) {
			
			if (yFrom != 6 && difY > 1) {
				throw new InvalidPawnMoveException();
			}
			if (yFrom == 6 && difY > 2) {
				throw new InvalidPawnMoveException();
			}
			if (yFrom < yTo) {
				throw new InvalidPawnMoveException();
			}
			if (difX > 1) {
				throw new InvalidPawnMoveException();
			}
			if(difY == 0) {
				throw new InvalidPawnMoveException();
			}
			if(difX == 1 && toPiece == null) {
				throw new InvalidPawnMoveException();
			}
			if(difX == 0 && difY == 1 && toPiece != null) {
				throw new InvalidPawnMoveException();
			}
			
		}
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) 
			throws InvalidPawnMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = to.getX();
		int yTo = to.getY();
		
		if (yFrom == 6 && yTo == 4) {
			Coordinate actualCoordinate = new Coordinate(xFrom, 5);
			Piece actPiece = board.getPieceAt(actualCoordinate);
		
		if (actPiece != null) {
			throw new InvalidPawnMoveException();
			}
		}
		
		if (yFrom == 1 && yTo == 3) {
			Coordinate actualCoordinate = new Coordinate(xFrom, 2);
			Piece actPiece = board.getPieceAt(actualCoordinate);
		
		if (actPiece != null) {
			throw new InvalidPawnMoveException();
			}
		}
	}
}
