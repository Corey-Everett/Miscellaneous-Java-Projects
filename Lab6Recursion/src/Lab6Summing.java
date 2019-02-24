
// Name: Corey Everett
// Date: March 20th, 2018
// Program: Recursive Triangle function
// Purpose: To output a triangle two different ways; Recursively and iteratively.

import java.util.Scanner;

public class Lab6Summing {

	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		
		System.out.print("Enter an integer: ");
		int n = input.nextInt();
		
	//	iterativeSum(n);
		int sum = recursiveSum(n);
		System.out.print(sum);

	}
	public static void iterativeSum(int n) {
		
		
		int sum = 0;
		
		for (int i = 0; i <=n; i++) {
			sum = sum + i;
		}
		System.out.print(sum);
	}
	public static int recursiveSum(int n) {
		
			if (n <= 1) {
			return n;
			}
			return n + recursiveSum(n - 1);
	}

}
