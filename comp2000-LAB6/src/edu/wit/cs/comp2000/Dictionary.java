// Name: Corey Everett
// Date: November 28th, 2018
// Program: Lab 6 - Dictionary ADT
// Purpose: To create a fully-functional dictionary in Java.
package edu.wit.cs.comp2000;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * A Dictionary class using separate chaining per the assignment.
 * 
 * @author David M Rosenberg
 * @version 0.1.0 stubbed version
 *          <p>
 *          Includes code based on Carrano and Henry's HashedDictionary.java [where noted]
 * 
 * @author Corey M. Everett
 * @version 1.0.0
 * 
 * @param <K> the type for keys
 * @param <V> the type for corresponding values
 */
public class Dictionary<K, V> implements DictionaryInterface<K, V> {


	// instance variables
	private LinkedList<TableEntry>[]	hashTable;
	private int							entryCount;


	 // when the load factor exceeds the threshold, the table must be resized -
	 // could be zero which will force the table to be resized after every add()

	private float						lambda;
	private float						lambdaThreshold;

	 // true: table size will be set to the next prime (if not already prime)
	 // false: table size will be used as is (for initial allocation and when doubled)

	private boolean						forcePrimeTableSize;

	 // true: prevent enlargeHashTable() from being invoked while it's already executing
	 // false: enlargeHashTable() will execute if invoked (the load factor threshold is met/exceeded)

	private boolean						resizing;

	/*
	 * constructors
	 */

	/**
	 * Set up the dictionary/hash table with the default configuration.
	 */
	public Dictionary() {
		this(DEFAULT_TABLE_SIZE, DEFAULT_LAMBDA_THRESHOLD, DEFAULT_FORCE_PRIME_TABLE_SIZE);
	}	// end no-argument constructor


	/**
	 * Sets up the dictionary/hash table with the specified initial size and default
	 * lambda threshold and prime table size configuration.
	 * 
	 * @param initialTableSize
	 *        the initial number of buckets - if not prime, increased to the next larger
	 *        prime number - set to the default configuration value if less than or equal
	 *        to 0
	 */
	public Dictionary(int initialTableSize) {
		this(initialTableSize, DEFAULT_LAMBDA_THRESHOLD, DEFAULT_FORCE_PRIME_TABLE_SIZE);
	}	// end 1-argument constructor


	/**
	 * Sets up the dictionary/hash table with the specified initial size and lambda
	 * threshold and default prime table size configuration.
	 * 
	 * @param initialTableSize
	 *        initial number of buckets - if not prime, increased to the next larger prime
	 *        number - set to the default configuration value if less than or equal to 0
	 * @param initialLambdaThreshold
	 *        a positive, non-zero value - when the load factor exceeds this value, the
	 *        table will be resized - set to the default configuration value if less than
	 *        or equal to 0
	 */
	public Dictionary(int initialTableSize, float initialLambdaThreshold) {
		this(initialTableSize, initialLambdaThreshold, DEFAULT_FORCE_PRIME_TABLE_SIZE);
	}	// end 2-argument constructor


	/**
	 * Sets up the dictionary/hash table with the specified initial size and lambda
	 * threshold and default prime table size configuration.
	 * 
	 * @param initialTableSize
	 *        initial number of buckets - if not prime, increased to the next larger prime
	 *        number (if prime table size enforced) otherwise used as-is - set to the
	 *        default configuration value if less than or equal to 0
	 * @param initialLambdaThreshold
	 *        a positive, non-zero value - when the load factor exceeds this value, the
	 *        table will be resized - set to the default configuration value if less than
	 *        or equal to 0
	 * @param initialForcePrimeTableSize
	 *        if true, table size (number of buckets) will always be increased to the next
	 *        prime number (if not already prime) upon instantiation and resizing - if
	 *        false, table size is used as-is (initialTableSize and new table size when
	 *        resized)
	 */
	public Dictionary(int initialTableSize, float initialLambdaThreshold, boolean initialForcePrimeTableSize) {
		// must be set before initial table size is validated
		forcePrimeTableSize = initialForcePrimeTableSize;

		// may be increased to the next prime number
		initialTableSize = validateTableSize(initialTableSize);

		lambdaThreshold = validateLambdaThreshold(initialLambdaThreshold);


		// TODO set up the instance
		hashTable = new LinkedList[initialTableSize];
		


		// TODO create private utility methods to do the various calculations
		
	}	// end full constructor


