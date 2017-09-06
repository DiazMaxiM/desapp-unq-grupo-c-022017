package model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.joda.time.DateTime;

public class SalesProcessor extends Thread {
	private SalesAdministration salesAdministration;
	private Mail mail;

	public SalesProcessor(SalesAdministration salesAdministration, Mail mail) {
		this.salesAdministration = salesAdministration;
		this.mail = mail;
	}

	public void run() {
		DateTime tomorrowDay = DateTime.now().plusDays(1).toDateTime();

		List<Order> ordersForTomorrow = this.salesAdministration.getSalesForDay(tomorrowDay);

		Map<Menu, Long> menusCount = countMenusForType(ordersForTomorrow);

		for (Order order : ordersForTomorrow) {
			if (applySecondPriceForMenus(menusCount, order)) {
				refreshPriceForSaleSecond(order);
			} else {
				if (applyFirstPriceForMenus(menusCount, order)) {
					refreshPriceForSaleFirst(order);
				}
			}
			sendMailsToConfirm(order);
		}
	}

	private boolean applyFirstPriceForMenus(Map<Menu, Long> menusCount, Order order) {
		return menusCount.get(order.getMenuToOrder()) < order.getMenuToOrder().getSecondMinimumNumberOfMenusToBuy()
				&& menusCount.get(order.getMenuToOrder()) >= order.getMenuToOrder().getFirstMinimumNumberOfMenusToBuy();

	}

	private void refreshPriceForSaleFirst(Order order) {
		order.getTransactionClient().setValue(order.getMenuToOrder().getFirstminimumPriceOfMenusToBuy().getValue());
		order.getTransactionProvider().setValue(order.getMenuToOrder().getFirstminimumPriceOfMenusToBuy().getValue());

	}

	private void sendMailsToConfirm(Order order) {
		try {
			mail.sendMailConfirmSaleProvider(order.getProvider().getEmail());
			mail.sendMailConfirmSaleClient(order.getClient().getEmail());
		} catch (Exception e) {
			// TODO Revisar

		}

	}

	private void refreshPriceForSaleSecond(Order order) {
		order.getTransactionClient().setValue(order.getMenuToOrder().getSecondMinimumPriceOfMenusToBuy().getValue());
		order.getTransactionProvider().setValue(order.getMenuToOrder().getSecondMinimumPriceOfMenusToBuy().getValue());
	}

	private boolean applySecondPriceForMenus(Map<Menu, Long> menusCount, Order order) {
		return menusCount.get(order.getMenuToOrder()) >= order.getMenuToOrder().getSecondMinimumNumberOfMenusToBuy();
	}

	private Map<Menu, Long> countMenusForType(List<Order> ordersForTomorrow) {
		Map<Menu, Long> menusCount = ordersForTomorrow.stream()
				.collect(Collectors.groupingBy(Order::getMenuToOrder, Collectors.counting()));
		return menusCount;
	}
}
