package com.israluci.ch04TicTacToe.ex01;

public class StartGame {

	public static void main(String[] args) {
		UserInterface ui=new UserInterface();
		
		ui.askWhereToPutPiece();
		ui.showBoard();
	}

}
