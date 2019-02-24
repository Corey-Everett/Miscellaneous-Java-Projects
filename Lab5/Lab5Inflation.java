// Name: Corey Everett
// Date: October 18th, 2017
// Program: Inflation (Lab 5)
// Purpose: This program calculates inflation from user input.

import java.util.Scanner;
import java.text.*;

public class Lab5Inflation {

	public static void main(String[] args) {

		// These three functions get the input, checking for errors as they are made.
		System.out.print("Enter the current price of the item: ");
		double currentPrice = getCurrentPrice();
		
		System.out.print("Enter the number of years of interest: ");
		double years = getYears();
		
		System.out.print("Enter the interest as a percentage: ");
		double interest = getInterest();
		
		// This section of code calculates the result from input, formatting to two decimal places
		String finalPrice = getFinalPrice(currentPrice, years, interest);
		
		// This section of code prints out the result from input.
		System.out.print("The cost of your item in " + years + " year(s) will be $" + finalPrice);
		

	}
	public static double getCurrentPrice() {
		Scanner input = new Scanner(System.in);
		double currentPrice = input.nextDouble();
		
		if (currentPrice <= 0.0) {
			System.out.print("Please enter a positive number for price: ");
		    return getCurrentPrice();
		}
		
		return currentPrice;
		
	}
	public static double getYears() {
		Scanner input = new Scanner(System.in);
		double years = input.nextDouble();
		
		if (years <= 0.0) {
			System.out.print("Please enter a positive number for years: ");
		    return getYears();
		}
		return years;
		
	}
	public static double getInterest() {
		Scanner input = new Scanner(System.in);
		double interest = input.nextDouble();
		if (interest <= 0.0) {
			System.out.print("Please enter a positive number for interest: ");
		    return getInterest();
		}
		return interest;
		
	}
	public static String getFinalPrice(double currentPrice, double years, double interest) {
	
		double finalPrice = currentPrice*Math.pow(1+(interest/100.0), years);
		DecimalFormat money = new DecimalFormat("#.00");
		
		return money.format(finalPrice);
	
	}

}
