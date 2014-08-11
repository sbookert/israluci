package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	Board b = new Board();
	int x=0,y=0;
	String turn="";
	PieceX px = new PieceX();
	PieceY py = new PieceY();

	public Piece askWhereToPutPiece(){
		Scanner s = new Scanner(System.in);
		String input;
		
		System.out.println("Where do you want to place your piece? example: x on 1,0 or exit");
		input = s.nextLine();
		
		//split input on spaces and set turn
		String[] strNum=input.split(" ");
		turn=strNum[0];
		
		if (turn.equalsIgnoreCase("exit"))
			return null;
		
		//debug: input was split on spaces, display content
		for (String str: strNum)
			System.out.println(str);
		
		//split location row and col
		String[] pieceLoc=strNum[2].split(",");
		x=Integer.parseInt(pieceLoc[0]);
		y=Integer.parseInt(pieceLoc[1]);
		
		//debug: Display piece location entered
		System.out.println(input);

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
	
	public void showBoard(){
		//addPiece returns boolean use it to drive
		// also turn needs to reset or check it is not the same player playing
		if(px.isTurn()){
			// Adds piece to empty slot and displays board
			System.out.println(b.addPiece(px));
			System.out.println("px turn");
		}
		
		if(py.isTurn()){
			// Adds piece to empty slot and displays board
			System.out.println(b.addPiece(py));
			System.out.println("py turn");
		}
		
		System.out.println(b.render());
	}
}
