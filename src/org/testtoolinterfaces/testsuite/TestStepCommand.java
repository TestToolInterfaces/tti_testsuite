/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * @author Arjan Kranenburg
 *
 */
public class TestStepCommand extends TestStepSimple
{
	private String myCommand;
	private String myInterface;

	/**
	 * @param anActionType one of action, check
	 * @param aSequenceNr
	 * @param aDescription
	 * @param aCommand
	 * @param anInterface
	 * @param aParameters
	 */
	public TestStepCommand( StepType anActionType,
			 			 int aSequenceNr,
						 String aDescription,
						 String aCommand,
						 String anInterface,
						 ParameterArrayList aParameters )
	{
		super(anActionType, aSequenceNr, aDescription, aParameters);
		Trace.println( Trace.LEVEL.CONSTRUCTOR,
					   "TestStepImpl( " + anActionType + ", "
	   									+ aSequenceNr + ", "
	   									+ aDescription + ", "
					   					+ aCommand + ", "
					   					+ anInterface + ", "
					   					+ "aParameters )",
				   	   true );

		myCommand = aCommand;
		myInterface = anInterface;
	}

	public String getCommand()
	{
		return myCommand;
	}

	public String getInterface()
	{
		return myInterface;
	}

	/* (non-Javadoc)
	 * @see org.testtoolinterfaces.TestSuite.TestStepSimple#getDisplayName()
	 */
	public String getDisplayName()
	{
		return myCommand;
	}
}
