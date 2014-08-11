package com.israluci.ch04TicTacToe.ex01;

public class Board {
	int row=3,col=3;
	private String[][] board= new String[row][col];
	private String strBracket=" ";	
	private PieceX px= new PieceX();
	private PieceY py= new PieceY();
	private int locX=0, locY=0;
	
	public Board(){
		//initialize board to brackets [ ]
		for (int i=0; i<row;i++)
			for (int j=0; j<col;j++)
				board[i][j]=strBracket;
	}
	
	public String render(){	
		 String strOut="";
		 
		// concatenate board to string for display
		for(int i=0; i<row;i++){
			if(i!=0)
				strOut+="\n";
			for(int j=0; j<col; j++){
				strOut=strOut+ "["+board[i][j]+"]";
			}
		}
		return strOut;	
	}

	/*- should return true if the piece can be placed on a square, then put the piece there
	  - should return false if there is already a piece there or if the square doesn't exist
	  - the top left square is has x=0, y=0, the bottom right square is x=2, y=2 */
	public boolean addPiece(Piece p){
		locX = p.getX()-1;
		locY = p.getY()-1;

	    if (p instanceof PieceX)
	    	px=(PieceX) p;
	    else
	    	py=(PieceY) p;
			
		if ((locX >= row || locX < 0) || (locY >= col || locY < 0))
			return false;
		else {
			// If location is empty then add piece
			if(board[locX][locY].equalsIgnoreCase(strBracket)){
				addPieceToBoard();
				
				return true;
			}else 
				return false;
		}	
	}

	private void addPieceToBoard() {
		if(px.isTurn()){
			board[locX][locY]="X";
		}
		
		if(py.isTurn()){
			 board[locX][locY]="O";
		 }
		
	}
}
