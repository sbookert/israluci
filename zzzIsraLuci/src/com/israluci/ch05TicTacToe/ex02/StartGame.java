package com.israluci.ch05TicTacToe.ex02;


public class StartGame {

	public static void main(String[] args) {
		UserInterface pieceUI=new UserInterface();
		Piece playerPiece=new Piece();
		
		/*Ask user where to add piece: If null is returned it means user entered exit and we stop
		 * otherwise we display the board to show where the piece was added*/
		do{
			playerPiece=pieceUI.askWhereToPutPiece(); 
			if(playerPiece==null)
				break;
			else
				pieceUI.showBoard( );
		}while(playerPiece != null);
		
		pieceUI.exitGame();
	}
}
