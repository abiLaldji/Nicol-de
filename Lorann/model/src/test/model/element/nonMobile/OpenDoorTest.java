package model.element.nonMobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Penetrability;

public class OpenDoorTest {
	OpenDoor opendoor = new OpenDoor();

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
	public void testOpenDoor() {
		final Penetrability expected = Penetrability.WIN;
		assertEquals(expected, opendoor.getPenetrability());
	}
	
	
}
