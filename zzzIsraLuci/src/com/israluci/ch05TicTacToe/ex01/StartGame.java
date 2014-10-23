package com.israluci.ch05TicTacToe.ex01;


public class StartGame {

	public static void main(String[] args) {

		final String playerX="x", playerO="o";
		UserInterface pieceUI=new UserInterface();
		Piece playerPiece=new Piece();
		boolean correctPlayerType=false;
		String playerType=""; 
		
		//Ask user which player they want to be
		do{
			playerType=pieceUI.enterPlayer();
			correctPlayerType=playerType.equalsIgnoreCase(playerX) || playerType.equalsIgnoreCase(playerO);
		}while(!correctPlayerType);
		
		// Set the player who has the next move.
		playerPiece.setPlayer(playerType); //Bad - This is being overwritten
		
		/*Ask user where to add piece: If null is returned it means user entered exit and we stop
		 * otherwise we display the board to show where the piece was added*/
		do{
			playerPiece=pieceUI.askWhereToPutPiece(); //Bad - This is overwriting playerPiece
			if(playerPiece==null)
				break;
			else
				pieceUI.showBoard();
		}while(playerPiece != null);
		
		pieceUI.exitGame();
	}
}
