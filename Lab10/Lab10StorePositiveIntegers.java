// Name: Corey Everett
// Date: November 30th, 2017
// Program: Store Positive Integers
// Purpose: This program reads a bunch of integers in a file and outputs them to another file.

import java.io.*;
import java.util.Scanner;

public class Lab10StorePositiveIntegers {

	//Instantiates scanner
	public static final Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		//Asks for inputs
		System.out.print("Enter input file; "); String inputFile = input.nextLine();
		System.out.print("Enter output file; "); String outputFile = input.nextLine();
		int[] positiveIntegers = new int[50];
		
		try (Scanner file_in = new Scanner(new File(inputFile))) {
			int i=0;
			// If the file's next line has an integer greater than 0, put it in the array
			while (file_in.hasNextLine() && file_in.nextInt() > 0) {
				int nextLine = file_in.nextInt();
				positiveIntegers[i] = nextLine; i++;
			}
		}
		
		catch (FileNotFoundException ex) {
			System.out.println("File " + inputFile + " not found!");
			System.exit(0);
		}
		
		//Prints array to the output file
		try (PrintWriter file_out = new PrintWriter(new File(outputFile))) {
			
			for (int i = 0; i <= 50; i++) {
				file_out.println(positiveIntegers[i]);
			}
			
			
		}
		catch (FileNotFoundException ex) {
			System.out.println("File " + outputFile + " not found!");
			System.exit(0);
		}
		
	}

}
