package de.fh.albsig.zeebmich;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.log4j.Logger;

import de.fh.albsig.zeebmich.service.WeatherService;

/**
 * The Class WeatherServiceTest.
 */
public class WeatherServiceTest {

	/** The log. */
	Logger log = Logger.getLogger(WeatherServiceTest.class.getName());

	/**
	 * Test weather service.
	 */
	@Test
	public void testWeatherService() {
		WeatherService ws = new WeatherService();
		try {
			assertTrue(ws.retrieveForecast("Albstadt") != null);
		} catch (Exception e) {
			log.warn(e.getMessage());
		}

	}
}
