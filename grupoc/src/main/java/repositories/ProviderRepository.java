package repositories;

import java.util.List;

import model.User;

public class ProviderRepository extends HibernateGenericDAO<User> implements GenericRepository<User> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<User> getDomainClass() {
		return User.class;
	}

	public User findByEmail(String email) {
		List<User> find = (List<User>) this.getHibernateTemplate()
				.find("from " + this.persistentClass.getName() + " where mail ='" + email + "'");
		List<User> list = find;
		return list.get(0);
	}
	public User findById(String id) {
		List<User> find = (List<User>) this.getHibernateTemplate()
				.find("from " + this.persistentClass.getName() + " where id ='" + id + "'");
		List<User> list = find;
		return list.get(0);
	}
}
