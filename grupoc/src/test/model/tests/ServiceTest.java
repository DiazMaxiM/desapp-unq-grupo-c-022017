package tests;
import org.junit.Test;
import builders.ServiceBuilder;
import exception.InvalidAddressException;
import exception.InvalidServiceException;
import exception.InvalidTelephoneNumberException;
import model.Address;
import model.Service;
import model.Telephone;

public class ServiceTest {

	@Test(expected=InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidService() throws InvalidServiceException{
		new Service(null,null,null,null,null,null,null,null,null);
	}
	
	@Test(expected=InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidName() throws InvalidServiceException{
		new ServiceBuilder()
        .withServiceName("")
	    .build();
	}
	
	@Test(expected=InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidLogo() throws InvalidServiceException{
		new ServiceBuilder()
        .withServiceLogo("")
	    .build();
	}
	
	@Test(expected=InvalidAddressException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidAddress() throws InvalidServiceException, InvalidAddressException{
		new ServiceBuilder()
        .withServiceAddress(new Address(null, null,null,null,null))
	    .build();
	}
	
	@Test(expected=InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidDescription() throws InvalidServiceException{
		new ServiceBuilder()
        .withServiceDescription("")
	    .build();
	}
	
	@Test(expected=InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidEmail() throws InvalidServiceException{
		new ServiceBuilder()
        .withServiceEmail("")
	    .build();
	}
	
	@Test(expected=InvalidServiceException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidWorkingHours() throws InvalidServiceException{
		new ServiceBuilder()
        .withServiceWorkingHours(null)
	    .build();
	}
	
	@Test(expected=InvalidTelephoneNumberException.class)
	public void testShouldFailWhenICreateAnInvalidServiceWithInvalidTelephone() throws InvalidServiceException, InvalidTelephoneNumberException{
		new ServiceBuilder()
       .withServiceTelephone(new Telephone("54", null, null))
	   .build();
	}
	
	@Test()
	public void testShouldPassWhenICreateAValidService() throws InvalidServiceException{
		new ServiceBuilder()
	    .build();
	}
	
	
}
