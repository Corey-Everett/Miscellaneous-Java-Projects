// Name: Corey Everett
// Date: February 13th, 2018
// Program: File IO
// Purpose: To help the Galaxers with their program and election. Reads votes from file, stores in array and outputs. Then, determines which candidate
// won in a system somehow less convoluted than America's; whoever's tally is divisible by 24 evenly. 

// Imports needed utilities
import java.util.Scanner; import java.io.File; import java.io.FileNotFoundException;

public class Lab3FileIOSpring2018 {
	
	public static void main(String[] args) {
		// Makes an array to tally votes and runs a method to tally them, checking for exceptions.
		int[] votes = {0,0,0,0,0};
		try {votes = countVotes(votes);}
		catch (FileNotFoundException e) {System.out.print("File not found!"); System.exit(0);}
		//Prints the amount of votes each candidate has and determines a winner.
		printVotes(votes); getWinner(votes);

	}
	
	public static int[] countVotes(int[] votes) throws FileNotFoundException {
	 // reads in votes from file, tallies them, and returns array
		votes = new int[5]; File f = new File("votes.txt"); Scanner fileInput = new Scanner(f);
		// Checks to see whether the next vote exists, essentially; if it does, parse it and add it to the votes.
		while (fileInput.hasNext()) {
			votes[fileInput.next().charAt(1)-'0']++;
		}
		fileInput.close(); return votes;
	}
	
	public static void printVotes(int[] votes) {
		// Prints the number of votes each candidate has.
		for (int i = 0; i<=4;i++) {
			System.out.println("Candidate " + i + "'s votes: " + votes[i]);
		}
	}
	
	public static void getWinner(int[] results) {
		//This method checks the amount of votes each candidate has. If any are divisible by 24 evenly, it returns the winner!
		for (int i = 0; i<=4;i++) {
			if (results[i] %24 == 0) {
				System.out.print("Candidate " + i+1 + " wins!"); System.exit(0);
			}
		}
	}

}
