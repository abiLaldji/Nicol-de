package model.element.nonMobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Penetrability;

public class HBoneTest {
	HBone hbone = new HBone();
	

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
	public void testHBone() {
		final Penetrability expected = Penetrability.BLOCKING;
		assertEquals(expected, hbone.getPenetrability());
	}

}
