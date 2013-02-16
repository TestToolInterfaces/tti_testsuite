package org.testtoolinterfaces.testsuite;

/**
 * Abstract Class to hold a TestStep.
 * TestSteps all have a sequenceNr and may have a description or ParameterArrayList.
 * 
 * @author Arjan Kranenburg
 *
 */
public abstract class TestStepImpl extends TestEntryImpl implements TestStep
{
	private ParameterArrayList myParameters;
	
	private String myDisplayName = "";

	/**
	 * Creates a TestStep
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a collection
	 * @param aDescription		Description
	 * @param aParameters		List of parameters
	 */
	public TestStepImpl( int aSequenceNr,
	                 String aDescription,
	                 ParameterArrayList aParameters )
	{
		super( aDescription, aSequenceNr );
		myParameters = aParameters;
	}

	/**
	 * @return the list of parameters. The list can be empty.
	 */
	public ParameterArrayList getParameters()
	{
		return myParameters;
	}

	@Override
	public String toString()
	{
		return this.getDisplayName();
	}

	/**
	 * Returns the Name of this step e.g. to be displayed in the result list
	 */
	public String getDisplayName()
	{
		return myDisplayName;
	}

	/**
	 * Sets the way this step is to be displayed
	 * @param aDisplayName
	 */
	public void setDisplayName( String aDisplayName )
	{
		myDisplayName = aDisplayName;
	}
}
