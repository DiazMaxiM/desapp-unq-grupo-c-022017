package repositories;

import java.util.List;

import model.Menu;

public class MenuRepository extends HibernateGenericDAO<Menu> implements GenericRepository<Menu> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Menu> getDomainClass() {
		return Menu.class;
	}

	public List<Menu> findMenuForName(String name) {
		List<Menu> find = (List<Menu>) this.getHibernateTemplate()
				.find("from " + this.persistentClass.getName() + " where menuName ='" + name + "'");
		return find;
	}

	public List<Menu> findMenuForCategory(String category) {
		List<Menu> find = (List<Menu>) this.getHibernateTemplate()
				.find("from " + this.persistentClass.getName() + " where menuCategory ='" + category + "'");
		return find;
	}

	public List<Menu> findMenuForLocality(String locality) {
		@SuppressWarnings("unchecked")
		List<Menu> find2 = (List<Menu>) this.getHibernateTemplate()
				.find("select m from Menu m inner join m.service as s where '" + locality
						+ "' in  elements(s.serviceDeliveryLocations)  ");
		List<Menu> find = find2;
		return find;
	}

	public Object findMenuForService(String idService) {
		List<Menu> find = (List<Menu>) this.getHibernateTemplate()
				.find("select m from Menu m where m.service.id = '" + idService + "'");
		return find;
	}

}