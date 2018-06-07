package model.element.nonMobile;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Collision;

public class BoneTest {
	Bone bone ;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		bone = new Bone();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBone() {
		final Collision expected = Collision.BLOCKING;
		assertEquals(expected, bone.getCollision());
		
	}
	

		
	}

