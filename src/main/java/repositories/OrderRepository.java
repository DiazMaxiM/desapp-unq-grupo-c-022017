package repositories;

import java.util.List;

import model.Menu;
import model.Order;

public class OrderRepository extends HibernateGenericDAO<Order> implements GenericRepository<Order> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Order> getDomainClass() {
		return Order.class;
	}

	public List<Order> findOrderForUser(String idUser) {
		List<Order> find = (List<Order>) this.getHibernateTemplate()
				.find("select o from Order o where o.client.idClient = '" + idUser + "'");
		return find;
		
	}
}