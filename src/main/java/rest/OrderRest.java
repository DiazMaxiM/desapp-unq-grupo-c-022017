/**
 *
 */
package rest;

import javax.ws.rs.Path;

import services.OrderService;

@Path("/")
public class OrderRest {

	public static final int NUMBER_OF_POST = 1;

	private OrderService orderService;

	public void setOrderService(final OrderService orderService) {
		this.orderService = orderService;
	}

}
