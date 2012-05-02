package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

/**
 * Interface for TestCases.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestCase extends TestEntry
{
	/**
	 * @return the Requirement IDs
	 */
	public ArrayList<String> getRequirements();

	/**
	 * @return the Initialization Steps
	 */
	public TestStepSequence getPrepareSteps();

	/**
	 * @return the Execution Steps
	 */
	public TestStepSequence getExecutionSteps();

	/**
	 * @return the Restore Steps
	 */
	public TestStepSequence getRestoreSteps();
}