package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

public interface TestCase extends TestEntry
{
	/**
	 * @return the Requirement IDs
	 */
	public ArrayList<String> getRequirements();

	/**
	 * @return the Initialization Steps
	 */
	public TestStepCollection getPrepareSteps();

	/**
	 * @return the Execution Steps
	 */
	public TestStepCollection getExecutionSteps();

	/**
	 * @return the Restore Steps
	 */
	public TestStepCollection getRestoreSteps();
}