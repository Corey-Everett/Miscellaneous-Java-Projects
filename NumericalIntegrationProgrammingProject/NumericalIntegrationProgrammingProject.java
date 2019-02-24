//Name: Corey Everett
//Date: January 11th, 2018
//Program: Numerical Integration Programming Project
//Purpose: To take any arbitrary 5th degree polynomial over any length and find the total area under the curve using the Midpoint rule, the 
// Trapezoid rule and Simpson's rule to give seperate approximations for a given definite integral. The program should accept limits of integration
// a and b, the number of subintervals n and the coefficients of an arbitrary 5th-degree polynomial, f(x) = Ax5 + Bx4 + Cx3 + Dx2 + Ex + F.
// Program outputs should include values of the approximations of each of the three approximation methods, the exact value of the integral as found
// using the fundamental theorem of calculus and the percent error for each method. 

// Import needed utilities
import java.util.InputMismatchException; import java.util.Scanner;

public class NumericalIntegrationProgrammingProject {
	
	// Instantiate a single scanner to be used for the entire program, in addition to an exception
	public static InputMismatchException e = new InputMismatchException();
	public static final Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		
		System.out.println("Welcome to the Numerical Integration Program! Enter a Fifth-degree polynomial, start/stop values and number of intervals to find the area of a function!");
		
		// Gathers input; The coefficients can be anything
		System.out.print("Enter Ax^5: "); double A = input.nextDouble(); System.out.print("Enter Bx^4: "); double B = input.nextDouble();
		System.out.print("Enter Cx^3: "); double C = input.nextDouble(); System.out.print("Enter Dx^2: "); double D = input.nextDouble();
		System.out.print("Enter Ex: "); double E = input.nextDouble(); System.out.print("Enter F: "); double F = input.nextDouble();
		
		// Gathers input; These coefficients have to be error-checked.
		System.out.print("Input a (start) value of function: "); double a = getA();
		System.out.print("Input b (end) value of function: "); double b = getB();
		System.out.print("Enter number of intervals:"); int n = getN();
		
		//This is literally just numerical integration. Way to confuse me, math! I'm not as hopeless as I thought.
		double fundamental = FundamentalTheorem(A,B,C,D,E,F,b,a); System.out.println("Exact: " + fundamental);
		
		double midpointArea = midpointRule(A,B,C,D,E,F,a,b,n); System.out.println("Midpoint rule area calculation: " + midpointArea);
	    System.out.println("Midpoint Error: " + Math.abs((fundamental-midpointArea)/fundamental*100) + "%.");
		 
	    double trapezoidArea = trapezoidRule(A,B,C,D,E,F,a,b,n); System.out.println("Trapezoidal: " + trapezoidArea);
	    System.out.println("Trapezoidal Error: " + Math.abs((fundamental-trapezoidArea)/fundamental*100) + "%.");
	    
	    double simpsonsRule = (midpointArea*2+trapezoidArea)/3; System.out.println("Simpson's: " + simpsonsRule);
	    System.out.println("Simpson's Error: " + Math.abs((fundamental-simpsonsRule)/fundamental*100) + "%.");

	}
	
	// Shortcut for finding the value of the function at any given x value
	public static double getFunctionValue(double A, double B, double C, double D, double E, double F, double x) {

		return A*Math.pow(x,5)+B*Math.pow(x,4)+C*Math.pow(x,3)+D*Math.pow(x,2)+E*x+F;
	}
	
	// This method calculates the area under the curve via trapezoid rule.
	public static double trapezoidRule(double A, double B, double C, double D, double E, double F, double a, double b, int n) {
		
		double sum = 0.0; double interval = (b-a)/(n*1.0);
		
		while (a <= (b-interval)) {
			sum = sum + (getFunctionValue(A,B,C,D,E,F,a)+getFunctionValue(A,B,C,D,E,F,a+interval))*interval/2.0; a = a+interval;
		}
		return sum;
	}
	
	// This method calculates the area under a curve via the midpoint rule.
	public static double midpointRule(double A, double B, double C, double D, double E, double F, double a, double b, int n) {
		
		double interval = (b-a)/(n*1.0);double sum = 0.0; double i = a + interval/2.0;
		
		while (i <= b) {
			sum = sum + getFunctionValue(A,B,C,D,E,F,i)*interval; i= i+interval;
		}
		return sum;		
	}
	
	// This function takes the integral values of the function, b-a. It's that easy.
	public static double FundamentalTheorem(double A, double B, double C, double D, double E, double F, double b, double a) {
	
	double upper = (A*Math.pow(b, 6)/6.0)+(B*Math.pow(b, 5)/5.0)+(C*Math.pow(b, 4)/4.0)+(D*Math.pow(b, 3)/3.0)+(E*Math.pow(b, 2)/2.0)+F*b;
	double lower = (A*Math.pow(a, 6)/6.0)+(B*Math.pow(a, 5)/5.0)+(C*Math.pow(a, 4)/4.0)+(D*Math.pow(a, 3)/3.0)+(E*Math.pow(a, 2)/2.0)+F*a;
	
	return upper-lower;
		
	}
	public static int getN() {
		
		int n = 0;
		try {
		 n = input.nextInt();
		} catch (InputMismatchException e){
		 System.out.print("Invalid input! Restart program and try again." ); System.exit(0);
		}
		if (n < 1) {System.out.print("Invalid n value! Must be 1 or greater. "); n = getN();}
		return n;
	}
	public static double getA() {
		double a = 0.0;
		try {
		a = input.nextDouble();
		} catch (InputMismatchException e){
		 System.out.print("Invalid input! Restart program and try again." ); System.exit(0);
		}
		return a;
	}
	public static double getB() {
		double b = 0.0;
		try {
		b = input.nextDouble();
		} catch (InputMismatchException e){
			 System.out.print("Invalid input! Restart program and try again." ); System.exit(0);
			}
		return b;
	}

}
