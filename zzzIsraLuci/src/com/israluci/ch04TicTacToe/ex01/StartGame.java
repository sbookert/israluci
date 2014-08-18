package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class StartGame {

	public static void main(String[] args) {
		UserInterface ui=new UserInterface();
		Piece p=new Piece();
		boolean playerPiece;
		String player;
		Scanner s = new Scanner(System.in);
		
		do{
			System.out.println("What player would you like to be? X or O");
			player=s.nextLine();
			playerPiece=player.equalsIgnoreCase("x") || player.equalsIgnoreCase("o");
		}while(!playerPiece);
		
		Piece.setP(player);
		
		do{
			p=ui.askWhereToPutPiece();
			ui.showBoard();
		}while(p != null);
	}

}
