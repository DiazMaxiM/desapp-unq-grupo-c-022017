package repositories;

import model.Account;

public class AccountRepository extends HibernateGenericDAO<Account> implements GenericRepository<Account> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Account> getDomainClass() {
		return Account.class;
	}
}