package hw4;

//************************************
//
//ComboTest class
//
//This is a test class for the ComboLock class.
//Your ComboLock class must work with this class.
//Do not alter this class
//
//*************************************

public class ComboTest{

  public static void main(String[] args){
      ComboLock lock = new ComboLock(2, 29, 16);
      lock.reset();
      lock.turnRight(0);
      lock.turnLeft(0);
      lock.turnRight(0);

      if (lock.open()){
          System.out.println("First attempt is a success!");
      }
      else{
          System.out.println("First attempt failed!");
      }
    
      lock.reset();
      lock.turnLeft(0);
      lock.turnRight(38);  
      lock.turnLeft(26); 
      lock.turnLeft(1);
      lock.turnRight(0);lock.turnRight(0);lock.turnRight(0);
      lock.turnRight(13);
      lock.turnRight(0);
      lock.turnRight(0);
      lock.turnRight(0);

     

      if (lock.open()){
          System.out.println("Second attempt is a success!");
      }
      else{
          System.out.println("Second attempt failed!");
      }

  }
}


