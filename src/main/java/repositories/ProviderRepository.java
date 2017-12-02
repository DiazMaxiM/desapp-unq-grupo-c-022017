package repositories;

import java.util.List;

import model.Provider;
import model.User;

public class ProviderRepository extends HibernateGenericDAO<Provider> implements GenericRepository<Provider> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Provider> getDomainClass() {
		return Provider.class;
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

	public User byIdService(Integer id) {
		List<User> find = (List<User>) this.getHibernateTemplate()
				.find("select p from Provider p  where  (select s from Service s where s.id ='" + id
						+ "' ) in  elements(p.servicesOffered)");
		List<User> list = find;
		return list.get(0);
	}
}
