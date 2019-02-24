//Name: Corey Everett
//Date: January 23rd, 2018
//Program: Prime Loops
//Purpose: Input a number and this program will tell you if it's prime.

import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab2PrimeLoopsSpring2018 {

	//Instantiates an exception and one single scanner for the entire program.
	public static InputMismatchException e = new InputMismatchException();
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Gathers initial inputs for part 1 of program. gatherNumber method handles an exception if data mismatch occurs.
		System.out.print("Input your number: "); int number = gatherNumber(); number = checkLower(number); boolean isPrime = checkPrime(number);
		
		//Checks to see whether number is prime using isPrime method
		if (isPrime == true) {System.out.println("Your number is prime! ");} 
		if (isPrime == false) {System.out.println("Your number is not prime. ");}
		
		//Gathers inputs for part 2 of program 
		System.out.println("Now, input an upper and lower value and the program will output any numbers between them that are prime.");
		System.out.print("Lower: "); int lower = gatherNumber(); lower = checkLower(lower);
		System.out.print("Upper: "); int upper = gatherNumber(); upper = checkUpper(upper, lower);
		
		//Once potential bugs are sorted out, checks all values between lower and upper with checkPrime method and prints when isPrime = true.
		for (int i = lower; i <=upper; i++) {
			if (checkPrime(i) == true) {
				System.out.print(i + " ");
			}
		}
		
	}
	public static int gatherNumber() {
		
		int number = 0;
		
		//This section of code gets a numeric value and catches a mismatch error. Given more time, I would try to have it get a new value 
		//but it kept printing the error message endlessly. For now, it simply exits the program.
		try {
			 number = input.nextInt();
		} catch (InputMismatchException e ) {
			System.out.print("Invalid input!"); System.exit(0);
		}
		
		return number;
	}
	//Error-checking method - if value is lower than 0, gets new input.
	public static int checkLower(int lower) {
		if (lower > 0) {
			return lower;
		} else {
			System.out.print("Number must be greater than 0! Try again: "); lower = gatherNumber(); lower = checkLower(lower);
		}
		return lower;
	}
	//Error-checking method - if value is lower than lower value, gets new input.
	public static int checkUpper(int upper, int lower) {
		
		if (upper > lower) {
			return upper;
		} else {
			System.out.print("Upper value must be greater than lower value! Try again: "); upper = gatherNumber(); upper = checkUpper(upper, lower);
		}
		return upper;
	}
	
	// This method checks to see whether a given integer is prime.
	public static boolean checkPrime(int number) {
		
		int i = 2;
		while (number > i) {
			if (number % i == 0) {return false;}
			i++;
		}
		return true;
	}
		
}
