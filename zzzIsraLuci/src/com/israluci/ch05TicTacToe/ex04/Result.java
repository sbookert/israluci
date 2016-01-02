package com.israluci.ch05TicTacToe.ex04;

public class Result {
	private String winner;
	private String loser;
	private int draw;
	
	public Result(){
		winner="";
		loser="";
		draw=0;
	}
	public String getWinner() {
		return winner;
	}
	public void setWinner(String winner) {
		this.winner = winner;
	}
	public String getLoser() {
		return loser;
	}
	public void setLoser(String loser) {
		this.loser = loser;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw() {
		this.draw = draw+1;
	}
	
	
}
