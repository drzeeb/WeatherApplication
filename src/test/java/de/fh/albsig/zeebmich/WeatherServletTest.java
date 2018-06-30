package de.fh.albsig.zeebmich;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.mockito.Mockito;

import de.fh.albsig.zeebmich.servlets.WeatherServlet;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * The Class WeatherServletTest.
 */
public class WeatherServletTest extends Mockito {

	/**
	 * Test request.
	 *
	 * @throws ServletException
	 *             the servlet exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	@Test
	public void testRequest() throws ServletException, IOException {

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);

		when(request.getParameter("city")).thenReturn("Albstadt");
		StringWriter stringWriter = new StringWriter();
		PrintWriter writer = new PrintWriter(stringWriter);
		when(response.getWriter()).thenReturn(writer);

		new WeatherServlet().doGet(request, response);

		assertTrue(stringWriter != null);
		assertFalse(stringWriter.toString().equals(""));
	}
}
