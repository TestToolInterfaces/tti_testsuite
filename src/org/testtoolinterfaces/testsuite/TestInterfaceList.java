package org.testtoolinterfaces.testsuite;

import org.testtoolinterfaces.testsuite.TestInterface;

public interface TestInterfaceList
{
	/**
	 * Returns the TestInterface from the list
	 * Returns null if the TestInterface is not found
	 */
	TestInterface getInterface( String anInterfaceName );

}
