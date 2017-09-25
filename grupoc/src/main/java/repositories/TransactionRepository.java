package repositories;

import model.Transaction;

public class TransactionRepository extends HibernateGenericDAO<Transaction> implements GenericRepository<Transaction> {

	private static final long serialVersionUID = -8543996946304099004L;

	@Override
	protected Class<Transaction> getDomainClass() {
		return Transaction.class;
	}
}