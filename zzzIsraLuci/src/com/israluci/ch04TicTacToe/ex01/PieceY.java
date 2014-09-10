package com.israluci.ch04TicTacToe.ex01;

public class PieceY extends Piece{
	
	public PieceY(){
		super();
	}
	
	public void setY(int y){
		if(y > 3)
			System.out.println("Y invalid location");
		else
			super.setY(y);
	}
}
