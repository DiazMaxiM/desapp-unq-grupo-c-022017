package repositories;

import model.Telephone;

public class TelephoneRepository extends HibernateGenericDAO<Telephone> implements GenericRepository<Telephone> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<Telephone> getDomainClass() {
		return Telephone.class;
	}
}