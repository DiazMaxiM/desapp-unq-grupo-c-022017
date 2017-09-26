package testHibernate;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import model.MapPosition;
import services.MapPositionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })

public class MapPositionHibernateTest {

	@Autowired
	private MapPositionService mapPositionService;

	@Test
	public void testSaveMapPosition() {
		mapPositionService.save(new MapPosition());
		assertEquals(1, mapPositionService.retriveAll().size());

	}

}