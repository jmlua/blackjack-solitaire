import java.util.*;

public class Deck {
	Card[] deck;
	int cardsLeft;

	/**
	 * This initializes the deck with 52 cards in suit and rank order
	 */
	
	public Deck() {
		deck = new Card[52];
		int index = 0;
		for (Card.Suit s: Card.Suit.values()) {
			for (Card.Rank r: Card.Rank.values()) {
				deck[index] = new Card(s,r);
				index++;
			}
		}
		cardsLeft = deck.length;

	}
	
	/**
	 * This method shuffles the deck of cards by swapping random cards around
	 */

	public void shuffle() {
		for (int i = 0; i < deck.length; i++) {
			Random random = new Random();
			int randomIndex = random.nextInt(deck.length);
			Card temp = deck[randomIndex];
			deck[randomIndex] = deck[i];
			deck[i] = temp;
		}
	}
	
	
	/** 
	 * This method deals a single card from the 
	 * top of the deck each time
	 */
	public Card dealCard() {
		Card dealtCard = deck[cardsLeft-1];
		cardsLeft --;
		return dealtCard;
	}
	

}
