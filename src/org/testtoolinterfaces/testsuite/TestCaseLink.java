package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;


public class TestCaseLink extends TestEntryImpl
{
	private String myType;
	private File myLink;
	private Hashtable<String,String> myAnyAttributes;

	/**
	 * @param aTestCaseId
	 * @param aType 
	 * @param aSequenceNr
	 * @param aLink
	 * @param anAnyAttributes
	 */
	public TestCaseLink( String aTestCaseId,
	                         String aType,
	                         int aSequenceNr,
	                         File aTestCaseLink,
	                         Hashtable<String, String> anAnyAttributes )
	{
		super(aTestCaseId, TestEntry.TYPE.CaseLink, "", aSequenceNr);

		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseLinkImpl( " + aTestCaseId + ", " 
					   						+ aType + ", "
					   						+ aSequenceNr + ", "
					   						+ aTestCaseLink.getPath() + ", "
					   						+ anAnyAttributes.size() + " )",
					   true );

		myType = aType;
		myLink = aTestCaseLink;
		myAnyAttributes = anAnyAttributes;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.testsuite.TestCaseLink#getScriptType()
	 */
	public String getScriptType()
	{
		return myType;
	}

	/**
	 * @return the myLink
	 */
	public File getLink()
	{
		return myLink;
	}

	/**
	 * @return the myAnyAttributes
	 */
	public Hashtable<String, String> getAnyAttributes()
	{
		return myAnyAttributes;
	}

	/**
	 * @param aLinkDir
	 */
	public void setLinkDir( File aLinkDir )
	{
		if ( ! myLink.isAbsolute() )
		{
			myLink = new File( aLinkDir, myLink.getPath() );
		}
	}
}
