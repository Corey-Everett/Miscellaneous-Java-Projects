package edu.wit.cs.comp2000.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.security.Permission;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import edu.wit.cs.comp2000.Dictionary;
import edu.wit.cs.comp2000.DictionaryInterface;

public class LAB6Tests{

	@Rule
	public Timeout globalTimeout = Timeout.seconds(5);

	@SuppressWarnings("serial")
	private static class ExitException extends SecurityException {}

	private static class NoExitSecurityManager extends SecurityManager {
	
		@Override
		public void checkPermission(Permission perm) {}

		@Override
		public void checkPermission(Permission perm, Object context) {}

		@Override
		public void checkExit(int status) { super.checkExit(status); throw new ExitException(); }
	}

	@Before
	public void setUp() throws Exception { System.setSecurityManager(new NoExitSecurityManager());}

	@After
	public void tearDown() throws Exception {System.setSecurityManager(null);}
	
	
	@Test
	public void testAdd() { // Completed
		// Only tests if dictionary crashes during add operation, not if value is stored correctly
		
		DictionaryInterface<String, String> d = new Dictionary<>();

		assertTrue(d.isEmpty() == true);
		d.add("key1", "value1");
		d.add("key2", "value2");
		d.add("key3", "value3");
		System.out.print(d.getValue("key1"));
		assertTrue("Value of key 1 should be value1", d.getValue("key1") == "value1");
		assertTrue("Value of key 2 should be value2", d.getValue("key2") == "value2");
		assertTrue("Value of key 3 should be value3", d.getValue("key3") == "value3");
		assertTrue(d.isEmpty() == false);
	}

	
	@Test
	public void testClear() {
		DictionaryInterface<String, String> d = new Dictionary<>();
		d.add("key1", "value1");
		d.add("key2", "value2");
		d.add("key3", "value3");
		assertTrue("Value of key 1 should be value1", d.getValue("key1") == "value1");
		assertTrue("Value of key 2 should be value2", d.getValue("key2") == "value2");
		assertTrue("Value of key 3 should be value3", d.getValue("key3") == "value3");
		assertTrue(d.isEmpty() == false);
		d.clear();
		assertTrue(d.isEmpty() == true);
		
	}
	
	
	@Test
	public void testContains() {
		
		DictionaryInterface<String, String> d = new Dictionary<>();
		d.add("key1", "value1");
		d.add("key2", "value2");
		d.add("key3", "value3");
		assertTrue("Value of key 1 should be value1", d.getValue("key1") == "value1");
		assertTrue("Value of key 2 should be value2", d.getValue("key2") == "value2");
		assertTrue("Value of key 3 should be value3", d.getValue("key3") == "value3");
		assertTrue(d.isEmpty() == false);
		d.clear();
		assertTrue(d.isEmpty() == true);
		assertTrue(d.contains("key1") == true);
		
	}
	
	
	@Test
	public void testGetSize() {
		DictionaryInterface<String, String> d = new Dictionary<>();

		assertEquals("Wrong number of entries", 0, d.getSize());

		d.add("key1", "value1");
		d.add("key2", "value2");
		d.add("key3", "value3");

		assertEquals("Wrong number of entries", 3, d.getSize());
		
		d.remove("key1");
		d.remove("key3");
		
		assertEquals("Wrong number of entries", 1, d.getSize());

	}
	
	
	@Test
	public void testGetValue() {
		
		DictionaryInterface<String, String> d = new Dictionary<>();
		d.add("key1", "value1");
		assertTrue("Implement this test", d.getValue("key1") == "value1"); // STUB
	}
	
	
	@Test
	public void testIsEmpty() {
		DictionaryInterface<String, String> d = new Dictionary<>();

		assertTrue("Dictionary should be empty", d.isEmpty());
		
		d.add("key1", "value1");
		d.add("key2", "value2");
		d.add("key3", "value3");
		
		assertTrue("Dictionary should not be empty", !d.isEmpty());

		d.clear();
		
		assertTrue("Dictionary should be empty", d.isEmpty());
	}
	
	
	@Test
	public void testRemove() {
		DictionaryInterface<String, String> d = new Dictionary<>();
		d.add("key1", "value1");
		assertTrue("Value of key 1 should be value1", d.getValue("key1") == "value1");
		assertTrue(d.isEmpty() == false);
		d.remove("key1");
		assertTrue(d.contains("key1") != true);
	}
	
	
	@Test
	public void testIterators() {
		DictionaryInterface<String, String> d = new Dictionary<>();

		d.add("key1", "value1");
		d.add("key2", "value2");
		d.add("key3", "value3");

		Iterator<String> i = d.getKeyIterator();

		// We don't know the order, so put everything in a set and check the set

		Set<String> s = new HashSet<>();
		int numItems = 0;

		while (i.hasNext()) {
			s.add(i.next());
			numItems++;
		}

		assertTrue("key1 is missing from iterator", s.contains("key1"));
		assertTrue("key2 is missing from iterator", s.contains("key2"));
		assertTrue("key3 is missing from iterator", s.contains("key3"));

		assertEquals("Wrong number of keys", 3, numItems);
		

		Iterator<String> v = d.getValueIterator();

		// We don't know the order, so put everything in a set and check the set

		s.clear();
		numItems = 0;

		while (v.hasNext()) {
			s.add(v.next());
			numItems++;
		}

		assertTrue("value1 is missing from iterator", s.contains("value1"));
		assertTrue("value2 is missing from iterator", s.contains("value2"));
		assertTrue("value3 is missing from iterator", s.contains("value3"));

		assertEquals("Wrong number of values", 3, numItems);
	}

}

