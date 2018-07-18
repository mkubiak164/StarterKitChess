package com.capgemini.chess.algorithms.validator;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class FieldValidator {
	
	
	public void validateFieldFromEmptiness(Piece piece, Color nextMoveColor)
			throws InvalidMoveException {
		
		Color actualColor = nextMoveColor; 
		
		if (piece == null) {
			throw new InvalidMoveException();
		}
		
		Color pieceColor = piece.getColor();
		
		if (actualColor != pieceColor) {
			throw new InvalidMoveException();
		}
		
	}
	
	
	public MoveType validateFieldToEmptiness(Piece piece, Color actualColor)
			throws InvalidMoveException {
				
		if (piece == null) {
			return MoveType.ATTACK;
		}
		
		Color pieceColor = piece.getColor();
		
		if (actualColor == pieceColor) {
			throw new InvalidMoveException();
		} else {
			return MoveType.CAPTURE;
		}

	}

	
}
