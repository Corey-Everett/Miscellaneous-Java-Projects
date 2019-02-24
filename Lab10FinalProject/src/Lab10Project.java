//Name: Corey Everett
//Date: April 23rd, 2018
//Program: Final Project
//purpose: Shows an iterative list which can be modified.

import java.util.*;

public class Lab10Project {

	public static void main(String[] args) {
		Double[] things = {-2.318, 4.0003,7.98,3.01,14.8};
		List<Double> list1 = new LinkedList<Double>();
		for(Double x: things) 
			list1.add(x);

	System.out.println("here's our linked list");
	System.out.println(list1);
	
	System.out.println("after adding 0.0 at position 2");
	list1.add(2, 0.0);
	System.out.println(list1);
	
	System.out.println("after removing the item at index 4");
	list1.remove(4);
	System.out.println(list1);
	
	System.out.println("here's the last item");
	System.out.println(((LinkedList<Double>) list1).getLast());
	
	System.out.println("after changing the item at index 1 to 3.888");
	list1.set(1, 3.888);
	System.out.println(list1);
	
	System.out.println("using an iterator to print the items in the list");
	Iterator<Double> it = list1.iterator();
	while (it.hasNext()) {
		System.out.println(it.next());
	}
	}

}
