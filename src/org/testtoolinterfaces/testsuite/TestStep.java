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
	 * @return the DisplayName
	 */
	public String getDisplayName();

	/**
	 * 
	 */
	public ParameterArrayList getParameters();

	/**
	 * @return the Action Type
	 */
	public ActionType getActionType();
}