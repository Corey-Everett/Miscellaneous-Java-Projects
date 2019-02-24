// Name: Corey Everett
// Date: October 18th, 2017
// Program: Guessing Game (Lab 5)
// Purpose: This program instantiates a random number which the user
// will guess to completion.

import java.util.Scanner;
import java.util.Random;

public class Lab5Guessing {

	public static void main(String[] args) {

		Random random;
		
		// Generate a number between 1 and 100
		boolean debug = false;  // For debugging, set to true;
		if (debug) {
			random = new Random(1L);
		} else {
			random = new Random();
		}
		int target = (Math.abs(random.nextInt()) % 100) + 1;
		
		if (debug) {
			System.out.println(target);			
		}
		
		
		// Create a method that gets a guess and then tells if too high or low.
		// If just right, end program.
		
		Scanner input = new Scanner(System.in);
		getInput(target);

	}
	
	
	public static void getInput(int target) {
		System.out.print("Enter your guess (between 1 and 100): ");
			Scanner input = new Scanner(System.in);
		    int guess = input.nextInt();
		    
		    if (guess > 100 || guess < 1) {
		    	System.out.println("Invalid input! ");
		    	getInput(target);
		    }
		    
			if (guess > target) {
				System.out.println("Too High! ");
				getInput(target);
			}
			if (guess < target) {
				System.out.println("Too Low! ");
				getInput(target);
			}
			if (guess == target) {
				System.out.println("You win!");
				System.exit(0);
			}
	}
}
