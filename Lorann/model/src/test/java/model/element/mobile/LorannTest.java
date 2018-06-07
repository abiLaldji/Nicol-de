package model.element.mobile;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class LorannTest {
	
	Lorann lorann;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		lorann = new Lorann(0, 0, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int expected = 0;
	
		assertEquals(expected,lorann.getScore());
	}

	@Test
	public void testCollect() throws IOException {
		lorann.collect(0,0);
		int expected = 1;
		
		assertEquals(expected,lorann.getScore());
		
	}
	
	
	@Test
	public void testGetScore() {
		int expected = 0;
		assertEquals(expected, lorann.getScore());
			
	}
	
	@Test
	public void testSetScore() {
		lorann.setScore(1);
		int expected = 1;
		assertEquals(expected, lorann.getScore());
		
	}
	
	
	
}
