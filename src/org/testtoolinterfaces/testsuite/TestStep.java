package org.testtoolinterfaces.testsuite;

public interface TestStep extends TestEntry
{
	public enum ActionType { initialize, action, check, restore };

	/**
	 * @return the Command
	 */
	public String getCommand();

	/**
	 * @return the Script
	 */
	public String getScript();

	/**
	 * 
	 */
	public ParameterTable getParameters();

	/**
	 * @return the Action Type
	 */
	public ActionType getActionType();
}