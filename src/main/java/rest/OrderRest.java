/**
 *
 */
package rest;

import java.io.IOException;
import java.text.ParseException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import exception.BalanceInsufficient;
import exception.InvalidClientException;
import exception.InvalidMenuException;
import exception.InvalidProviderException;
import exception.InvalidPurchaseException;
import exception.InvalidTimeZoneException;
import exception.NumberOfMenusExceededException;
import exception.PendingScoreException;
import miniObjects.OrderJson;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import serviceException.InvalidDeliveryLocation;
import services.MenuService;
import services.OrderService;
import services.ProviderService;
import services.ScoreService;
import services.UserService;
import validation.InvalidFormatTimeZoneException;

@Path("/")
public class OrderRest {

	public static final int NUMBER_OF_POST = 1;

	public OrderService orderService;
	private MenuService menuService;
	private ProviderService providerService;
	private UserService userService; 
	private ScoreService scoreService; 
 
	public void setOrderService(final OrderService orderService) {
		this.orderService = orderService;
	} 
	
	public void setScoreService(final ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	public void setMenuService(final MenuService menuService) {
		this.menuService = menuService;
	}

	public void setProviderService(final ProviderService providerService) {
		this.providerService = providerService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}
	
	@POST
	@Path("/newOrder")
	@Consumes("application/json") 
	@Produces("application/json")
	public Response newOrder(OrderJson orderJson) throws NumberFormatException, InvalidTimeZoneException, InvalidMenuException, InvalidClientException, InvalidProviderException, ParseException, InvalidFormatTimeZoneException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, NumberOfMenusExceededException, InvalidDeliveryLocation, IOException {
	     					
		orderService.newPurchase(orderJson);	
    
		return Response.ok().build();
	}
	
	
	
	


}
