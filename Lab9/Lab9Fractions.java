// Name: Corey Everett
// Date: November 14th, 2017
// Program: Fractions
// Purpose: This program has three methods - subtractFractions(), multiplyFractions(),
// and divideFractions(). The idea is to do the math on each fraction and then return
// then still in fractional form.

import java.util.Scanner;

public class Lab9Fractions {

	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Initialize necessary variables
		int[] arr1 = new int[2]; int[] arr2 = new int[2]; int[] arr3 = new int[2]; char operation;
		
		//Assign values to all variables, error-checking.
		System.out.print("Enter the numerator for the first fraction: "); arr1[0] = input.nextInt();
		System.out.print("Enter the denominator for the first fraction: "); arr1[1] = input.nextInt();
		System.out.print("Enter the numerator for the second fraction: "); arr2[0] = input.nextInt();
		System.out.print("Enter the denominator for the second fraction: "); arr2[1] = input.nextInt();
		System.out.print("Enter the operation (+, -, *, /): "); operation = getOperation();
		
		// If/else statements which determine which function is done to the array. Values stored in arr3.
		if (operation == '+') {arr3 = addFractions(arr1, arr2);}
		if (operation == '-') {arr3 = subtractFractions(arr1, arr2);}
		if (operation == '*') {arr3 = multiplyFractions(arr1, arr2);}
		if (operation == '/') {arr3 = divideFractions(arr1, arr2);}
		
		// arr3 simplified using gcd method
		int gcd = gcd(arr3[0], arr3[1]);
		arr3[0] = arr3[0]/gcd; arr3[1] = arr3[1]/gcd;
		
		//The result of your input is outputted here.
		System.out.print(arr1[0] +"/"+ arr1[1]+ " " + operation + " " + arr2[0] + "/" + arr2[1] + " = " + arr3[0] + "/" + arr3[1]);
		
	}
	public static int gcd(int a, int b) {
		int t = 999;
		  while (b != 0) {
	            t = b;
	            b = a % b;
	            a = t;
	            if (b==0) {return t;}
	        }
	return t;
		
	}
	public static char getOperation() {
		char operation = input.next().charAt(0);
		if (operation == '+'||operation ==  '-'|| operation == '*'||operation == '/') {
			return operation;
		} else {
			operation = getOperation();
		}
		return operation;
	}
	public static int[] subtractFractions(int[] arr1, int[] arr2) {
		
		int[] arr3 = new int[2];
		//subtract code
		arr3[0] = (arr1[0]*arr2[1])-(arr2[0]*arr1[1]);
		arr3[1] = arr1[1]*arr2[1];
		return arr3;
	}
	public static int[] multiplyFractions(int[] arr1, int[] arr2) {
		
		int[] arr3 = new int[2];
		//multiply code
		arr3[0] = arr1[0]*arr2[0];
		arr3[1] = arr1[1]*arr2[1];
		return arr3;
	}
	public static int[] divideFractions(int[] arr1, int[] arr2) {
	
	int[] arr3 = new int[2];
	//divide code
	arr3[0] = arr1[0]*arr2[1];
	arr3[1] = arr1[1]*arr2[0];
	return arr3;
}
	public static int[] addFractions(int[] arr1, int[] arr2) {
		
	int[] arr3 = new int[2];
	//add code
	arr3[0] = (arr1[0]*arr2[1])+(arr2[0]*arr1[1]);
	arr3[1] = arr1[1]*arr2[1];
	return arr3;
}

}
