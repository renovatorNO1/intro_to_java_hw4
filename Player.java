//******************************************
//name: Yuxuan Liu
//UNI: yl3433
//
//******************************************
package hw4;
import java.util.*; 
public class Player {
	
	
	private ArrayList<Card> hand; // the player's cards
	// you will likely need more instance variables
		
	public Player(){		
		// create a player here
		hand = new ArrayList<Card>(5);
	}

	public void addCard(Card c){
		// add the card c to the player's hand
		hand.add(c);
	}

	public void removeCard(Card c){
		// remove the card c from the player's hand
		hand.remove(c);
	}
	
	public void sortHand() {
		//Sort hand
		Collections.sort(hand);
	}
	
	public ArrayList<Card> getHand() {
		return hand;
	}
	// you will likely need more methods here
}
