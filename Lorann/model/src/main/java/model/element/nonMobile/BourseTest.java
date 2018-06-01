package model.element.nonMobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Penetrability;

public class BourseTest {
	Bourse bourse = new Bourse();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
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
	public void testBourse() {
		final Penetrability expected = Penetrability.PENETRABLE;
		assertEquals(expected, bourse.getPenetrability());
	}
	
	@Test
	public void testBourseFaux() {
		final Penetrability expected = Penetrability.BLOCKING;
		assertEquals(expected, bourse.getPenetrability());
	}
	

}
