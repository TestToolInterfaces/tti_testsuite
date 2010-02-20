package org.testtoolinterfaces.testsuite;

public interface TestScript
{
	/**
	 * @return the Execution Script
	 */
	public String getExecutionScript();

	/**
	 * @return the Script type
	 */
	public String getType();

	/**
	 * @return the Parameters
	 */
	public ParameterTable getParameters();
}
