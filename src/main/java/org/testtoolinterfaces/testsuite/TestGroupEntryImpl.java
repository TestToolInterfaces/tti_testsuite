package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * Abstract Class to hold a TestEntryWithId.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupEntryImpl extends TestEntryImpl
				implements TestGroupEntry
{
	private String myId;

    /**
     * Creates a TestExecutionItem
     * 
	 * @param anId			Identifier
	 * @param aType			Type of TestEntry
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 */
	public TestGroupEntryImpl( String anId,
	                      TYPE aType,
	                      String aDescription,
	                      int aSequenceNr )
	{
		super(aType, aDescription, aSequenceNr);
		Trace.println( Trace.CONSTRUCTOR,
					   "TestEntryImpl(" + anId + ", "
					   					+ aType + ", "
					   					+ aDescription + ", "
					   					+ aSequenceNr + " )",
					   true );
		
		myId = anId;
	}

	public String getId()
	{
		return myId;
	}

	@Override
	public String toString()
	{
		return myId;
	}
}
