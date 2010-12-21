/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
abstract public class TestStepSimple extends TestStep implements TestEntry
{
	public enum SimpleType { action, check };

	private ParameterArrayList myParameters;
	private String myDescription;

	/**
	 * Returns the Name of this step e.g. to be displayed in the result list
	 */
	abstract public String getDisplayName();

	/**
	 * @param anActionType one of action, check
	 * @param aSequenceNr
	 * @param aDescription
	 * @param aParameters
	 */
	public TestStepSimple( StepType anActionType,
			 			 int aSequenceNr,
						 String aDescription,
						 ParameterArrayList aParameters )
	{
		super(anActionType, aSequenceNr);
		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestStepImpl( " + anActionType + ", "
	   									+ aSequenceNr + ", "
	   									+ aDescription + ", "
					   					+ "aParameters )",
				   	   true );

		myParameters = aParameters;
		myDescription = aDescription;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestStep#getParameters()
	 */
	public ParameterArrayList getParameters()
	{
		return myParameters;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#toString()
	 */
	public String toString()
	{
		return this.getStepType().toString() + ": " + getDisplayName();
	}

	@Override
	public String getDescription()
	{
		return myDescription;
	}

	@Override
	public String getId()
	{
		return this.getStepType().toString() + this.getSequenceNr();
	}

	@Override
	public TYPE getType()
	{
		return TestEntry.TYPE.Step;
	}

	@Override
	public void setDescription(String aDescription)
	{
		myDescription = aDescription;		
	}
}
