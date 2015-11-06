package com.israluci.ch05TicTacToe.ex03;

public class GameController {
	private UserInterface pieceUI=new UserInterface();
	private Piece playerPiece=new TicTacToePiece();
	
	public void start(){
		doNext();	
		end();
	};

	private void end(){
		pieceUI.exitGame();		
	};
	
	private void doNext(){
		//Ask user where to add piece: If null is returned it means user entered exit and we stop
		//otherwise we display the board to show where the piece was added
		do{
			playerPiece=pieceUI.askWhereToPutPiece(); 
			if(playerPiece==null)
				break;
			else
				pieceUI.showBoard( );
		}while(playerPiece != null);		
	};

}