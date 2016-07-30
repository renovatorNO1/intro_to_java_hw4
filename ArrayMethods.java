package hw4;
import java.util.*;
//******************************************
//
//class: ArrayMethods
//
//name: Yuxuan Liu
//UNI: yl3433
//Practice Exercise E7.2
//******************************************
interface returnValues {
	  public int[] getValues();
}

public class ArrayMethods implements returnValues{
 
  private int[] values;
  private int[] default_values;
  private HashMap<String, String> map = new HashMap<String, String>();


  public ArrayMethods(int[] initialValues){

  // do not alter this method
  
      values = initialValues;
      default_values = initialValues.clone();
      
  }


  public void swapFirstAndLast(){
	  int temp;
	  temp = values[0];//Store the first element into temp
	  values[0] = values[values.length-1];//Change the first element to the last
	  values[values.length-1] = temp;//Change the last element to the first
  }

  public void shiftRight(){

  // your code here: part b
	  int temp = values[values.length-1];//Store the last element into temp
	  //This for loop intends to shift elements to the right by 1 position
	  for (int i=values.length-1;i>0;i--) {
		  values[i] = values[i-1];//move the previous element into the next position
	  }
	  values[0] = temp;//Store the last element into the first position

  }

  public void replaceEven(){

	  for (int i =0;i<values.length;i++){
		  //The if statement tests if the element is even
		  if (values[i]%2==0) {
			  values[i]=0;//replace the element with 0
		  }
	  }

  }

  public void replaceByLarger(){

  
	  int temp = values[0];
	  int temp1;
	  //The following loop compares the elements on both sides and operates on the larger one
	  for (int i =1;i<values.length-1;i++) {
		  if (temp < values[i+1]) {
			  temp = values[i];//store the values[i] into temp for use in next pass
			  values[i] = values[i+1];
		  } else {
			  temp1 = temp;
			  temp = values[i];//store the values[i] into temp for use in next pass
			  values[i] = temp1;
		  }
	  }

  }

  public void removeMiddle(){

  // your code here: part e
	  int currentSize = values.length;
	  
	  if (values.length%2==1){
		  //The following loop removes the middle element if the size of
		  //array is odd. Decrease the size by 1
		  for (int i = (values.length+1)/2; i < currentSize; i++)
		  {
		  values[i - 1] = values[i];
		  }
		  currentSize--;
	  } else {
		  //The following loop removes the middle two elements if the size of
		  //array is even. Decrease the size by 2
		  for (int i = values.length/2+1; i < currentSize; i++)
		  {
		  values[i - 2] = values[i];
		  }
		  currentSize = currentSize - 2;
	  }
	  int[] temp = new int[currentSize];//Create a array of the same size
	  //Insert every eligible element into temp in the same order 
	  for (int j=0;j<currentSize;j++) {
		  temp[j] = values[j];
	  }
	  values = temp;//point the values to the object stored in temp

  }

  public void evenToFront(){
	  int counter = 0;
	  for (int i=0;i<values.length;i++){
		  if (values[i]%2==0){
			  counter++;
			  int temp = values[i];
			  for (int j=i;j>0;j--) {
				  values[j] = values[j-1];
			  }
			  values[0] = temp;	//Store the original number into the first element		  			  
		  }
	  }
	  int[] array = new int[values.length];
	  for (int j = 0; j< counter; j++) {
		  array[j] = values[counter-j-1];
	  }
	  for (int k = counter; k<values.length; k++) {
		  array[k] = values[k];
	  }
	  values = array;

  }

  


  public int getSecondLargest(){

  // what if all the elements are the same
		int maxTemp = values[0];
		//The following loop gives the maximum element
		for (int i=1;i<values.length;i++) {
			if (maxTemp < values[i]) {maxTemp = values[i];}	
		}
		
		int secondMax = values[0];
		//The following loop set secondMax to any value that is smaller than maxTemp
		for (int i=1;i<values.length;i++) {
			if (values[i] < maxTemp) {secondMax = values[i];}	
		}
		
		//The following loop gives the real second maximum of the array
		for (int i=0;i<values.length;i++) {
			if (secondMax < values[i] && values[i]!= maxTemp) {secondMax = values[i];}	
		}
		return secondMax;

  }

  public boolean isSorted(){

  // your code here: part h
	  boolean isSort = true;
	  for (int i=1;i<values.length;i++) {
		  if (values[i] < values[i-1]) { isSort = false;}
		  //When there exists some element that is smaller than its predecessor, then return false
	  }
	  return isSort;

  }

  public boolean closeDuplicates(){

	  boolean found = false;
	  for (int i=1;i<values.length;i++) {
		  if (values[i] == values[i-1]) {
			  
			  found = true;
		  }
	  }
	  return found;
	  

  }

  public boolean anyDuplicates(){

  // your code here: part j
	  boolean found = false;
	  for (int i=0;i<values.length-1;i++) {
		  for (int j = i+1; j<values.length;j++) {
			  if (values[i] == values[j]) {
				  found = true;
			  }
		  }
		 
	  }
	  return found;

  }
  public void setArray() {
	  
	  values = default_values.clone();

  }

  public int[] getValues(){

  // do not alter this method
  
      return values;
  }

   
} // end class


