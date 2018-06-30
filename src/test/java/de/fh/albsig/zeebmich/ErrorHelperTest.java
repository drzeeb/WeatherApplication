package de.fh.albsig.zeebmich;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import de.fh.albsig.zeebmich.errorhelper.ErrorHelper;

/**
 * The Class ErrorHelperTest.
 */
public class ErrorHelperTest {
	/**
	 * Test return of error helper.
	 */
	@Test
	public void testReturnOfErrorHelper() {
		ErrorHelper eh = new ErrorHelper("FOO", "BAR");
		assertTrue(!"".equals(eh.throwErrorXML()) || eh.throwErrorXML() != null);
	}

	/**
	 * Test getters.
	 */
	@Test
	public void testGetters() {
		ErrorHelper eh = new ErrorHelper("FOO", "BAR");

		assertTrue(eh.getDescription() != null);
		assertTrue(eh.getTitle() != null);
	}

	@Test
	public void testSetters() {
		ErrorHelper eh = new ErrorHelper();
		eh.setTitle("FOO");
		eh.setDescription("BAR");

		assertTrue("FOO".equals(eh.getTitle()));
		assertTrue("BAR".equals(eh.getDescription()));
	}
}
