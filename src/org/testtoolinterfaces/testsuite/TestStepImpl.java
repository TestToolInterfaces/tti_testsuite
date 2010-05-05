/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestStepImpl extends TestEntryImpl implements TestStep
{
	private ActionType myActionType;
	private String myCommand;
	private ParameterArrayList myParameters;

	/**
	 * @param anActionType one of initialize, action, check, restore
	 * @param aSequenceNr
	 * @param aDescription
	 * @param aCommand
	 */
	public TestStepImpl( ActionType anActionType,
			 			 int aSequenceNr,
						 String aDescription,
						 String aCommand,
						 ParameterArrayList aParameters )
	{
		super("TestStep_" + aSequenceNr, TestEntry.TYPE.Step, aDescription, aSequenceNr);
		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestStepImpl( " + anActionType + ", "
	   									+ aSequenceNr + ", "
	   									+ aDescription + ", "
					   					+ aCommand + " )",
				   	   true );

		myActionType = anActionType;
		myCommand = aCommand;
		myParameters = aParameters;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestStep#getCommand()
	 */
	public String getCommand()
	{
		return myCommand;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestStep#getParameters()
	 */
	public ParameterArrayList getParameters()
	{
		return myParameters;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestStep#getActionType()
	 */
	public ActionType getActionType()
	{
		return myActionType;
	}
	
	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestEntry#toString()
	 */
	public String toString()
	{
		return myActionType.toString() + ": " + myCommand;
	}

	public String getScript()
	{
		return "";
	}
}
