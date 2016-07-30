//******************************************
//name: Yuxuan Liu
//UNI: yl3433
//
//******************************************
package hw4;
import java.util.*;

public class Game {
	
	private Player p;
	private Deck cards;
	int round = 0;//indicate which round the player is in. No more than 2 rounds
	
	
	// you'll probably need some more here
	
	
	public Game(String[] testHand){
		// This constructor is to help test your code
		// use the contents of testHand to
		// make a hand for the player
		// use the following encoding for cards
		// c = clubs
		// d = diamonds
		// h = hearts
		// s = spades
		// 1-13 correspond to ace - king
		// example: s1 = ace of spades
		// example: testhand = {s1, s13, s12, s11, s10} = royal flush
		p = new Player();
		cards = new Deck();
		cards.shuffle();
		
		int tempSuit;
		int tempValue;
		Card tempCard;
		for (int i=0; i<5; i++) {
			if (testHand[i].substring(0,1).equals("c")) {tempSuit = 1;}
			else if (testHand[i].substring(0,1).equals("d")) {tempSuit = 2;}
			else if (testHand[i].substring(0,1).equals("h")) {tempSuit = 3;}
			else {tempSuit = 4;}
			//Now get the value of the card
			tempValue = Integer.parseInt(
					testHand[i].substring(1, testHand[i].length()));
			//Create the card once we have the suit and the value
			tempCard = new Card(tempSuit, tempValue);
			
			p.addCard(tempCard);//add the card into the hand
			p.sortHand();//Sort the cards for later use
			
		}

		
	}
	
	public Game(){
		// This constructor is to actually play a normal game
		p = new Player();
		cards = new Deck();
		cards.shuffle();
		
		//deal the top card of the deck
		for (int i=0; i<5; i++) {
			p.addCard(cards.deal());
		}
		p.sortHand();

		
	}
	
	public void play(){
		// this method should play the game	
		round++;//increment the number of rounds whenever play() is called
		
		String score = checkHand(p.getHand());
		System.out.println("Your score is " + score);
		System.out.println("Your cards in order are");
		for (int i=0; i<5; i++) {
			System.out.println("Card " +(i+1)+ " is: " + p.getHand().get(i));
		}
		
		if (round < 2)//If still at the first round
		{
			
			System.out.println("If you want to change some of the cards, please enter the");
			System.out.println(" indice of them in order, separated by space.");
			System.out.println(" Or if you don't want to change any, just hit Enter");
			Scanner reader = new Scanner(System.in);
			String response = reader.nextLine();
			
			//The following codes are to determine what cards should be discarded
			if (response.length() >=1 ) {
				String[] positions = response.split(" ");
				
				int count = 0;//Use count to determine how many cards need to be drawn
				//from the deck
				for (String pos: positions) {
					int i = Integer.parseInt(pos)-1;
					p.removeCard(p.getHand().get(i));
					count++;
				}
				for (int i=0; i<count; i++) {
					p.addCard(cards.deal());
				}
				p.sortHand();
				
			}
			reader.close();	
			play();
			
		}

		if (round == 2)//round 2 means the end of the game
		{
			System.out.println("Game Over! Hope you enjoyed the game!");
		}
	}	
	
	public String checkHand(ArrayList<Card> hand){
		// this method should take an ArrayList of cards
		// as input and then determine what evaluates to and
		// return that as a String
		Collections.sort(hand);
		//Prioritize the scoring so to avoid overlapped counting
		if (RoyalFlush(hand)) {return "250";}
		else if (StraightFlush(hand)) {return "50";}
		else if (Quadriple(hand)) {return "25";}
		else if (FullHouse(hand)) {return "6";}
		else if (Flush(hand)) {return "5";}
		else if (Straight(hand)) {return "4";}
		else if (Triple(hand)) {return "3";}
		else if (TwoPairs(hand)) {return "2";}
		else if (OnePair(hand)) {return "1";}
		else {return "0";}		
	}
	
	/**
	 * Check royal Flush
	 * @param hand
	 * @return if it's a royal Flush or not
	 */
	public boolean RoyalFlush(ArrayList<Card> hand) {
		//The best possible hand in poker. A 10, jack, queen, king, and ace,
		//all of the same suit. Payout: 250
		boolean royalFlush = true;
		int[] rfTemplate= {1,10,11,12,13};
		
		for (int i=0; i<5; i++) {
			if (i<4 && hand.get(i).getSuit() !=  hand.get(i+1).getSuit()) {
				royalFlush = false;
			}
			if (hand.get(i).getValue() != rfTemplate[i]) {
				royalFlush = false;
			}
		}
		return royalFlush;
	}
	
