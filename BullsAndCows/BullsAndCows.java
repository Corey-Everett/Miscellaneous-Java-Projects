//Name: Corey Everett
//Date: January 16th, 2018
//Program: Bulls and Cows (Lab 1)
//Purpose: This program plays a game - the user has 10 turns to guess a four digit number. The game will provide input each turn as to their guess.

import java.util.Random; import java.util.Scanner;

public class BullsAndCows {
	//Instantiate and declare final variables.
	public static final Random rand = new Random();
	public static final Scanner input = new Scanner(System.in);
	public static final int DIGITS = 4; public static final int TURNS = 10;

		public static String pickNumber() {
			//Simple scanner method.
			System.out.print("Guess your number: "); String guessNumber = input.nextLine();
			if (guessNumber.length() == 4) {
				return guessNumber;
			} else {
				System.out.print("Number must be four characters long!"); guessNumber = pickNumber();
			}
			return guessNumber;
		}

		public static boolean haveDuplicates (String s) {
			// Simple error-checking method.
			char zero, one, two, three; zero = s.charAt(0);one = s.charAt(1);two = s.charAt(2);three = s.charAt(3);	boolean hasDuplicates = false;
			if (zero == one || zero == two || zero == three || one == two || one == three || two == three) {hasDuplicates = true;}
			return hasDuplicates;
		}

		public static String getRandomNumber() {
			// Creates the random number you need to guess
			String numbers = "";
			for (int i = 0; i <=3;i++) { numbers = numbers + rand.nextInt(10);}
			boolean hasDigits = haveDuplicates(numbers); if (hasDigits == true) {numbers = getRandomNumber();} 
			return numbers;
		}
		
		public static void playGame () {
			//Instantiate and declare variables.
			String number = getRandomNumber(); String guessNumber = ""; int bulls = 0; int cows = 0;
			//Run loop until correct answer or 10 turns, whichever comes first.
			for (int i = 0; i <= TURNS-1; i++) {
				System.out.print("Turn " + (i+1) + ". ");guessNumber = pickNumber(); char zero, one, two, three; zero = guessNumber.charAt(0); one = guessNumber.charAt(1); two = guessNumber.charAt(2); three = guessNumber.charAt(3);
				if (guessNumber.equals(number)) {System.out.print("Congratulations! You win!"); System.exit(0) /* replace later */;	}
				else {
					//Count bulls
					for (int j = 0; j <=3; j++) {
					if (guessNumber.charAt(j) == number.charAt(j)) {bulls++;}
					}
					//Count cows
					if (number.charAt(3) == (zero|one|two)) {cows++;}
					if (number.charAt(2) == (zero|one|three)) {cows++;}
					if (number.charAt(1) == (zero|two|three)) {cows++;}
					if (number.charAt(0) == (one|two|three)) {cows++;}
					System.out.print("Cows: " + cows + ".   Bulls: " + bulls + ". "); cows = 0; bulls = 0;
				}
			}
			//Used once loop completes - if the user hasn't guessed the number, the user is informed that they are a loser.
		  System.out.print("The number is " + number + ". You lose!");
		}

		public static void printRules()
		{
			System.out.println("\nGuess the " + DIGITS + " digit number; all digits are unique.\nA cow means right digit, wrong position,\na bull means right digit, right position.\nYou have " + TURNS + " turns.\nGood luck!");
		}

		public static void main (String [] args) {
			printRules();
			playGame();
		}
	}
