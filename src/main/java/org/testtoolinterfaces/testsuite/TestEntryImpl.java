package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

import org.testtoolinterfaces.utils.Trace;

/**
 * Abstract Class to hold a TestEntry.
 * TestEntries all have an Id, a Type, a sequenceNr and may have a description.
 * 
 * They may also store any other attributes and elements
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
	private Hashtable<String, String> myAnyAttributes;
	private Hashtable<String, String> myAnyElements;

    /**
     * Creates a TestEntry
     * 
	 * @param anId			Identifier
	 * @param aType			Type of TestEntry
	 * @param aDescription	Description
	 * @param aSequenceNr	Sequence number, to be used in a collection
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestEntryImpl( String anId,
	                      TYPE aType,
	                      String aDescription,
	                      int aSequenceNr,
	                      Hashtable<String, String> anAnyAttributes,
	                      Hashtable<String, String> anAnyElements )
	{
		Trace.println( Trace.CONSTRUCTOR,
					   "TestEntryImpl(" + anId + ", "
					   					+ aType + ", "
					   					+ aDescription + ", "
					   					+ aSequenceNr + " )",
					   true );
		
		myId = anId;
		myType = aType;
		myDescription = aDescription;
		mySequenceNr = aSequenceNr;
		
		myAnyAttributes = anAnyAttributes;
		myAnyElements = anAnyElements;
	}

	public String getId()
	{
		return myId;
	}

	public TYPE getType()
	{
		return myType;
	}

	public String getDescription()
	{
		return myDescription;
	}
	
	public int getSequenceNr()
	{
		return mySequenceNr;
	}

	public void setSequenceNr(int aSequenceNr)
	{
		mySequenceNr = aSequenceNr;
	}

	public void setDescription(String aDescription)
	{
		myDescription = aDescription;
	}

	@Override
	public String toString()
	{
		return myId;
	}

	public Hashtable<String, String> getAnyAttributes()
	{
		return myAnyAttributes;
	}

	public Hashtable<String, String> getAnyElements()
	{
		return myAnyElements;
	}
}
