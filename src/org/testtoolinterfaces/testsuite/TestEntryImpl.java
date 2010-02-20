package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * 
 * @author Arjan Kranenburg
 *
 */
abstract class TestEntryImpl implements TestEntry
{
	private String myId;
	private TYPE myType;
	private String myDescription;
	private int mySequenceNr = 0;

    /**
	 * @param anId
	 * @param aType
	 * @param aSequenceNr 
	 * @param aSequenceNr 
	 */
	public TestEntryImpl(String anId, TYPE aType, String aDescription, int aSequenceNr)
	{
		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestEntryImpl(" + anId + ", "
					   				+ aType + ", "
					   				+ aDescription + ", "
					   				+ aSequenceNr + " )",
					   true );
		
		myId = anId;
		myType = aType;
		myDescription = aDescription;
		mySequenceNr = aSequenceNr;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#getId()
	 */
	public String getId()
	{
		return myId;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#getType()
	 */
	public TYPE getType()
	{
		return myType;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#getDescription()
	 */
	public String getDescription()
	{
		return myDescription;
	}
	
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#getSequenceNr()
	 */
	public int getSequenceNr()
	{
		return mySequenceNr;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#setDescription(java.lang.String)
	 */
	public void setDescription(String aDescription)
	{
		myDescription = aDescription;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#toString()
	 */
	public String toString()
	{
		return myId;
	}
}
