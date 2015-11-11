package com.israluci.ch05TicTacToe.ex03;

public abstract class Piece {
	private int x;
	private int y;
	private boolean turn;
	private String player;
	private static int count;
	
	//Initialize in constructor
	public Piece(){
		x=0;
		y=0;
		turn=false;
		player="";
		count=0;
	}
	
	/**
	* Returns the shape of the piece represented by a character, for example X and O in the case of
	* tic tac toe.
	**/
	abstract public String getShape();;
	
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

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String p) {
		this.player = p;
	}

	public static int getCount() {
		return count;
	}

	public static void setCount(){
		count=count+1;
	}
}
