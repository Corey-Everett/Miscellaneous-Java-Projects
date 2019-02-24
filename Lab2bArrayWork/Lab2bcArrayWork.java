//Name: Corey Everett
//Date: February 6th, 2018
//Program: Array Work Part C
//Purpose: This program prints the average of numbers in a two-dimensional array. 

public class Lab2bcArrayWork {

	public static void main(String[] args) {
		
		int[][] values = {{0,1,2},{0,1,2}}; double sum = 0.0;
		
		sum = calculateAverage(values, sum); System.out.print(sum);

	}
	
	public static double calculateAverage(int[][] values, double sum) {
		
		int count = 0;
		for (int i = 0; i<= values.length-1; i++ ) {
			for (int j = 0; j <= values[i].length-1; j++) {
				sum = sum + values[i][j]; count++;
			}
		}
		return sum/count;
	}
	
}
