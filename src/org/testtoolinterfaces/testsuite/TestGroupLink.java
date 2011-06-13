package org.testtoolinterfaces.testsuite;

import java.io.File;
import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;


/**
 * @author Arjan
 *
 */
public class TestGroupLink extends TestEntryImpl
{
	String myType = "";
	File myLink;
	Hashtable<String, String> myAnyAttributes;
	
	/**
	 * @param aTestGroupId
	 * @param aTestGroupType
	 * @param aSequenceNr
	 * @param aTestGroupLink
	 * @param anAnyAttributes
	 */
	public TestGroupLink( String aTestGroupId,
	                          String aTestGroupType,
	                          int aSequenceNr,
	                          File aTestGroupLink,
	                          Hashtable<String, String> anAnyAttributes )
	{
		super(aTestGroupId, TestEntry.TYPE.GroupLink, "", aSequenceNr);

		Trace.println( Trace.CONSTRUCTOR,
					   "TestGroupLinkImpl( " + aTestGroupId + ", " 
					   						 + aTestGroupType + ", "
					   						 + aSequenceNr + ", "
					   						 + aTestGroupLink + " )",
					   true );
		
		myType = aTestGroupType;
		myLink = aTestGroupLink;
		myAnyAttributes = anAnyAttributes;
	}

	/**
	 * @return the myType
	 */
	public String getGroupType()
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
