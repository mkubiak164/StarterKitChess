package com.capgemini.chess.algorithms.validator;

import java.util.ArrayList;
import java.util.List;

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

	List<Coordinate> whitePieces = new ArrayList<>();
	List<Coordinate> blackPieces = new ArrayList<>();
	// int[][] whitePieces = new int[15][2];
	// int[][] blackPieces = new int[15][2];
	private PieceMoveFactory pieceMoveFactory = new PieceMoveFactory();
	private int whiteKingX;
	private int whiteKingY;
	private int blackKingX;
	private int blackKingY;

	public KingInCheckValidator(Board board) {
		this.board = board;
	}

	public void whereArePieces() {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Coordinate actualCoordinate = new Coordinate(i, j);
				Piece actPiece = board.getPieceAt(actualCoordinate);

				if (actPiece != null && actPiece.getType() == PieceType.KING) {
					if (actPiece.getColor() == Color.WHITE) {
						Piece whiteKing = actPiece;
						whiteKingX = i;
						whiteKingY = j;
					}
					if (actPiece.getColor() == Color.BLACK) {
						Piece blackKing = actPiece;
						blackKingX = i;
						blackKingY = j;
					}
				}

				if (actPiece != null && actPiece.getColor() == Color.WHITE) {
					whitePieces.add(actualCoordinate);
				}

				if (actPiece != null && actPiece.getColor() == Color.BLACK) {
					blackPieces.add(actualCoordinate);
				}
			}
		}
	}

	public boolean isWhiteKingInCheck() {

		whereArePieces();

		Coordinate coordinateTo = new Coordinate(whiteKingX, whiteKingY);

		for (int k = 0; k < blackPieces.size(); k++) {
		
			Coordinate coordinateFrom = blackPieces.get(k);
			Piece fromPiece = board.getPieceAt(coordinateFrom);

			try {
				MoveValidator moveValidator = pieceMoveFactory.createPieceValidator(fromPiece.getType(), board);
				moveValidator.validatePieceMove(coordinateFrom, coordinateTo);
				moveValidator.validateIfSthIsOnTheWayTo(coordinateFrom, coordinateTo);
			} catch (InvalidMoveException ex) {
				continue;
			}
			return true;
		}
		return false;
	}

	public boolean isBlackKingInCheck() {

		whereArePieces();

		Coordinate coordinateTo = new Coordinate(blackKingX, blackKingY);

		for (int k = 0; k < whitePieces.size(); k++) {

			Coordinate coordinateFrom = whitePieces.get(k);
			Piece fromPiece = board.getPieceAt(coordinateFrom);

			try {
				MoveValidator moveValidator = pieceMoveFactory.createPieceValidator(fromPiece.getType(), board);
				moveValidator.validatePieceMove(coordinateFrom, coordinateTo);
				moveValidator.validateIfSthIsOnTheWayTo(coordinateFrom, coordinateTo);
			} catch (InvalidMoveException ex) {
				continue;
			}
			return true;
		}
		return false;
	}
}
