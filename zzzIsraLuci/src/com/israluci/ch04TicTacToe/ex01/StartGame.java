package com.israluci.ch04TicTacToe.ex01;

public class StartGame {

	public static void main(String[] args) {
		UserInterface ui=new UserInterface();
		Piece p=new Piece();
		
		do{
			p=ui.askWhereToPutPiece();
			ui.showBoard();
		}while(p != null);
	}

}
