package testHibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLocalNumberException;
import model.Telephone;
import services.TelephoneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })

public class TelephoneHibernateTest {

	@Autowired
	private TelephoneService telephoneService;

	@Ignore
	@Test
	public void testSaveTelephone()
			throws InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException {
		telephoneService.save(new Telephone("54", "011", "43511464"));
		assertEquals(1, telephoneService.retriveAll().size());

	}

}