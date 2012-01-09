package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;


/**
 * Class for a link to a Test Group.
 * TestGroupLinks all have an Id, a Type, a sequenceNr, and a link to a File.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupLink extends TestEntryImpl
{
	public static final String TYPE_TTI = "tti";

	private String myType;
	private File myLink;
	
	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestGroupLink	Test Group File
	 * @param aType				Type of the TG File
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      File aTestGroupLink,
	                      String aType,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		super(aTestGroupId, TestEntry.TYPE.GroupLink, "", aSequenceNr, anAnyAttributes, anAnyElements );

		Trace.println( Trace.CONSTRUCTOR,
					   "TestGroupLinkImpl( " + aTestGroupId + ", " 
					   						 + aSequenceNr + ", "
					   						 + aTestGroupLink + ", "
					   						 + aType + ", "
					   						 + anAnyAttributes.size() + ", "
					   						 + anAnyElements.size() + " )",
					   true );
		
		myType = aType;
		myLink = aTestGroupLink;
	}

	/**
	 * Constructor without unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestGroupLink	Test Group File
	 * @param aType				Type of the TG File
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      File aTestGroupLink,
	                      String aType )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      aTestGroupLink,
		      aType,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * Constructor for type 'tti' without unknown attributes or elements
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTestGroupLink	Test Group File
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      File aTestGroupLink )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      aTestGroupLink,
		      TYPE_TTI,
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
	}

	/**
	 * @return the Test Group File
	 */
	public File getLink()
	{
		return myLink;
	}

	/**
	 * @return the type of the Test Group File
	 */
	public String getLinkType()
	{
		return myType;
	}

	/**
	 * Sets the directory of the TG Link.
	 * 
	 * Only if the TG Link is not already absolute.
	 * This will change the stored TG link.
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
