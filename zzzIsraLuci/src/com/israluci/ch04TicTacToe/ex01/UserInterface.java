package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	private Board b = new Board();
	private int x=0,y=0;
	private String turn="";
	private PieceX px = new PieceX();
	private PieceY py = new PieceY();
	private String input;
	private Scanner s = new Scanner(System.in);
	private String[] strNum=null;
	
	public Piece askWhereToPutPiece(){
		
		getInput();
		
		if (turn.equalsIgnoreCase("exit"))
			return null;
		
		splitRowCol();

		if(turn.equalsIgnoreCase("X")){
			px.setX(x);
			px.setY(y);
			px.setTurn(true);
			return px;
		}
		
		if(turn.equalsIgnoreCase("O"))
		{
			py.setX(x);
			py.setY(y);
			py.setTurn(true);
			return py;
		}
		
		return null;
	
	}
	
	// Add verification for x and y to be > 0
	private void splitRowCol() {
		//split location row and col
		String[] pieceLoc=strNum[2].split(",");
		x=Integer.parseInt(pieceLoc[0]);
		y=Integer.parseInt(pieceLoc[1]);
		
	}

	private void getInput() {
		boolean condition=false;
		
		do{
			System.out.println("Where do you want to place your piece? example: x on 1,0 or exit");
			input = s.nextLine();
			//split input on spaces and set turn
			strNum=input.split(" ");		
			condition = ( strNum.length == 3) && (!Piece.getP().equalsIgnoreCase(strNum[0]));
			turn=strNum[0];
		}while ( condition);
		
	}

	public void showBoard(){
		//addPiece returns boolean use it to drive
		// also turn needs to reset or check it is not the same player playing
		if(px.isTurn()){
			// Adds piece to empty slot and displays board
			b.addPiece(px);
			px.setTurn(false);
		}
		
		if(py.isTurn()){
			// Adds piece to empty slot and displays board
			b.addPiece(py);
			py.setTurn(false);
		}
		
		System.out.println(b.render());
	}
}
