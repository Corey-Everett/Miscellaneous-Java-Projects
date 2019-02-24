// Name: Corey Everett
// Date: January 30th, 2019
// Program: Algorithms Assignment 2
// Purpose: This program replicates a heap add function.

package edu.wit.cs.comp2350;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* Adds floating point numbers with varying precision 
 * 
 * Wentworth Institute of Technology
 * COMP 2350
 * Assignment 2
 * 
 */


public class A2 {

	// This method is meant to replicate the "add" function using a heap.
	
	// Important rules with heap. Parent of a node is ((insert rule here)). Child of a node is ((insert rule here.))
	// The idea of this is to take the two smallest nodes in the heap and then sum them, effectively removing a node.
	// From there, this process is repeated until the total size is 1. This results in a really long-winded means
	// of gathering the sum of all node values. 
	
	
	// Make sure there's an int that tracks "this is the useful part of the heap"
	
	// There are effectively seven steps to this process, outlined in the assignment 2 paper:
	// STEP 1: Build Heap
	// STEP 2: While the heap is greater than size 1,
	//       while (a.length() > 1) {
	// STEP 3 and 4: Gather minimum of heap twice
	//    -- Find the minimum by looking for smallest value in the array
	//    -- Remove the minimum and store it as "min1" and "min2"
	// STEP 5: Sum the two values
	//    -- sum = min1+min2
	// STEP 6: insert sum into heap
	// STEP 7 (once loop is complete): return the heap[0]. 
	
	// Following these rules on parent-child relationships, and mathematics, and just a little bit of insanity, this project will work. 
	
	public static float heapAdd(float[] a) {
		
		// STEP 0: Really easy, quick cases to save time in the instance of small input arrays. Hey, you never know. 
		
		if (a.length == 0) return 0;
		if (a.length == 1) return a[0];
		if (a.length == 2) return a[1]+a[0];
		
		// STEP 1: Build (initialize variables and sort the array into a "heap".
		// min1 is the position of the first smallest number in the heap. min2 is the position of the second smallest number in the heap.
		// sum is the sum of the numbers min1 and min2 point to. These numbers are initalized with the highest possible int value
		// so as to provide a good means of seeing any potential errors.
		
			int min1 = a.length-1, min2 = a.length-1; float tmp = 2147483647; 
			
		// STEP 1.5: The rest of step 1 is to ensure that the float array is assembled in such
		// a manner that it can be construed as a heap where the highest numbers form roots. This is most easily done by reverse-sorting
		// the array, which I will do automatically at cost to my grade until such time I can figure out how to complete it without.
		// This section of code sorts the array values into a heap by their size, largest to smallest. Under the heap structure, this is valid.
			
			
			Arrays.sort(a);
			// This section of code reverses the sorted array.
			for(int i = 0; i < a.length / 2; i++)
			{
			    float temp = a[i];
			   a[i] = a[a.length - i - 1];
			    a[a.length - i - 1] = temp;
			}
			
			System.out.print("Reverse Sorted and In heap format:" + Arrays.toString(a) + "\n)");
		long thresholdSum = 0;
		
		// STEP 2: Loop with two conditions, in case something messes up and the array doesn't actually decrease in size. Every 20 iterations,
		// re-sort the array. This should prevent infinite loops.
		
		while (a.length > 1 && a[1] != 0) {
		// STEP 3 AND STEP 4: Min1 and min2 (First difficult part)
			
		float smallestValue1 = 2147483647;
		float smallestValue2 = 2147483647;	                       
			
		for (int i = 0; i <= a.length-1; i++) {
			
			if (a[i] < smallestValue1 && a[i] != 0) { min1 = i; smallestValue1 = a[i]; }
			
		}
			// Remove min1 after making smallest
		a[min1] = 0;
		System.out.println("Smallest value 1: " + smallestValue1 + ", position " + min1);
			// Get min2
		 	for (int i = 0; i <= a.length-1; i++) {
				
				if (a[i] < smallestValue2 && a[i] != 0) { min2 = i; smallestValue2 = a[i]; }
				
			}
				// Remove min1 after making smallest
			a[min2] = 0;
			System.out.println("Smallest value 2: " + smallestValue2 +", position " + min2);
		
		// STEP 5: Sum the two values. If it goes over the legally-allowed limit, add it to the threshold sum. 
			tmp = smallestValue1 + smallestValue2; 
			if (tmp > 2147483647) {
				thresholdSum = thresholdSum + 2147483647;
				tmp = tmp - 2147483647; 
				// If stuff hits the fan and the program is overloaded with numbers, provide an answer which should hopefully be somewhere near the final product.
				if (thresholdSum > 2147483647*6) {
					return thresholdSum + a[0] +a[1] +a[2] +a[3] + a[4];
				}
			}
		System.out.println("Temp sum: " + tmp);
		// STEP 6: insert sum into heap (second difficult part. This is where knowledge of heaps come into play.)
		// Place the value of temp into the end of the valid part of the array. If the value of temp is greater than its parent, swap the parent value
		// with the temp value. Repeat this process until it is not true.
			
		// Rules for parent-child relationships: parent of i = (i-1)/2.
		// Left child: i = 2i+1. Right child = 2i+2.
		
		// Add sum into heap.
		a[min2] = tmp;
		
		// while the number is greater than its parent, replace with its parent.
		
			float tempValue;
					
			while (a[min2] > a[(min2-1)/2]) {
				// Save parent value
				tempValue = a[(min2-1)/2];
				// Replace parent with child
				a[(min2-1)/2] = a[min2];
				// Now daddy's your son.
				a[min2] = tempValue;
				min2 = (min2-1)/2;
				
			}
		
		
		
		// STEP 6.5. Closing loop stuff. If the entries are empty more than halfway through and all the other entries are zero, cut the length in half and use that.
		// With the current loop structure, the program should still return whether the length is 1 or not.
	//	float[] b = Arrays.copyOfRange(a, 0, a.length/2);
	//	if (seqAdd(a) == seqAdd(b)) {
	//		a = b;
	//	}
		// Covering instances where stuff gets weird.
		
		}
		
		// STEP 7: Return a[0], a[1] and the threshold sum. This will account for many possible contingencies and won't mess up
		// the program if they are not present.
		return a[1]+a[0]+thresholdSum; // return the error-minimized sum of floats in the topmost part of the heap.
	}

