package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Service;

public class ServiceTest {

	@Test
	public void test() {
		Service service= new Service();
		assertTrue(service.isAValidService());
	}

}
