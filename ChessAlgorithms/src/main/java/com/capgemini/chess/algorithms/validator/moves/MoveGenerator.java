package com.capgemini.chess.algorithms.validator.moves;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.chess.algorithms.data.Coordinate;

public class MoveGenerator {

	public List<Coordinate> generateKingMoves(Coordinate from) {
		
		List<Coordinate> moves = new ArrayList();
		moves.add(new Coordinate(from.getX(), from.getY()+1));
		moves.add(new Coordinate(from.getX(), from.getY()-1));
		moves.add(new Coordinate(from.getX()-1, from.getY()));
		moves.add(new Coordinate(from.getX()+1, from.getY()));
		moves.add(new Coordinate(from.getX()+1, from.getY()+1));
		moves.add(new Coordinate(from.getX()-1, from.getY()+1));
		moves.add(new Coordinate(from.getX()+1, from.getY()-1));
		moves.add(new Coordinate(from.getX()-1, from.getY()-1));
		
		return moves;
	}
	
	public List<Coordinate> generateBishopMoves(Coordinate from) {
		
		List<Coordinate> moves = new ArrayList();
		moves.add(new Coordinate(from.getX()+1, from.getY()+1));
		moves.add(new Coordinate(from.getX()-1, from.getY()+1));
		moves.add(new Coordinate(from.getX()+1, from.getY()-1));
		moves.add(new Coordinate(from.getX()-1, from.getY()-1));
		
		return moves;
	}
	
	public List<Coordinate> generateKnightMoves(Coordinate from) {
		
		List<Coordinate> moves = new ArrayList();
		moves.add(new Coordinate(from.getX()+1, from.getY()+2));
		moves.add(new Coordinate(from.getX()+1, from.getY()-2));
		moves.add(new Coordinate(from.getX()-1, from.getY()+2));
		moves.add(new Coordinate(from.getX()-1, from.getY()-2));
		moves.add(new Coordinate(from.getX()+2, from.getY()+1));
		moves.add(new Coordinate(from.getX()+2, from.getY()-1));
		moves.add(new Coordinate(from.getX()-2, from.getY()-1));
		moves.add(new Coordinate(from.getX()-2, from.getY()+1));
		
		return moves;
	}
	
	public List<Coordinate> generateRookMoves(Coordinate from) {
		
		List<Coordinate> moves = new ArrayList();
		moves.add(new Coordinate(from.getX(), from.getY()+1));
		moves.add(new Coordinate(from.getX(), from.getY()-1));
		moves.add(new Coordinate(from.getX()-1, from.getY()));
		moves.add(new Coordinate(from.getX()+1, from.getY()));
		
		return moves;
	}
	
	public List<Coordinate> generatePawnMoves(Coordinate from) {
		
		List<Coordinate> moves = new ArrayList();
		moves.add(new Coordinate(from.getX(), from.getY()+1));
		moves.add(new Coordinate(from.getX(), from.getY()+2));
		moves.add(new Coordinate(from.getX(), from.getY()-1));
		moves.add(new Coordinate(from.getX(), from.getY()-2));
		moves.add(new Coordinate(from.getX()+1, from.getY()+1));
		moves.add(new Coordinate(from.getX()+1, from.getY()-1));
		moves.add(new Coordinate(from.getX()-1, from.getY()+1));
		moves.add(new Coordinate(from.getX()-1, from.getY()-1));
		
		return moves;
	}
}
