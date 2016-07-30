package hw4;

public class R7Q5 {
	
	private double[] array;
	public R7Q5 (double[] input) {
		array = input;
	}
	
	public double[] findData() {
		double minTemp = array[0];
		double maxTemp = array[0];
		for (int i=1;i<array.length;i++) {

			if (maxTemp < array[i]) {maxTemp = array[i];}
			if (minTemp > array[i]) {minTemp = array[i];}
		}	
		double[] data = {maxTemp, minTemp};
		return data;
	}

	

	
}
