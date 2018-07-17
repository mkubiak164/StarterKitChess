package com.capgemini.chess.algorithms.validator;

import java.util.Arrays;
import java.util.List;

import com.capgemini.chess.algorithms.data.Coordinate;
import com.capgemini.chess.algorithms.implementation.exceptions.InvalidMoveException;

public class CoordinateValidator {
	
	final int maxFieldIndex = 7;
	final int minFieldIndex = 0;
	
	public void validateCoordinate(Coordinate coordinate) throws InvalidMoveException {
		
		int x = coordinate.getX();
		int y = coordinate.getY(); 
		
		boolean xIsGreaterThanMinIndex = x >= minFieldIndex;
		boolean xIsSmallerThanMaxIndex = x <= maxFieldIndex;
		boolean yIsGreaterThanMinIndex = y >= minFieldIndex;
		boolean yIsSmallerThanMaxIndex = y <= maxFieldIndex;
		
		List<Boolean> checklist = Arrays.asList(xIsGreaterThanMinIndex, xIsSmallerThanMaxIndex, 
				yIsGreaterThanMinIndex, yIsSmallerThanMaxIndex);
		
		if (checklist.contains(Boolean.FALSE)) {
			throw new InvalidMoveException();
		}
		
	}
	
}
