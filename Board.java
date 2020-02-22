import java.util.*;

public class Board {
	int playingSpaces;
	int discardSpaces;
	int[] scoreArray; 
	Hand[] hands;
	
	public static int[][] handMap = {
			{1, 2, 3, 4, 5},
			{6, 7, 8, 9, 10},
			{0, 11, 12, 13, 0},
			{0, 14, 15, 16, 0}
	}; 
	
	/**
	 * Initializes the Board class and the number of hands within each board
	 */
	
	public Board() {
		scoreArray = new int[20]; //used to store cards' values when they're placed and used to calculate each hand's score
		playingSpaces = 16; //Available slots left on the board
		discardSpaces = 4; // Available slots left on the discard pile
		
		//initializes 9 hands to add points for the respective rows and columns since board is in a 4x5 matrix
		hands = new Hand[9];
		int count = 0;
		//initializes each hand such that it includes each slot in the respective rows
		for (int i = 0; i < handMap.length; i++) {
			ArrayList<Integer> handIdx = new ArrayList<Integer>();
			for (int j = 0; j < handMap[i].length; j++) {
				handIdx.add(handMap[i][j]);
			}
			hands[count] = new Hand(this, handIdx);
			count++;
		}
		//initializes each hand such that it includes each slot in the respective columns
		for (int j = 0; j < handMap[0].length; j++) {
			ArrayList<Integer> handIdx = new ArrayList<Integer>();
			for (int i = 0; i < handMap.length; i++) {
				handIdx.add(handMap[i][j]);
			}
			hands[count] = new Hand(this, handIdx);
			count++;
		}
	}
	
	/**
	 * this method calculates the total game points
	 * of each hand and returns a final score
	 */
	public int totalScore() {
		int finalScore = 0;
		for (int i = 0; i < hands.length; i++) {
			finalScore += hands[i].getScore(this);
			System.out.println("Hand score is " + finalScore);
		}
		return finalScore;
	}
		
	/** a 2D-string array of the starting play board which 
	 * shows all the board positions. This will be used
	 * to display the cards after they're placed on the board
	 */
	
	public static String[][] playingBoard = { 
			{"1", "2", "3", "4", "5"},
			{"6", "7", "8", "9", "10"},
			{"0", "11", "12", "13", "0"}, 
			{"0", "14", "15", "16", "0"}
	};
	
	
	//This is the array of discarded cards spots
	public static String[] discards = {"17", "18", "19", "20"};
	
	
	/**
	 *	This replaces the board positions with dealt cards from the deck
	 */
	
	public void replace(int boardPosition, Card newCard) {
		String boardPositionString = Integer.toString(boardPosition);
		if (boardPosition <= 16) {
			for (int i = 0; i < playingBoard.length; i++) {
				for (int j = 0; j < playingBoard[i].length; j++) {
					if (playingBoard[i][j].equals(boardPositionString)) {
						playingBoard[i][j] = newCard.toString();	//if this is the right position, place card on board
					}
				}
			}	
		}
		else {
			discards[boardPosition - 17] = newCard.toString();
		}
		
		scoreArray[boardPosition-1] = newCard.value; //replace index position in score array with card value
		if (boardPosition <= 16) {
			playingSpaces --;	//reduce number of available spaces on playing spaces
		}
		
		discardSpaces --;	//if not, reduce number of spots on discard board instead
	}
	
	/**
	 * This method prints the board and the dealt cards on screen
	 */
	
	public void display() {
		StringBuilder playBoardDisplay = new StringBuilder(50);
		for (int i = 0; i < playingBoard.length; i++) { 
			for (int j = 0; j < playingBoard[i].length; j++) {
				if (playingBoard[i][j].equals("0")) {	//'0' is removed from the playBoard since cards are not placed on those spots
					playBoardDisplay.append("       ");
				}
				
				else if (playingBoard[i][j].length() == 2) {  //adds number of spaces according to card's char length
					playBoardDisplay.append(playingBoard[i][j] + "     "); 
				} 
				
				else if (playingBoard[i][j].length() == 3) {
					playBoardDisplay.append(playingBoard[i][j] + "    ");
				} 
				
				else {
					playBoardDisplay.append(playingBoard[i][j] + "      ");
				}
			}
			playBoardDisplay.append("\n");
		}
		
		System.out.println("Current board: \n ");
		System.out.println(playBoardDisplay);
		System.out.println();
		
		StringBuilder discardDisplay = new StringBuilder();
		for (String element: discards) {
			discardDisplay.append(element + "  |  ");
		}
		
		System.out.println("Discard spots:  |  " + discardDisplay);
		System.out.println();
		
	}

	
}
