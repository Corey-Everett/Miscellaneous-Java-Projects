// Name: Corey Everet
// Date: November 20th, 2017
// Program: Median
// Purpose: Randomly generates five numbers and asks for the median.

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;
public class Lab9Median {
	
	//Instantiates a global scanner for convenience.
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		//Instantiates needed variables, makes an array with no duplicate numbers
		int[] arr = new int[5]; Random rand = new Random(); arr = fillArray(arr, rand); char YorN;
		
		//Asks for median of five randomly generated numbers and gathers user's guess
		System.out.print("What is the median of " + arr[0]+ ", " + arr[1]+ ", " +arr[2]+ ", "+ arr[3]+ " and "+ arr[4] + "? "); int guess = input.nextInt();
		
		// If the quess is the median, says correct! Else incorrect. Asks user if they want to try again.
		if (guess == arr[2]) {System.out.print("Correct! Try again? (y)");}
		else {System.out.print("Incorrect! Try again? (y) ");}
		
		// y to restart program, n or other character to exit program.
		YorN = input.next().charAt(0); if (YorN == 'y') {main(new String[]{"a"});}
		else {System.exit(0);}
		
	}
	public static int[] fillArray(int[] arr, Random rand) {
		int temp;
		//Fills the array. If a duplicate occurs, restart the method.
			for (int i =0; i<=4;i++) {
				temp = rand.nextInt(90)+10;
				if (Arrays.asList(arr).contains(temp)) {
					arr = fillArray(arr, rand);
				}
			arr[i] = temp;
		}
			Arrays.sort(arr);
			
	return arr;
		}
}
