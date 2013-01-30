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
	 * Constructor for type 'tti'
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestCaseLink		Test Case File
	 */
	public TestCaseLink(String aTestCaseId, int aSequenceNr, TestLink aTcLink) {
		super(aTestCaseId, TestEntry.TYPE.CaseLink, "", aSequenceNr );

		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseLink( " + aTestCaseId + ", " 
					                    + aSequenceNr + ", "
					                    + aTcLink.getPath() + " )",
					   true );

		myLink = aTcLink;
	}

	@Deprecated // Use constructor without anyAttributes and anyElements
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
		this( aTestCaseId, aSequenceNr, aTcLink );
		Trace.println( Trace.CONSTRUCTOR,
					   "TestCaseLink( " + aTestCaseId + ", " 
					                    + aSequenceNr + ", "
					                    + aTcLink.getPath() + ", "
					                    + anAnyAttributes.size() + ", "
					                    + anAnyElements.size() + " )",
					   true );

		this.setAnyAttributes(anAnyAttributes);
		this.setAnyElements(anAnyElements);
	}

	@Deprecated // Use constructor without anyAttributes and anyElements
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
		      (TestLink) new TestLinkImpl( aTcLinkName, aType ) );

		this.setAnyAttributes(anAnyAttributes);
		this.setAnyElements(anAnyElements);
	}

	/**
	 * Constructor
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
		      (TestLink) new TestLinkImpl(aTcLinkName, aType) );
	}

	/**
	 * Constructor for default type
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
		      (TestLink) new TestLinkImpl( aTcLinkName, TYPE_TTI ) );
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
		      (TestLink) new TestLinkImpl( aTestCaseLink.getPath(), aType ) );

		this.setAnyAttributes(anAnyAttributes);
		this.setAnyElements(anAnyElements);
	}

	/**
	 * Constructor
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
		      (TestLink) new TestLinkImpl( aTestCaseLink.getPath(), aType ) );
	}

	/**
	 * Constructor for type 'tti'
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
		      (TestLink) new TestLinkImpl( aTestCaseLink.getPath(), TYPE_TTI ) );
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
