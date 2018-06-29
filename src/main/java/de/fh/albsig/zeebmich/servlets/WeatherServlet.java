package de.fh.albsig.zeebmich.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import de.fh.albsig.zeebmich.service.WeatherService;

public class WeatherServlet extends HttpServlet {

	private Logger log = Logger.getLogger(WeatherServlet.class.getName());
	private static final long serialVersionUID = 1L;

	public final void doGet(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		String city = request.getParameter("city");
		log.info("City: " + city);
		WeatherService weatherService = new WeatherService();
		try {
			System.out.print(weatherService.retrieveForecast(city));
		} catch (Exception e) {
			System.out.println("Error Retrieving Forecast: " + e.getMessage());
		}
	}

	public final void doPost(final HttpServletRequest request, final HttpServletResponse response)
			throws ServletException, IOException {
		// Learnd from Prof. Dr. Nemirowskj
		doGet(request, response);
	}
}
