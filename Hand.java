import java.util.ArrayList;

public class Hand {
	int handSize;
	ArrayList<Integer> handIdx;
	
	/**
	 * this initializes the Hand class and also calculates 
	 * the points of each hand of cards
	 */

	Hand(Board board, ArrayList<Integer> handIdx) {
		//removes zeros from arrayList because they don't contain any value
		this.handIdx = handIdx;
		this.handIdx.removeIf(idx -> idx.equals(0));
		this.handSize = this.handIdx.size();
	
	}
	
	/**
	 * This method adds the points from each card in a hand
	 * and converts them to game points. 
	 */

	public int getScore(Board board) {
		int handPoints = 0;
		int ace = 0;
		int totalScore = 0;
		for (int idx : handIdx) {
			handPoints += board.scoreArray[idx-1]; 
			if (board.scoreArray[idx-1] == 1) {
				ace ++;
			}
		}
		//if you have an Ace (or more) but handPoints are still < 11
		if ((ace > 0) && (handPoints <= 11)) {
			handPoints += 10;
		}
		if (handPoints >= 22) {
			totalScore = 0;
		}
		
		if ((handPoints == 21) && (handSize == 2)) {
				totalScore = 10;				
			}
		
		if ((handPoints == 21) && (handSize > 2)) {
			totalScore = 7;				
		}
		
		if (handPoints == 20) {
			totalScore = 5;
		}
		if (handPoints == 19) {
			totalScore = 4;
		}
		if (handPoints == 18) {
			totalScore = 3;
		}
		if (handPoints == 17) {
			totalScore = 2;
		}
		if (handPoints <= 16) {
			totalScore = 1;
		}
		return totalScore;
	}


}