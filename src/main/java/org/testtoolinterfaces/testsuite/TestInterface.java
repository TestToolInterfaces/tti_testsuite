/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

/**
 * Interface for TestInterfaces.
 * 
 * @author Arjan Kranenburg
 */
public interface TestInterface
{
	/**
	 * @return the interface name
	 */
	public String getInterfaceName();
	
	/**
	 * @return an array list of commands supported by this interface
	 */
	public ArrayList<String> getCommands();

	/**
	 * To check if this interface supports a specific command.
	 * 
	 * @param aCommand	command to check
	 * @return			flag if command is supported
	 */
	public boolean hasCommand( String aCommand );
	
	/**
	 * Method to verify the parameters of a specific command.
	 * 
	 * @param aCommand		command to verify
	 * @param aParameters	parameters to verify
	 * @return				flag if the parameters are OK for this command
	 * @throws TestSuiteException	when something is wrong with the parameter. 
	 */
	public boolean verifyParameters( String aCommand,
	                                 ParameterArrayList aParameters )
			throws TestSuiteException;
	
	/**
	 * Constructs a valid parameter
	 * 
	 * @param aName		Name of the parameter
	 * @param aType		Type of the parameter
	 * @param aValue	Value of the parameter
	 * @return			Valid parameter
	 * @throws TestSuiteException when some of the inputs are incorrect.
	 */
	public Parameter createParameter( String aName,
	                                  String aType,
	                                  String aValue )
			throws TestSuiteException;

	/**
	 * Destroys the interfaces. Gives the opportunity for the interface to e.g. close connections or clean-up. 
	 */
	public void destroy();
}