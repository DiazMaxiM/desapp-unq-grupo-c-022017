package testHibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import builders.ClientBuilder;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.User;
import services.UserService;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })
public class UserHibernateTest {

	@Autowired
	private UserService userService;
	
	@Test
	public void testSaveUser() throws InvalidAddressException, InvalidLocalNumberException, InvalidAreaCodeException, InvalidCountryCodeException, InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException, InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidTelephoneNumberException, InvalidMapPositionException, InvalidCuitException, InvalidFirstNameException, InvalidLastNameException, InvalidEmailAddressException {
		User clientBuilder= new ClientBuilder().build();
		userService.save(clientBuilder);
		
		assertEquals(userService.getRepository().findById(1), clientBuilder);
	}

}
