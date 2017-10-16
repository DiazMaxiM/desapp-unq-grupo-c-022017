package repositories;

import model.Price;

public class PriceRepository extends HibernateGenericDAO<Price> implements GenericRepository<Price> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Price> getDomainClass() {
		return Price.class;
	}
}