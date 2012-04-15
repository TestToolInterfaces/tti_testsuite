package org.testtoolinterfaces.testsuite;

import java.util.Iterator;

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
	public TestInterface getInterface( String anInterfaceName );

	/**
	 * @return an Iterator for the TestInterfaces
	 */
	public Iterator<TestInterface> iterator();
}
