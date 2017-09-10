package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import org.joda.time.DateTime;

import com.google.gson.Gson;

public class HolidaysChecker<V> {

	public Boolean isHolidays(DateTime date) throws IOException {

		String year = new Integer(date.getYear()).toString();
		String month = new Integer(date.getMonthOfYear()).toString();
		String day = new Integer(date.getDayOfMonth()).toString();
		URL url = new URL("http://nolaborables.com.ar/api/v2/feriados/".concat(year));
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String message = org.apache.commons.io.IOUtils.toString(rd);

		ArrayList<?> yourList = new Gson().fromJson(message, ArrayList.class);

		Long count = yourList.stream().filter(predicate -> new Gson().toJsonTree(predicate).getAsJsonObject().get("dia")
				.getAsInt() == new Integer(day)
				&& new Gson().toJsonTree(predicate).getAsJsonObject().get("mes").getAsInt() == new Integer(month))
				.count();

		return count > 0;
	}
}
