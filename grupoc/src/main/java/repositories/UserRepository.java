package repositories;

import model.User;

public class UserRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}

}
