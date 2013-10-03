package org.testtoolinterfaces.testsuite;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testtoolinterfaces.utils.Mark;

/**
 * Abstract Class to hold a TestEntryWithId.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestGroupEntryImpl extends TestEntryImpl
				implements TestGroupEntry
{
    private static final Logger LOG = LoggerFactory.getLogger(TestGroupEntryImpl.class);

    private String myId;

    /**
     * Creates a TestExecutionItem
     * 
	 * @param anId			Identifier
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 */
	public TestGroupEntryImpl( String anId,
	                      String aDescription,
	                      int aSequenceNr )
	{
		super(aDescription, aSequenceNr);
		LOG.trace(Mark.CONSTRUCTOR, "{}, {}, {}",
				anId, aDescription, aSequenceNr);
		
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
