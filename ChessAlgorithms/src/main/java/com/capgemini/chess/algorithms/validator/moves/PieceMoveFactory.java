package com.capgemini.chess.algorithms.validator.moves;
import com.capgemini.chess.algorithms.data.enums.*;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class PieceMoveFactory {

	public MoveValidator createPieceValidator (PieceType type, Board board) 
			throws InvalidMoveException {
		
		switch (type) {
		
		case BISHOP: 
			return new BishopValidator(board);
			
		case KING:
			return new KingValidator(board);
	
			
		case KNIGHT:
			return new KnightValidator(board);
	
			
		case PAWN:
			return new PawnValidator(board);

			
		case QUEEN:
			return new QueenValidator(board);
	
			
		case ROOK:
			return new RookValidator(board);
	
	
		default:
			throw new InvalidMoveException();
		}
		
	}
	
	
}
