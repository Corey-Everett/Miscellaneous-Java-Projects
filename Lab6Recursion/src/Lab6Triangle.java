// Name: Corey Everett
// Date: March 20th, 2018
// Program: Recursive Triangle function
// Purpose: To output a triangle two different ways; Recursively and iteratively.

import java.util.Scanner;

public class Lab6Triangle {
	
public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		

		System.out.print("Input an integer: "); int n = input.nextInt();
		
		interativeTriangle(n);
		recursiveTriangle(n);
		
	}
	
	public static void interativeTriangle(int n) {
		
		for (int i = 0; i <= n; i++) {
			for (int j = n-i; j>= 1; --j) {
				System.out.print("*");
			}
			System.out.println();
		}
		
	}
	
	public static void recursiveTriangle(int n) {
		
		for (int i = 0; i <= n-1; i++) {
		System.out.print("*");	
		}
		System.out.println();
		if (n > 0) {
		recursiveTriangle(n - 1);
		}
	}

}
