/**
 * 
 */
package org.testtoolinterfaces.testsuite.impl;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestInterface;
import org.testtoolinterfaces.utils.Mark;

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
public class TestStepCommand extends TestStepImpl
{
    private static final Logger LOG = LoggerFactory.getLogger(TestStepCommand.class);

    private final String myCommand;
	private final TestInterface myInterface;

	/**
	 * Creates a TestStepCommand
	 * 
	 * @param aSequenceNr		Sequence number, to be used in a list
	 * @param aDescription		Description
	 * @param aCommand			Command to execute
	 * @param anInterface		Interface towards which the command is directed
	 * @param aParameters		List of parameters
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aDescription,
						 String aCommand,
						 @NotNull TestInterface anInterface,
						 ParameterArrayList aParameters )
	{
		super( aSequenceNr, aDescription, aParameters );
		LOG.trace(Mark.CONSTRUCTOR, "{}, {}, {}, {}, {}",
				aSequenceNr, aDescription,
				aCommand, anInterface, aParameters);

		myCommand = aCommand;
		myInterface = anInterface;
		
		this.setDisplayName( myInterface.getInterfaceName() + ":" + myCommand );
	}

	/**
	 * Creates a TestStepCommand without parameters and unknown attributes and elements
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
						 @NotNull TestInterface anInterface )
	{
		this( aSequenceNr,
		      aDescription,
		      aCommand,
		      anInterface,
		      new ParameterArrayList() );
	}

	/**
	 * Creates a TestStepCommand without description and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aCommand		Command to execute
	 * @param anInterface	Interface towards which the command is directed
	 * @param aParameters	List of parameters
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aCommand,
						 @NotNull TestInterface anInterface,
						 ParameterArrayList aParameters )
	{
		this( aSequenceNr,
		      "",
		      aCommand,
		      anInterface,
		      aParameters );
	}

	/**
	 * Creates a TestStepCommand without description, parameter, and unknown attributes and elements
	 * 
	 * @param aSequenceNr	Sequence number, to be used in a list
	 * @param aCommand		Command to execute
	 * @param anInterface	Interface towards which the command is directed
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aCommand,
						 @NotNull TestInterface anInterface )
	{
		this( aSequenceNr,
		      "",
		      aCommand,
		      anInterface,
		      new ParameterArrayList() );
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
	@NotNull
	public TestInterface getInterface()
	{
		return myInterface;
	}
}
