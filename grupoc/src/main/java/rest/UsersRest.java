/**
 *
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import model.User;
import repositories.GenericRepository;

@Path("/users")
public class UsersRest {

	public static final int NUMBER_OF_POST = 1;

	private GenericRepository<User> userRepository;

	/**
	 * IMPORTANTE!! - Acá deben inyectar el servicio de la aplicación y este
	 * servicio REST solo debe hacer un delegate simple.
	 */
	@GET
	@Path("/maxi")
	@Produces("application/json")
	public Integer findPostsPublishedByBlogId(@PathParam("from") final Integer from) {

		return 1;
	}

	public void setUserRepository(final GenericRepository<User> userDAO) {
		this.userRepository = userDAO;
	}

}
