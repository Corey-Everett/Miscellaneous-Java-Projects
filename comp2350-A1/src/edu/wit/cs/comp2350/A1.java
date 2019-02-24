// Name: Corey Everett
// Date: January 17th, 2019
// Program: Algorithms Lab 1 - Counting Sort and Radix Sort
// Purpose: This program will take a given array and return that array, sorted, with many possible sorting algorithms. In particular,
// completion of this lab involves the implementation of Counting Sort and Radix Sort.

package edu.wit.cs.comp2350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Sorts integers from command line using various algorithms 
 * 
 * Wentworth Institute of Technology
 * COMP 2350
 * Assignment 1
 * 
 */

public class A1 {

	// This method will sort the given array by the sorting method "Counting Sort". An array is kept of each possible value, and then that possible value is
	// printed that many times. 
	
	public static int[] countingSort(int[] a) {
		// Create space for final, sorted array.
		// STEP 1: For every occurance of a number in an array, the corresponding space in the "count" array is incremented by 1.
		// STEP 2: Print these numbers, from lowest to highest, into the "final" array.
		int initLength = a.length;
		int max = 524288;
		int[] count = new int[524288];
		
		// For every value in the array, increase the count array by 1 in its corresponding location.
		for (int i = 0; i<=initLength-1; i++) { count[a[i]]++;}
		
		int[] sorted = new int[initLength];
		// Add sorted numbers to sorted array;
		int addPosition = 0;
		for (int k = 0; k<=count.length-1; k++) {
			for (int l = 0; l<=count[k];l++) {
				if (count[k] != 0) {
					sorted[addPosition] = k; addPosition++; --count[k];
				}
			}
		}
		
		
		return sorted;	// return an array with sorted values
	}

	// This method will sort the given array using Radix Sort. This involves checking the place value, but no comparisons, and is one of the oldest
	// sorting methods. UNIMPLEMENTED, for a sorting algorithm can't be wrong if it doesn't exist!
	public static int[] radixSort(int[] a) {
		// Create space for final, sorted array.
		int[] sorted = new int[a.length];
		
		
		return sorted;	// return an array with sorted values
	}

	/********************************************
	 * 
	 * You shouldn't modify anything past here
	 * 
	 ********************************************/

	public final static int MAX_INPUT = 524287;
	public final static int MIN_INPUT = 0;

	// example sorting algorithm
	public static int[] insertionSort(int[] a) {

		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j;
			for (j = i-1; j >= 0 && tmp < a[j]; j--)
				a[j+1] = a[j];
			a[j+1] = tmp;
		}

		return a;
	}

	/* Implementation note: The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy,
	 *  Jon Bentley, and Joshua Bloch. This algorithm offers O(n log(n)) performance on many data 
	 *  sets that cause other quicksorts to degrade to quadratic performance, and is typically 
	 *  faster than traditional (one-pivot) Quicksort implementations. */
	public static int[] systemSort(int[] a) {
		Arrays.sort(a);
		return a;
	}

	// read ints from a Scanner
	// returns an array of the ints read
	private static int[] getInts(Scanner s) {
		ArrayList<Integer> a = new ArrayList<Integer>();

		while (s.hasNextInt()) {
			int i = s.nextInt();
			if ((i <= MAX_INPUT) && (i >= MIN_INPUT))
				a.add(i);
		}

		return toIntArray(a);
	}

	// copies an ArrayList of Integer to an array of int
	private static int[] toIntArray(ArrayList<Integer> a) {
		int[] ret = new int[a.size()];
		for(int i = 0; i < ret.length; i++)
			ret[i] = a.get(i);
		return ret;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.printf("Enter the sorting algorithm to use ([c]ounting, [r]adix, [i]nsertion, or [s]ystem): ");
		char algo = s.next().charAt(0);

		System.out.printf("Enter the integers to sort, followed by a non-integer character: ");
		int[] unsorted_values = getInts(s);
		int[] sorted_values = {};

		s.close();

		switch (algo) {
		case 'c':
			sorted_values = countingSort(unsorted_values);
			break;
		case 'r':
			sorted_values = radixSort(unsorted_values);
			break;
		case 'i':
			sorted_values = insertionSort(unsorted_values);
			break;
		case 's':
			sorted_values = systemSort(unsorted_values);
			break;
		default:
			System.out.println("Invalid sorting algorithm");
			System.exit(0);
			break;
		}

		System.out.println(Arrays.toString(sorted_values));
	}

}
