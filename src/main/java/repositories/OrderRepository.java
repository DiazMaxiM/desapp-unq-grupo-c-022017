package repositories;

import model.Order;

public class OrderRepository extends HibernateGenericDAO<Order> implements GenericRepository<Order> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Order> getDomainClass() {
		return Order.class;
	}
}