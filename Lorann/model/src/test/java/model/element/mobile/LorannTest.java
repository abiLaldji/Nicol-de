package model.element.mobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class LorannTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Lorann lorann = new Lorann(0,0,null);
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int expected = 0;
		Mobile lorann = null;
		assertEquals(expected,lorann.getScore());
	}

}
