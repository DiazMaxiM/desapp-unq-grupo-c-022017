/**
 *
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

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
import miniObjects.ErrorJson;
import miniObjects.UserJson;
import model.User;
import services.ProviderService;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;

@Path("/")
public class ProviderRest {

	public static final int NUMBER_OF_POST = 1;

	private ProviderService providerService;

	@GET
	@Path("/newuser/{pass}/{name}/{surname}/{cuit}/{mail}/{countryCode}/{areaCode}/{localNumber}/{locality}/{street}/{numberStreet}/{floor}/{latitude}/{length}")
	@Produces("application/json")
	public Response newUser(@PathParam("pass") final String pass, @PathParam("name") final String name,
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
		User user = null;
		try {
			user = this.providerService.newProvider(pass, name, surname, cuit, mail, countryCode, areaCode, localNumber,
					locality, street, numberStreet, floor, latitude, length);
			return Response.ok().entity(new UserJson(user.getId(), user.getName(), user.getTypeUser())).build();
		} catch (InvalidLocalNumberException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(101)).build();
		} catch (InvalidAreaCodeException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(102)).build();
		} catch (InvalidCountryCodeException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(103)).build();
		} catch (InvalidAddressException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(104)).build();
		} catch (InvalidTelephoneNumberException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(105)).build();
		} catch (InvalidCuitException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(106)).build();
		} catch (InvalidFirstNameException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(107)).build();
		} catch (InvalidLastNameException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(108)).build();
		} catch (InvalidEmailAddressException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(109)).build();
		} catch (InvalidMapPositionException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(110)).build();
		} catch (NumberFormatException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(111)).build();
		} catch (InvalidLengthMapPositionException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(112)).build();
		} catch (InvalidLatitudeMapPositionException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(113)).build();
		} catch (InvalidNumberStreetException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(114)).build();
		} catch (InvalidStreetAddressException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(115)).build();
		} catch (InvalidLocalityAddressException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(116)).build();
		}
	}

	@GET
	@Path("/getServices/{id}")
	@Produces("application/json")
	public Response getServices(@PathParam("id") final String id) {
		return Response.ok().entity(this.providerService.getServicesByIdProvider(id)).build();
	}

	public void setProviderService(final ProviderService providerService) {
		this.providerService = providerService;
	}

}
