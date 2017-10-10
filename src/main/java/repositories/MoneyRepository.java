package repositories;

import model.Money;

public class MoneyRepository extends HibernateGenericDAO<Money> implements GenericRepository<Money> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Money> getDomainClass() {
		return Money.class;
	}
}