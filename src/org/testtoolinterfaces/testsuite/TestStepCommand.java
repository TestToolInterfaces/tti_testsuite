/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.utils.Trace;

/**
 * Class for Test Steps that consist of a single command.
 * TestStepCommands all have a sequenceNr, a Command, and an Interface.
 * And they may have a description or list of Parameter.
 * 
 * The interface is the interface towards the command must be issued.
 * 
 * @author Arjan Kranenburg
 *
 */
public class TestStepCommand extends TestStep
{
	private String myCommand;
	private TestInterface myInterface;

	/**
	 * Creates a TestStepCommand
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aDescription	Description
	 * @param aCommand		Command to execute
	 * @param anInterface	Interface towards which the command is directed
	 * @param aParameters	List of parameters
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aDescription,
						 String aCommand,
						 TestInterface anInterface,
						 ParameterArrayList aParameters )
	{
		super( aSequenceNr, aDescription, aParameters );
		Trace.println( Trace.CONSTRUCTOR,
					   "TestStepImpl( "
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
	 * Creates a TestStepCommand with an empty parameter list
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aDescription	Description
	 * @param aCommand		Command to execute
	 * @param anInterface	Interface towards which the command is directed
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aDescription,
						 String aCommand,
						 TestInterface anInterface )
	{
		this( aSequenceNr, aDescription, aCommand, anInterface, new ParameterArrayList() );
	}

	/**
	 * Creates a TestStepCommand with no description
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aCommand		Command to execute
	 * @param anInterface	Interface towards which the command is directed
	 * @param aParameters	List of parameters
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aCommand,
						 TestInterface anInterface,
						 ParameterArrayList aParameters )
	{
		this( aSequenceNr, "", aCommand, anInterface, aParameters );
	}

	/**
	 * Creates a TestStepCommand with no description and an empty parameter list
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aCommand		Command to execute
	 * @param anInterface	Interface towards which the command is directed
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aCommand,
						 TestInterface anInterface )
	{
		this( aSequenceNr, "", aCommand, anInterface, new ParameterArrayList() );
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

	@Override
	public String getDisplayName()
	{
		return myInterface.getInterfaceName() + "->" + myCommand;
	}
}
