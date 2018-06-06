package model;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MapTest {
	Map mp;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		mp = new Map();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetWidth() {
		int expected = 20;
		assertEquals(expected,mp.getWidth());
	}

	@Test
	public void testGetHeight() {
		int expected = 12;
		assertEquals(expected,mp.getHeight());
	}
	
	
}
