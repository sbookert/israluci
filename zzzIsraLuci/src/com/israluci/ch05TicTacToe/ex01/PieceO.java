package com.israluci.ch05TicTacToe.ex01;

public class PieceO extends Piece{
	
	public PieceO(){
		super();
	}
	
	public void setY(int y){
		if(y > 3)
			System.out.println("Y invalid location");
		else
			super.setY(y);
	}
}
