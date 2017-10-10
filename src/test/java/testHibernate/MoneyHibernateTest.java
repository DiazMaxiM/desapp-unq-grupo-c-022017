package testHibernate;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.Money;
import model.Symbol;
import services.MoneyService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })

public class MoneyHibernateTest {

	@Autowired
	private MoneyService moneyService;

	@Test
	public void testSaveTimeZone() {
		moneyService.save(new Money(Symbol.ARG));
		List<Money> a = moneyService.retriveAll();

		assertEquals(1, a.size());
		assertEquals(Symbol.ARG, a.get(0).getSymbol());

	}

}
