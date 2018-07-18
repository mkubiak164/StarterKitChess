package com.capgemini.chess.algorithms.validator;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.BoardState;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.enums.PieceType;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.*;
import com.capgemini.chess.algorithms.validator.moves.MoveValidator;
import com.capgemini.chess.algorithms.validator.moves.PieceMoveFactory;

public class KingInCheckValidator {
	
	private Board board;
	int[][] whitePieces = new int[7][1];
	int[][] blackPieces = new int[7][1];
	private PieceMoveFactory pieceMoveFactory = new PieceMoveFactory();
	private int whiteKingX;
	private int whiteKingY;
	private int blackKingX;
	private int blackKingY;
	private MoveType moveType;
	private Object move = null;
	
	public KingInCheckValidator(Board board) {
		this.board = board;
	}
	
	{
	
	for (int i=0; i<8; i++) {
		for (int j=0; j<8; j++) {
			Coordinate actualCoordinate = new Coordinate(i, j);
			Piece actPiece = board.getPieceAt(actualCoordinate);
			
			if (actPiece.getType() == PieceType.KING) {
				if (actPiece.getColor() == Color.WHITE) {
					Piece whiteKing = actPiece;
					int whiteKingX = i;
					int whiteKingY = j;
				}
				if (actPiece.getColor() == Color.BLACK) {
					Piece blackKing = actPiece;
					int blackKingX = i;
					int whiteKingY = j;
				}
			}
			if (actPiece != null && actPiece.getColor() == Color.WHITE) {
				for (int k=0; k<7; k++) {
					whitePieces [k][0] = actualCoordinate.getX();
					whitePieces [k][1] = actualCoordinate.getY();
				}
			}
			if (actPiece != null && actPiece.getColor() == Color.BLACK) {
				for (int k=0; k<7; k++) {
					blackPieces [k][0] = actualCoordinate.getX();
					blackPieces [k][1] = actualCoordinate.getY();
				}
			}
		}
	}
}
	public Boolean isWhiteKingInCheck() throws InvalidMoveException {
		
		Coordinate coordinateTo = new Coordinate(whiteKingX, whiteKingY);
		boolean isWKInCheck;
		
		for(int k = 0; k < blackPieces.length; k++) {
			int xFrom = blackPieces[k][0];
			int yFrom = blackPieces[k][1];
			
			Coordinate coordinateFrom = new Coordinate(xFrom, yFrom);
			Piece fromPiece = board.getPieceAt(coordinateFrom);
			MoveValidator moveValidator = pieceMoveFactory.createPieceValidator(fromPiece.getType(), board);
			moveValidator.validatePieceMove(coordinateFrom, coordinateTo);
			moveValidator.validateIfSthIsOnTheWayTo(coordinateFrom, coordinateTo);
			move = new Move(coordinateFrom, coordinateTo, moveType, fromPiece);
		}
		if (move != null) {
			// throw new WhiteKingInCheckException();
			isWKInCheck = true;
		} else {
			isWKInCheck = false;
		}
		return isWKInCheck;
	}
	
	public Boolean isBlackKingInCheck() throws InvalidMoveException {
		
		Coordinate coordinateTo = new Coordinate(blackKingX, blackKingY);
		boolean isBKInCheck;
		
		for(int k = 0; k < whitePieces.length; k++) {
			int xFrom = whitePieces[k][0];
			int yFrom = whitePieces[k][1];
			
			Coordinate coordinateFrom = new Coordinate(xFrom, yFrom);
			Piece fromPiece = board.getPieceAt(coordinateFrom);
			
			MoveValidator moveValidator = pieceMoveFactory.createPieceValidator(fromPiece.getType(), board);
			moveValidator.validatePieceMove(coordinateFrom, coordinateTo);
			moveValidator.validateIfSthIsOnTheWayTo(coordinateFrom, coordinateTo);
			move = new Move(coordinateFrom, coordinateTo, moveType, fromPiece);
		}
		if (move != null) {
		//	throw new BlackKingInCheckException();
			isBKInCheck = true;
		} else {
			isBKInCheck = false;
		}
		return isBKInCheck;
	}
}


