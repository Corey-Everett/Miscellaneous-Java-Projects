// Name: Corey Everett
// Date: October 18th, 2017
// Program: Polygon (Lab 5)
// Purpose: To compute the area, perimeter and interior angle of a regular polygon based on inputs.

import java.util.Scanner;

public class Lab5Polygon {

	public static void main(String[] args) {
		
		System.out.print("Enter number of sides: ");
		int sides = sides();
		System.out.print("Enter side length: ");
		double sideLength = sideLength();
		
		double area = (sideLength*sideLength*sides)/(4.0*(Math.tan(Math.PI/sides)));
		double perimeter = sides*sideLength;
		double interiorAngle = 180.0 - (360.0/sides);
		
		System.out.println("Area: " + area);
		System.out.println("Perimeter: " + perimeter);
		System.out.print("Interior angle: " + interiorAngle + " degrees");
		
	}
	public static int sides() {
		int sides;
		Scanner input = new Scanner(System.in);
		sides = input.nextInt();
		if (sides < 3) {
			System.out.print("Input a valid amount of sides (3 or more): ");
			return sides();
		}
		return sides;
	}
	public static double sideLength() {
		double sideLength;
		Scanner input = new Scanner(System.in);
		sideLength = input.nextDouble();
		if (sideLength <= 0.0) {
			System.out.print("Input a valid side length (greater than 0)");
			return sideLength();
		}
		return sideLength;
	}
}
