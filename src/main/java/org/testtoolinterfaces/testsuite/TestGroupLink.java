package org.testtoolinterfaces.testsuite;

/**
 * Class for a link to a Test Group.
 * TestGroupLinks all have an Id, a Type, a sequenceNr, and a link to a File.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupLink extends TestExecItemLinkImpl
{
	/**
	 * Constructor
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTgLinkName		Test Group File Name
	 * @param aType				Type of the TG File
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      String aTgLinkName,
	                      String aType )
	{
		super( TYPE.GroupLink, aTestGroupId,
		      aSequenceNr,
		      new TestLinkImpl( aTgLinkName, aType ) );
	}

	/**
	 * Constructor for default type
	 * 
	 * @param aTestGroupId		TG Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTgLinkName		Test Group File Name
	 */
	public TestGroupLink( String aTestGroupId,
	                      int aSequenceNr,
	                      String aTgLinkName )
	{
		this( aTestGroupId,
		      aSequenceNr,
		      aTgLinkName, TYPE_TTI );
	}
}
