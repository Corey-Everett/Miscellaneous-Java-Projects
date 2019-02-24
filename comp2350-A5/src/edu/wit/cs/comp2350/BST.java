package edu.wit.cs.comp2350;

// TODO: copy your lab 4 BST code here
public class BST extends LocationHolder {

	@Override
	public DiskLocation find(DiskLocation d) {
		// Start with the root node, and then recursively call the below nodes based on whether the number is less than or greater than number.
		
		 DiskLocation result = _find(d, root);
		return result;
	}
	public DiskLocation _find(DiskLocation d, DiskLocation c) {
		// D is the DiskLocation being searched for, c is the "comparator" DiskLocation. 
		// Go right if the value being searched for is larger
		if (d == null || d == nil || d.equals(c) ) {
			return c;
		}
		if (d.isGreaterThan(c)) {
			return _find(d, c.right);
		}
		// Go left if the value being searched for is smaller
		else {
			return _find(d, c.left);
		}
		// If neither if statement applies, that means the two are equal and therefore the desired object. Return c or d.
	}

	@Override
	public DiskLocation next(DiskLocation d) {
		// This method returns the next location in a Binary Search Tree when given the parameter of a DiskLocation within that
		// tree. It accomplishes this via
		if (d.right != nil) {
			return min(d.right);
		}
		DiskLocation ancestor = d.parent;
		while (ancestor != nil && d == ancestor.right) {
			d = ancestor;
			ancestor = ancestor.parent;
		}
		return ancestor;
	}

	@Override
	public DiskLocation prev(DiskLocation d) {
		// This method returns the previous location in a Binary Search Tree when given the parameter of a DiskLocation within that
		// tree. It accomplishes this via
		if (d.left != nil) {
			return max(d.left);
		}
		DiskLocation ancestor = d.parent;
		while (ancestor != nil && d == ancestor.left) {
			d = ancestor;
			ancestor = ancestor.parent;
		}
		return ancestor;
	}
	// This method will find the parent of a node, given proper inputs.
	  public DiskLocation findParent(DiskLocation d, DiskLocation currentLocation, DiskLocation parentLocation) {
	        if (currentLocation == null || currentLocation == nil) {return parentLocation;}
	        else if (currentLocation.isGreaterThan(d)) { return findParent(d,currentLocation.left, currentLocation);}
	        else { return findParent(d,currentLocation.right,currentLocation);}   
	    }
	@Override
	public void insert(DiskLocation d) {
		// Find d's parent
		d.parent = findParent(d, root, nil);
		// If the binary sorting tree is empty, set the root value to d and make sure the left and right values are nil.
		if (d.parent == null || d.parent == nil) {root = d;}
		else if (d.parent.isGreaterThan(d)) {d.parent.left = d;}
		else {d.parent.right = d;}
		d.left = nil;
		d.right = nil;
	}
	
	// This section of code does nothing. I didn't have the heart to delete it. :(
	public void _insert(DiskLocation d, DiskLocation c) {
		// We have established that the root currently exists. As such, go down and check left/right values.
		// If the value has been determined to fit, it is added in. If not, go down and try again.
		// This is a recursive implementation.
		if (c.isGreaterThan(d) == true) {
			if (c.right == nil) {
				c.right = d; c.right.right = nil; c.right.left = nil; c.right.parent = c;
			} else {
				_insert(d, c.right);
			}
		} else {
			if (c.left == nil) {
				c.left = d; c.left.right = nil; c.left.left = nil; c.left.parent = c;
			} else {
				_insert(d, c.left);
			}
		}
		
	}

	@Override
	public int height() {
		// TODO: This method should go through the entire tree, lowest number to largest number and determine the "lowest" point based on how many generations
		// up the next and previous nodes are. This should involve a count variable that keeps track of how many layers have been traversed.
		return height(root);
	
	}
	public int height(DiskLocation d) {
		
		// Cover the instance where there are no transitions needed.
		if (d == root && ( (d.left == nil && d.right == nil) || (d.left == null && d.right == null))) {return 0;}
		else if (d == nil)  {return -1;}
	      
		// Determine highest tree recursively.
	     int leftHeight = height(d.left);
	     int rightHeight = height(d.right);

	     return 1 + Math.max(rightHeight, leftHeight);
	     
	}
	// These are two mini-methods. When called on root, min returns the leftmost value, and max returns the rightmost value. You never know!
	public DiskLocation min(DiskLocation d) {
		if (d != nil && d != null) {min(d.left);}
		return d;
	}
	public DiskLocation max(DiskLocation d) {
		if (d != nil && d != null) {min(d.right);}
		return d; 
	}

}
