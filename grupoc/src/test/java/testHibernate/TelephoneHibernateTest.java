package testHibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Telephone;
import services.TelephoneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })

public class TelephoneHibernateTest {

	@Autowired
	private TelephoneService telephoneService;

	@Test
	public void testSaveTelephone() {
		telephoneService.save(new Telephone());
		assertEquals(1, telephoneService.retriveAll().size());

	}

}