package tests;

import java.io.IOException;

import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import model.HolidaysChecker;

public class HolidaysCheckerTest {

	@Ignore
	@Test
	public void test() throws IOException {
		HolidaysChecker h = new HolidaysChecker();
		Assert.assertTrue(h.isHolidays(new DateTime(2017, 1, 1, 0, 0).toLocalDateTime()));
		Assert.assertFalse(h.isHolidays(new DateTime(2017, 2, 1, 0, 0).toLocalDateTime()));
	}

}
