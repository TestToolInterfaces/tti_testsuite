package org.testtoolinterfaces.testsuite;

import java.io.File;

/**
 * Interface for TestExecutionItemLinks.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestExecItemLink extends TestGroupEntry
{
	public static final String TYPE_TTI = "tti";

	/**
	 * @return the TestItem File
	 */
	public File getLink();

	/**
	 * @param aLink	the TestItem Link.
	 */
	public void setLink(TestLink aLink);

	/**
	 * @return the type of the Test Link File
	 */
	public String getLinkType();

	/**
	 * Sets the directory of the Test Item Link.
	 * 
	 * Only if the Test Item Link is not already absolute.
	 * This will change the stored Test Item link.
	 * 
	 * @param aLinkDir	The directory to set to the Test Item Link.
	 */
	public void setLinkDir( File aLinkDir );
}