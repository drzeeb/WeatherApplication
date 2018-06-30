package de.fh.albsig.zeebmich.errorhelper;

/**
 * The Class ErrorHelper.
 */
public class ErrorHelper {

/**
 * Throw error XML.
 *
 * @param title of the errormessage
 * @param description error description
 * @return the error as xml
 */
	private String title, description;

	/**
	 * Instantiates a new error helper.
	 */
	public ErrorHelper() {
	}

	/**
	 * Instantiates a new error helper.
	 *
	 * @param strTitle errortitle
	 * @param strDescription errordescription
	 */
	public ErrorHelper(final String strTitle, final String strDescription) {
		this.title = strTitle;
		this.description = strDescription;
	}

	/**
	 * Throw error XML.
	 *
	 * @return Error as XML
	 */
	public final String throwErrorXML() {
		StringBuilder xmlBuilder = new StringBuilder("<?xml "
				+ "version=\"1.0\""
				+ " encoding=\"UTF-8\"?>");
		xmlBuilder.append("<error>");
		xmlBuilder.append("<title>" + title + "</title>");
		xmlBuilder.append("<description>" + description
				+ "</description>");
		xmlBuilder.append("</error>");
		return xmlBuilder.toString();
	}

	/**
	 * Gets the title.
	 *
	 * @return error title
	 */
	public final String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param strTitle of errormessage
	 */
	public final void setTitle(final String strTitle) {
		this.title = strTitle;
	}

	/**
	 * Gets the description.
	 *
	 * @return errordescription
	 */
	public final String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param strDescription of error
	 */
	public final void setDescription(final String strDescription) {
		this.description = strDescription;
	}

}
