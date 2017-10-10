package testHibernate;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import model.TimeZone;
import services.TimeZoneService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml", "/META-INF/spring-services-context.xml" })

public class TimeZoneHibernateTest {

	 @Autowired
	    private TimeZoneService  timeZoneService;

	    @Test
	    public void testSaveTimeZone() {
	    	timeZoneService.save(new TimeZone());
	        assertEquals(1, timeZoneService.retriveAll().size());
	    }

	}

