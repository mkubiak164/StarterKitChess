package com.capgemini.chess.algorithms.validator.moves;
import com.capgemini.chess.algorithms.data.enums.*;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

/*enum PieceType {
	KING,
    QUEEN,
    BISHOP,
    KNIGHT,
    ROOK,
    PAWN;
}

interface MoveValidator {}*/




public class PieceMoveFactory {

	public MoveValidator createPieceValidator (PieceType type) 
			throws InvalidMoveException {
		
		switch (type) {
		
		case BISHOP: 
			return new BishopValidator();

			
		case KING:
			return new KingValidator();
	
			
		case KNIGHT:
			return new KnightValidator();
	
			
		case PAWN:
			return new PawnValidator();

			
		case QUEEN:
			return new QueenValidator();
	
			
		case ROOK:
			return new RookValidator();
	
	
		default:
			throw new InvalidMoveException();
		}
		
	}
	
	
}
