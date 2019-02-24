// Name: Corey Everett
// Date: November 28th, 2017
// Program: Square Root
// Purpose: To get the square root of a number without using the Math.pow method, rather relying
// on Heron's formula to get the job done. 

import java.text.DecimalFormat;
import java.util.Scanner;

public class Lab10SquareRoot {
 
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Asks for inputs
		System.out.print("Input x (square number):"); double x = input.nextDouble();
		System.out.print("Input initial guess: "); double initial = input.nextDouble();
		System.out.print("Input margin of error: "); double error = input.nextDouble();
		
		//squareRoot method approximates square root using a guess, margin of error and value for the squared number
		double squareRoot = squareRoot(x, initial, error);
		
		DecimalFormat df = new DecimalFormat("#.#####");
		
		//outputs squareroot, rounded to five decimal spaces
		System.out.print("Your answer is " + df.format(squareRoot));

	}
	public static double squareRoot(double x, double guess, double error) {
		
		double squareRoot = (guess+x)/guess; double absolute = absoluteValue(guess, squareRoot);
		
		if (absolute > error) {squareRoot(x, squareRoot, error);}
		else {return squareRoot;}
		
		return squareRoot;
	}
	public static double absoluteValue(double guess, double x) {
		double absoluteValue;
		if (guess < 0) {guess = guess*-1;}
		if (x  < 0) { x = x*-1;}
		if (guess > x) {absoluteValue = guess -x;}
		else { absoluteValue = x - guess;}
		return absoluteValue;
	}

}