	/*
	 * public API methods
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#add(java.lang.Object, java.lang.Object)
	 */
	@Override
	public V add(K key, V value) {
		int index = key.hashCode() % hashTable.length;
		
		if ( hashTable[index] == null || hashTable[index].isEmpty() ) {
			hashTable[index] = new LinkedList<TableEntry>();
		}
		TableEntry entry = new TableEntry(key, null);
		for (LinkedList<TableEntry> slasher : hashTable) {
			if (slasher != null && slasher.contains(slasher.contains(entry))) {
				int indexSlasher = slasher.indexOf(entry);
				slasher.get(indexSlasher).value = value;
				V tempValue = slasher.get(indexSlasher).value;
				return tempValue;
			}
		}
		TableEntry hashSlinging = new TableEntry(key, value);
		hashTable[index].add(entry);
		entryCount++;
		
		lambda = entryCount / hashTable.length;
		if (lambda >= lambdaThreshold) {
			enlargeHashTable();
		}
		return value;
	}	// end add()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#clear()
	 */
	@Override
	public void clear() {
		int size = 0;

	}	// end clear()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#contains(java.lang.Object)
	 */
	@Override
	public boolean contains(K key) {
		int index = key.hashCode() % hashTable.length;
		boolean found = false;
		for (int i = 0; i<= hashTable.length; i++) {
			
		}
		return found;
	}	// end contains()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#getKeyIterator()
	 */
	@Override
	public Iterator<K> getKeyIterator() {
		// TODO Auto-generated method stub
		return null;
	}	// end getKeyIterator()


