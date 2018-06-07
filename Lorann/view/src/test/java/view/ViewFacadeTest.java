package view;

import static org.junit.Assert.*;

import java.awt.event.KeyEvent;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import controller.IOrderPerformer;
import controller.UserOrder;

public class ViewFacadeTest {
	ViewFacade vf;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		vf = new ViewFacade(null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetOrderPerformer() {
	
		IOrderPerformer expected = null;
		assertEquals(expected,vf.getOrderPerformer());
	}

	/*@Test
	public void testSetOrderPerformer() {
		vf.setOrderPerformer();
	}*/
	
	@Test
	public void testkeyReleased() {
		vf.keyReleased(KeyEvent.VK_RIGHT);
	}
}
