package com.israluci.ch05TicTacToe.ex04;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserInterface {
	private Board grid = new Board();
	private int positionX=1,positionY=1,max=3;
	private TicTacToePiece playerX = new TicTacToePiece();
	private TicTacToePiece playerO = new TicTacToePiece();
	private Scanner readPlayersResponse = new Scanner(System.in);
	private String[] player_on_xy=new String[3];
	private boolean winner=false,on=true,notCorrectFormat=true,autoPlayer=false, pieceAdded=true;
	private String input="",turn="",previousPlayer=null,answer="No",turnHasPlayer="",continuePlaying="Yes";
	private String X="X", O="O";
	private Random rand = new Random();
	private boolean autoUserNotAdded=false;
	private boolean userNotAdded=false;
	private ArrayList<String> result = new ArrayList<String>(10);
	
	public Piece askWhereToPutPiece(){
		
		firstTimePlayingDisplay();
		
		// If player already won, then exit the app
		if(winner){
			winnerUserDisplay();
			answer = readPlayersResponse.nextLine().trim();
			// Reset to start new game.
			if (answer.equalsIgnoreCase(continuePlaying)||answer.equalsIgnoreCase("y")){
				afterWinResetVars();
			}else {
				return null;
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

	private void firstTimePlayingDisplay() {
		if (turn.equalsIgnoreCase(turnHasPlayer)){
			System.out.print("Let's get this game started!!");
		}		
	}

	private void winnerUserDisplay() {
		//result.add(previousPlayer);
		//System.out.println("Winner: " + previousPlayer.toUpperCase() + " player.");
		if (previousPlayer.toUpperCase().equals(X))
			System.out.println("Loser: Player O");
		else
			System.out.println("Loser: Player X");
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
			if (turn.equalsIgnoreCase(X))
				turn=O;
			else
				turn=X;
		}
		//If the automated user can't find a spot, it could take a few tries
		positionX=randInt(1,3);
		positionY=randInt(1,3);		

	}

	private Piece setUserPosition() {
		//current turn for any player is set to false
		/* We know whose turn it is and
		 * we have verified x and y as valid locations
		 * set the x and y to the appropriate player*/
		if(turn.equalsIgnoreCase(X)){
			playerX.setX(positionX);
			playerX.setY(positionY);
			playerX.setTurn(true);
			playerX.setPlayer(X);
			return playerX;
		}
		
		if(turn.equalsIgnoreCase(O))
		{
			playerO.setX(positionX);
			playerO.setY(positionY);
			playerO.setPlayer(O);
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
			
			// Check if current player is not the same as the previous one.
			if (turn.equalsIgnoreCase(previousPlayer)){
				System.out.println();
				System.out.println(turn.toUpperCase()+" player played previously.\n");
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
				//once auto user has played, set flag to false to give regular user a turn.
				autoPlayer=false;
				autoUserNotAdded=false;
			}
			
		}while(notCorrectFormat);				
	}

	private void askPlayerPosition() {
		System.out.println();
		System.out.print("Where do you want to place your piece? " );
		System.out.println("(example: 'x on 1,1' or 'exit')");	
		input = readPlayersResponse.nextLine().trim();
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
			else{
				notCorrectFormat=true;
				System.out.println("Please enter the correct format.");
			}
		}else{
			notCorrectFormat=true;
			System.out.println("\nInvalid format. Please try again.\n");
		}
	}
		
	private boolean setRowCol() {// length, validLocationRange, emptyPosition, 
		//split apart row and col
		String[] pieceLoc=player_on_xy[2].split(",");
		
		// To avoid exceptions:
		// Verify location is composed of 2 numbers, x and y
		// Verify x and y are composed of only digits from 1-3
		// Verify position is empty and not already taken.
		if(pieceLoc.length==2){
			String x=pieceLoc[0];
			String y=pieceLoc[1];		

				if(x.matches("[1-3]")&&y.matches("[1-3]")){
					int numX=Integer.parseInt(x);
					int numY=Integer.parseInt(y);
					
						if( grid.returnPosition(numX,numY).equals(" ") ){
							positionX=numX;
							positionY=numY;
							autoPlayer=true; // don't automate unless the user pieces were added properly
							return false;
						}else 
							System.out.println("Location is taken");
				}else
					System.out.println("Make sure you choose locations 1-3.\n");
			
		}else
			System.out.println("\nPosition should have x and y location.\n");
		return true;
	}

	public void showBoard(){
		//This might could be re-factored using isntanceof
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
				result.add(previousPlayer);
				//System.out.println("Winner: " + previousPlayer.toUpperCase() + " player.");
				for(String s : result)
					System.out.println("Winner: "+s+ " player.");
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
				result.add(previousPlayer);
				//System.out.println("Winner: " + previousPlayer.toUpperCase() + " player.");
				for(String s : result)
					System.out.println("Winner: "+s+ " player.");
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
