package com.israluci.ch05TicTacToe.ex01;

import java.util.Scanner;

public class StartGame {

	public static void main(String[] args) {

		final String player1="x", player2="o";
		UserInterface ui=new UserInterface();
		Piece p=new Piece();
		boolean playerPiece;
		String player=null; 
		Scanner s = new Scanner(System.in);
		
		//Ask user which player they want to be
		do{
			player=ui.enterPlayer();
			playerPiece=player.equalsIgnoreCase(player1) || player.equalsIgnoreCase(player2);
		}while(!playerPiece);
		
		// Set the player who has the next move.
		p.setP(player);
		
		/*Ask user where to add piece: If null is returned it means user entered exit and we stop
		 * otherwise we display the board to show where the piece was added*/
		do{
			p=ui.askWhereToPutPiece();
			if(p==null)
				break;
			else
				ui.showBoard();
		}while(p != null);
		
		ui.exitGame();
		s.close();
	}
}
