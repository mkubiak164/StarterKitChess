package com.capgemini.chess.algorithms.implementation;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class CoordinateValidatorTest {
	
	@Test
	// @Rule(InvalidMoveException.class)
	public void shouldThrowExceptionWhenCoordinatesFromAreBigger() {
	
		// given
				BoardManager boardManager = new BoardManager();
				
				// when
				boolean exceptionThrown = false;
				try {
					boardManager.performMove(new Coordinate(8, 16), new Coordinate(7, 6));
				} catch (InvalidMoveException e) {
					exceptionThrown = true;
				}
				
				// then 
				assertTrue(exceptionThrown);
			}
	
	@Test
	// @Rule(InvalidMoveException.class)
	public void shouldThrowExceptionWhenCoordinatesFromAreSmaller() {
	
		// given
				BoardManager boardManager = new BoardManager();
				
				// when
				boolean exceptionThrown = false;
				try {
					boardManager.performMove(new Coordinate(-8, 5), new Coordinate(7, 6));
				} catch (InvalidMoveException e) {
					exceptionThrown = true;
				}
				
				// then 
				assertTrue(exceptionThrown);
			}
	
	@Test
	// @Rule(InvalidMoveException.class)
	public void shouldThrowExceptionWhenCoordinatesToAreBigger() {
	
		// given
				BoardManager boardManager = new BoardManager();
				
				// when
				boolean exceptionThrown = false;
				try {
					boardManager.performMove(new Coordinate(5, 3), new Coordinate(7, 16));
				} catch (InvalidMoveException e) {
					exceptionThrown = true;
				}
				
				// then 
				assertTrue(exceptionThrown);
			}
	
	@Test
	// @Rule(InvalidMoveException.class)
	public void shouldThrowExceptionWhenCoordinatesToAreSmaller() {
	
		// given
				BoardManager boardManager = new BoardManager();
				
				// when
				boolean exceptionThrown = false;
				try {
					boardManager.performMove(new Coordinate(7, 3), new Coordinate(7, -6));
				} catch (InvalidMoveException e) {
					exceptionThrown = true;
				}
				
				// then 
				assertTrue(exceptionThrown);
			}

	

}
