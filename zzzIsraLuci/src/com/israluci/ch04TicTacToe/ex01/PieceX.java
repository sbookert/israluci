package com.israluci.ch04TicTacToe.ex01;

public class PieceX extends Piece{
	private String turn;
	public PieceX(){
		super();
		turn="X";
	}
	
	public void setX(int x){
		if(x > 3)
			System.out.println("X invalid location");
		else
			super.setX(x);
	}

}
