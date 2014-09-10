package com.israluci.ch04TicTacToe.ex01;

public class Piece {
	private int x;
	private int y;
	private boolean turn;
	private static String p;
	private static int count;
	
	public Piece(){
		x=0;
		y=0;
		turn=false;
		p="X";
		count=0;
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

	public boolean isTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public static String getP() {
		return p;
	}

	public static void setP(String p) {
		Piece.p = p;
	}

	public static int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	public static void setCount(){
		count=count+1;
	}
}