	@Override
	public int getSize() {
		return entryCount;
	}	// end getSize()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#getValue(java.lang.Object)
	 */
	@Override
	public V getValue(K key) {
		V hash = key.hashCode() % hashTable.length;
		return hash;
	}	// end getValue()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#getValueIterator()
	 */
	@Override
	public Iterator<V> getValueIterator() {
		
		return Iterator<V> = new ValueIterator();
	}	// end getValueIterator()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return entryCount == 0;
	}	// end isEmpty()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#remove(java.lang.Object)
	 */
	@Override
	public V remove(K key) {
		// TODO Auto-generated method stub
		return null;
	}	// end remove()


	/*
	 * private methods
	 */


	/**
	 * Increases the size of the hash table to at least twice its old size (to the next
	 * prime number if necessary). This method must rehash the table entries.
	 */
	private void enlargeHashTable() {

		// TODO resize the table
	} // end enlargeHashTable()


	/**
	 * Test a value for prime-ness.\
	 * [based on isPrime() in HashedDictionary.java by Carrano and Henry]
	 * 
	 * @param testValue
	 *        value to test
	 * @return true if testValue is prime; false if not
	 */
	private boolean isPrime(int testValue) {
		boolean result;
		boolean done = false;

		if ((testValue == 1) || (testValue % 2 == 0))	// 1 and even numbers are not prime
			result = false; 
		else if ((testValue == 2) || (testValue == 3))	// 2 and 3 are prime
			result = true;
		else {	// integer is odd and >= 5 
			// a prime is odd and not divisible by every odd integer up to its square root
			result = true;		// assume prime
			for (int divisor = 3; !done && (divisor * divisor <= testValue); divisor += 2) {
				if (testValue % divisor == 0) {
					result = false;	// divisible; not prime
					done = true;
				} // end if
			} // end for
		} // end if

		return result;
	}	// end isPrime()


	/**
	 * Get the next prime number greater than or equal to the starting value [based on
	 * getNextPrime() in HashedDictionary.java by Carrano and Henry]
	 * 
	 * @param startValue
	 *        the initial value
	 * @return if startValue is already prime it is returned, otherwise the next higher
	 *         value which is prime
	 */
	private int nextPrime(int startValue) {
		int nextPrimeValue = startValue;

		// if even, add 1 to make odd
		if (nextPrimeValue % 2 == 0)
			nextPrimeValue++;

		// test odd integers
		while(!isPrime(nextPrimeValue))
			nextPrimeValue += 2;

		return nextPrimeValue;
	}	// end nextPrime()


	/**
	 * Ensure the candidate table size (number of buckets) is positive, non-zero, and
	 * prime (if necessary).
	 * 
	 * @param candidateTableSize
	 *        starting value for consideration for table size
	 * @return a positive, non-zero size which, if necessary, is prime
	 */
	private int validateTableSize(int candidateTableSize) {
		// ensure the supplied size is positive, non-zero
		int validatedTableSize = (candidateTableSize <= 0) ? DEFAULT_TABLE_SIZE : candidateTableSize;

		// if the size must be prime, make it so
		if (forcePrimeTableSize)
			validatedTableSize = nextPrime(validatedTableSize);

		return validatedTableSize;
	}	// end validateTableSize()


	/**
	 * Ensure the candidate load factor threshold is non-negative.
	 * 
	 * @param candidateThreshold
	 *        value for consideration for load factor threshold
	 * @return a positive threshold value
	 */
	private float validateLambdaThreshold(float candidateThreshold) {
		return (candidateThreshold < 0.0) ? DEFAULT_LAMBDA_THRESHOLD : candidateThreshold;
	}	// end validateLambdaThreshold()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#getLoadFactorThreshold()
	 */
	@Override
	public float getLoadFactorThreshold() {
		return lambdaThreshold;
	}	// end getLoadFactorThreshold()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#getPrimeTableSize()
	 */
	@Override
	public boolean getPrimeTableSize() {
		return forcePrimeTableSize;
	}	// end getPrimeTableSize()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#setLoadFactorThreshold(float)
	 */
	@Override
	public float setLoadFactorThreshold(float newLoadFactor) {
		float savedLambdaThreshold = lambdaThreshold;
		lambdaThreshold = validateLambdaThreshold(newLoadFactor);

		return savedLambdaThreshold;
	}	// end setLoadFactorThreshold()


	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.wit.cs.comp2000.DictionaryInterface#setPrimeTableSize(boolean)
	 */
	@Override
	public boolean setPrimeTableSize(boolean forceToPrime) {
		boolean savedPrimeTableSize = forcePrimeTableSize;
		forcePrimeTableSize = forceToPrime;

		return savedPrimeTableSize;
	}	// end setPrimeTableSize()


	/**
	 * Utility construct to represent key/value pairs.
	 * 
	 * <p>
	 * WARNING:<br>
	 * The Java Class Library's LinkedList class uses K's equals() rather than
	 * TableEntry's equals(). This means that the handling of both
	 * aTableEntry.equals(anotherTableEntry) and aTableEntry.equals(aKey) are both
	 * supported but our equals() will only get called if we give LinkedList's contains()
	 * or indexOf() a TableEntry as the parameter - calling them with a key as the
	 * parameter always fails to match.
	 * 
	 * <p>
	 * To use a TableEntry as the parameter to LinkedList methods, instantiate a
	 * TableEntry with the key and specify null for the value:
	 * 
	 * <pre>
	 *     bucket = hashTable[ hashIndex ];
	 *     if(bucket.contains(new TableEntry(key, null))
	 *          {
	 *          // the key is in the bucket
	 *          }
	 * </pre>
	 */
	private class TableEntry {
		/*
		 * instance variables
		 */
		private final K	key;
		private V value;


		/*
		 * constructors
		 */

		/**
		 * Set up the TableEntry - note that the key cannot be changed.
		 * 
		 * @param theKey
		 *        setting for the key (immutable)
		 * @param initialValue
		 *        initial corresponding value
		 */
		private TableEntry(K theKey, V initialValue) {
			this.key = theKey;
			this.value = initialValue;
		}	// end 2-arg constructor


		/*
		 * public API methods
		 */


		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#equals(java.lang.Object)
		 */
		@Override
		@SuppressWarnings("unchecked")
		public boolean equals(Object otherObject) {
			// if same instance - consider it a match
			if (this == otherObject)
				return true;

			// if nothing to compare to - no match
			if (otherObject == null)
				return false;

			// WARNING: Must search with a TableEntry rather than the key because LinkedList uses 
			//		the key's class' equals() method, not the element's!!!  So, for now,
			//		the key handling portion of this method will not execute
			K otherKey;
			
			if (otherObject.getClass().equals(this.getClass()))
				// the parameter is a TableEntry - get the key from it
				otherKey = ((TableEntry) otherObject).key;
			else if (otherObject.getClass().equals(this.key.getClass()))
				// the parameter is a key - use it
				otherKey = (K) otherObject;
			else	// the parameter is not a supported type - so no match
				return false;

			// finally, we can compare this TableEntry's key and the parameter
			// Note:	key should never be null - if it is, allow the NullPointerException
			return key.equals(otherKey);
		}	// end equals()


		/*
		 * (non-Javadoc)
		 * 
		 * @see java.lang.Object#toString()
		 */
		@Override
		public String toString() {
			return "<" + key + " : " + value + ">";
		}	// end toString()

	}	// end inner class TableEntry


}	// end class Dictionary
