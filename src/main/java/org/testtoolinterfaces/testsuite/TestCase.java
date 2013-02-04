package org.testtoolinterfaces.testsuite;

/**
 * Interface for TestCases.
 * 
 * @author Arjan Kranenburg
 *
 */
public interface TestCase extends TestEntry
{
	/**
	 * @return the Execution Steps
	 */
	public TestStepSequence getExecutionSteps();
}