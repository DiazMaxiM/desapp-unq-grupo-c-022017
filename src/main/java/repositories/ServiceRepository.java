package repositories;

import model.Service;

public class ServiceRepository extends HibernateGenericDAO<Service> implements GenericRepository<Service> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Service> getDomainClass() {
		return Service.class;
	}

}