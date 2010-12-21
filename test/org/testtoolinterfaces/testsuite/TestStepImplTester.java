package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestStep;

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
		TestStepCommand testStep = new TestStepCommand(
				TestStep.StepType.action,
				0,
				"An extensive description",
				"command string",
				"interface1",
				new ParameterArrayList() );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Command", "command string", testStep.getCommand());
		Assert.assertEquals("Incorrect Interface", "interface1", testStep.getInterface());
	}
}
