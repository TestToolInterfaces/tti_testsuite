package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.TTIException;

/**
 * 
 * @author Arjan
 */
public class TestSuiteException extends TTIException
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 1328189529445640127L;
	private TestEntry myTestEntry;

	/**
	 * @param aMessage
	 */
	public TestSuiteException(String aMessage)
	{
		this( aMessage, "UnknownID", 0 );
	}

	/**
	 * @param aMessage
	 * @param anId
	 */
	public TestSuiteException( String aMessage, String anId )
	{
		this( aMessage, anId, 0 );
	}

	/**
	 * @param aMessage
	 * @param anId
	 * @param aSequenceNr
	 */
	public TestSuiteException( String aMessage, String anId, int aSequenceNr )
	{
		super( aMessage, anId, aSequenceNr );
		myTestEntry = null;
	}

	/**
	 * @param aMessage
	 * @param aTestEntry
	 */
	public TestSuiteException(String aMessage, TestEntry aTestEntry)
	{
		super( aMessage, aTestEntry.getId(), aTestEntry.getSequenceNr() );
		myTestEntry = aTestEntry;
	}

	/**
	 * @param aMessage
	 * @param anException
	 */
	public TestSuiteException(String aMessage, Exception anException)
	{
		this( aMessage, "UnknownID", 0, anException );
	}

	/**
	 * @param aMessage
	 * @param anId
	 * @param anException
	 */
	public TestSuiteException( String aMessage, String anId, Exception anException )
	{
		this( aMessage, anId, 0, anException );
	}

	/**
	 * @param aMessage
	 * @param anId
	 * @param aSequenceNr
	 * @param anException
	 */
	public TestSuiteException( String aMessage, String anId, int aSequenceNr, Exception anException )
	{
		super( aMessage, anId, aSequenceNr, anException );
		myTestEntry = null;
	}

	/**
	 * @param aMessage
	 * @param aTestEntry
	 * @param anException
	 */
	public TestSuiteException(String aMessage, TestEntry aTestEntry, Exception anException)
	{
		super( aMessage, aTestEntry.getId(), aTestEntry.getSequenceNr(), anException );
		myTestEntry = aTestEntry;
	}

	/**
	 * @return the myTestEntry
	 */
	public TestEntry getTestEntry()
	{
		return myTestEntry;
	}
	
	/**
	 * @param aTestEntry the TestEntry to set
	 */
	public TestSuiteException setTestEntry(TestEntry aTestEntry)
	{
		myTestEntry = aTestEntry;
		return this;
	}
}