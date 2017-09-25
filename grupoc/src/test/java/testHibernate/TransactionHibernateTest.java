package testHibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Transaction;
import model.TypeTransaction;
import services.TransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })

public class TransactionHibernateTest {

	@Autowired
	private TransactionService transactionService;

	@Test
	public void testSaveTimeZone() {
		transactionService.save(new Transaction(TypeTransaction.CREDIT, 5.0));
		assertEquals(1, transactionService.retriveAll().size());
	}

}
