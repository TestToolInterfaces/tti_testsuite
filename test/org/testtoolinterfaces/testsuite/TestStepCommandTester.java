package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestStep;

public class TestStepCommandTester extends TestCase
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
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepCommand#TestStepCommand()}.
	 */
	@Test
	public void testConstructor()
	{
		TestInterface_stub iface = new TestInterface_stub( "interface1" );

		ParameterArrayList paramTable = new ParameterArrayList();

		ParameterImpl param_e = new ParameterImpl("-e", "e-parameter");
		param_e.setIndex(0);
		paramTable.add(param_e);

		TestStepCommand testStep = new TestStepCommand(
				TestStep.StepType.action,
				0,
				"An extensive description",
				"command string",
				iface,
				paramTable );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
		Assert.assertEquals("Incorrect Parameters", "e-parameter", ((ParameterImpl) testStep.getParameters().get("-e")).getValue());

		Assert.assertEquals("Incorrect Command", "command string", testStep.getCommand());
		Assert.assertEquals("Incorrect Interface", "interface1", testStep.getInterface().getInterfaceName());
		Assert.assertEquals("Incorrect Display Name", "command string", testStep.getDisplayName());
	}
}
