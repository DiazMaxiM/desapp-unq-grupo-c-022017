package repositories;

import model.Address;

public class AddressRepository extends HibernateGenericDAO<Address> implements GenericRepository<Address> {

    private static final long serialVersionUID = -8543996946304099004L;

    @Override
    protected Class<Address> getDomainClass() {
        return Address.class;
    }
}
