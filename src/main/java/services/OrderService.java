package services;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDateTime;
import org.springframework.transaction.annotation.Transactional;

import exception.BalanceInsufficient;
import exception.InvalidClientException;
import exception.InvalidMenuException;
import exception.InvalidProviderException;
import exception.InvalidPurchaseException;
import exception.InvalidTimeZoneException;
import exception.NumberOfMenusExceededException;
import exception.PendingScoreException;
import miniObjects.OrderJson;
import model.Menu;
import model.Order;
import model.Provider;
import model.Score;
import model.ScoringManager;
import model.TimeZone;
import model.TypeOfDelivery;
import model.User;
import orderExceptions.InvalidDateOfDeliveryException;
import orderExceptions.InvalidDeliveryTimeException;
import orderExceptions.InvalidNumberOfMenusToOrderException;
import orderExceptions.InvalidTypeOfDeliveryException;
import repositories.OrderRepository;

import serviceException.InvalidDeliveryLocation;
import validation.InvalidFormatTimeZoneException;
import validation.SaleValidation;

public class OrderService extends GenericService<Order> {

	private static final long serialVersionUID = -2932116622242535843L;
    
	private MenuService menuService;
	private UserService userService; 
	private ScoreService scoreService; 
	
	public void setScoreService(final ScoreService scoreService) {
		this.scoreService = scoreService;
	}
	
	public void setMenuService(final MenuService menuService) {
		this.menuService = menuService;
	}

	public void setUserService(final UserService userService) {
		this.userService = userService;
	}
	

	
	@Transactional
	public void newPurchase(OrderJson order) throws NumberFormatException, InvalidMenuException, InvalidClientException, InvalidProviderException, InvalidNumberOfMenusToOrderException, InvalidTypeOfDeliveryException, InvalidDateOfDeliveryException, InvalidDeliveryTimeException, ParseException, InvalidTimeZoneException, InvalidFormatTimeZoneException, BalanceInsufficient, PendingScoreException, InvalidPurchaseException, NumberOfMenusExceededException, InvalidDeliveryLocation, IOException {
		
		User client= userService.getUser(order.getClient());
		Provider provider = (Provider) userService.getUser(order.getProvider()); 
		Menu menu = menuService.getMenuById(Integer.valueOf(order.getMenu())); 
		TimeZone deliveryTime = new TimeZone(order.getStartTimeDelivery(),order.getEndTimeDelivery());
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = formatter.parse(order.getDateDelivery());
		LocalDateTime dayOfDelivery = new org.joda.time.LocalDateTime(date);
		List<Score> scores = scoreService.getAllScore();
		
		Order newOrder= new Order(menu,new Integer(order.getCountMenu()),TypeOfDelivery.valueOf(order.getTypeDelivery()),
				dayOfDelivery,deliveryTime,client,provider);
		
		ScoringManager scoringManager = new ScoringManager();
		scoringManager.setScoresList(scores);
		OrderRepository repo = (OrderRepository) this.getRepository();
		SaleValidation validator = new SaleValidation(scoringManager);
		if(validator.isValidSale(newOrder)) {
			repo.save(newOrder);
		}
		
	}

}
