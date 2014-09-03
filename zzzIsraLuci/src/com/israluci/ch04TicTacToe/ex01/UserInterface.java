package com.israluci.ch04TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	private Board b = new Board();
	private int x=0,y=0;
	private String turn="";
	private PieceX px = new PieceX();
	private PieceY py = new PieceY();
	private String input;
	private Scanner s = new Scanner(System.in);
	private String[] strNum=new String[3];
	private boolean on=true,pos=true,correctPlayer=true,notCorrectFormat;
	private boolean winner=false;
	
	public Piece askWhereToPutPiece(){
		if(winner)
			return null;
		
		getUserInput();

		if(turn.equalsIgnoreCase("X")){
			px.setX(x);
			px.setY(y);
			px.setTurn(true);
			return px;
		}
		
		if(turn.equalsIgnoreCase("O"))
		{
			py.setX(x);
			py.setY(y);
			py.setTurn(true);
			return py;
		}
		
		return null;
	
	}
	
	private boolean setRowCol() {
		//split location row and col
		String[] pieceLoc=strNum[2].split(",");

		if(pieceLoc.length==2){
			if(pieceLoc[0].matches("[1-3]")&&pieceLoc[1].matches("[1-3]")){
				x=Integer.parseInt(pieceLoc[0]);
				y=Integer.parseInt(pieceLoc[1]);
				return false;
			}
		}
		return true;
	}

	private void getUserInput() {	
		do{
			System.out.println("Where do you want to place your piece? example: x on 1,1 or exit");
			input = s.nextLine().trim();
			strNum=input.split(" ");
			
			turn=strNum[0];
			
			if(turn.equalsIgnoreCase("exit"))
				break;
			
			verifyUserResponseFormat();
			
		}while(notCorrectFormat);		
	}

	private void verifyUserResponseFormat() {
		// TODO Auto-generated method stub
		
		if(strNum.length==3){
			/*checkTurn is false when Piece.getP() matches user input
			 *otherwise if checkTurn is true then user input doesn't match
			 *next move so the loop needs to be triggered again.
			 */
			correctPlayer=(!Piece.getP().equalsIgnoreCase(strNum[0]));
			
			if(!correctPlayer){
				on=(strNum[1].equalsIgnoreCase("on"));
				if(on)
					notCorrectFormat=setRowCol();
				else
					notCorrectFormat=true;	
			}else
				notCorrectFormat=true;
		}else
			notCorrectFormat=true;
		notCorrectFormat=notCorrectFormat;
	}

	public void showBoard(){
		//addPiece returns boolean use it to drive
		// also turn needs to reset or check it is not the same player playing
		if(px.isTurn()){
			// Adds piece to empty slot and displays board
			b.addPiece(px);
			if(b.GameOver(x-1, y-1)){
				System.out.println("Player X is the winner!!");
				winner=true;
			}
			px.setTurn(false);
		}
		
		if(py.isTurn()){
			// Adds piece to empty slot and displays board
			b.addPiece(py);
			if(b.GameOver(x-1, y-1)){
				System.out.println("Player O is the winner!!");
				winner=true;
			}
			py.setTurn(false);
		}
		
		System.out.println(b.render());
	}
}
