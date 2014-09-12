package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class StartGame {

	public static void main(String[] args) {
		UserInterface ui=new UserInterface();
		Piece p=new Piece();
		boolean playerPiece;
		String player;
		Scanner s = new Scanner(System.in);
		
		//Ask user which player they want to be
		do{
			System.out.println("What player would you like to be? X or O");
			player=s.nextLine().trim();
			playerPiece=player.equalsIgnoreCase("x") || player.equalsIgnoreCase("o");
		}while(!playerPiece);
		
		// Set the player who has the next move.
		Piece.setP(player);
		
		/*Ask user where to add piece
		 * If null is returned it means user entered exit so we stop app
		 * otherwise we display the board to show where piece was added*/
		do{
			p=ui.askWhereToPutPiece();
			if(p==null)
				break;
			else
				ui.showBoard();
		}while(p != null);
		
		s.close();
	}
}
