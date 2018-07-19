package com.capgemini.chess.algorithms.validator.moves;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;
import com.capgemini.chess.algorithms.implementation.exceptions.KingInCheckException;
import com.capgemini.chess.algorithms.validator.CoordinateValidator;
import com.capgemini.chess.algorithms.validator.FieldValidator;
import com.capgemini.chess.algorithms.validator.KingInCheckValidator;

public class PieceMoveValidator {
	
	private CoordinateValidator coordinateValidator = new CoordinateValidator();
	private FieldValidator fieldValidator = new FieldValidator();
	private PieceMoveFactory pieceMoveFactory = new PieceMoveFactory();
	private KingInCheckValidator kingInCheckValidator; 
	private Board board;
	
	public PieceMoveValidator(Board board) {
		this.board = board;
		kingInCheckValidator = new KingInCheckValidator(board);
	}
	
	public Move validateMove(Coordinate from, Coordinate to, Color nextMoveColor) 
			throws InvalidMoveException, KingInCheckException {
		
		coordinateValidator.validateCoordinate(from);
		coordinateValidator.validateCoordinate(to);
		
		Piece piece = board.getPieceAt(from);
		Piece pieceTo = board.getPieceAt(to);
//		Color nextMoveColor = calculateNextMoveColor();
		fieldValidator.validateFieldFromEmptiness(piece, nextMoveColor); 
		MoveType moveType = fieldValidator.validateFieldToEmptiness(pieceTo, nextMoveColor); 
		
		MoveValidator moveValidator = pieceMoveFactory.createPieceValidator(piece.getType(), board);
		moveValidator.validatePieceMove(from, to);
		moveValidator.validateIfSthIsOnTheWayTo(from, to);
		
		board.setPieceAt(piece, to);
		board.setPieceAt(null, from);
		
		if (isKingInCheck(nextMoveColor)) {
			board.setPieceAt(piece, from);
			board.setPieceAt(pieceTo, to);
			throw new KingInCheckException();
		}
		
		Move move = new Move(from, to, moveType, piece);
		
	
		
		return move;
	}
	
	private boolean isKingInCheck(Color kingColor) {

		if (kingColor == Color.WHITE) {
			return kingInCheckValidator.isWhiteKingInCheck();
		}
		if (kingColor == Color.BLACK) {
			return kingInCheckValidator.isBlackKingInCheck();
		}
		return false;
	}

}
