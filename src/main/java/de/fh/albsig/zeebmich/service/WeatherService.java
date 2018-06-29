package de.fh.albsig.zeebmich.service;

import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import org.apache.log4j.Logger;
import org.apache.commons.io.IOUtils;

public class WeatherService {
	private static Logger log = Logger.getLogger(WeatherService.class.getName());

	public String retrieveForecast(String city) throws Exception {
		log.info("get weather");
		String weatherData = "";

		URL url = new URL("https://query.yahooapis.com/v1/public/yql?q=select%20*%20"
				+ "from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20"
				+ "from%20geo.places(1)%20where%20text%3D%22" + city + "%22)and%20u%3D%22c%22");
		URLConnection urlc = url.openConnection();
		weatherData = IOUtils.toString(urlc.getInputStream(), StandardCharsets.UTF_8);
		return weatherData;
	}
}
