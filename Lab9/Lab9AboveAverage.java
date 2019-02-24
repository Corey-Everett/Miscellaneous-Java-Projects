// Name: Corey Everett
// Date: November 17th, 2017
// Program: Above Average
// Purpose: Gathers values in an array and prints all values above the average.

import java.util.Scanner;

public class Lab9AboveAverage {

	//Instantiates a global scanner, negating the need for multiple ones.
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Instantiates array and average variable, asking for input.
		int[] arr1 = new int[100]; int average;
		System.out.println("Type up to 100 integers for an array, type 0 to end. ");

		// Gathers input
		for (int i = 0; i <=100; i++) {
			System.out.print("Array index " + i + "?: "); arr1[i] = input.nextInt();
			if (arr1[i] == 0) {
				
				//reads array values and outputs the average
				average = readIntoArray(arr1, i+1); System.out.print("Average is " + average +". ");
				
				//Prints the array values that are above average and their index.
				printAboveAverage(arr1, average, i-1);
			}
		}

	}
	public static int readIntoArray(int[] arr1, int arrayLength) {
		int count = 0; int average;
		for (int i = 0; i<=arr1.length-1;i++) {
			count = count+arr1[i];
		}
		average = count/(arrayLength-1);
		return average;
	}
	public static void printAboveAverage(int[] arr1, int average, int count) {
		System.out.println("All values above average shown here:");
		for (int i = 0; i <= count; i++) {
			if (arr1[i] > average) {
				System.out.println("Index " + i + ": " + arr1[i]);
			}
		}
		System.exit(0);
	}

}
