package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	Board b = new Board();
	PieceX px = new PieceX();
	PieceY py = new PieceY();
	int x=0,y=0;
	String turn="";

	public Piece askWhereToPutPiece(){
		Scanner s = new Scanner(System.in);
		String input;
		do {
		System.out.println("Where do you want to place your piece? example: x on 1,0 or exit");
		input = s.nextLine();
		
		String[] strNum=input.split(" ");
		turn=strNum[0];	
		if (turn.equalsIgnoreCase("exit"))
			return null;
		
		for (String str: strNum)
			System.out.println(str);
		
		String[] loc=strNum[2].split(",");
		x=Integer.parseInt(loc[0]);
		y=Integer.parseInt(loc[1]);

		System.out.println(input);
		showBoard();
		}while(!input.toLowerCase().equals("exit"));
	
		return null;
	}
	
	public void showBoard(){

		if(turn.equalsIgnoreCase("x")){
			px.setX(x);
			px.setY(y);
			
			System.out.println(b.addPiece(px));
			System.out.println(b.render());
		}else{
			py.setX(x);
			py.setY(y);
			
			System.out.println(b.addPiece(py));
			//System.out.println(b.render());
		}

	}
}
