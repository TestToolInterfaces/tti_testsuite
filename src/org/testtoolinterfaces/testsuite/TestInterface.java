/**
 * 
 */
package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

/**
 * @author Arjan Kranenburg
 */
public interface TestInterface
{
	public String getInterfaceName();
	
	public ArrayList<String> getCommands();

	public boolean hasCommand( String aCommand );
	
	public boolean verifyParameters( String aCommand,
	                                 ParameterArrayList aParameters )
			throws TestSuiteException;
	
	public Parameter createParameter( String aName,
	                                  String aType,
	                                  String aValue )
			throws TestSuiteException;
}