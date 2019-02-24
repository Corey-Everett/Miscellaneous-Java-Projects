// Name: Corey Everett
// Date: February 6th, 2019
// Program: Algorithms Lab 3 - QuickSort and RandQuickSort
// Purpose: This program will implement the two sorting algorithms,
// QuickSort and randQuickSort.

package edu.wit.cs.comp2350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

/* Sorts geographic points in place in an array
 * by surface distance to a specific point 
 * 
 * Wentworth Institute of Technology
 * COMP 2350
 * Assignment 3
 * 
 */

public class A3 {

	// This method is designed to sort all the distances via QuickSort. It does this through several steps. The general idea is as follows.
		// QUICKSORT(A,p,r)
		// if p <r
		// 	q = PARTITION(A,p,r)
		// 	QUICKSORT(A, p, q-1)
		// 	QUCIKSORT(A, q+1, r)
	
	// Partition is it's own method, and the idea behind that is explained in the appropriate method.
	// Credit goes to the class-approved textbook for the concept, page 171.
	
	public static void quickSort(Coord[] destinations) {
		// "Meta-quicksort" which runs quicksort below. Overloaded methods for the win!
		quickSort(destinations, 0, destinations.length-1);
	}
	
	public static void quickSort(Coord[] destinations, int startIndex, int endIndex) {
		
		// Quicksort method based on textbook implementation, page 171.
		// This section of code sets up array. Since we're checking distance of each set of destinations, those are the numbers we will be comparing.
		// If the array has a length longer than one, partition it.
		if (startIndex < endIndex) {
			
			int pivot = partition(destinations, startIndex, endIndex);
			// Run two calls of Quicksort on the subarrays
			quickSort(destinations, startIndex, pivot);
			quickSort(destinations, pivot+1, endIndex);
			
		} // end quicksort loop
	} // End method
	
	
	// This method will make up the bulk of Quicksort's "Heavy lifting".
	
		// PARTITION(A, p, r)
		// x = A[r]
		// i = p-1
		// for j = p to r -1
			// if A[j] <= x
				// i++
				// Exchange A[i] with A[j]
		// exchange A[i + 1] with A[r]
		// return i + 1
	public static int partition(Coord[] destinations, int start, int end) {
		
		// To partition the array, we need a pivot value.
		int pivotIndex = start;
		double pivotValue = destinations[start].getDist();
		
		// Initiate for loop
		for (int i = start; i <= end; i++) {
			
			// If the value is smaller than the pivotValue, swap the value with the value 1 place in front of it (if needed) and swap
			// the pivot value with the value one place in front of it. Increase the pivotIndex by 1.
			if (destinations[i].getDist() < pivotValue) {
				
				if (i != pivotIndex +1) {
					//swap pivotIndex+1 and current i index
					Coord tempCoord = destinations[pivotIndex+1];
					destinations[pivotIndex+1] = destinations[i];
					destinations[i] = tempCoord;
				}
				// swap pivotIndex and pivotIndex+1
				Coord tempCoord = destinations[pivotIndex];
				destinations[pivotIndex] = destinations[pivotIndex+1];
				destinations[pivotIndex+1] = tempCoord;
				pivotIndex++;
				
			}
		}
		// Returns needed index.
		return pivotIndex;
	}
	
	// This method is designed to emulate the previous method, except with random inputs for the "pivots". This part of the 
	// lab appears to only differ on one count; 
	public static void randQuickSort(Coord[] destinations) {
		randQuickSort(destinations, 0, destinations.length-1);
	}
	public static void randQuickSort(Coord[] destinations, int startIndex, int endIndex) {
		// All in all, a similar method to before. 
		if (startIndex < endIndex) {
			
			int pivot = randPartition(destinations, startIndex, endIndex);
			// Run two calls of Quicksort on the subarrays
			quickSort(destinations, startIndex, pivot);
			quickSort(destinations, pivot+1, endIndex);
			
		}
	}
	public static int randPartition(Coord[] destinations, int start, int end) {
		
	// To partition the array, we need a pivot value. This value is chosen randomly; a random integer between start and end.
	// The only place this differs from the method "partition" from the first part.
		Random rand = new Random();
		// Gets the pivot-index
		int pivotIndex = rand.nextInt(end) - start;
		double pivotValue = destinations[pivotIndex].getDist();
		
		// This part swaps the pivot with the Coord with the start of the index, as the original only works when the pivotIndex starts
		// at start and programmers are lazy.
		
		Coord tempCoord = destinations[start];
		destinations[start] = destinations[pivotIndex];
		destinations[pivotIndex] = tempCoord;
		pivotIndex = start;
				
		for (int i = start; i <= end; i++) {
					
			if (destinations[i].getDist() < pivotValue) {
						
				if (i != pivotIndex +1) {
							
					tempCoord = destinations[pivotIndex+1];
					destinations[pivotIndex+1] = destinations[i];
					destinations[i] = tempCoord;
				}
						
					tempCoord = destinations[pivotIndex];
					destinations[pivotIndex] = destinations[pivotIndex+1];
					destinations[pivotIndex+1] = tempCoord;
					pivotIndex++;
						
				}
			}
			
		return pivotIndex;
	}


	/********************************************
	 * 
	 * You shouldn't modify anything past here
	 * 
	 ********************************************/

	// Call system sort with a lambda expression on the comparator
	public static void systemSort(Coord[] destinations) {
		Arrays.sort(destinations, (a, b) -> Double.compare(a.getDist(), b.getDist()));
	}

	// Insertion sort eventually sorts an array
	public static void insertionSort(Coord[] a) {

		for (int i = 1; i < a.length; i++) {
			Coord tmpC = a[i];
			int j;
			for (j = i-1; j >= 0 && tmpC.getDist() < a[j].getDist(); j--)
				a[j+1] = a[j];
			a[j+1] = tmpC;
		}
	}

	private static Coord getOrigin(Scanner s) {
		double lat = s.nextDouble();
		double lon = s.nextDouble();

		Coord ret = new Coord(lat, lon);
		return ret;
	}

	private static Coord[] getDests(Scanner s, Coord start) {
		ArrayList<Coord> a = new ArrayList<>();

		while (s.hasNextDouble()) {
			a.add(new Coord(s.nextDouble(), s.nextDouble(), start));
		}

		Coord[] ret = new Coord[a.size()];
		a.toArray(ret);

		return ret;
	}

	private static void printCoords(Coord start, Coord[] a) {

		System.out.println(start.toColorString("black"));

		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i].toColorString("red"));
		}
		System.out.println();
		System.out.println("Paste these results into http://www.hamstermap.com/custommap.html if you want to visualize the coordinates.");
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.printf("Enter the sorting algorithm to use [i]nsertion sort, [q]uicksort, [r]andomized quicksort, or [s]ystem quicksort): ");
		char algo = s.next().charAt(0);

		System.out.printf("Enter your starting coordinate in \"latitude longitude\" format as doubles: (e.g. 42.3366322 -71.0942150): ");
		Coord start = getOrigin(s);

		System.out.printf("Enter your end coordinates one at a time in \"latitude longitude\" format as doubles: (e.g. 38.897386 -77.037400). End your input with a non-double character:%n");
		Coord[] destinations = getDests(s, start);

		s.close();

		switch (algo) {
		case 'i':
			insertionSort(destinations);			
			break;
		case 'q':
			quickSort(destinations);
			break;
		case 'r':
			randQuickSort(destinations);
			break;
		case 's':
			systemSort(destinations);
			break;
		default:
			System.out.println("Invalid search algorithm");
			System.exit(0);
			break;
		}

		printCoords(start, destinations);

	}

}
