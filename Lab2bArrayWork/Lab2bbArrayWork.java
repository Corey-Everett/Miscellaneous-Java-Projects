//Name: Corey Everett
//Date: February 6th, 2018
//Program: Array Work Part B
//Purpose: This program determines whether two arrays intersect (have the same value). It will then print whether they intersect or not.

public class Lab2bbArrayWork {

	public static void main(String[] args) {
		
		int[] array1 = {0}; int[] array2 = {0};
		
		boolean intersects = intersect(array1, array2);
		
		if (intersects == true) {
			System.out.print("Intersects!");
		}
		if (intersects == false) {
			System.out.print("Does not intersect!");
		}

	}
	
	public static boolean intersect(int[] array1, int[] array2) {
		
		boolean intersect = false;
		
		for (int i = 0; i <= array1.length-1; i++) {
			for (int j = 0; j<=array2.length-1; j++) {
				if (array1[i] == (array2[j])) {intersect = true;}

			}
		}
		
		return intersect;
	}

}
