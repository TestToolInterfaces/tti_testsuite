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
public abstract class TestEntryImpl implements TestEntry
{
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
	public TestEntryImpl( TYPE aType,
	                      String aDescription,
	                      int aSequenceNr )
	{
		Trace.println( Trace.CONSTRUCTOR,
					   "TestEntryImpl(" + aType + ", "
					   					+ aDescription + ", "
					   					+ aSequenceNr + " )",
					   true );
		
		myType = aType;
		myDescription = aDescription;
		mySequenceNr = aSequenceNr;
		
		myAnyAttributes = new Hashtable<String, String>();
		myAnyElements = new Hashtable<String, String>();
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

	public Hashtable<String, String> getAnyAttributes()
	{
		return myAnyAttributes;
	}

	/**
	 * @param anAnyAttributes the AnyAttributes to set
	 */
	public void setAnyAttributes(Hashtable<String, String> anAnyAttributes) {
		myAnyAttributes = anAnyAttributes;
	}

	public Hashtable<String, String> getAnyElements()
	{
		return myAnyElements;
	}

	/**
	 * @param anAnyElements the AnyElements to set
	 */
	public void setAnyElements(Hashtable<String, String> anAnyElements) {
		myAnyElements = anAnyElements;
	}
}
