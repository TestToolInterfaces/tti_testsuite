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
	
	private TestLink myLink;

	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTcLink			Link to Test Case File
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     TestLink aTcLink,
	                     Hashtable<String, String> anAnyAttributes,
						 Hashtable<String, String> anAnyElements )
	{
		super(aTestCaseId, TestEntry.TYPE.CaseLink, "", aSequenceNr, anAnyAttributes, anAnyElements );

		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseLink( " + aTestCaseId + ", " 
					                    + aSequenceNr + ", "
					                    + aTcLink.getPath() + ", "
					                    + anAnyAttributes.size() + ", "
					                    + anAnyElements.size() + " )",
					   true );

		myLink = aTcLink;
	}

	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTcLinkName		Test Case File Name
	 * @param aType				Type of the TC File
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     String aTcLinkName,
	                     String aType,
	                     Hashtable<String, String> anAnyAttributes,
						 Hashtable<String, String> anAnyElements )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      new TestLinkImpl( aTcLinkName, aType ),
		      anAnyAttributes,
		      anAnyElements );
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTcLinkName		Test Case File Name
	 * @param aType				Type of the TC File
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     String aTcLinkName,
	                     String aType )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      new TestLinkImpl( aTcLinkName, aType ),
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor for default type and without unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTcLinkName		Test Case File Name
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     String aTcLinkName )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      new TestLinkImpl( aTcLinkName, TYPE_TTI ),
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

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
	@Deprecated
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     File aTestCaseLink,
	                     String aType,
	                     Hashtable<String, String> anAnyAttributes,
						 Hashtable<String, String> anAnyElements )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      new TestLinkImpl( aTestCaseLink.getPath(), aType ),
		      anAnyAttributes,
		      anAnyElements );
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestCaseLink		Test Case File
	 * @param aType				Type of the TC File
	 */
	@Deprecated
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     File aTestCaseLink,
	                     String aType )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      new TestLinkImpl( aTestCaseLink.getPath(), aType ),
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
	@Deprecated
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     File aTestCaseLink )
	{
		this( aTestCaseId,
		      aSequenceNr,
		      new TestLinkImpl( aTestCaseLink.getPath(), TYPE_TTI ),
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the Test Case File
	 */
	public File getLink()
	{
		return myLink.getFile();
	}

	/**
	 * @param aLink	The TC Link.
	 */
	public void setLink(TestLink aLink)
	{
		myLink = aLink;
	}

	/**
	 * @return the type of the Test Case File
	 */
	public String getLinkType()
	{
		return myLink.getType();
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
		if ( ! myLink.getFile().isAbsolute() )
		{
			myLink = new TestLinkImpl( aLinkDir, myLink.getPath(), myLink.getType() );
		}
	}
}
