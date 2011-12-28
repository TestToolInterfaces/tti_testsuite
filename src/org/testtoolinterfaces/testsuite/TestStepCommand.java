/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for simple command.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepCommand extends TestStepSimple
{
	private String myCommand;
	private TestInterface myInterface;

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
						 TestInterface anInterface,
						 ParameterArrayList aParameters )
	{
		super(anActionType, aSequenceNr, aDescription, aParameters);
		Trace.println( Trace.CONSTRUCTOR,
					   "TestStepImpl( " + anActionType + ", "
	   									+ aSequenceNr + ", "
	   									+ aDescription + ", "
					   					+ aCommand + ", "
					   					+ anInterface.getInterfaceName() + ", "
					   					+ "aParameters )",
				   	   true );

		myCommand = aCommand;
		myInterface = anInterface;
	}

	/**
	 * @return the command
	 */
	public String getCommand()
	{
		return myCommand;
	}

	/**
	 * @return the TestInterface
	 */
	public TestInterface getInterface()
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
