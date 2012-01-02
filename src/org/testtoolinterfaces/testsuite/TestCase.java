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
	public TestStepOrdered getPrepareSteps();

	/**
	 * @return the Execution Steps
	 */
	public TestStepOrdered getExecutionSteps();

	/**
	 * @return the Restore Steps
	 */
	public TestStepOrdered getRestoreSteps();
}