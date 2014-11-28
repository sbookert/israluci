package com.israluci.ch05TicTacToe.ex01;

import java.util.Scanner;

public class UserInterface {
	private Board grid = new Board();
	private int positionX=1,positionY=1,max=3;
	private String turn="";
	private PieceX playerX = new PieceX();
	private PieceO playerO = new PieceO();
	private String input;
	private Scanner scanUI = new Scanner(System.in);
	private String[] numberOfSplits=new String[3];
	private boolean on=true,notCorrectFormat;
	private boolean winner=false;
	private String firstPlayer=null;
	private String secondPlayer=null;
	
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
			
			if(turn.equalsIgnoreCase("exit") )
				break;
			
			verifyUserResponseFormat();
			
		}while(notCorrectFormat);	
	}

	private void verifyUserResponseFormat() {
	
		// if input is not well formatted then loop again
		if(numberOfSplits.length==max & validate(turn)){			
			 
			on=(numberOfSplits[1].equalsIgnoreCase("on"));
			
			/* check if usr input has the word on
			 * if true then set the row and colmn
			 * else loop again
			 * */
			if(on)
				notCorrectFormat=setRowCol(); //returning false will keep getUserInput loop going	
			else
				notCorrectFormat=true;

		}else
			notCorrectFormat=true;
	}
		
	private boolean setRowCol() {
		//split location string to get row and col
		String[] pieceLoc=numberOfSplits[2].split(",");

		/* Verify location is composed of x and y
		 * Verify x and y are composed of only digits from 1-3*/
		if(pieceLoc.length==2){
			//secondPlayer=turn;
			if(pieceLoc[0].matches("[1-3]")&&pieceLoc[1].matches("[1-3]")){
				positionX=Integer.parseInt(pieceLoc[0]);
				positionY=Integer.parseInt(pieceLoc[1]);
				return false;
			}else
				System.out.println("Make sure you choose locations 1-3.\n");
		}else
			System.out.println("\nPosition should have x and y location.\n");
		
		return true;
	}

	public void showBoard(){
		
		if(playerX.isTurn()){
			// Adds piece to empty slot. 
			// If empty location was chosen then set turn to next player.
			if(grid.addPiece(playerX))
				secondPlayer=turn;
				
			// If game over then display winner and set player as winner
			if(grid.GameOver(positionX-1, positionY-1)){
				System.out.println("\nGame Over\n");//Player X is the winner
				winner=true;
			}
			playerX.setTurn(false);
		}
		
		if(playerO.isTurn()){
			// Adds piece to empty slot
			// If empty location was chosen then set turn to next player.
			if(grid.addPiece(playerO))
				secondPlayer=turn;
			
			// If game over then display winner and set player as winner
			if(grid.GameOver(positionX-1, positionY-1)){
				System.out.println("\nGame Over");//Player O is the winner
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
