package hw4;

public class ArrayMethodsTester {
	public static void main (String[] args) {	
	int[] array = {10,2,4,4,5,6,7,8,10,1};
	ArrayMethods values = new ArrayMethods(array);

	boolean a = values.anyDuplicates();
	System.out.println(a);
	
	boolean b = values.closeDuplicates();
	System.out.println(b);
	
	boolean c = values.isSorted();
	System.out.println(c);
	
	int d = values.getSecondLargest();
	System.out.println("Second Largest number is "+d);
	
	System.out.println("The following is the result of shiftRight");
	values.shiftRight();
	for(int j: values.getValues()) {
		System.out.print(j+",");
	}
	System.out.println();
	
	System.out.println("The following is the result of eventoFront");
	values.setArray();
	values.evenToFront();
	
	for(int j: values.getValues()) {
		System.out.print(j+",");
	}
	System.out.println();
	
	System.out.println("The following is the result of swapFirstAndLast");
	values.setArray();
	values.swapFirstAndLast();
	
	for(int j: values.getValues()) {
		System.out.print(j+",");
	}
	System.out.println();
	values.setArray();
	
	System.out.println("The following is the result of removeMiddle");
	values.removeMiddle();
	for(int j: values.getValues()) {
		System.out.print(j+",");
	}
	System.out.println();
	
	System.out.println("The following is the result of replaceEven");
	values.setArray();
	values.replaceEven();
	for(int j: values.getValues()) {
		System.out.print(j+",");
	}
	System.out.println();
	
	System.out.println("The following is the result of replaceByLarger");
	values.setArray();
	values.replaceByLarger();
	for(int j: values.getValues()) {
		System.out.print(j+",");
	}
	System.out.println();
	
	
	
	
	
	
	
	}
}
