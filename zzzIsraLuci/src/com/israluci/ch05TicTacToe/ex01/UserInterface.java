package com.israluci.ch05TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	private Board grid = new Board();
	private int positionX=0,positionY=0,max=3;
	private String turn="";
	private PieceX playerX = new PieceX();
	private PieceO playerO = new PieceO();
	private String input;
	private Scanner scanUI = new Scanner(System.in);
	private String[] numberOfSplits=new String[3];
	private boolean on=true,notCorrectFormat;
	private boolean winner=false;
	String firstPlayer=null;
	String secondPlayer=null;
	
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
			playerX.setX(positionX);
			playerX.setY(positionY);
			playerX.setTurn(true);
			return playerX;
		}
		
		if(turn.equalsIgnoreCase("O"))
		{
			playerO.setX(positionX);
			playerO.setY(positionY);
			playerO.setTurn(true);
			return playerO;
		}
		
		return null;
	
	}

	private void getUserInput() {	
		do{
			System.out.print("Where do you want to place your piece? " );
			System.out.println("(example: 'x on 1,1' or 'exit')");
			input = scanUI.nextLine().trim();
			numberOfSplits=input.split(" ");
			
			turn=numberOfSplits[0];

			/* Check player entered (firstPlayer) with secondPlayer*/
			if (turn.equalsIgnoreCase(secondPlayer)){
				System.out.println("\n"+turn.toUpperCase()+" player played previously.");
				continue;
			}
				//secondPlayer=turn;
			
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
			secondPlayer=turn;
			if(pieceLoc[0].matches("[1-3]")&&pieceLoc[1].matches("[1-3]")){
				positionX=Integer.parseInt(pieceLoc[0]);
				positionY=Integer.parseInt(pieceLoc[1]);
				return false;
			}else
				System.out.println("Make sure you choose locations 1-3.\n");
		}else
			System.out.println("\nLocation should have x and y components.\n");
		
		return true;
	}

	public void showBoard(){
		
		if(playerX.isTurn()){
			// Adds piece to empty slot
			grid.addPiece(playerX);
			// If game over then display winner and set player as winner
			if(grid.GameOver(positionX-1, positionY-1)){
				System.out.println("\nGame Over\n");//Player X is the winner
				winner=true;
			}
			playerX.setTurn(false);
		}
		
		if(playerO.isTurn()){
			// Adds piece to empty slot 
			grid.addPiece(playerO);
			// If game over then display winner and set player as winner
			if(grid.GameOver(positionX-1, positionY-1)){
				System.out.println("\nGame Over\n");//Player O is the winner
				winner=true;
			}
			playerO.setTurn(false);
		}
		System.out.println();
		System.out.println(grid.render());
		System.out.println();
	}
	
	public String enterPlayer(){
		
		System.out.println("What player would you like to be? X or O");
		firstPlayer=scanUI.nextLine().trim();
		
		return firstPlayer;
	}
	
	public void exitGame(){
		System.out.println("\nGoodbye.");
	}

	public boolean validate(String playerType) {
		final String playerX="x", playerO="o";
		boolean correctPlayerType=false;
		correctPlayerType=playerType.equalsIgnoreCase(playerX) || playerType.equalsIgnoreCase(playerO);
		if (!correctPlayerType)
			System.out.println("Please choose either X or O\n");
		return correctPlayerType;
	}
}
