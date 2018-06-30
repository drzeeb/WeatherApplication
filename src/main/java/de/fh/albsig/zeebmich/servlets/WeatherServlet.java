package de.fh.albsig.zeebmich.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import de.fh.albsig.zeebmich.errorhelper.ErrorHelper;
import de.fh.albsig.zeebmich.service.WeatherService;

/**
 * The Class WeatherServlet.
 */
public class WeatherServlet extends HttpServlet {

	private static final long serialVersionUID = -6004602445517820628L;
	/** The log. */
	private static final Logger log = Logger.
			getLogger(WeatherServlet.class.getName());

	/**
   * Handles the get request and returns
   * weatherdata as xml.
   *
   * @see HttpServlet#doGet(HttpServletRequest request,
   * HttpServletResponse response).
   * @param request request from user
   * @param response response from server
   * @throws ServletException if something goes wrong in the servlet
   * @throws IOException if doGet fails on IO handling
   */
	public final void doGet(final HttpServletRequest request, 
			final HttpServletResponse response)
			throws ServletException, IOException {
		ErrorHelper eh = null;
		WeatherService weatherService = new WeatherService();
		String city = request.getParameter("city");
		log.info("Check if city is null or empty");
		if (city == null || "".equals(city)) {
			log.warn("city is null or empty");
			eh = new ErrorHelper("City missing",
					"Please add a city as parameter");
			response.getWriter().append(eh.throwErrorXML());
		}
		if (eh == null) {
			log.info("City: " + city);
			try {
				response.getWriter().append(weatherService.
						retrieveForecast(city));
			} catch (Exception e) {
				eh = new ErrorHelper(e.toString(),
						e.getMessage());
				response.getWriter().append(eh.throwErrorXML());
			}
		}
	}

	/**
	   * Handles the get request 
	   * and call doGet with params from itself.
	   *
	   * @see HttpServlet#doGet(HttpServletRequest request,
	   * HttpServletResponse response).
	   * @param request request from user
	   * @param response response from server
	   * @throws ServletException if something goes wrong in the servlet
	   * @throws IOException if doPost fails on IO handling
	   */
	public final void doPost(final HttpServletRequest request,
			final HttpServletResponse response)
			throws ServletException, IOException {
		// Learnd from Prof. Dr. Nemirowskij
		doGet(request, response);
	}
}
