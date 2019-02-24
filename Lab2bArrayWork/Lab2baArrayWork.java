//Name: Corey Everett
//Date: February 6th, 2018
//Program: Array Work Part A
//Purpose: This program creates an array of numbers and then uses a method to find the largest value.

public class Lab2baArrayWork {

	public static void main(String[] args) {


		int[] values = {0,1,1,2,115,6,8,3,6,4,11};
		
		int largest = getLargest(values); printArray(values);
		
		System.out.print("Largest value is " + largest);

	}
	//Finds largest value with simple array method
	public static int getLargest(int[] values) {
		
		int largest = -90000000;
		
		for (int i = 0; i <= values.length-1; i++) {
			
			if (values[i] > largest) {largest = values[i];}
		}
		
		return largest;
	}
	
	public static void printArray(int[] values) {
		
		for (int i = 0; i <= values.length-1; i++) {System.out.print(values[i] + " ");}
		
	}

}
