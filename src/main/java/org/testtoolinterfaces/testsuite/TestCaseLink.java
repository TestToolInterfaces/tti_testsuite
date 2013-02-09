package org.testtoolinterfaces.testsuite;

/**
 * Class for a link to a Test Case.
 * TestCaseLinks all have an Id, a Type, a sequenceNr, and a link to a File.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestCaseLink extends TestExecItemLinkImpl
{
	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTcLink			Test Case Link
	 */
	public TestCaseLink(String aTestCaseId, int aSequenceNr,
			TestLink aTcLink) {
		super( TYPE.CaseLink, aTestCaseId, aSequenceNr, aTcLink);
	}

	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTcLinkName		Test Case File Name
	 * @param aType				Type of the TC File
	 */
	public TestCaseLink(String aTestCaseId, int aSequenceNr,
			String aTcLinkName, String aType) {
		this( aTestCaseId, aSequenceNr, new TestLinkImpl(aTcLinkName, aType) );
	}

	/**
	 * Constructor
	 * 
	 * @param aTestCaseId		TC Identifier
	 * @param aSequenceNr		Sequence Number
	 * @param aTcLinkName		Test Case File Name
	 */
	public TestCaseLink( String aTestCaseId,
	                     int aSequenceNr,
	                     String aTcLinkName )
	{
		this( aTestCaseId, aSequenceNr, aTcLinkName, TYPE_TTI);
	}

}
