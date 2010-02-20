package org.testtoolinterfaces.testsuite;

public interface TestCaseLink extends TestCase
{
	/**
	 * @return the TestCase script
	 */
	public TestScript getTestCaseScript();

	/**
	 * @return the Script Type
	 */
	public String getScriptType();
}