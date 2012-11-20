package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

/**
 * Abstract Class to hold a TestStep.
 * TestSteps all have a sequenceNr and may have a description or ParameterArrayList.
 * 
 * @author Arjan Kranenburg
 *
 */
public abstract class TestStep implements TestEntry
{
	private int mySequenceNr;
	private String myDescription;
	private ParameterArrayList myParameters;
	private Hashtable<String, String> myAnyAttributes;
	private Hashtable<String, String> myAnyElements;
	
	private String myDisplayName = "";

	/**
	 * Creates a TestStep
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a collection
	 * @param aDescription		Description
	 * @param aParameters		List of parameters
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestStep( int aSequenceNr,
	                 String aDescription,
	                 ParameterArrayList aParameters,
                     Hashtable<String, String> anAnyAttributes,
                     Hashtable<String, String> anAnyElements )
	{
		mySequenceNr = aSequenceNr;
		myDescription = aDescription;
		myParameters = aParameters;

		myAnyAttributes = anAnyAttributes;
		myAnyElements = anAnyElements;
	}

	/**
	 * @return the list of parameters. The list can be empty.
	 */
	public ParameterArrayList getParameters()
	{
		return myParameters;
	}

	public int getSequenceNr()
	{
		return mySequenceNr;
	}

	public void setSequenceNr(int aSequenceNr)
	{
		mySequenceNr = aSequenceNr;
	}

	public String getDescription()
	{
		return myDescription;
	}

	public String getId()
	{
		return null; // Steps do not have unique IDs
	}

	/**
	 * Returns the Name of this step e.g. to be displayed in the result list
	 */
	public String getDisplayName()
	{
		return myDisplayName;
	}

	public TYPE getType()
	{
		return TYPE.Step;
	}

	public void setDescription(String aDescription)
	{
		myDescription = aDescription;
	}

	/**
	 * Sets the way this step is to be displayed
	 * @param aDisplayName
	 */
	public void setDisplayName( String aDisplayName )
	{
		myDisplayName = aDisplayName;
	}

	@Override
	public String toString()
	{
		return getDisplayName();
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
