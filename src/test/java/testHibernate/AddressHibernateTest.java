package testHibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Address;
import services.AddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })

public class AddressHibernateTest {

	@Autowired
	private AddressService addressService;

	@Ignore
	@Test
	public void testSaveMapPosition() {
		addressService.save(new Address());
		assertEquals(1, addressService.retriveAll().size());

	}

}
