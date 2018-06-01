package model.element.nonMobile;



import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Penetrability;


public class ClosedDoorTest {
	ClosedDoor closeddoor = new ClosedDoor();

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
	public void testClosedDoor() {
		final Penetrability expected = Penetrability.BLOCKING;
		assertEquals(expected, closeddoor.getPenetrability());
	}
	@Test
	public void testClosedDoorFaux() {
		final Penetrability expected = Penetrability.PENETRABLE;
		assertEquals(expected, closeddoor.getPenetrability());
	}


}
