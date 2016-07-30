package hw4;
/**
 * this class models the combination lock in a gym locker.
 * @author Yuxuan
 *
 */

public class ComboLock {


	private int[] key = new int[3];//key stores the secret combination of the lock
	private int input = 0;//input stores the user input
	private int counter;//counter keep tracks of the order of numbers
	private boolean[] unlocked = {false, false, false};//initialize unlocked as false 

	
	/**
	 * Constructor of ComboLock class
	 * Store the secret combinations into an array
	 * @param secret1
	 * @param secret2
	 * @param secret3
	 */
	public ComboLock(int secret1, int secret2, int secret3){
		this.key[0] = secret1;
		this.key[1] = secret2;
		this.key[2] = secret3;
	}
	/**
	 * reset() clears all the user inputs and set all the instance variables
	 * as in original values.
	 */
	public void reset() {
		this.input = 0;
		this.counter = 0;
		for (int i=0; i<3; i++) {
			this.unlocked[i] = false;//turn every entry of unlocked false
		}
		
	}
	/**
	 * turnLeft() mimics the effect of turning the lock knob counterclockwise
	 * by a given number of ticks 
	 * @param ticks
	 */
	public void turnLeft(int ticks) {
				
		this.input= (this.input + ticks)%40;
		// turnleft is equivalent to increasing the input and takes its modulo
		if (this.input == this.key[this.counter]) {
			this.unlocked[this.counter] = true;
			if (this.counter <2){
				this.counter++;//Prevent counter to be out of scope of key array
				}
		}
	}
	/**
	 * turnRight() mimics the effect of turning the lock knob clockwise
	 * by a given number of ticks 
	 * @param ticks
	 */
	public void turnRight(int ticks) {
		
		
		this.input = ((this.input - ticks)%40+40)%40;
		// turnleft is equivalent to decreasing the input and take its modulo 
		if (this.input == this.key[this.counter]) {
			this.unlocked[this.counter] = true;
			if (this.counter < 2){
			this.counter++;//Prevent counter to be out of scope of key array
			}
		}
	}
	/**
	 * open returns the state of the lock
	 * @return
	 */
	public boolean open() {			
		return this.unlocked[2];
	}
	

}
