/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.Hashtable;

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
	 * @param anAnyAttributes	Attributes that were not recognized, but kept anyway
	 * @param anAnyElements		Elements that were not recognized, but kept anyway
	 */
	public TestStepCommand(
			 			 int aSequenceNr,
						 String aDescription,
						 String aCommand,
						 TestInterface anInterface,
						 ParameterArrayList aParameters,
	                     Hashtable<String, String> anAnyAttributes,
	                     Hashtable<String, String> anAnyElements )
	{
		super( aSequenceNr,
		       aDescription,
		       aParameters,
		       anAnyAttributes,
		       anAnyElements );
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
		
		this.setDisplayName( myInterface.getInterfaceName() + ":" + myCommand );
	}

	/**
	 * Creates a TestStepCommand without unknown attributes and elements
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
						 TestInterface anInterface,
						 ParameterArrayList aParameters )
	{
		this( aSequenceNr,
		      aDescription,
		      aCommand,
		      anInterface,
		      aParameters, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
						 TestInterface anInterface )
	{
		this( aSequenceNr,
		      aDescription,
		      aCommand,
		      anInterface,
		      new ParameterArrayList(), 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
						 TestInterface anInterface,
						 ParameterArrayList aParameters )
	{
		this( aSequenceNr,
		      "",
		      aCommand,
		      anInterface,
		      aParameters, 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
						 TestInterface anInterface )
	{
		this( aSequenceNr,
		      "",
		      aCommand,
		      anInterface,
		      new ParameterArrayList(), 
		      new Hashtable<String, String>(),
		      new Hashtable<String, String>() );
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
}
