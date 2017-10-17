/**
 *
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import exception.BalanceInsufficient;
import exception.InvalidAddressException;
import exception.InvalidAreaCodeException;
import exception.InvalidCountryCodeException;
import exception.InvalidLatitudeMapPositionException;
import exception.InvalidLengthMapPositionException;
import exception.InvalidLocalNumberException;
import exception.InvalidLocalityAddressException;
import exception.InvalidLoggingException;
import exception.InvalidMapPositionException;
import exception.InvalidNumberStreetException;
import exception.InvalidStreetAddressException;
import exception.InvalidTelephoneNumberException;
import miniObjects.ErrorJson;
import miniObjects.UserJson;
import model.User;
import services.UserService;
import userExceptions.InvalidCuitException;
import userExceptions.InvalidEmailAddressException;
import userExceptions.InvalidFirstNameException;
import userExceptions.InvalidLastNameException;
import userExceptions.InvalidPasswordException;

@Path("/users")
public class UsersRest {

	public static final int NUMBER_OF_POST = 1;

	private UserService userService;

	// http://localhost:8080/123/grupoc/rest/users/newuser/rosali/zaracho/123/ro@zaracho/54/011/43511464/AVELLANEDA/mitre/5000/0/1/1
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
		user = this.userService.newUser(pass, name, surname, cuit, mail, countryCode, areaCode, localNumber, locality,
				street, numberStreet, floor, latitude, length);
		return Response.ok().entity(new UserJson(user.getId(), user.getName())).build();
		return Response.status(Response.Status.NOT_FOUND).build();

	}

	@GET
	@Path("/loggingUser/{mail}/{pass}")
	@Produces("application/json")
	public Response loggingUser(@PathParam("mail") final String mail, @PathParam("pass") final String pass

	) {

		try {
			User user = userService.loggingUser(mail, pass);
			return Response.ok(new UserJson(user.getId(), user.getName())).build();
		} catch (InvalidLoggingException e) {
			return Response.status(Response.Status.NOT_FOUND).entity(new ErrorJson(100)).build();
		}

	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}

	@GET
	@Path("/addTransactionUser/{id}/{typeTransaction}/{value}")
	@Produces("application/json")
	public boolean addTransactionUser(@PathParam("id") final String id,
			@PathParam("typeTransaction") final String typeTransaction, @PathParam("value") final String value) {
		try {
			this.userService.addTransaction(id, typeTransaction, value);
		} catch (BalanceInsufficient e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@GET
	@Path("/getBalanceUser/{id}")
	@Produces("application/json")
	public Double getBalanceUser(@PathParam("id") final String id) {
		return this.userService.getBalance(id);
	}

	// http://localhost:8080/grupoc/rest/users/updateuser/1/123456/54/011/43511464/QUILMES/mitre/5000/0/1/1
	@GET
	@Path("/updateuser/{id}/{password}/{countryCode}/{areaCode}/{localNumber}/{locality}/{street}/{numberStreet}/{floor}/{latitude}/{length}")
	@Produces("application/json")
	public boolean updateUser(@PathParam("id") final String id, @PathParam("password") final String password,
			@PathParam("countryCode") final String countryCode, @PathParam("areaCode") final String areaCode,
			@PathParam("localNumber") final String localNumber, @PathParam("locality") final String locality,
			@PathParam("street") final String street, @PathParam("numberStreet") final String numberStreet,
			@PathParam("floor") final String floor, @PathParam("latitude") final String latitude,
			@PathParam("length") final String length) {
		try {
			this.userService.updateUser(id, password, countryCode, areaCode, localNumber, locality, street,
					numberStreet, floor, latitude, length);
		} catch (NumberFormatException | InvalidLengthMapPositionException | InvalidLatitudeMapPositionException
				| InvalidLocalNumberException | InvalidAreaCodeException | InvalidCountryCodeException
				| InvalidNumberStreetException | InvalidStreetAddressException | InvalidLocalityAddressException
				| InvalidMapPositionException | InvalidPasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
