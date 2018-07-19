package com.capgemini.chess.algorithms.validator.moves;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.enums.Color;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class AnyMoveValidator {

	private Board board;

	List<Coordinate> whitePieces = new ArrayList<>();
	List<Coordinate> blackPieces = new ArrayList<>();

	MoveGenerator moveGenerator = new MoveGenerator();
	PieceMoveValidator pieceMoveValidator;
	
	public AnyMoveValidator(Board board) {
		this.board = board;
		this.pieceMoveValidator = new PieceMoveValidator(board);
	}

	public void whereArePieces() {

		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Coordinate actualCoordinate = new Coordinate(i, j);
				Piece actPiece = board.getPieceAt(actualCoordinate);

				if (actPiece != null && actPiece.getColor() == Color.WHITE) {
					whitePieces.add(actualCoordinate);
				}

				if (actPiece != null && actPiece.getColor() == Color.BLACK) {
					blackPieces.add(actualCoordinate);
				}
			}
		}
	}
	
	public List<Coordinate> returnWhitePieces() {
		return whitePieces;
	}
	
	public List<Coordinate> returnBlackPieces() {
		return blackPieces;
	}
	
	public boolean validateAnyMoves(Color color) {
		
		whereArePieces();
		
		if(color == Color.WHITE) {
			for(Coordinate from : whitePieces) {
				List<Coordinate> moves = generateMoves(from); 
				//lista zawierajaca koordynaty TO
				for( Coordinate to : moves) {
					try {
						//validateMove
						pieceMoveValidator.validateMove(from, to, color);
						return true;
					} catch (InvalidMoveException ex) {
						continue;
					}
				}
			}
		}
		else {
			for (Coordinate from : blackPieces) {
				List<Coordinate> moves = generateMoves(from);
				// lista zawierajaca koordynaty TO
				for (Coordinate to : moves) {
					try {
						// validateMove
						pieceMoveValidator.validateMove(from, to, color);
						return true;
					} catch (InvalidMoveException ex) {
						continue;
					}
				}
			}
		}
		return false;
	}
	
	public List<Coordinate> generateMoves(Coordinate from) {
		List<Coordinate> moves;
		Piece piece = board.getPieceAt(from);
		switch(piece.getType()) {
			case KING :
			case QUEEN:
				moves = moveGenerator.generateKingMoves(from);
				break;
			case BISHOP :
				moves = moveGenerator.generateBishopMoves(from);
				break;
			case KNIGHT :
				moves = moveGenerator.generateKnightMoves(from);
				break;
			case PAWN :
				moves = moveGenerator.generatePawnMoves(from);
				break;
			case ROOK :
				moves = moveGenerator.generateRookMoves(from);
				break;
			
		default:
			moves = new ArrayList<>();
			break;
			
		}
		return moves;
	}

	
}
