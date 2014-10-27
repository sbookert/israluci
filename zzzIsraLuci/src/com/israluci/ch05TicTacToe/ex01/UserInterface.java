package com.israluci.ch05TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	private Board grid = new Board();
	private int x=0,y=0,max=3;
	private String turn="";
	private PieceX playerX = new PieceX();
	private PieceO playerO = new PieceO();
	private Piece playerPiece = new Piece();
	private String input;
	private Scanner scanUI = new Scanner(System.in);
	private String[] numberOfSplits=new String[3];
	private boolean on=true,correctPlayer=true,notCorrectFormat;
	private boolean winner=false;
	String player=null;
	String player2=null;
	
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
			playerX.setX(x);
			playerX.setY(y);
			playerX.setTurn(true);
			return playerX;
		}
		
		if(turn.equalsIgnoreCase("O"))
		{
			playerO.setX(x);
			playerO.setY(y);
			playerO.setTurn(true);
			return playerO;
		}
		
		return null;
	
	}

	private void getUserInput() {	
		do{
			/* Check that turn is the opposite of the last turn*/
			System.out.print("Where do you want to place your piece? " );
			System.out.println("(example: 'x on 1,1' or 'exit')");
			input = scanUI.nextLine().trim();
			numberOfSplits=input.split(" ");
			
			turn=numberOfSplits[0];

			if (turn.equalsIgnoreCase(player2))
				break;
			
			player2=turn;
			
			if(turn.equalsIgnoreCase("exit") )
				break;
			
			verifyUserResponseFormat();
			
		}while(notCorrectFormat);	
	}

	private void verifyUserResponseFormat() {
	
		if(numberOfSplits.length==max){			
			/* If it is the correct player then 
			 * check if usr input has the word on
			 * if true then set the row and colmn
			 * */ 
			on=(numberOfSplits[1].equalsIgnoreCase("on"));
			if(on)
				notCorrectFormat=setRowCol(); //returning false will keep getUserInput loop going	

		}else
			notCorrectFormat=true;
	}
		
	private boolean setRowCol() {
		//split location string to get row and col
		String[] pieceLoc=numberOfSplits[2].split(",");

		/* Verify location is composed of x and y
		 * Verify x and y are composed of only digits from 1-3*/
		if(pieceLoc.length==2){
			if(pieceLoc[0].matches("[1-3]")&&pieceLoc[1].matches("[1-3]")){
				x=Integer.parseInt(pieceLoc[0]);
				y=Integer.parseInt(pieceLoc[1]);
				return false;
			}else
				System.out.println("Please enter a valid location.\n");
		}
		return true;
	}

	public void showBoard(){
		
		if(playerX.isTurn()){
			// Adds piece to empty slot
			grid.addPiece(playerX);
			// If game over then display winner and set player as winner
			if(grid.GameOver(x-1, y-1)){
				System.out.println("\nGame Over\n");//Player X is the winner
				winner=true;
			}
			playerX.setTurn(false);
		}
		
		if(playerO.isTurn()){
			// Adds piece to empty slot 
			grid.addPiece(playerO);
			// If game over then display winner and set player as winner
			if(grid.GameOver(x-1, y-1)){
				System.out.println("\nGame Over\n");//Player O is the winner
				winner=true;
			}
			playerO.setTurn(false);
		}
		
		System.out.println(grid.render());
	}
	
	public String enterPlayer(){
		
		System.out.println("What player would you like to be? X or O");
		player=scanUI.nextLine().trim();
		
		return player;
	}
	
	public void exitGame(){
		System.out.println("\nGoodbye.");
	}
}
