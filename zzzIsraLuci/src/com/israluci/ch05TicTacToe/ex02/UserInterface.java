package com.israluci.ch05TicTacToe.ex02;

import java.util.Scanner;

public class UserInterface {
	private Board grid = new Board();
	private int positionX=1,positionY=1,max=3;
	private PieceX playerX = new PieceX();
	private PieceO playerO = new PieceO();
	private Scanner scanUI = new Scanner(System.in);
	private String[] player_on_xy=new String[3];
	private boolean winner=false,on=true,notCorrectFormat;
	private String input="",turn="",previousPlayer=null;
	private boolean automate=false;
	
	public Piece askWhereToPutPiece(){
		if (turn.equalsIgnoreCase(""))
			System.out.println("Let's get this party started!!");
		
		//System.out.println("turn: "+turn + "prev player" + previousPlayer);
		// If player already won, then exit the app
		if(winner)
			return null;
		
		// getUserInput: verifyUserResponseFormat and setRowCol
		if (automate==false)
			getUserInput();
		else
			automateUser();
		/* We know whose turn it is and
		 * we have verified x and y as valid locations
		 * set the x and y to the appropriate player*/
		return setUserPosition();		
	}

	private void automateUser() {
		System.out.println("1.if user is not winning set rand 2. if user is winning then block user");
		automate=false;
	}

	private Piece setUserPosition() {
		//current turn for any player is set to false
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
			player_on_xy=input.split(" "); 
			
			turn=player_on_xy[0];
			
			/* Check player entered turn(firstPlayer) with secondPlayer*/
			if (turn.equalsIgnoreCase(previousPlayer)){
				System.out.println("\n"+turn.toUpperCase()+" player played previously.");
				continue;
			}
			
			if(turn.equalsIgnoreCase("exit") )
				break;
			
			verifyUserResponseFormat();
			
		}while(notCorrectFormat);	
		automate=true;
	}

	private void verifyUserResponseFormat() {
	
		// if input is not well formatted then loop again
		if(player_on_xy.length==max & validate(turn)){			
			 
			on=(player_on_xy[1].equalsIgnoreCase("on"));
			
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
		String[] pieceLoc=player_on_xy[2].split(",");

		/* Verify location is composed of x and y
		 * Verify x and y are composed of only digits from 1-3*/
		if(pieceLoc.length==2){
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
				previousPlayer=turn;
				
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
				previousPlayer=turn;
			
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
