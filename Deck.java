//******************************************
//name: Yuxuan Liu
//UNI: yl3433
//
//******************************************
package hw4;
import java.util.*;


public class Deck {
	
	private Card[] theDeck;
	private int top = 0; // the index of the top of the deck

	
	public Deck(){
		// make a 52 card deck here
		theDeck = new Card[52];
		Card temp;
		int count = 0;
		for (int i=1; i<5; i++) {
			//i indicates the suit
			for (int j=1; j<14; j++) {
				//j indicates the value
				temp = new Card(i,j);
				theDeck[count]=temp;
				count++;
			}
			
		}
	}
	
	public void shuffle(){
		//Use Fisher Yates algorithm to shuffle the cards
	    int index;
	    Card temp;
	    Random random = new Random();
	    for (int i = theDeck.length - 1; i > 0; i--)
	    {
	        index = random.nextInt(i + 1);//Generate a random number
	        if (index != i)//If the number is not its own location 
	        {//Swap them
	        	 temp = theDeck[index];
	        	 theDeck[index] = theDeck[i];
	        	 theDeck[i] = temp;
	        }
	    }
	}
	
	public Card deal(){
		// deal the top card in the deck
		top++;//Once the deal is called, the top card should be the next
		return theDeck[top-1];
	}
	
	public Card[] getCards(){ 
		return theDeck;
	}
	
	// add more methods here if needed
	/*
	public static void main(String[] args) {
		Deck newdeck = new Deck();	
		for (int i=0; i<51; i++) {
			System.out.println(newdeck.getCards()[i]);
		}
	}
		*/
}