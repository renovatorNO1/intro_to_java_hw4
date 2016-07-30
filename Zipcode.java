package hw4;
import java.util.HashMap;

//******************************* //
// Zip code class //
// This is a template for your zip code class 
// You may add methods and instance variables to this 
// class but your code must work with the provided test class ZipTest.java 
// 
//*******************************
public class Zipcode{
  private String zipcode = ""; 
  private String barcode = "";
  

/**
 * zip_toBar converts digit to barcode
 * @param key
 * @return
 */
  public static String zip_toBar(String key) {
	  HashMap<String,String> table = new HashMap<String, String>();
	  table.put("0",  "||:::");
	  table.put("1",  ":::||");
	  table.put("2",  "::|:|");
	  table.put("3",  "::|||");
	  table.put("4",  ":|:::");
	  table.put("5",  ":|:||");
	  table.put("6",  ":||::");
	  table.put("7",  "|::::");
	  table.put("8",  "|::||");
	  table.put("9",  "|:|::");
	  return table.get(key);	  	  
  }
  /**
   * static method bar_toString converts barcode to string
   * @param key
   * @return
   */
  public static String bar_toString (String key) {
	  HashMap<String,String> table = new HashMap<String, String>();
	  table.put("||:::", "0");
	  table.put(":::||", "1");
	  table.put("::|:|", "2");
	  table.put("::|||", "3");
	  table.put(":|:::", "4");
	  table.put(":|:||", "5");
	  table.put(":||::", "6");
	  table.put("|::::", "7");
	  table.put("|::||", "8");
	  table.put("|:|::", "9");
	  return table.get(key);	
  }
  /**
   * when the parameter is an integer, Zipcode generates a corresponding barcode
   * @param zip_number
   */
  public Zipcode(int zip_number){
  // add your own code here to     
  // to complete the constructor
	  if (zip_number / 10000 == 0 || zip_number / 10000 >= 10) {
		  System.out.println("Please enter a legitimate zipcode");
	  } else {
	  zipcode = Integer.toString(zip_number);//convert zip_number to string
	  String[] splitArray = zipcode.split("");//split the zipcode into an array
	  
	  for (int i=0;i<5;i++){
		  barcode += zip_toBar(splitArray[i]);
		  //barcode concatenates as the loop interates each digit
	  }
	  barcode = "|"+ barcode +"|";//add the frame for barcode
	  }
  }
  /**
   * when the param is a string, Zipcode generates a corresponding zipcode
   * @param bar_string
   */
  public Zipcode(String bar_string){
	  barcode = bar_string.substring(1,bar_string.length()-1);
	  //Get the actual barcode by discarding the first and last character
	  for (int i=0;i<bar_string.length()-6;i+=5){
		  zipcode += bar_toString(barcode.substring(i, i+5));
		  //zipcode concatenates the digit as the loop iterates every barcode unit
	  }
  }
  /**
   * return the barcode
   * @return
   */
  public String getBarcode(){

      return barcode;     
  }
  /**
   * return the zipcode
   * @return
   */
  public String getZipcode(){
	  return zipcode;
  }
}