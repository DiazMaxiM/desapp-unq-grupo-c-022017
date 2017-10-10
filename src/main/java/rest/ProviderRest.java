/**
 *
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import exception.InvalidAddressException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalityAddressException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import services.ProviderService;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

@Path("/providers")
public class ProviderRest {

	public static final int NUMBER_OF_POST = 1;

	private ProviderService providerService;

	// http://localhost:8080/123/grupoc/rest/providers/newuser/rosali/zaracho/123/ro@zaracho/54/011/43511464/AVELLANEDA/mitre/5000/0/1/1
	@GET
	@Path("/newuser/{pass}/{name}/{surname}/{cuit}/{mail}/{countryCode}/{areaCode}/{localNumber}/{locality}/{street}/{numberStreet}/{floor}/{latitude}/{length}")
	@Produces("application/json")
	public void newUser(@PathParam("pass") final String pass, @PathParam("name") final String name,
			@PathParam("surname") final String surname, @PathParam("cuit") final String cuit,
			@PathParam("mail") final String mail, @PathParam("countryCode") final String countryCode,
			@PathParam("areaCode") final String areaCode, @PathParam("localNumber") final String localNumber,
			@PathParam("locality") final String locality, @PathParam("street") final String street,
			@PathParam("numberStreet") final String numberStreet, @PathParam("floor") final String floor,
			@PathParam("latitude") final String latitude, @PathParam("length") final String length

	) throws InvalidAddressException, InvalidTelephoneNumberException, InvalidCuitException, InvalidFirstNameException,
			InvalidLastNameException, InvalidEmailAddressException, InvalidMapPositionException, NumberFormatException,
			InvalidLengthMapPositionException, InvalidLatitudeMapPositionException, InvalidNumberStreetException,
			InvalidStreetAddressException, InvalidLocalityAddressException {

	}

	public void setProviderService(final ProviderService providerService) {
		this.providerService = providerService;
	}

}
