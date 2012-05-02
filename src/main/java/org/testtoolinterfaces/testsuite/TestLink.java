package org.testtoolinterfaces.testsuite;

import java.io.File;

/**
 * Interface for links to Test Groups or Test Case files.
 * TestLinks have a {@link java.io.File File} and a Type to indicate the format of the file.
 * 
 * @author Arjan
 *
 */
public interface TestLink
{
	public static final String TYPE_TTI = "tti";

	/**
	 * @return File object of this link (will loose the type)
	 */
	public File getFile();
	
	/**
	 * @return the type of this Test link
	 */
	public String getType();

	// Methods below are basically the same as for java.io.File
	
	/* (non-Javadoc)
	 * @see java.io.File#getAbsoluteFile()
	 */
	public File getAbsoluteFile();

	/* (non-Javadoc)
	 * @see java.io.File#getParentFile()
	 */
	public File getParentFile();

	/* (non-Javadoc)
	 * @see java.io.File#getPath()
	 */
	public String getPath();

	/* (non-Javadoc)
	 * @see java.io.File#getAbsolutePath()
	 */
	public String getAbsolutePath();

	/* (non-Javadoc)
	 * @see java.io.File#getParent()
	 */
	public String getParent();

	/* (non-Javadoc)
	 * @see java.io.File#getName()
	 */
	public String getName();
}