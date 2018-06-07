package model.element.nonMobile;





import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Collision;


public class ClosedDoorTest {
	ClosedDoor closeddoor;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		closeddoor = new ClosedDoor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testClosedDoor() {
		final Collision expected = Collision.KILL;
		assertEquals(expected, closeddoor.getCollision());
	}
	


}
