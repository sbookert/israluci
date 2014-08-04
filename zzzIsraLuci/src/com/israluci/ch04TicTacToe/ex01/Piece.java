package com.israluci.ch04TicTacToe.ex01;

public class Piece {
	private int x;
	private int y;
	private String turn;
	
	public Piece(){
		x=0;
		y=0;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	
}
