/**
 *
 */
package rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import services.MenuService;

@Path("/menu")
public class MenuRest {

	public static final int NUMBER_OF_POST = 1;

	private MenuService menuService;

	@GET
	@Path("/listMenu/{name}")
	@Produces("application/json")
	public Response listMenu(@PathParam("name") final String name) {
		return Response.ok(menuService.listMenuForName(name)).build();
	}

	public void setMenuService(final MenuService menuService) {
		this.menuService = menuService;
	}

}
