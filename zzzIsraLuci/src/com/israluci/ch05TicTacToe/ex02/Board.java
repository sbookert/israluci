package com.israluci.ch05TicTacToe.ex02;

public class Board {
	private int row=3,col=3,max=row*col;
	private String[][] board= new String[row][col];
	private String boardBracket=" ";	
	private PieceX pieceX= new PieceX();
	private PieceO pieceO= new PieceO();
	private int locationX=0, locationY=0;
	
	public Board(){
		//initialize board to brackets [ ]
		for (int i=0; i<row;i++)
			for (int j=0; j<col;j++)
				board[i][j]=boardBracket;
	}
	
	public String render(){	
		 String boardUI="";
		 
		// concatenate board to string for display
		for(int i=0; i<row;i++){
			if(i!=0)
				boardUI+="\n";
			for(int j=0; j<col; j++){
				boardUI=boardUI+ "["+board[i][j]+"]";
			}
		}
		return boardUI;	
	}

	/*- should return true if the piece can be placed on a square, then put the piece there
	  - should return false if there is already a piece there or if the square doesn't exist
	  - the top left square is has x=1, y=1, the bottom right square is x=2, y=2 */
	public boolean addPiece(Piece userPiece){
		locationX = userPiece.getX()-1;
		locationY = userPiece.getY()-1;

	    if (userPiece instanceof PieceX)
	    	pieceX = (PieceX)userPiece;
	    else
	    	pieceO = (PieceO)userPiece;
			
		if ((locationX >= row || locationX < 0) || (locationY >= col || locationY < 0)){
			return false;
		}
		else {
			// If location is empty then add piece
			if(board[locationX][locationY].equalsIgnoreCase(boardBracket)){
				addPieceToBoard();				
				return true;
			}else {
				return false;
			}
		}	
	}

	private void addPieceToBoard() {
		if(pieceX.isTurn()){
			board[locationX][locationY]="X";
			pieceX.setPlayer("o");
			Piece.setCount();
		}
		
		if(pieceO.isTurn()){
			 board[locationX][locationY]="O";
			 pieceO.setPlayer("x");
			 Piece.setCount();
		 }
		
	}
	
	public boolean GameOver(int rMove, int cMove){
		 /* _
		 *  _
		 *  _*/
		if(board[0][cMove] == board[1][cMove] && 
		   board[0][cMove] == board[2][cMove])
			return true;
		// _ _ _
		if(board[rMove][0] == board[rMove][1] && 
		   board[rMove][0] == board[rMove][2])
			return true;
		// diagonal
		if(board[0][0] == board[1][1] && 
		   board[0][0] == board[2][2] && 
		   board[1][1] !=" ")
			return true;
		if(board[0][2] == board[1][1] && 
			board[0][2] == board[2][0] && 
			board[1][1] !=" ")
			return true;
		
		if(Piece.getCount() == max)
			return true;
		
		return false;
	}
}
