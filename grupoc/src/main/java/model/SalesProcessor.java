package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

public class SalesProcessor extends Thread {
	private SalesAdministration salesAdministration;

	public SalesProcessor(SalesAdministration salesAdministration) {
		this.salesAdministration = salesAdministration;
	}

	public void run() {
		DateTime tomorrowDay = DateTime.now().plusDays(1).toDateTime();

		List<Order> ordersForTomorrow = this.salesAdministration.getSalesForDay(tomorrowDay);

		Map<Menu, Long> menusCount = countMenusForType(ordersForTomorrow);

		for (Order order : ordersForTomorrow) {
			if (hasMinimumCountOrders(menusCount, order)) {
				cancelTransactionClientProvider(order);
			}

		}
	}

	private void cancelTransactionClientProvider(Order order) {
		order.getTransactionClient().setRejected();
		order.getTransactionClient().setRejected();
	}

	private boolean hasMinimumCountOrders(Map<Menu, Long> menusCount, Order order) {
		return menusCount.get(order.getMenuToOrder()) < order.getMenuToOrder().getFirstMinimumNumberOfMenusToBuy();
	}

	private Map<Menu, Long> countMenusForType(List<Order> ordersForTomorrow) {
		Map<Menu, Long> menusCount = ordersForTomorrow.stream()
				.collect(Collectors.groupingBy(Order::getMenuToOrder, Collectors.counting()));
		return menusCount;
	}
}
