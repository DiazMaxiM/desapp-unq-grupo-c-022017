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

@Path("/")
public class MenuRest {

	public static final int NUMBER_OF_POST = 1;

	private MenuService menuService;

	@GET
	@Path("/listMenu/{name}")
	@Produces("application/json")
	public Response listMenu(@PathParam("name") final String name) {
		return Response.ok(menuService.listMenuForName(name)).build();
	}

	@GET
	@Path("/listMenus")
	@Produces("application/json")
	public Response listMenu() {
		return Response.ok(menuService.listMenus()).build();
	}

	public void setMenuService(final MenuService menuService) {
		this.menuService = menuService;
	}

	@GET
	@Path("/listMenuCategory/{category}")
	@Produces("application/json")
	public Response listMenuForCategory(@PathParam("category") final String category) {
		return Response.ok(menuService.listMenuForCategory(category)).build();
	}

	@GET
	@Path("/listMenuLocality/{locality}")
	@Produces("application/json")
	public Response listMenuForLocality(@PathParam("locality") final String locality) {
		return Response.ok(menuService.listMenuForLocality(locality)).build();
	}
}
