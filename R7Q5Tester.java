package hw4;


public class R7Q5Tester {
	public static void main(String[] args){

		double[] a = {-1,2,3,4,5,6,10,3,5,0};
		R7Q5 test1 = new R7Q5(a);
		double[] result = test1.findData();
		double max = result[0];
		double min = result[1];
		System.out.println(max);
		System.out.println(min);
	}

}
