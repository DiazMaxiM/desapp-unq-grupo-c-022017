package tests;
import org.junit.Test;

import builder.MenuBuilder;
import exception.InvalidDeliveryPriceException;
import exception.InvalidEndDateOfferMenuException;
import exception.InvalidMenuCategoryException;
import exception.InvalidMenuDeliveryPriceException;
import exception.InvalidMenuDescriptionException;
import exception.InvalidMenuException;
import exception.InvalidMenuNameException;
import exception.InvalidStartDateOfferMenuException;
import model.Menu;

public class MenuTest {

	@Test(expected=InvalidMenuNameException.class)
	public void testShouldFailWhenICreateAnInvalidMenu() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException {
		new Menu(null,null,null,null,null, null, null, null, null, null, null, null, null, null, null);
	}
	
	@Test()
	public void testShouldPassWhenICreateAValidMenu() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException {
		new MenuBuilder()
		.build();
	}
	
	@Test(expected=InvalidMenuNameException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortName() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException {
		new MenuBuilder()
		.withMenuName("ppp")
		.build();
	}
	
	@Test(expected=InvalidMenuDescriptionException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortDescription() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException {
		new MenuBuilder()
		.withMenuDescription("ppp")
		.build();
	}
	@Test(expected=InvalidMenuCategoryException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidCategory() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException {
		new MenuBuilder()
		.withMenuCategory(null)
		.build();
	}
	
	@Test(expected=InvalidMenuDeliveryPriceException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidMenu() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException {
		new MenuBuilder()
		.withMenuDeliveryPrice(new Double(50))
		.build();
	}
	
	@Test(expected=InvalidStartDateOfferMenuException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidisinValidStartDateOfferMenu() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException, InvalidDeliveryPriceException, InvalidStartDateOfferMenuException, InvalidEndDateOfferMenuException, InvalidMenuDeliveryPriceException {
		new MenuBuilder()
		.withStartDateOfferMenu(null)
		.build();
	}
	

	
}
