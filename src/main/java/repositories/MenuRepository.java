package repositories;

import model.Menu;

public class MenuRepository extends HibernateGenericDAO<Menu> implements GenericRepository<Menu> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Menu> getDomainClass() {
		return Menu.class;
	}
}