package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	/*
	 * - this class should print to console: Where do you want to place your piece? (example: 'x on 1,0' or 'exit')
	
	- returns null if user typed exit
	
	 * 
	 * */
	public Piece askWhereToPutPiece(){
		Scanner s = new Scanner(System.in);
		System.out.println("Where do you want to place your piece? \\(example: \'x on 1,0\' or \'exit\'\\)");
		String input = s.nextLine();
		if (input.toLowerCase().equals("exit"))
			return null;		
		return null;
	}
	
	/*
	 * - this class prints the board to the screen for example: 

	[ ][X][ ]
	
	[ ][ ][O]
	
	[ ][ ][ ]
	*
	*/
	public void showBoard(){
		
	}
}
