package model.element.nonMobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Penetrability;

public class PurseTest {

	Purse purse = new Purse();
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
	public void testBone() {
		final Penetrability expected = Penetrability.BLOCKING;
		assertEquals(expected, purse.getPenetrability());
	}
	@Test
	public void testBoneFaux() {
		final Penetrability expected = Penetrability.PENETRABLE;
		assertEquals(expected, purse.getPenetrability());
	}
}
