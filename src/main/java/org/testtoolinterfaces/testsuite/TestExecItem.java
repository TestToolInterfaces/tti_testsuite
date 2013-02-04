package org.testtoolinterfaces.testsuite;

import java.util.ArrayList;

/**
 * Interface for TestExecutionItems.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestExecItem extends TestGroupEntry
{
	/**
	 * @return the Requirement IDs
	 */
	public ArrayList<String> getRequirements();

	/**
	 * @return the Preparation Steps
	 */
	public TestStepSequence getPrepareSteps();

	/**
	 * @return the Restore Steps
	 */
	public TestStepSequence getRestoreSteps();

}