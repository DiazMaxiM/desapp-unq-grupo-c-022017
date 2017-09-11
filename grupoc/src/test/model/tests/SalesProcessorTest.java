package tests;

import static org.mockito.Mockito.never;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.mockito.Mockito;

import model.Mail;
import model.Menu;
import model.Order;
import model.Price;
import model.SalesAdministration;
import model.SalesProcessor;
import model.Transaction;

public class SalesProcessorTest {

	@Test
	public void test() {

		List<Order> ordersList = new ArrayList<Order>();

		Transaction TransactionClientOrder1 = Mockito.mock(Transaction.class);
		Transaction TransactionProviderOrder1 = Mockito.mock(Transaction.class);
		Transaction TransactionClientOrder2 = Mockito.mock(Transaction.class);
		Transaction TransactionProviderOrder2 = Mockito.mock(Transaction.class);
		Transaction TransactionClientOrder3 = Mockito.mock(Transaction.class);
		Transaction TransactionProviderOrder3 = Mockito.mock(Transaction.class);
		Transaction TransactionClientOrder4 = Mockito.mock(Transaction.class);
		Transaction TransactionProviderOrder4 = Mockito.mock(Transaction.class);

		Price priceMinimumMenu1 = Mockito.mock(Price.class);
		Price priceMaximunMenu1 = Mockito.mock(Price.class);

		Mockito.when(priceMinimumMenu1.getValue()).thenReturn(5.0);
		Mockito.when(priceMaximunMenu1.getValue()).thenReturn(2.5);

		Price priceMinimumMenu2 = Mockito.mock(Price.class);
		Price priceMaximunMenu2 = Mockito.mock(Price.class);

		Mockito.when(priceMinimumMenu2.getValue()).thenReturn(10.0);
		Mockito.when(priceMaximunMenu2.getValue()).thenReturn(6.0);

		Menu menu1 = Mockito.mock(Menu.class);

		Mockito.when(menu1.getFirstMinimumNumberOfMenusToBuy()).thenReturn(2);
		Mockito.when(menu1.getSecondMinimumNumberOfMenusToBuy()).thenReturn(3);
		Mockito.when(menu1.getFirstminimumPriceOfMenusToBuy()).thenReturn(priceMinimumMenu1);
		Mockito.when(menu1.getSecondMinimumPriceOfMenusToBuy()).thenReturn(priceMaximunMenu1);

		Menu menu2 = Mockito.mock(Menu.class);

		Mockito.when(menu2.getFirstMinimumNumberOfMenusToBuy()).thenReturn(1);
		Mockito.when(menu2.getSecondMinimumNumberOfMenusToBuy()).thenReturn(3);
		Mockito.when(menu2.getFirstminimumPriceOfMenusToBuy()).thenReturn(priceMinimumMenu1);
		Mockito.when(menu2.getSecondMinimumPriceOfMenusToBuy()).thenReturn(priceMaximunMenu1);

		Order order1 = Mockito.mock(Order.class);
		Order order2 = Mockito.mock(Order.class);
		Order order3 = Mockito.mock(Order.class);
		Order order4 = Mockito.mock(Order.class);

		Mockito.when(order1.getMenuToOrder()).thenReturn(menu1);
		Mockito.when(order2.getMenuToOrder()).thenReturn(menu1);
		Mockito.when(order4.getMenuToOrder()).thenReturn(menu1);
		Mockito.when(order3.getMenuToOrder()).thenReturn(menu2);

		Mockito.when(order1.getTransactionClient()).thenReturn(TransactionClientOrder1);
		Mockito.when(order2.getTransactionClient()).thenReturn(TransactionClientOrder2);
		Mockito.when(order3.getTransactionClient()).thenReturn(TransactionClientOrder3);
		Mockito.when(order4.getTransactionClient()).thenReturn(TransactionClientOrder4);

		Mockito.when(order1.getTransactionProvider()).thenReturn(TransactionProviderOrder1);
		Mockito.when(order2.getTransactionProvider()).thenReturn(TransactionProviderOrder2);
		Mockito.when(order3.getTransactionProvider()).thenReturn(TransactionProviderOrder3);
		Mockito.when(order4.getTransactionProvider()).thenReturn(TransactionProviderOrder4);

		ordersList.add(order1);
		ordersList.add(order2);
		ordersList.add(order3);
		ordersList.add(order4);

		Mail mail = Mockito.mock(Mail.class);
		SalesAdministration salesAdministration = Mockito.mock(SalesAdministration.class);
		Mockito.when(salesAdministration.getSalesForDay(new DateTime(2017, 9, 11, 0, 0))).thenReturn(ordersList);

		SalesProcessor salesProcessor = new SalesProcessor(salesAdministration, mail);

		salesProcessor.run();

		Mockito.verify(TransactionClientOrder1).setValue(2.5);
		Mockito.verify(TransactionClientOrder2).setValue(2.5);
		Mockito.verify(TransactionClientOrder4).setValue(2.5);
		Mockito.verify(TransactionProviderOrder1).setValue(2.5);
		Mockito.verify(TransactionProviderOrder2).setValue(2.5);
		Mockito.verify(TransactionProviderOrder4).setValue(2.5);
		Mockito.verify(TransactionClientOrder3, never()).setValue(6.0);

	}

}
