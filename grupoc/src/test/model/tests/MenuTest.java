package tests;
import org.junit.Test;

import builder.MenuBuilder;
import exception.InvalidMenuCategoryException;
import exception.InvalidMenuDeliveryPriceException;
import exception.InvalidMenuDescriptionException;
import exception.InvalidMenuException;
import exception.InvalidMenuNameException;
import model.Menu;

public class MenuTest {

	@Test(expected=InvalidMenuNameException.class)
	public void testShouldFailWhenICreateAnInvalidMenu() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException {
		new Menu(null,null,null,null,null, null, null, null, null, null, null, null, null, null, null);
	}
	
	@Test()
	public void testShouldPassWhenICreateAValidMenu() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException {
		new MenuBuilder()
		.build();
	}
	
	@Test(expected=InvalidMenuNameException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortName() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException {
		new MenuBuilder()
		.withMenuName("ppp")
		.build();
	}
	
	@Test(expected=InvalidMenuDescriptionException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithAShortDescription() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException {
		new MenuBuilder()
		.withMenuDescription("ppp")
		.build();
	}
	@Test(expected=InvalidMenuCategoryException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalidCategory() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException {
		new MenuBuilder()
		.withMenuCategory(null)
		.build();
	}
	
	@Test(expected=InvalidMenuDeliveryPriceException.class)
	public void testShouldFailWhenICreateAnInvalidMenuWithInvalid() throws InvalidMenuException, InvalidMenuNameException, InvalidMenuDescriptionException, InvalidMenuCategoryException {
		new MenuBuilder()
		.withMenuDeliveryPrice(new Double(50))
		.build();
	}
	
}
