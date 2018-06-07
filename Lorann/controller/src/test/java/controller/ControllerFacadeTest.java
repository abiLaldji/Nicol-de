package controller;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ControllerFacadeTest {
ControllerFacade cf;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		cf= new ControllerFacade(null, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGet() {
		UserOrder expected = UserOrder.NOP;
		assertEquals(expected, cf.getStackOrder());
		

	}
	
	@Test
	public void testSet(){
		cf.setStackOrder(UserOrder.RIGHT);
		UserOrder expected = UserOrder.RIGHT;
		assertEquals(expected, cf.getStackOrder());
	}
	
	@Test
	public void testClear() {
		cf.setStackOrder(UserOrder.RIGHT);
		cf.clearStackOrder();
		UserOrder expected = UserOrder.NOP;
		assertEquals(expected, cf.getStackOrder());
	}

}
