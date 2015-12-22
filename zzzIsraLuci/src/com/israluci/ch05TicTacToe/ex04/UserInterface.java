package com.israluci.ch05TicTacToe.ex04;

import java.util.Random;
import java.util.Scanner;

public class UserInterface {
	private Board grid = new Board();
	private int positionX=1,positionY=1,max=3;
	private TicTacToePiece playerX = new TicTacToePiece();
	private TicTacToePiece playerO = new TicTacToePiece();
	private Scanner scanUI = new Scanner(System.in);
	private String[] player_on_xy=new String[3];
	private boolean winner=false,on=true,notCorrectFormat=true,autoPlayer=false, pieceAdded=true;
	private String input="",turn="",previousPlayer=null,answer="No";
	private Random rand = new Random();
	private boolean autoUserNotAdded=false;
	private boolean userNotAdded=false;
	
	
	public Piece askWhereToPutPiece(){
		
		firstTimePlayingPrompt();
		
		// If player already won, then exit the app
		if(winner){
			winnerUserPromt();
			answer = scanUI.nextLine().trim();
			// Reset to start new game.
			if (!answer.equalsIgnoreCase("Yes")){
				return null;
			}else {
				afterWinResetVars();
			}
		}
		
		// getUserInput: verifyUserResponseFormat and setRowCol
		getUserInput();
		return setUserPosition();		
	}
	
	private void afterWinResetVars() {
		winner=false; on=true;notCorrectFormat=true;
		input="";
		turn="";
		previousPlayer=null;
		autoPlayer=false;
		pieceAdded=true;
		grid = new Board();
	    playerX = new TicTacToePiece();
		playerO = new TicTacToePiece();
	}

	private void firstTimePlayingPrompt() {
		if (turn.equalsIgnoreCase("")){
			System.out.println("Let's get this game started!!");
		}		
	}

	private void winnerUserPromt() {
		System.out.println("Winner: " + previousPlayer.toUpperCase() + "player.");
		System.out.print("Would you like to play again? " );
		
	}

	public int randInt(int min, int max) {	
	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
	
	private void automateUser() {
		// Switch players only if piece was added successfully otw don't switch players.
		if(pieceAdded){
			System.out.println("My turn");
			if (turn.equalsIgnoreCase("x"))
				turn="O";
			else
				turn="X";
		}
		positionX=randInt(1,3);
		positionY=randInt(1,3);		
		System.out.println("I choose position: "+positionX+"," + positionY);
	}

	private Piece setUserPosition() {
		//current turn for any player is set to false
		/* We know whose turn it is and
		 * we have verified x and y as valid locations
		 * set the x and y to the appropriate player*/
		if(turn.equalsIgnoreCase("X")){
			playerX.setX(positionX);
			playerX.setY(positionY);
			playerX.setTurn(true);
			playerX.setPlayer("X");
			return playerX;
		}
		
		if(turn.equalsIgnoreCase("O"))
		{
			playerO.setX(positionX);
			playerO.setY(positionY);
			playerO.setPlayer("O");
			playerO.setTurn(true);
			return playerO;
		}

		return null;	
	}

	private void getUserInput() {	
		do{
			if (autoPlayer==true && pieceAdded == false){
				autoUserNotAdded=true;
				//System.out.println("Piece not added by automation.");
			}
			if (autoPlayer==false && pieceAdded == false){
				userNotAdded=true;
				//System.out.println("Piece not added.");
			}
				
			if (autoPlayer==false || userNotAdded==true){
				askPlayerPosition();							
			}
			
			if (autoPlayer==true || autoUserNotAdded==true)
				automateUser();
			
			/* Check player entered turn(firstPlayer) with secondPlayer*/
			if (turn.equalsIgnoreCase(previousPlayer)){
				System.out.println("\n"+turn.toUpperCase()+" player played previously.\n");
				//have user pick another player
				notCorrectFormat=true; 
				continue;
			}
			
			if(turn.equalsIgnoreCase("exit") )
				break;
			
			if (autoPlayer==false || userNotAdded==true){
				verifyUserResponseFormat();				
			}else{
				//turn off the autoplayer, give the user back the game.
				autoPlayer=false;
			}
			
		}while(notCorrectFormat);				
	}

	private void askPlayerPosition() {
		System.out.print("Where do you want to place your piece? " );
		System.out.println("(example: 'x on 1,1' or 'exit')");	
		input = scanUI.nextLine().trim();
		player_on_xy=input.split(" "); 				
		turn=player_on_xy[0];	
	}

	private void verifyUserResponseFormat() {
	
		// if input is not well formatted then loop again
		if(player_on_xy.length==max & validate(turn)){			
			 
			on=(player_on_xy[1].equalsIgnoreCase("on"));
			// check if user input has the word on, if true then set the row and colmn
			// else loop again
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
		int x=Integer.parseInt(pieceLoc[0]);
		int y=Integer.parseInt(pieceLoc[1]);
		
		if( grid.returnPosition(x,y).equals(" ") ){
		/* Verify location is composed of x and y
		 * Verify x and y are composed of only digits from 1-3*/
			if(pieceLoc.length==2){
				if(pieceLoc[0].matches("[1-3]")&&pieceLoc[1].matches("[1-3]")){
					positionX=x;
					positionY=y;
					autoPlayer=true; // don't automate unless the user pieces were added properly
					return false;
				}else
					System.out.println("Make sure you choose locations 1-3.\n");
			}else
				System.out.println("\nPosition should have x and y location.\n");
		}else 
			System.out.println("Location is taken");
		return true;
	}

	public void showBoard(){
		
		if(playerX.isTurn()){
			// Adds piece to empty slot. 
			// If empty location was chosen then set turn to next player.
			if(grid.addPiece(playerX)){
				previousPlayer=turn;
				System.out.println();
				System.out.println(grid.render());
				System.out.println();
				pieceAdded=true;
				playerX.setTurn(false);
			}
			else{
				//Position chosen by player x was already taken
				//if automation doesn't add properly then it will hit this code mult times
				autoPlayer=true;
				pieceAdded=false;				
			}
				
			// If game over then display winner and set player as winner
			if(grid.GameOver(positionX-1, positionY-1)){
				System.out.println("\nGame Over\n");//Player X is the winner
				winner=true;
			}
		}
		
		if(playerO.isTurn()){
			// Adds piece to empty slot
			// If empty location was chosen then set turn to next player.
			if(grid.addPiece(playerO)){
				previousPlayer=turn;
				System.out.println();
				System.out.println(grid.render());
				System.out.println();
				playerO.setTurn(false);
				pieceAdded=true;
			}
			else{
				//Position chosen by player o was already taken
				//if automation doesn't add properly then it will hit this code mult times
				autoPlayer=true;
				pieceAdded=false;				
			}
			
			// If game over then display winner and set player as winner
			if(grid.GameOver(positionX-1, positionY-1)){
				System.out.println("\nGame Over");//Player O is the winner
				winner=true;
			}
			
		}
		
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
