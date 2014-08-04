package com.israluci.ch04TicTacToe.ex01;

public class StartGame {

	public static void main(String[] args) {
		
		Board b = new Board();
		PieceX px = new PieceX();
		PieceY py = new PieceY();
		
		px.setX(1);
		px.setY(3);
		
		System.out.println(b.addPiece(px));
		System.out.println(b.render());
		
		px.setX(3);
		px.setY(1);
		
		System.out.println(b.addPiece(px));
		System.out.println(b.render());
	}

}
