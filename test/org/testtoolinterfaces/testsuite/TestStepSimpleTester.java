package org.testtoolinterfaces.testsuite;

import junit.framework.Assert;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.testtoolinterfaces.testsuite.ParameterArrayList;
import org.testtoolinterfaces.testsuite.TestEntry;
import org.testtoolinterfaces.testsuite.TestStep;

public class TestStepSimpleTester extends TestCase
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
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSimple#TestStepSimple()}.
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
				1,
				"An extensive description",
				"command string",
				iface,
				paramTable );

		Assert.assertEquals("Incorrect Type", TestEntry.TYPE.Step, testStep.getType());
		Assert.assertEquals("Incorrect Id", "action1", testStep.getId());
		Assert.assertEquals("Incorrect String", "action: command string", testStep.toString());
		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
		Assert.assertEquals("Incorrect Parameters", "e-parameter", ((ParameterImpl) testStep.getParameters().get("-e")).getValue());
	}
	
	/**
	 * Test method for {@link org.testtoolinterfaces.testsuite.TestStepSimple#setDescription()}.
	 */
	@Test
	public void testSetDescription()
	{
		TestInterface_stub iface = new TestInterface_stub( "interface1" );

		TestStepSimple testStep = new TestStepCommand(
				TestStep.StepType.action,
				0,
				"An extensive description",
				"command string",
				iface,
				new ParameterArrayList() );

		Assert.assertEquals("Incorrect Description", "An extensive description", testStep.getDescription());
		testStep.setDescription( "new description" );
		Assert.assertEquals("Incorrect Description", "new description", testStep.getDescription());
	}
}
