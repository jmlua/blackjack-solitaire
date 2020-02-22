import java.util.*;

public class BlackjackSolitaire {
	
	int points;
	
	/* 
	 * this method prompts the user for input about the board position to place card in
	 * @return int userPosition
	 */
	
	public int getUserInput() {
		//prompt user to key in board position
		System.out.println("Where do you want to place this card? (Enter a number between 1 to 20): ");
		Scanner userInput = new Scanner(System.in);
		int userPosition  = userInput.nextInt();
//		userInput.close();	
		return userPosition;
	}
	
	/*
	 * this method gets a user input and checks if 
	 * the input is valid, ie between 1 to 20
	 * It also checks if the spot has been filled previously
	 * If user input is valid, it will place the card on the board
	 */
	
	public void placeCard(Board gameBoard, Card newCard) {	
		//check if user input is valid, if not, loop until a valid input is received
		boolean validInput = false;		
		while (validInput == false) {
			//get user input
			int userInputPos = getUserInput();
			
			if ((userInputPos < 1) || (userInputPos > 20)) {
				System.out.println("Please enter a number between 1 to 20 only.");
				continue;
			}
				
			else if (gameBoard.scoreArray[userInputPos - 1] != 0) {
				System.out.println("This position has been filled. Please enter another number.");
				continue;
			}	
			
			gameBoard.replace(userInputPos, newCard);
			validInput = true;				
			}
		
		}
			
	public void exit() {
		System.out.println("The game is completed!");
			}
	
	
	public void play() {
		Deck deck = new Deck();
		deck.shuffle();
		Board board = new Board();
		board.display();
		while (board.playingSpaces > 0) {
			//deal a new card
			Card dealtCard = deck.dealCard();
			//show user dealt card
			System.out.println("Card to play: " + dealtCard.toString());
			//get user input, do necessary checks, place card on board
			placeCard(board, dealtCard); 
			board.display();
			}
		System.out.println("All 16 playing positions have now been filled. \n" + "Scoring will now begin.");
		System.out.println("Your final score is: " + board.totalScore());
		exit();
		}
		
}

