package tests;

import org.junit.Ignore;
import org.junit.Test;

import builders.ServiceBuilder;
import exception.InvalidAddressException;
import exception.InvalidLocalityAddressException;
import exception.InvalidNumberStreetException;
import exception.InvalidServiceException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Telephone;
import serviceException.InvalidServiceDescriptionException;
import serviceException.InvalidServiceEmailException;
import serviceException.InvalidServiceLogoException;
import serviceException.InvalidServiceNameException;
import serviceException.InvalidServiceWorkingHoursException;

public class ServiceTest {
	@Test(expected = InvalidServiceNameException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidName()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().withServiceName("").build();
	}

	@Test(expected = InvalidServiceLogoException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidLogo()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().withServiceLogo("").build();
	}

	@Test(expected = InvalidAddressException.class)
	@Ignore
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidAddress()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().withServiceAddress(new Address(null, null, null, null, null)).build();
	}

	@Test(expected = InvalidServiceDescriptionException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidDescription()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().withServiceDescription("").build();
	}

	@Test(expected = InvalidServiceEmailException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidEmail()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().withServiceEmail("").build();
	}

	@Test(expected = InvalidServiceWorkingHoursException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidWorkingHours()
			throws InvalidServiceException, InvalidAddressException, InvalidServiceNameException,
			InvalidServiceLogoException, InvalidServiceDescriptionException, InvalidServiceEmailException,
			InvalidServiceWorkingHoursException, InvalidTelephoneNumberException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().withServiceWorkingHours(null).build();
	}

	@Test(expected = InvalidTelephoneNumberException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidTelephone()
			throws InvalidServiceException, InvalidTelephoneNumberException, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().withServiceTelephone(new Telephone("54", null, null)).build();
	}

	@Test()
	public void testShouldPassWhenICreateAValidService() throws InvalidServiceException, InvalidAddressException,
			InvalidServiceNameException, InvalidServiceLogoException, InvalidServiceDescriptionException,
			InvalidServiceEmailException, InvalidServiceWorkingHoursException, InvalidTelephoneNumberException,
			InvalidNumberStreetException, InvalidStreetAddressException, InvalidLocalityAddressException {
		new ServiceBuilder().build();
	}

}
