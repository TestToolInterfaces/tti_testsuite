package org.testtoolinterfaces.testsuite;

/**
 * Interface for TestSteps.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestStep extends TestEntry
{
	/**
	 * @return the list of parameters. The list can be empty.
	 */
	public ParameterArrayList getParameters();

	/**
	 * Returns the Name of this step e.g. to be displayed in the result list
	 */
	public String getDisplayName();

}
