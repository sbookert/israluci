package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	int x=0,y=0;
	String turn="";

	public Piece askWhereToPutPiece(){
		Scanner s = new Scanner(System.in);
		System.out.println("Where do you want to place your piece? example: x on 1,0 or exit");
		String input = s.nextLine();
		
		String[] strNum=input.split(" ");
		turn=strNum[0];
		
		
		for (String str: strNum)
			System.out.println(str);
		
		String[] loc=strNum[2].split(",");
		x=Integer.parseInt(loc[0]);
		y=Integer.parseInt(loc[1]);

		
		if (input.toLowerCase().equals("exit"))
			return null;		
		return null;
	}
	
	public void showBoard(){
		Board b = new Board();
		PieceX px = new PieceX();
		PieceY py = new PieceY();
		
		px.setX(x);
		px.setY(y);
		
		System.out.println(b.addPiece(px));
		System.out.println(b.render());

	}
}
