package org.testtoolinterfaces.testsuite;

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

	/**
	 * Returns the Name of this step e.g. to be displayed in the result list
	 */
	abstract public String getDisplayName();

	/**
	 * Creates a TestStep
	 * 
	 * @param aSequenceNr	Sequence nummer, to be used in a list
	 * @param aDescription	Description
	 * @param aParameters	List of parameters
	 */
	public TestStep( int aSequenceNr, String aDescription, ParameterArrayList aParameters )
	{
		mySequenceNr = aSequenceNr;
		myDescription = aDescription;
		myParameters = aParameters;
	}

	/**
	 * Creates a TestStep without any parameters
	 * 
	 * @param aSequenceNr	Sequence nummer, to be used in a list
	 * @param aDescription	Description
	 */
	public TestStep( int aSequenceNr, String aDescription )
	{
		this( aSequenceNr, aDescription, new ParameterArrayList() );
	}

	/**
	 * Creates a TestStep without a description
	 * 
	 * @param aSequenceNr	Sequence nummer, to be used in a list
	 * @param aParameters	List of parameters
	 */
	public TestStep( int aSequenceNr, ParameterArrayList aParameters )
	{
		this( aSequenceNr, "", aParameters );
	}

	/**
	 * Creates a TestStep without a description and any parameters
	 * 
	 * @param aSequenceNr	Sequence nummer, to be used in a list
	 */
	public TestStep( int aSequenceNr )
	{
		this( aSequenceNr, "", new ParameterArrayList() );
	}

	/**
	 * @return the list of parameters. The list can be empty.
	 */
	public ParameterArrayList getParameters()
	{
		return myParameters;
	}

	@Override
	public int getSequenceNr()
	{
		return mySequenceNr;
	}

	@Override
	public String getDescription()
	{
		return myDescription;
	}

	@Override
	public String getId()
	{
		return null; // Steps do not have unique IDs
	}

	@Override
	public TYPE getType()
	{
		return TYPE.Step;
	}

	@Override
	public void setDescription(String aDescription)
	{
		myDescription = aDescription;
	}

	@Override
	public String toString()
	{
		return getDisplayName();
	}
}
