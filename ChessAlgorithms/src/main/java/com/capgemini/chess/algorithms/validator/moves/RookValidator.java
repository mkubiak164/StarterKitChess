package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.*;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class RookValidator implements MoveValidator {

	
	// wieza
	
	@Override
	public void validatePieceMove(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		if (xFrom != xTo || yFrom != yTo) {
			throw new InvalidMoveException();
		}	
	}

	@Override
	public void validateIfSthIsOnTheWayTo(Coordinate from, Coordinate to) throws InvalidMoveException {
		
		int xFrom = from.getX();
		int yFrom = from.getY();
		int xTo = from.getX();
		int yTo = from.getY();
		
		int difX = Math.abs(Math.abs(xFrom) - Math.abs(xTo));
		int difY = Math.abs(Math.abs(yFrom) - Math.abs(yTo));
		
		
		if (difX != 0 && difY == 0) {
			if (xFrom < xTo) {
				for(int i=xFrom+1; i<=xTo; i++) {
					
					Coordinate aC = new Coordinate(i, yFrom);
					Board 
					Piece actPiece = getPieceAt(aC);
					
					
					
					if (actPiece != null && actPiece.getColor() != ) {
						throw new InvalidMoveException();
						break;
					}
					
				/*	public Board getBoard() {
						return this.board;
						*/
						
					/*private Piece[][] pieces = new Piece[SIZE][SIZE];
					 * 
					 * public Piece[][] getPieces() {
						return pieces;
					}*/
					
					
					/*public Piece getPieceAt(Coordinate coordinate) {
						return pieces[coordinate.getX()][coordinate.getY()];
					}*/
								
				}
			}
			else {
				for(int i=xFrom-1; i<=xTo; i--) {
					
			// TODO napisać co dalej		
					
				}
			}
		}
		
		if (difY != 0 && difX == 0) {
			if (yFrom < yTo) {
				for(int i=yFrom+1; i<=yTo; i++) {
					// TODO
				}
			}
			else {
				for(int i=yFrom-1; i<=yTo; i--) {
					
					// TODO napisać co dalej		
							
				}
			}
		}
	}
	
	

}
