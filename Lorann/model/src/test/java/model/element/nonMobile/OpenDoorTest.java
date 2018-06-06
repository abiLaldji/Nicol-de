package model.element.nonMobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Collision;

public class OpenDoorTest {
	OpenDoor opendoor; 

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		opendoor = new OpenDoor();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testOpenDoor() {
		final Collision expected = Collision.WIN;
		assertEquals(expected, opendoor.getCollision());
	}
	
	
}
