package model.element.nonMobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Collision;

public class HBoneTest {
	HBone hbone; 
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		hbone = new HBone();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		final Collision expected = Collision.BLOCKING;
		assertEquals(expected, hbone.getCollision());
	}

}
