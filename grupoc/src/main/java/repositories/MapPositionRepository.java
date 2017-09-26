package repositories;

import model.MapPosition;

public class MapPositionRepository extends HibernateGenericDAO<MapPosition> implements GenericRepository<MapPosition> {

	private static final long serialVersionUID = 1L;

	@Override
	protected Class<MapPosition> getDomainClass() {
		return MapPosition.class;
	}
}