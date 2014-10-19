package com.israluci.ch05TicTacToe.ex01;

public class Piece {
	private int x;
	private int y;
	private boolean turn;
	private String p;
	private static int count;
	
	//Initialize in constructor
	public Piece(){
		x=0;
		y=0;
		turn=false;
		p="X";
		count=0;
	}
	
	//Setters and getters 
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

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(){
		count=count+1;
	}
}
