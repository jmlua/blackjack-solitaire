
public class Card {
	Rank rank;
	Suit suit;
	int value;
	
	
	 // Enumerate Suits in the deck
    public static enum Suit {
        CLUBS, DIAMONDS, HEARTS, SPADES
    };
    
    // Enumerate Ranks in the deck
    public static enum Rank {
    	ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
    };
	
    //places the value of each card rank in an array 
    
	public static int[] rankValue = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
	
	public static String[] rankInitial = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
	
	
	public static String[] suitInitial = {"D", "C", "H", "S"};

	
	/**
	 * This initializes the card class with its suit, rank and value
	 */
	
	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
		this.value = rankValue[rank.ordinal()];	
	}
	
	/**
	 * This method returns the card as an initial of its suit and rank
	 */
	
	public String toString() {
		return rankInitial[rank.ordinal()] + suitInitial[suit.ordinal()];
		
	}
	
	
}
