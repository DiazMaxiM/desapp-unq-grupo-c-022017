/**
 *
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import model.Locality;

@Path("/")
public class LocalityRest {

	public static final int NUMBER_OF_POST = 1;

	@GET
	@Path("/listLocality")
	@Produces("application/json")
	public Response listLocality() {
		return Response.ok(Locality.values()).build();
	}

}
