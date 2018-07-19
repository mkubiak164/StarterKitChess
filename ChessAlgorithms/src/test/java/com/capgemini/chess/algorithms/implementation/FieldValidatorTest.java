package com.capgemini.chess.algorithms.implementation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.data.Move;
import com.capgemini.chess.algorithms.data.enums.MoveType;
import com.capgemini.chess.algorithms.data.enums.Piece;
import com.capgemini.chess.algorithms.data.generated.Board;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class FieldValidatorTest {
	

	private boolean exceptionThrown;

	@Test
	// @Rule(InvalidMoveException.class)
	public void shouldThrowExceptionWhenPieceFromIsNull() throws InvalidMoveException {
	
		// given
				Board board = new Board();
				board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
				board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(7, 0));
				
				// when
				BoardManager boardManager = new BoardManager(board);
				try {
					Move move = boardManager.performMove(new Coordinate(3, 0), new Coordinate(6, 0));
				} catch (InvalidMoveException e) {
					exceptionThrown = true;
				}
				
				// then
			
				equals(exceptionThrown);
			}
	
	
	@Test
	// @Rule(InvalidMoveException.class)
	public void shouldThrowExceptionWhenPieceToIsSameColor() throws InvalidMoveException {
	
		// given
				Board board = new Board();
				board.setPieceAt(Piece.WHITE_KING, new Coordinate(4, 0));
				board.setPieceAt(Piece.WHITE_ROOK, new Coordinate(7, 0));
				
				// when
				BoardManager boardManager = new BoardManager(board);
				try {
					Move move = boardManager.performMove(new Coordinate(4, 0), new Coordinate(7, 0));
				} catch (InvalidMoveException e) {
					exceptionThrown = true;
				}
				
				// then
			
				equals(exceptionThrown);
			}
	
	
	
	

}
