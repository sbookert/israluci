package com.israluci.ch05TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	private Board b = new Board();
	private int x=0,y=0,max=3;
	private String turn="";
	private PieceX px = new PieceX();
	private PieceO py = new PieceO();
	private String input;
	private Scanner s = new Scanner(System.in);
	private String[] strNum=new String[3];
	private boolean on=true,correctPlayer=true,notCorrectFormat;
	private boolean winner=false;
	
	public Piece askWhereToPutPiece(){
		// If player already won, then exit the app
		if(winner)
			return null;
		
		// getUserInput: verifyUserResponseFormat and setRowCol
		getUserInput();

		/* We know whose turn it is and
		 * we have verified x and y as valid locations
		 * set the x and y to the appropriate player*/
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

	private void getUserInput() {	
		do{
			System.out.print("Where do you want to place your piece? " );
			System.out.println("(example: 'x on 1,1' or 'exit')");
			input = s.nextLine().trim();
			strNum=input.split(" ");
			
			turn=strNum[0];
			
			if(turn.equalsIgnoreCase("exit"))
				break;
			
			verifyUserResponseFormat();
			
		}while(notCorrectFormat);		
	}

	private void verifyUserResponseFormat() {
	
		if(strNum.length==max){
			/*checkTurn is false when Piece.getP() matches user input
			 *otherwise if checkTurn is true then user input doesn't match
			 *next move so the loop needs to be triggered again.
			 */
			correctPlayer=(!Piece.getP().equalsIgnoreCase(turn));
			
			/* If it is the correct player then 
			 * check if usr input has the word on
			 * if true then set the row and colmn
			 * */
			if(!correctPlayer){
				on=(strNum[1].equalsIgnoreCase("on"));
				if(on)
					notCorrectFormat=setRowCol(); //returning false will keep getUserInput loop going	
			}else
				notCorrectFormat=true;
		}else
			notCorrectFormat=true;
	}
		
	private boolean setRowCol() {
		//split location string to get row and col
		String[] pieceLoc=strNum[2].split(",");

		/* Verify location is composed of x and y
		 * Verify x and y are composed of only digits from 1-3*/
		if(pieceLoc.length==2){
			if(pieceLoc[0].matches("[1-3]")&&pieceLoc[1].matches("[1-3]")){
				x=Integer.parseInt(pieceLoc[0]);
				y=Integer.parseInt(pieceLoc[1]);
				return false;
			}
		}
		return true;
	}

	public void showBoard(){
		
		if(px.isTurn()){
			// Adds piece to empty slot
			b.addPiece(px);
			// If game over then display winner and set player as winner
			if(b.GameOver(x-1, y-1)){
				System.out.println("Game Over");//Player X is the winner
				winner=true;
			}
			px.setTurn(false);
		}
		
		if(py.isTurn()){
			// Adds piece to empty slot 
			b.addPiece(py);
			// If game over then display winner and set player as winner
			if(b.GameOver(x-1, y-1)){
				System.out.println("Game Over");//Player O is the winner
				winner=true;
			}
			py.setTurn(false);
		}
		
		System.out.println(b.render());
	}
}
