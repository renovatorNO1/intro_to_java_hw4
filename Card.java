//******************************************
//name: Yuxuan Liu
//UNI: yl3433
//
//******************************************
package hw4;

public class Card implements Comparable<Card>{
	
	private int suit; // use integers 1-4 to encode the suit
	private int value; // use integers 1013 to encode the value
	
	public Card(int s, int v){
		//make a card with suit s and value v
		suit = s;
		value = v;
	}
	
	public int compareTo(Card c){
		// use this method to compare cards so they 
		// may be easily sorted
		int result;
		if (value > c.value) { result = 1;}
		else if (value < c.value) {result = -1;}
		else {
			if (suit > c.suit) {result = 1;}
			else if (suit < c.suit) {result = -1;}
			else {result = 0;}
			}
		return result;
	}
	
	public String toString(){
		// use this method to easily print a Card object
		String description;
		
		description = suit+","+ value; 
		return description; 
	}
	// add some more methods here if needed
	public int getSuit(){

		return suit;
	}
	public int getValue(){

		return value;
	}

}