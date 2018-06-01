package model.element.nonMobile;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.element.Penetrability;

public class BoneTest {
	Bone bone = new Bone();
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
		assertEquals(expected, bone.getPenetrability());
	}
	@Test
	public void testBoneFaux() {
		final Penetrability expected = Penetrability.PENETRABLE;
		assertEquals(expected, bone.getPenetrability());
	}
}
