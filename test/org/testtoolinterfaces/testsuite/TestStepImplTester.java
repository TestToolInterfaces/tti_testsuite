package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterTable;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestStep;
import org.testtoolinterfaces.testsuite.TestStepImpl;


public class TestStepImplTester extends TestCase
{
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		System.out.println("==========================================================================");
		System.out.println(this.getName() + ":");
	}

	/**
	 * Test Cases
	 */
	public void testCase_constructor()
	{
		TestStepImpl testStep = new TestStepImpl(
				TestStep.ActionType.action,
				0,
				"An extensive description",
				"command string",
				new ParameterTable() );
		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Command", "command string", testStep.getCommand());
	}
}
