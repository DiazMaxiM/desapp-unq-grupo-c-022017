package repositories;

import model.TimeZone;

public class TimeZoneRepository extends HibernateGenericDAO<TimeZone> implements GenericRepository<TimeZone> {

    private static final long serialVersionUID = -8543996946304099004L;

    @Override
    protected Class<TimeZone> getDomainClass() {
        return TimeZone.class;
    }
}