	/**
	 * Check straight flush
	 * @param hand
	 * @return if it's a straight flush or not
	 */
	public boolean StraightFlush(ArrayList<Card> hand) {
		//A straight and a flush: Five cards with consecutive values of
		//the same suit. Payout: 50
		boolean straightFlush = true;
		for (int i = 0; i<4; i++) {
			if (hand.get(i).getSuit() !=  hand.get(i+1).getSuit()) {
				straightFlush = false;
			}
			if (hand.get(i).getValue() != hand.get(i+1).getValue()-1) {
				straightFlush = false;
			}
		}
		return straightFlush;
	}
	/**
	 * check Four of a kind
	 * @param hand
	 * @return if it's a four of a kind
	 */
	public boolean Quadriple(ArrayList<Card> hand) {
		//Kind—Four cards of the same value, such as four queens. Payout: 25
		int mode = hand.get(2).getValue();
		int count = 0;
		for (int i=0; i<5; i++) {
			if (hand.get(i).getValue() == mode) {count++;}
		}
		if (count == 4) {
			return true;
		} else {return false;}
	}
	/**
	 * Check full house
	 * @param hand
	 * @return if it's a full house
	 */
	public boolean FullHouse(ArrayList<Card> hand) {
		//Three of a kind and a pair, for example three queens and two 5’s.
		//Payout: 6
		int mode = hand.get(2).getValue();
		int count = 0;
		boolean pair = false;
		boolean triple = false;
		for (int i=0; i<5; i++) {
			if (hand.get(i).getValue() == mode) {count++;}
		}
		if (count == 3) {triple = true;}
		if (hand.get(0).getValue() == hand.get(1).getValue() ||
			hand.get(3).getValue() == hand.get(4).getValue()) {
			pair = true;
		}
		
		if (pair && triple) {
			return true;
		} else {return false;}
	}
	/**
	 * check flush
	 * @param hand
	 * @return if it's a flush or not
	 */
	public boolean Flush(ArrayList<Card> hand) {
		//Five cards, not necessarily in order, of the same suit. Payout: 5
		boolean flush = true;
		for (int i=0; i<4; i++) {
			if (hand.get(i).getSuit() != hand.get(i+1).getSuit()) {
				flush = false;}
		}
		return flush;
	}
	
	/**
	 * Check straight
	 * @param hand
	 * @return if it's a straight or not
	 */
	public boolean Straight(ArrayList<Card> hand) {
		//Five cards with consecutive values, not necessarily of the same
		//suit, such as 4, 5, 6, 7, and 8. The ace can either precede a 2 or follow a king.
		//Payout: 4
		boolean straight = true;
		int[] special = {1,10,11,12,13};
		for (int i=0; i<4; i++) {
			if (hand.get(i).getValue() != special[i]) {
				straight = false;}
		}
		if (straight) {return straight;}
		straight = true;
		for (int i=0; i<4; i++) {
			if (hand.get(i).getValue() != hand.get(i+1).getValue()-1) {
				straight = false;}
		}
		return straight;
	}
	/**
	 * Check triple
	 * @param hand
	 * @return if it's a three of a kind
	 */
	public boolean Triple(ArrayList<Card> hand) {
		//Three cards of the same value, for example three queens.
		//Payout: 3
		int count = 0;
		int mode = hand.get(2).getValue();
		for (int i=0; i<4; i++) {
			if (hand.get(i).getValue() == mode) {count++;}
		}
		if (count == 3) {return true;}
		else {return false;}
	}
	/**
	 * Check two pairs
	 * @param hand
	 * @return If it has two pairs
	 */
	public boolean TwoPairs(ArrayList<Card> hand) {
		//Two pairs, for example two queens and two 5’s. Payout: 2
		int count = 0;
		int pair1 = hand.get(1).getValue();
		int pair2 = hand.get(3).getValue();
		for (int i=0; i<5; i++) {
			if (hand.get(i).getValue() == pair1 ||
				hand.get(i).getValue() == pair2) {
				count++;
			}
		}
		if (count == 4) {return true;}
		else {return false;}
	}
	/**
	 * Check one pair
	 * @param hand
	 * @return if it has one pair
	 */
	public boolean OnePair(ArrayList<Card> hand) {
		//Two cards of the same value, for example two queens. Payout: 1
		boolean pair = false;
		for (int i=0; i<4; i++) {
			if (hand.get(i).getValue() == hand.get(i+1).getValue()){
				pair = true;
			}
		}
		return pair;
	}
	// you will likely want many more methods here
	// see discussion in class
}