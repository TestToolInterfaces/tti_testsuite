package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.testsuite.TestInterface;

/**
 * Interface for a list of TestInterfaces.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestInterfaceList
{
	/**
	 * 
	 * @param anInterfaceName	The interface name
	 * @return The TestInterface from the list, null if the TestInterface is not found
	 */
	TestInterface getInterface( String anInterfaceName );

}
