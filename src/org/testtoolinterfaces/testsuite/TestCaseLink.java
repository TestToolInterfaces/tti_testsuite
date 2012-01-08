package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for a link to a Test Case.
 * TestCaseLinks all have an Id, a Type, a sequenceNr, and a link to a File.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestCaseLink extends TestEntryImpl
{
	public static final String TYPE_TTI = "tti";
	
	private String myType;
	private File myLink;

	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestCaseLink		Test Case File
	 * @param aType				Type of the TC File
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     File aTestCaseLink,
	                     String aType,
	                     Hashtable<String, String> anAnyAttributes,
						 Hashtable<String, String> anAnyElements )
	{
		super(aTestCaseId, TestEntry.TYPE.CaseLink, "", aSequenceNr, anAnyAttributes, anAnyElements );

		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseLink( " + aTestCaseId + ", " 
					                    + aSequenceNr + ", "
					                    + aTestCaseLink.getPath() + ", "
					                    + aType + ", "
					                    + anAnyAttributes.size() + ", "
					                    + anAnyElements.size() + " )",
					   true );

		myType = aType;
		myLink = aTestCaseLink;
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestCaseLink		Test Case File
	 * @param aType				Type of the TC File
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     File aTestCaseLink,
	                     String aType )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      aTestCaseLink,
		      aType,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor for type 'tti' without unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestCaseLink		Test Case File
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     File aTestCaseLink )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      aTestCaseLink,
		      TYPE_TTI,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the Test Case File
	 */
	public File getLink()
	{
		return myLink;
	}

	/**
	 * @return the type of the Test Case File
	 */
	public String getLinkType()
	{
		return myType;
	}

	/**
	 * Sets the directory of the TC Link.
	 * 
	 * Only if the TC Link is not already absolute.
	 * This will change the stored TC link.
	 * 
	 * @param aLinkDir	The directory to set to the TC Link.
	 */
	public void setLinkDir( File aLinkDir )
	{
		if ( ! myLink.isAbsolute() )
		{
			myLink = new File( aLinkDir, myLink.getPath() );
		}
	}
}
