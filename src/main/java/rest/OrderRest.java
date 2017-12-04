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
import services.OrderService;
import validation.InvalidFormatTimeZoneException;


@Path("/")
public class OrderRest {

	public static final int NUMBER_OF_POST = 1;

	public OrderService orderService;
 
	public void setOrderService(final OrderService orderService) {
		this.orderService = orderService;
	} 
	
	@POST
	@Path("/newOrder")
	@Consumes("application/json") 
	@Produces("application/json")
	public Response newOrder(OrderJson orderJson) throws NumberFormatException, InvalidMenuException, InvalidClientException, InvalidProviderException, InvalidTimeZoneException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, NumberOfMenusExceededException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, ParseException, InvalidFormatTimeZoneException, InvalidDeliveryLocation, IOException {
	     					
		orderService.newPurchase(orderJson);	
    
		return Response.ok().build();
	}
	
	
	
	


}
