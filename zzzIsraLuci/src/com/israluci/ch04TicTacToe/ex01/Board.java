package com.israluci.ch04TicTacToe.ex01;

public class Board {
	int row=3,col=3;
	private String[][] board= new String[row][col];
	private String strBracket="[ ]";
	private int max=board.length;		
	private String turn="[X]";
	
	
	public Board(){
		for (int i=0; i<max;i++)
			for (int j=0; j<max;j++)
				board[i][j]=strBracket;
	}
	
	public String render(){
		String strOut="";
		
		for(int i=0; i<3;i++){
			if(i!=0)
				strOut+="\n";
			for(int j=0; j<3; j++){
			strOut+=board[i][j];
			}
		}
		return strOut;	
	}

	/*
	- should return true if the piece can be placed on a square, then put the piece there
	- should return false if there is already a piece there or if the square doesn't exist
	- the top left square is has x=0, y=0, the bottom right square is x=2, y=2
	*/
	public boolean addPiece(Piece p){
		int x=p.getX()-1;
		int y=p.getY()-1;
	
		if ((x>=max||x<0) || (y>=max||y<0))
			return false;
		else {
			if(board[x][y].equalsIgnoreCase(strBracket)){
				board[x][y]=turn;
				if(turn=="[X]")
					turn="[O]";
				else
					turn="[X]";
				return true;
			}else 
				return false;
		}	
	}

}