	/********************************************
	 * 
	 * You shouldn't modify anything past here
	 * 
	 ********************************************/

	// sum an array of floats sequentially - high rounding error
	public static float seqAdd(float[] a) {
		float ret = 0;

		for (int i = 0; i < a.length; i++)
			ret += a[i];

		return ret;
	}

	// sort an array of floats and then sum sequentially - medium rounding error
	public static float sortAdd(float[] a) {
		Arrays.sort(a);
		return seqAdd(a);
	}

	// scan linearly through an array for two minimum values,
	// remove them, and put their sum back in the array. repeat.
	// minimized rounding error
	public static float min2ScanAdd(float[] a) {
		int min1, min2;
		float tmp;

		if (a.length == 0) return 0;

		for (int i = 0, end = a.length; i < a.length - 1; i++, end--) {

			if (a[0] < a[1]) { min1 = 0; min2 = 1; }	// initialize
			else { min1 = 1; min2 = 0; }

			for (int j = 2; j < end; j++) {		// find two min indices
				if (a[min1] > a[j]) { min2 = min1; min1 = j; }
				else if (a[min2] > a[j]) { min2 = j; }
			}

			tmp = a[min1] + a[min2];	// add together
			if (min1<min2) {			// put into first slot of array
				a[min1] = tmp;			// fill second slot from end of array
				a[min2] = a[end-1];
			}
			else {
				a[min2] = tmp;
				a[min1] = a[end-1];
			}
		}

		return a[0];
	}

	// read floats from a Scanner
	// returns an array of the floats read
	private static float[] getFloats(Scanner s) {
		ArrayList<Float> a = new ArrayList<Float>();

		while (s.hasNextFloat()) {
			float f = s.nextFloat();
			if (f >= 0)
				a.add(f);
		}
		return toFloatArray(a);
	}

	// copies an ArrayList to an array
	private static float[] toFloatArray(ArrayList<Float> a) {
		float[] ret = new float[a.size()];
		for(int i = 0; i < ret.length; i++)
			ret[i] = a.get(i);
		return ret;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		System.out.printf("Enter the adding algorithm to use ([h]eap, [m]in2scan, se[q], [s]ort): ");
		char algo = s.next().charAt(0);

		System.out.printf("Enter the non-negative floats that you would like summed, followed by a non-numeric input: ");
		float[] values = getFloats(s);
		float sum = 0;

		s.close();

		if (values.length == 0) {
			System.out.println("You must enter at least one value");
			System.exit(0);
		}
		else if (values.length == 1) {
			System.out.println("Sum is " + values[0]);
			System.exit(0);

		}

		switch (algo) {
		case 'h':
			sum = heapAdd(values);
			break;
		case 'm':
			sum = min2ScanAdd(values);
			break;
		case 'q':
			sum = seqAdd(values);
			break;
		case 's':
			sum = sortAdd(values);
			break;
		default:
			System.out.println("Invalid adding algorithm");
			System.exit(0);
			break;
		}

		System.out.printf("Sum is %f\n", sum);		

	}

}
