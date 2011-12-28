package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestStep;

public class TestStepScriptTester extends TestCase
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
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepScript#TestStepScript()}.
	 */
	@Test
	public void testConstructor()
	{
		TestStepScript testStep = new TestStepScript(
				TestStep.StepType.check,
				0,
				"An extensive description",
				"script",
				"bash",
				new ParameterArrayList() );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Script", "script", testStep.getScript());
		Assert.assertEquals("Incorrect Script Type", "bash", testStep.getScriptType());
		Assert.assertEquals("Incorrect Display Name", "script", testStep.getDisplayName());
	}
}
